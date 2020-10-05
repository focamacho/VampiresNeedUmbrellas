package com.focamacho.vampiresneedumbrellas.items;

import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.handlers.ModObjects;
import com.focamacho.vampiresneedumbrellas.handlers.VampirismHandler;
import com.focamacho.vampiresneedumbrellas.utils.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDiamondUmbrella extends Item {
	
	private boolean breakable = this.isDamageable();
	
	public ItemDiamondUmbrella(Item.Properties builder, String name) {
		super(builder);
		this.setRegistryName(name);
		
		ModObjects.itemsList.add(this);
	}
	
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(Utils.isVampirismLoaded) VampirismHandler.applyEffect(stack, worldIn, entityIn, breakable);
	}
	
	@Override
	public int getMaxDamage(ItemStack stack) {
		return ConfigHolder.diamondUmbrellaDurability;
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack) {
		return 1;
	}
	
	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
		return true;
	}
	
	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return false;
	}

	@Override
	public boolean isDamageable() {
		return ConfigHolder.diamondUmbrellaDurability != -1;
	}
}
