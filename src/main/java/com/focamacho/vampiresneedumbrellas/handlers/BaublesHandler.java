package com.focamacho.vampiresneedumbrellas.handlers;

import com.focamacho.vampiresneedumbrellas.config.ConfigUmbrella;
import com.focamacho.vampiresneedumbrellas.items.ItemCreativeUmbrellaBauble;
import com.focamacho.vampiresneedumbrellas.items.ItemFakeUmbrella;
import com.focamacho.vampiresneedumbrellas.items.ItemRod;
import com.focamacho.vampiresneedumbrellas.items.ItemUmbrellaBauble;
import com.focamacho.vampiresneedumbrellas.utils.Utils;

import net.minecraft.item.Item;

public class BaublesHandler {

	public static Item umbrellaIron = null;
	public static Item umbrellaGold = null;
	public static Item umbrellaDiamond = null;
	
	public static Item umbrellaIronRod = null;
	public static Item umbrellaGoldRod = null;
	public static Item umbrellaDiamondRod = null;
	
	public static Item creativeUmbrella = null;

	public static void initBaublesItems() {
		ModObjects.umbrellaIron = new ItemFakeUmbrella("fake_iron_umbrella", 0);
		
		umbrellaIron = new ItemUmbrellaBauble("iron_umbrella", ConfigUmbrella.ironUmbrellaDurability, 0);
		umbrellaGold = new ItemUmbrellaBauble("gold_umbrella", ConfigUmbrella.goldUmbrellaDurability, 0);
		umbrellaDiamond = new ItemUmbrellaBauble("diamond_umbrella", ConfigUmbrella.diamondUmbrellaDurability, 0);
		
		for(int i = 1; i < 16; i++) {
			new ItemUmbrellaBauble(Utils.getColorNameFromNumber(i) + "_iron_umbrella", ConfigUmbrella.ironUmbrellaDurability, i);
			new ItemUmbrellaBauble(Utils.getColorNameFromNumber(i) + "_gold_umbrella", ConfigUmbrella.goldUmbrellaDurability, i);
			new ItemUmbrellaBauble(Utils.getColorNameFromNumber(i) + "_diamond_umbrella", ConfigUmbrella.diamondUmbrellaDurability, i);
		}
		
		if(ConfigUmbrella.creativeUmbrella) {
			creativeUmbrella = new ItemCreativeUmbrellaBauble();
		}
		
		umbrellaIronRod = new ItemRod("iron_umbrella_rod");
		umbrellaGoldRod = new ItemRod("gold_umbrella_rod");
		umbrellaDiamondRod = new ItemRod("diamond_umbrella_rod");
		
	}
}
