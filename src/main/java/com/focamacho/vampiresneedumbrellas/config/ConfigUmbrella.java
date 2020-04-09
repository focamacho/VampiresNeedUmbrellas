package com.focamacho.vampiresneedumbrellas.config;

import com.focamacho.vampiresneedumbrellas.VampiresNeedUmbrellas;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigUmbrella {
	
	public static Configuration config;
	public static ConfigUmbrella instance;
	
	public static boolean overrideSunscreen;
	
	public static int ironUmbrellaDurability;
	public static int goldUmbrellaDurability;
	public static int diamondUmbrellaDurability;
	
	public static boolean umbrellaMainHand;
	public static boolean umbrellaOffHand;
	public static int umbrellaProtectionTime;
	public static boolean umbrellaAnvil;
	public static boolean umbrellaBauble;
	
	public static boolean creativeUmbrella;
	public static boolean creativeUmbrellaConfigs;
	
	@SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
        if(eventArgs.getModID().equals(VampiresNeedUmbrellas.MODID)) {
            ConfigUmbrella.syncConfig();
        }
    }
	
	public static void init(File file) {
        config = new Configuration(file);
        syncConfig();
	}
	
	public static void syncConfig() {
	
		String category;
		
		category = "Umbrellas Durability";
		ironUmbrellaDurability = config.getInt("ironUmbrellaDurability", category, 600, -1, 432000, "The durability in seconds of the Iron Umbrella when in the sun. Set to -1 if you want it to be unbreakable");
		goldUmbrellaDurability = config.getInt("goldUmbrellaDurability", category, 2400, -1, 432000, "The durability in seconds of the Gold Umbrella when in the sun. Set to -1 if you want it to be unbreakable");
		diamondUmbrellaDurability = config.getInt("diamondUmbrellaDurability", category, 9600, -1, 432000, "The durability in seconds of the Diamond Umbrella when in the sun. Set to -1 if you want it to be unbreakable");
		
		category = "Vampirism Override";
		overrideSunscreen = config.getBoolean("overrideSunscreen", category, true, "Override the Vampirism Sunscreen effect with a new one that does not shows the effect in the inventory");
		
		category = "Umbrellas Mechanics";
		umbrellaMainHand = config.getBoolean("umbrellaMainHand", category, true, "Set to false if you don't want the umbrella to work in the main-hand");
		umbrellaOffHand = config.getBoolean("umbrellaOffHand", category, true, "Set to false if you don't want the umbrella to work in the off-hand");
		umbrellaProtectionTime = config.getInt("umbrellaProtectionTime", category, 1, 1, 10, "The time in seconds of protection that the umbrella gives you.\n"
																							+ "Example: If set to 10, you'll receive a \"Sunscreen Effect\" of 10 seconds and consume 10 from the durability of the Umbrella.\n"
																							+ "It's useful if you want to make things for vampires a bit harder, a example for that is: Set the config \"umbrellaOffHand\" to false and\n"
																							+ "this Protection Time to 1, so vampires will only be able to use the umbrella in their main hand\n"
																							+ "and will have less than 1 second of protection if they take it out of their hand, forcing them to always use the umbrella in the sun.");
		umbrellaAnvil = config.getBoolean("umbrellaAnvil", category, false, "Set to false if you don't want the umbrella to be enchanted using anvils.");
		umbrellaBauble = config.getBoolean("umbrellaBauble", category, false, "Set to false if you don't want the umbrella to be used in the baubles slots");
		
		category = "Others";
		creativeUmbrella = config.getBoolean("creativeUmbrella", category, true, "Enable/disable the Creative Umbrella.");
		creativeUmbrellaConfigs = config.getBoolean("creativeUmbrellaConfigs", category, false, "If true, the Creative Umbrella will respect the \"umbrellaMainHand\" and \"umbrellaOffHand\" configs.\n"
																								+ "If false, the Creative Umbrella will always works in main-hand and off-hand");
		
		if(config.hasChanged()){
			config.save();
		}
	}
} 
