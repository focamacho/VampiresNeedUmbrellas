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
	public static IntValue configNetheriteUmbrellaDurability;
	
	public static BooleanValue configUmbrellaMainHand;
	public static BooleanValue configUmbrellaOffHand;
	public static BooleanValue configUmbrellaAnvil;
	public static BooleanValue configUmbrellaBauble;
	public static BooleanValue configUmbrellaRepair;

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
			configNetheriteUmbrellaDurability = builder
					.comment("The durability in seconds of the Netherite Umbrella when in the sun. Set to -1 if you want it to be unbreakable")
					.translation(VampiresNeedUmbrellas.MODID + ".config.netheriteUmbrellaDurability")
					.defineInRange("netheriteUmbrellaDurability", 14400, -1, 432000);
			builder.pop();
			
			builder.push("Umbrellas Mechanics");
			configUmbrellaMainHand = builder
					.comment("Set to false if you don't want the umbrella to work in the main-hand")
					.translation(VampiresNeedUmbrellas.MODID + ".config.umbrellaMainHand")
					.define("umbrellaMainHand", true);
			configUmbrellaOffHand = builder
					.comment("Set to false if you don't want the umbrella to work in the off-hand")
					.translation(VampiresNeedUmbrellas.MODID + ".config.umbrellaOffHand")
					.define("umbrellaOffHand", true);
			configUmbrellaAnvil = builder
					.comment("Set to false if you don't want the umbrella to be enchanted using anvils.")
					.translation(VampiresNeedUmbrellas.MODID + ".config.umbrellaAnvil")
					.define("umbrellaAnvil", true);
			configUmbrellaBauble = builder
					.comment("Set to false if you don't want the umbrella to be used in the curios slot")
					.translation("vampiresneedumbrellas.config.umbrellaBauble")
					.define("umbrellaBauble", false);
			configUmbrellaRepair = builder
					.comment("Set to false if you don't want umbrellas to be repaired using an anvil and the material it is made from.")
					.translation("vampiresneedumbrellas.config.umbrellaRepair")
					.define("umbrellaRepair", true);
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