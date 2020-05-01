package com.focamacho.vampiresneedumbrellas.items;

import com.focamacho.vampiresneedumbrellas.VampiresNeedUmbrellas;
import com.focamacho.vampiresneedumbrellas.handlers.ModObjects;
import com.focamacho.vampiresneedumbrellas.handlers.VampirismHandler;
import com.focamacho.vampiresneedumbrellas.utils.Utils;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCreativeUmbrella extends Item {
	
	public ItemCreativeUmbrella() {
		this.setRegistryName("creative_umbrella");
		this.setUnlocalizedName("creative_umbrella");
		this.setMaxStackSize(1);
		this.setCreativeTab(VampiresNeedUmbrellas.vampiresNeedUmbrellasTab);
		
		ModObjects.itemsList.add(this);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(Utils.isVampirismLoaded) VampirismHandler.applyCreativeEffect(stack, worldIn, entityIn);
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return false;
	}
	
}
