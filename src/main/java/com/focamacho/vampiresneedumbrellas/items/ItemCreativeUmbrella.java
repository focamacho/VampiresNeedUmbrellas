package com.focamacho.vampiresneedumbrellas.items;

import com.focamacho.vampiresneedumbrellas.handlers.VampirismHandler;
import com.focamacho.vampiresneedumbrellas.utils.Utils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

public class ItemCreativeUmbrella extends ItemUmbrella {

	public ItemCreativeUmbrella(Item.Properties builder) {
		super(builder, "creative_umbrella", () -> -1, () -> 0D, null);
	}

	@ParametersAreNonnullByDefault
	@Override
	public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(Utils.isVampirismLoaded) VampirismHandler.applyCreativeEffect(stack, entityIn);
	}

	@ParametersAreNonnullByDefault
	@Override
	public boolean isFoil(ItemStack stack) {
		return true;
	}

}
