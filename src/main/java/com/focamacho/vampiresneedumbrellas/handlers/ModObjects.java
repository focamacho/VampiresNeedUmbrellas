package com.focamacho.vampiresneedumbrellas.handlers;

import com.focamacho.vampiresneedumbrellas.VampiresNeedUmbrellas;
import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.items.ItemCreativeUmbrella;
import com.focamacho.vampiresneedumbrellas.items.ItemRod;
import com.focamacho.vampiresneedumbrellas.items.ItemUmbrella;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModObjects {

	public static final DeferredRegister<Item> registry = DeferredRegister.create(Registries.ITEM, VampiresNeedUmbrellas.MODID);

	public static void initItems(IEventBus bus) {
		//Umbrellas
		for (int i = 0; i < 16; i++) {
			registry.register(getColorForNumber(i) + "iron_umbrella", () -> new ItemUmbrella(new Item.Properties().stacksTo(1), () -> ConfigHolder.ironUmbrellaDurability, () -> ConfigHolder.ironUmbrellaSpeed, Items.IRON_INGOT));
			registry.register(getColorForNumber(i) + "gold_umbrella", () -> new ItemUmbrella(new Item.Properties().stacksTo(1), () -> ConfigHolder.goldUmbrellaDurability, () -> ConfigHolder.goldUmbrellaSpeed, Items.GOLD_INGOT));
			registry.register(getColorForNumber(i) + "diamond_umbrella", () -> new ItemUmbrella(new Item.Properties().stacksTo(1), () -> ConfigHolder.diamondUmbrellaDurability, () -> ConfigHolder.diamondUmbrellaSpeed, Items.DIAMOND));
			registry.register(getColorForNumber(i) + "netherite_umbrella", () -> new ItemUmbrella(new Item.Properties().stacksTo(1), () -> ConfigHolder.netheriteUmbrellaDurability, () -> ConfigHolder.netheriteUmbrellaSpeed, Items.NETHERITE_INGOT));
		}

		//Creative Umbrella
		registry.register("creative_umbrella", () -> new ItemCreativeUmbrella(new Item.Properties().stacksTo(1)));

		//Umbrella Rods
		registry.register("iron_umbrella_rod", () -> new ItemRod(new Item.Properties()));
		registry.register("gold_umbrella_rod", () -> new ItemRod(new Item.Properties()));
		registry.register("diamond_umbrella_rod", () -> new ItemRod(new Item.Properties()));

		registry.register(bus);
	}

	private static String getColorForNumber(int number) {
		return switch (number) {
			case 0 -> "";
			case 1 -> "red_";
			case 2 -> "cactus_green_";
			case 3 -> "brown_";
			case 4 -> "lapis_blue_";
			case 5 -> "purple_";
			case 6 -> "cyan_";
			case 7 -> "light_gray_";
			case 8 -> "gray_";
			case 9 -> "pink_";
			case 10 -> "lime_green_";
			case 11 -> "yellow_";
			case 12 -> "light_blue_";
			case 13 -> "magenta_";
			case 14 -> "orange_";
			case 15 -> "white_";
			default -> "";
		};
	}

}
