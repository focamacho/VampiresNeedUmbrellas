package com.focamacho.vampiresneedumbrellas.handlers;

import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.SlotResult;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CuriosHandler {

    public static void onBrokenCurio(String id, int index, Player consumer) {
        CuriosApi.broadcastCurioBreakEvent(new SlotContext(id, consumer, index, false, false));
    }

    public static Optional<SlotResult> getUmbrellaEquiped(ItemStack umbrella, Player player) {
        Optional<ICuriosItemHandler> inventory = CuriosApi.getCuriosInventory(player).resolve();
        if(inventory.isPresent()) {
            return inventory.get().findFirstCurio(umbrella.getItem());
        }

        return Optional.empty();
    }

    public static ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt, UUID SPEED_ATTRIBUTE, double speed) {
        return new ICapabilityProvider() {
            private final LazyOptional<ICurio> lazyCurio = LazyOptional.of(()-> new ICurio() {

                @Override
                public ItemStack getStack() {
                    return stack;
                }

                @Override
                public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                    Multimap<Attribute, AttributeModifier> attributes = HashMultimap.create();

                    if(speed != 0) {
                        attributes.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(SPEED_ATTRIBUTE, "Umbrella Speed Modifier", speed, AttributeModifier.Operation.MULTIPLY_BASE));
                    }

                    return attributes;
                }

                @Override
                public List<Component> getAttributesTooltip(List<Component> tooltips) {
                    tooltips.clear();
                    return tooltips;
                }

            });

            @Nonnull
            @Override
            public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction side) {
                return CuriosCapability.ITEM.orEmpty(capability, lazyCurio);
            }

        };
    }

}