package com.focamacho.vampiresneedumbrellas.handlers;

import com.focamacho.vampiresneedumbrellas.VampiresNeedUmbrellas;
import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
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
import org.apache.commons.lang3.tuple.ImmutableTriple;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.type.capability.ICurio;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;

public class CuriosHandler {

    public static void registerUmbrellaCurios() {
        InterModComms.sendTo("curios", "register_type", () -> new SlotTypeMessage.Builder("umbrella").size(1).icon(new ResourceLocation(VampiresNeedUmbrellas.MODID, "curios")).build());
    }

    public static void onBrokenCurio(String id, int index, Player consumer) {
        CuriosApi.getCuriosHelper().onBrokenCurio(id, index, consumer);
    }

    public static Optional<ImmutableTriple<String, Integer, ItemStack>> getUmbrellaEquiped(ItemStack umbrella, Player player) {
        return CuriosApi.getCuriosHelper().findEquippedCurio(umbrella.getItem(), player);
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
                public boolean showAttributesTooltip(String identifier) {
                    return false;
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