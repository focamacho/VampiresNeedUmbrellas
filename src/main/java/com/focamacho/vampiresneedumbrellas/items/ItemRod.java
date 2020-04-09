package com.focamacho.vampiresneedumbrellas.items;

import com.focamacho.vampiresneedumbrellas.VampiresNeedUmbrellas;
import com.focamacho.vampiresneedumbrellas.handlers.ModObjects;
import net.minecraft.item.Item;

public class ItemRod extends Item {
	
	public ItemRod(String name) {
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(VampiresNeedUmbrellas.vampiresNeedUmbrellasTab);
		
		ModObjects.itemsList.add(this);
	}
}