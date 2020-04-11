package com.focamacho.vampiresneedumbrellas.config;

import com.focamacho.vampiresneedumbrellas.VampiresNeedUmbrellas;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class ConfigUmbrella {
	
	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	private static final General GENERAL = new General(BUILDER);
	public static final ForgeConfigSpec spec = BUILDER.build();
	
	//Config Values
	public static IntValue configIronUmbrellaDurability;
	public static IntValue configGoldUmbrellaDurability;
	public static IntValue configDiamondUmbrellaDurability;
	
	public static BooleanValue configOverrideSunscreen;
	
	public static BooleanValue configUmbrellaMainHand;
	public static BooleanValue configUmbrellaOffHand;
	public static IntValue configUmbrellaProtectionTime;
	public static BooleanValue configUmbrellaAnvil;
	public static BooleanValue configUmbrellaBauble;
	
	public static BooleanValue configCreativeUmbrella;
	public static BooleanValue configCreativeUmbrellaConfigs;
	
	public static class General {
		public General(final ForgeConfigSpec.Builder builder) {
			builder.push("Umbrellas Durability");
			configIronUmbrellaDurability = builder
					.comment("The durability in seconds of the Iron Umbrella when in the sun. Set to -1 if you want it to be unbreakable")
					.translation(VampiresNeedUmbrellas.MODID + ".config.ironUmbrellaDurability")
					.defineInRange("ironUmbrellaDurability", 600, -1, 432000);
			configGoldUmbrellaDurability = builder
					.comment("The durability in seconds of the Gold Umbrella when in the sun. Set to -1 if you want it to be unbreakable")
					.translation(VampiresNeedUmbrellas.MODID + ".config.goldUmbrellaDurability")
					.defineInRange("goldUmbrellaDurability", 2400, -1, 432000);
			configDiamondUmbrellaDurability = builder
					.comment("The durability in seconds of the Diamond Umbrella when in the sun. Set to -1 if you want it to be unbreakable")
					.translation(VampiresNeedUmbrellas.MODID + ".config.diamondUmbrellaDurability")
					.defineInRange("diamondUmbrellaDurability", 9600, -1, 432000);
			builder.pop();
			
			/* Not implemented yet
			builder.push("Vampirism Override");
			configOverrideSunscreen = builder
					.comment("Override the Vampirism Sunscreen effect with a new one that does not shows the effect in the inventory")
					.translation(VampiresNeedUmbrellas.MODID + ".config.overrideSunscreen")
					.define("overrideSunscreen", true);
			builder.pop();
			*/
			
			builder.push("Umbrellas Mechanics");
			configUmbrellaMainHand = builder
					.comment("Set to false if you don't want the umbrella to work in the main-hand")
					.translation(VampiresNeedUmbrellas.MODID + ".config.umbrellaMainHand")
					.define("umbrellaMainHand", true);
			configUmbrellaOffHand = builder
					.comment("Set to false if you don't want the umbrella to work in the off-hand")
					.translation(VampiresNeedUmbrellas.MODID + ".config.umbrellaOffHand")
					.define("umbrellaOffHand", true);
			configUmbrellaProtectionTime = builder
					.comment("The time in seconds of protection that the umbrella gives you.\n"
							+ "Example: If set to 10, you'll receive a \"Sunscreen Effect\" of 10 seconds and consume 10 from the durability of the Umbrella.\n"
							+ "It's useful if you want to make things for vampires a bit harder, a example for that is: Set the config \"umbrellaOffHand\" to false and\n"
							+ "this Protection Time to 1, so vampires will only be able to use the umbrella in their main hand\n"
							+ "and will have less than 1 second of protection if they take it out of their hand, forcing them to always use the umbrella in the sun.")
					.translation(VampiresNeedUmbrellas.MODID + ".config.umbrellaProtectionTime")
					.defineInRange("umbrellaProtectionTime", 1, 1, 10);
			configUmbrellaAnvil = builder
					.comment("Set to false if you don't want the umbrella to be enchanted using anvils.")
					.translation(VampiresNeedUmbrellas.MODID + ".config.umbrellaAnvil")
					.define("umbrellaAnvil", false);
			ConfigUmbrella.configUmbrellaBauble = builder
					.comment("Set to false if you don't want the umbrella to be used in the curios slot")
					.translation("vampiresneedumbrellas.config.umbrellaBauble")
					.define("umbrellaBauble", false);
			builder.pop();
			
			builder.push("Others");
			configCreativeUmbrellaConfigs = builder
					.comment("If true, the Creative Umbrella will respect the \"umbrellaMainHand\" and \"umbrellaOffHand\" configs.\n"
							+ "If false, the Creative Umbrella will always works in main-hand and off-hand")
					.translation(VampiresNeedUmbrellas.MODID + ".config.creativeUmbrellaConfigs")
					.define("creativeUmbrellaConfigs", false);
			builder.pop();
		}
	}

}