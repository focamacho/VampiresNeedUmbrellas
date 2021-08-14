package com.focamacho.vampiresneedumbrellas.items;

import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.handlers.ModObjects;
import com.focamacho.vampiresneedumbrellas.handlers.VampirismHandler;
import com.focamacho.vampiresneedumbrellas.utils.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

public class ItemCreativeUmbrella extends Item {
	
	public ItemCreativeUmbrella(Item.Properties properties) {
		super(properties);
		this.setRegistryName("creative_umbrella");
		
		ModObjects.itemsList.add(this);
	}

	@ParametersAreNonnullByDefault
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(Utils.isVampirismLoaded) VampirismHandler.applyCreativeEffect(stack, entityIn);
	}

	@ParametersAreNonnullByDefault
	@Override
	public boolean isFoil(ItemStack stack) {
		return true;
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

}
