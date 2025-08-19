package com.focamacho.vampiresneedumbrellas.items;

import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.handlers.VampirismHandler;
import com.focamacho.vampiresneedumbrellas.utils.Utils;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.UUID;
import java.util.function.Supplier;

public class ItemUmbrella extends Item {

    private static final UUID SPEED_ATTRIBUTE = UUID.fromString("278caaa5-8912-490c-acb1-d3c10bac2150");

    private final Supplier<Integer> durabilitySupplier;
    public final Supplier<Double> speedSupplier;
    private final Item repairItem;

    public ItemUmbrella(Item.Properties builder, Supplier<Integer> durabilitySupplier, Supplier<Double> speedSupplier, Item repairItem) {
        // This durability is just to trick the ItemStack$isDamageableItem check
        super(builder.durability(100));
        this.durabilitySupplier = durabilitySupplier;
        this.speedSupplier = speedSupplier;
        this.repairItem = repairItem;
    }

    @ParametersAreNonnullByDefault
    @Override
    public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(Utils.isVampirismLoaded) VampirismHandler.applyEffect(stack, worldIn, entityIn, isDamageable(stack));
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers(ItemStack stack) {
        ItemAttributeModifiers.Builder attributes = ItemAttributeModifiers.builder();

        AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("vampiresneedumbrellas:umbrella_modifier"), speedSupplier.get(), AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        attributes.add(Attributes.MOVEMENT_SPEED, modifier, EquipmentSlotGroup.MAINHAND);
        attributes.add(Attributes.MOVEMENT_SPEED, modifier, EquipmentSlotGroup.OFFHAND);

        return attributes.build();
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return durabilitySupplier.get();
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return ConfigHolder.umbrellaAnvil;
    }

    @Override
    public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
        return enchantment.is(Enchantments.UNBREAKING) || enchantment.is(Enchantments.MENDING) || enchantment.is(Enchantments.VANISHING_CURSE);
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

    @Override
    public int getBarWidth(ItemStack stack) {
        return Math.round(13.0F - (float)stack.getDamageValue() * 13.0F / (float)this.getMaxDamage(stack));
    }

    @ParametersAreNonnullByDefault
    @Override
    public int getBarColor(ItemStack stack) {
        float f = Math.max(0.0F, ((float)this.getMaxDamage(stack) - (float)stack.getDamageValue()) / (float)this.getMaxDamage(stack));
        return Mth.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
    }
}
