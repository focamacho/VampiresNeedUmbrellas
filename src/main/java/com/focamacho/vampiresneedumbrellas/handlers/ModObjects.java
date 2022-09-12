package com.focamacho.vampiresneedumbrellas.handlers;

import com.focamacho.vampiresneedumbrellas.VampiresNeedUmbrellas;
import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.items.ItemCreativeUmbrella;
import com.focamacho.vampiresneedumbrellas.items.ItemRod;
import com.focamacho.vampiresneedumbrellas.items.ItemUmbrella;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModObjects {

	private static final DeferredRegister<Item> registry = DeferredRegister.create(ForgeRegistries.ITEMS, VampiresNeedUmbrellas.MODID);

	public static void initItems(IEventBus bus) {
		//Umbrellas
		for (int i = 0; i < 16; i++) {
			registry.register(getColorForNumber(i) + "iron_umbrella", () -> new ItemUmbrella(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB).stacksTo(1), () -> ConfigHolder.ironUmbrellaDurability, () -> ConfigHolder.ironUmbrellaSpeed, Items.IRON_INGOT));
			registry.register(getColorForNumber(i) + "gold_umbrella", () -> new ItemUmbrella(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB).stacksTo(1), () -> ConfigHolder.goldUmbrellaDurability, () -> ConfigHolder.goldUmbrellaSpeed, Items.GOLD_INGOT));
			registry.register(getColorForNumber(i) + "diamond_umbrella", () -> new ItemUmbrella(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB).stacksTo(1), () -> ConfigHolder.diamondUmbrellaDurability, () -> ConfigHolder.diamondUmbrellaSpeed, Items.DIAMOND));
			registry.register(getColorForNumber(i) + "netherite_umbrella", () -> new ItemUmbrella(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB).stacksTo(1), () -> ConfigHolder.netheriteUmbrellaDurability, () -> ConfigHolder.netheriteUmbrellaSpeed, Items.NETHERITE_INGOT));
		}

		//Creative Umbrella
		registry.register("creative_umbrella", () -> new ItemCreativeUmbrella(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB).stacksTo(1)));

		//Umbrella Rods
		registry.register("iron_umbrella_rod", () -> new ItemRod(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB)));
		registry.register("gold_umbrella_rod", () -> new ItemRod(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB)));
		registry.register("diamond_umbrella_rod", () -> new ItemRod(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB)));

		registry.register(bus);
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
