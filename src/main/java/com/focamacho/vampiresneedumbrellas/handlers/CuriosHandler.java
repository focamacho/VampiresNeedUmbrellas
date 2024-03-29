package com.focamacho.vampiresneedumbrellas.handlers;

import com.focamacho.vampiresneedumbrellas.VampiresNeedUmbrellas;
import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.InterModComms;
import top.theillusivec4.curios.api.*;
import top.theillusivec4.curios.api.type.capability.ICurio;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CuriosHandler {

    public static void registerUmbrellaCurios() {
        InterModComms.sendTo("curios", "register_type", () -> new SlotTypeMessage.Builder("umbrella").size(1).icon(new ResourceLocation(VampiresNeedUmbrellas.MODID, "curios")).build());
    }

    public static void onBrokenCurio(String id, int index, Player consumer) {
        CuriosApi.getCuriosHelper().onBrokenCurio(new SlotContext(id, consumer, index, false, false));
    }

    public static Optional<SlotResult> getUmbrellaEquiped(ItemStack umbrella, Player player) {
        return CuriosApi.getCuriosHelper().findFirstCurio(player, umbrella.getItem());
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

                    if(ConfigHolder.umbrellaBauble && speed != 0) {
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