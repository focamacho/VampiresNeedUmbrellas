package com.focamacho.vampiresneedumbrellas.items;

import com.focamacho.vampiresneedumbrellas.handlers.VampirismHandler;
import com.focamacho.vampiresneedumbrellas.utils.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Supplier;

public class ItemCreativeUmbrella extends ItemUmbrella {

	public ItemCreativeUmbrella(Item.Properties builder) {
		super(builder, "creative_umbrella", () -> -1, () -> 0D, null);
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

}
