package com.focamacho.vampiresneedumbrellas.items;

import com.focamacho.vampiresneedumbrellas.handlers.ModObjects;
import net.minecraft.world.item.Item;

public class ItemRod extends Item {
	
	public ItemRod(Item.Properties properties, String name) {
		super(properties);
		this.setRegistryName(name);

		ModObjects.itemsList.add(this);
	}

}