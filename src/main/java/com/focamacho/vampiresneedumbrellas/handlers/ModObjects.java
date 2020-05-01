package com.focamacho.vampiresneedumbrellas.handlers;

import java.util.ArrayList;
import java.util.List;

import com.focamacho.vampiresneedumbrellas.config.ConfigUmbrella;
import com.focamacho.vampiresneedumbrellas.items.ItemCreativeUmbrella;
import com.focamacho.vampiresneedumbrellas.items.ItemRod;
import com.focamacho.vampiresneedumbrellas.items.ItemUmbrella;
import com.focamacho.vampiresneedumbrellas.potions.VampirismPotion;
import com.focamacho.vampiresneedumbrellas.utils.Utils;

import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.registries.IForgeRegistry;

public class ModObjects {

	public static List<Item> itemsList = new ArrayList<Item>();
	
	public static Item umbrellaIron = null;
	public static Item umbrellaGold = null;
	public static Item umbrellaDiamond = null;

	public static Potion sunscreen = null;
	
	public static Item umbrellaIronRod = null;
	public static Item umbrellaGoldRod = null;
	public static Item umbrellaDiamondRod = null;
	
	public static Item creativeUmbrella = null;
	
	public static void initPotion(IForgeRegistry<Potion> registry) {
		if(Utils.isVampirismLoaded) {
			sunscreen = new VampirismPotion("sunscreen", false, 0xFFF100);
			sunscreen.registerPotionAttributeModifier(VampirismHandler.sunDamage, "9dc9420c-3e5e-41c7-9ba4-ff70e9dc69fc", -0.5, 2);
			
			registry.register(sunscreen);
		}
	}
	
	public static void initItems(IForgeRegistry<Item> registry) {
		umbrellaIron = new ItemUmbrella("iron_umbrella", ConfigUmbrella.ironUmbrellaDurability, 0);
		umbrellaGold = new ItemUmbrella("gold_umbrella", ConfigUmbrella.goldUmbrellaDurability, 0);
		umbrellaDiamond = new ItemUmbrella("diamond_umbrella", ConfigUmbrella.diamondUmbrellaDurability, 0);
			
		registry.register(umbrellaIron);
		registry.register(umbrellaGold);
		registry.register(umbrellaDiamond);
		
		for(int i = 1; i < 16; i++) {
			Item umbrellaIronCollored = new ItemUmbrella(Utils.getColorNameFromNumber(i) + "_iron_umbrella", ConfigUmbrella.ironUmbrellaDurability, i);
			Item umbrellaGoldCollored = new ItemUmbrella(Utils.getColorNameFromNumber(i) + "_gold_umbrella", ConfigUmbrella.goldUmbrellaDurability, i);
			Item umbrellaDiamondCollored = new ItemUmbrella(Utils.getColorNameFromNumber(i) + "_diamond_umbrella", ConfigUmbrella.diamondUmbrellaDurability, i);	

			registry.register(umbrellaIronCollored);
			registry.register(umbrellaGoldCollored);
			registry.register(umbrellaDiamondCollored);
		}
		
		if(ConfigUmbrella.creativeUmbrella) {
			creativeUmbrella = new ItemCreativeUmbrella();
			registry.register(creativeUmbrella);
		}
		
		umbrellaIronRod = new ItemRod("iron_umbrella_rod");
		registry.register(umbrellaIronRod);
		
		umbrellaGoldRod = new ItemRod("gold_umbrella_rod");
		registry.register(umbrellaGoldRod);
		
		umbrellaDiamondRod = new ItemRod("diamond_umbrella_rod");
		registry.register(umbrellaDiamondRod);
		
	}
	
}
