package com.focamacho.vampiresneedumbrellas.handlers;

import com.focamacho.vampiresneedumbrellas.VampiresNeedUmbrellas;
import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.items.ItemCreativeUmbrella;
import com.focamacho.vampiresneedumbrellas.items.ItemRod;
import com.focamacho.vampiresneedumbrellas.items.ItemUmbrella;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.registries.IForgeRegistry;

public class ModObjects {

	public static void initItems(IForgeRegistry<Item> registry) {
		//Umbrellas
		for (int i = 0; i < 16; i++) {
			registry.register(new ItemUmbrella(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB), getColorForNumber(i) + "iron_umbrella", () -> ConfigHolder.ironUmbrellaDurability, () -> ConfigHolder.ironUmbrellaSpeed, Items.IRON_INGOT));
			registry.register(new ItemUmbrella(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB), getColorForNumber(i) + "gold_umbrella", () -> ConfigHolder.goldUmbrellaDurability, () -> ConfigHolder.goldUmbrellaSpeed, Items.GOLD_INGOT));
			registry.register(new ItemUmbrella(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB), getColorForNumber(i) + "diamond_umbrella", () -> ConfigHolder.diamondUmbrellaDurability, () -> ConfigHolder.diamondUmbrellaSpeed, Items.DIAMOND));
			registry.register(new ItemUmbrella(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB), getColorForNumber(i) + "netherite_umbrella", () -> ConfigHolder.netheriteUmbrellaDurability, () -> ConfigHolder.netheriteUmbrellaSpeed, Items.NETHERITE_INGOT));
		}

		//Creative Umbrella
		registry.register(new ItemCreativeUmbrella(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB)));

		//Umbrella Rods
		registry.register(new ItemRod(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB), "iron_umbrella_rod"));
		registry.register(new ItemRod(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB), "gold_umbrella_rod"));
		registry.register(new ItemRod(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB), "diamond_umbrella_rod"));
	}

	private static String getColorForNumber(int number) {
		switch(number){
			case 0:
				return "";
			case 1:
				return "red_";
			case 2:
				return "cactus_green_";
			case 3:
				return "brown_";
			case 4:
				return "lapis_blue_";
			case 5:
				return "purple_";
			case 6:
				return "cyan_";
			case 7:
				return "light_gray_";
			case 8:
				return "gray_";
			case 9:
				return "pink_";
			case 10:
				return "lime_green_";
			case 11:
				return "yellow_";
			case 12:
				return "light_blue_";
			case 13:
				return "magenta_";
			case 14:
				return "orange_";
			case 15:
				return "white_";
		}
		return "";
	}

}
