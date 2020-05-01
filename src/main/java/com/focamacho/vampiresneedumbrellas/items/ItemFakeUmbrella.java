package com.focamacho.vampiresneedumbrellas.items;

import com.focamacho.vampiresneedumbrellas.VampiresNeedUmbrellas;
import com.focamacho.vampiresneedumbrellas.handlers.ModObjects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemFakeUmbrella extends Item {
	
	public ItemFakeUmbrella(String name, int color) {
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
		this.setCreativeTab(null);
		
		this.addPropertyOverride(new ResourceLocation(VampiresNeedUmbrellas.MODID, "color"), new IItemPropertyGetter() {

			@Override
			public float apply(ItemStack stack, World worldIn, EntityLivingBase entityIn) {
				return color;
			}

		});
		
		ModObjects.itemsList.add(this);
	}
	
}
