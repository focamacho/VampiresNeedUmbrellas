package com.focamacho.vampiresneedumbrellas.items;

import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.handlers.ModObjects;
import com.focamacho.vampiresneedumbrellas.handlers.VampirismHandler;
import com.focamacho.vampiresneedumbrellas.utils.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

public class ItemGoldUmbrella extends Item {
	
	public ItemGoldUmbrella(Item.Properties builder, String name) {
		super(builder);
		this.setRegistryName(name);
		
		ModObjects.itemsList.add(this);
	}

	@ParametersAreNonnullByDefault
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(Utils.isVampirismLoaded) VampirismHandler.applyEffect(stack, worldIn, entityIn, isDamageable(stack));
	}
	
	@Override
	public int getMaxDamage(ItemStack stack) {
		return ConfigHolder.goldUmbrellaDurability;
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
		return ConfigHolder.goldUmbrellaDurability != -1;
	}

	@ParametersAreNonnullByDefault
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
		return ConfigHolder.umbrellaRepair && repair.getItem().equals(Items.GOLD_INGOT);
	}

}
