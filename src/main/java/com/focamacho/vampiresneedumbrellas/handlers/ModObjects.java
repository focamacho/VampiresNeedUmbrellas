package com.focamacho.vampiresneedumbrellas.handlers;

import com.focamacho.vampiresneedumbrellas.VampiresNeedUmbrellas;
import com.focamacho.vampiresneedumbrellas.items.*;
import com.focamacho.vampiresneedumbrellas.utils.Utils;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

public class ModObjects {

	public static List<Item> itemsList = new ArrayList<>();

	public static Item umbrellaIron = null;
	public static Item umbrellaGold = null;
	public static Item umbrellaDiamond = null;
	public static Item umbrellaNetherite = null;

	public static Item umbrellaIronRod = null;
	public static Item umbrellaGoldRod = null;
	public static Item umbrellaDiamondRod = null;

	public static Item creativeUmbrella = null;

	public static void initItems(IForgeRegistry<Item> registry) {

		umbrellaIron = new ItemIronUmbrella((new Item.Properties()).tab(VampiresNeedUmbrellas.CREATIVETAB), "iron_umbrella");
		registry.register(umbrellaIron);
		umbrellaGold = new ItemGoldUmbrella((new Item.Properties()).tab(VampiresNeedUmbrellas.CREATIVETAB), "gold_umbrella");
		registry.register(umbrellaGold);
		umbrellaDiamond = new ItemDiamondUmbrella((new Item.Properties()).tab(VampiresNeedUmbrellas.CREATIVETAB), "diamond_umbrella");
		registry.register(umbrellaDiamond);
		umbrellaNetherite = new ItemNetheriteUmbrella((new Item.Properties()).tab(VampiresNeedUmbrellas.CREATIVETAB), "netherite_umbrella");
		registry.register(umbrellaNetherite);

		for (int i = 1; i < 16; i++) {
			ItemIronUmbrella itemIronUmbrella = new ItemIronUmbrella(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB), Utils.getColorNameFromNumber(i) + "_iron_umbrella");
			ItemGoldUmbrella itemGoldUmbrella = new ItemGoldUmbrella(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB), Utils.getColorNameFromNumber(i) + "_gold_umbrella");
			ItemDiamondUmbrella itemDiamondUmbrella = new ItemDiamondUmbrella(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB), Utils.getColorNameFromNumber(i) + "_diamond_umbrella");
			ItemNetheriteUmbrella itemNetheriteUmbrella = new ItemNetheriteUmbrella(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB), Utils.getColorNameFromNumber(i) + "_netherite_umbrella");

			registry.register(itemIronUmbrella);
			registry.register(itemGoldUmbrella);
			registry.register(itemDiamondUmbrella);
			registry.register(itemNetheriteUmbrella);
		}

		creativeUmbrella = new ItemCreativeUmbrella(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB));
		registry.register(creativeUmbrella);

		umbrellaIronRod = new ItemRod(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB), "iron_umbrella_rod");
		registry.register(umbrellaIronRod);
		umbrellaGoldRod = new ItemRod(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB), "gold_umbrella_rod");
		registry.register(umbrellaGoldRod);
		umbrellaDiamondRod = new ItemRod(new Item.Properties().tab(VampiresNeedUmbrellas.CREATIVETAB), "diamond_umbrella_rod");
		registry.register(umbrellaDiamondRod);
	}
}
