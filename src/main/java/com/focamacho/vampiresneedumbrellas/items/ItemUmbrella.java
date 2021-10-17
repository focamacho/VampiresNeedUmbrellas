package com.focamacho.vampiresneedumbrellas.items;

import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.handlers.CuriosHandler;
import com.focamacho.vampiresneedumbrellas.handlers.ModObjects;
import com.focamacho.vampiresneedumbrellas.handlers.VampirismHandler;
import com.focamacho.vampiresneedumbrellas.utils.Utils;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.UUID;
import java.util.function.Supplier;

public class ItemUmbrella extends Item {

    private static final UUID SPEED_ATTRIBUTE = UUID.fromString("278caaa5-8912-490c-acb1-d3c10bac2150");

    private final Supplier<Integer> durabilitySupplier;
    private final Supplier<Double> speedSupplier;
    private final Item repairItem;

    public ItemUmbrella(Item.Properties builder, String name, Supplier<Integer> durabilitySupplier, Supplier<Double> speedSupplier, Item repairItem) {
        super(builder);
        this.setRegistryName(name);

        this.durabilitySupplier = durabilitySupplier;
        this.speedSupplier = speedSupplier;
        this.repairItem = repairItem;
    }

    @ParametersAreNonnullByDefault
    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(Utils.isVampirismLoaded) VampirismHandler.applyEffect(stack, worldIn, entityIn, isDamageable(stack));
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributes = HashMultimap.create();

        if (speedSupplier.get() != 0 && (slot == EquipmentSlotType.MAINHAND || slot == EquipmentSlotType.OFFHAND)) {
            attributes.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(SPEED_ATTRIBUTE, "Umbrella Speed Modifier", speedSupplier.get(), AttributeModifier.Operation.MULTIPLY_BASE));
        }

        return attributes;
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
        return Utils.isCuriosLoaded ? CuriosHandler.initCapabilities(stack, nbt, SPEED_ATTRIBUTE, speedSupplier.get()) : super.initCapabilities(stack, nbt);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return durabilitySupplier.get();
    }

    @Override
    public int getItemStackLimit(ItemStack stack) {
        return 1;
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return ConfigHolder.umbrellaAnvil;
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return durabilitySupplier.get() != -1;
    }

    @ParametersAreNonnullByDefault
    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return ConfigHolder.umbrellaRepair && repair.getItem().equals(repairItem);
    }

}
