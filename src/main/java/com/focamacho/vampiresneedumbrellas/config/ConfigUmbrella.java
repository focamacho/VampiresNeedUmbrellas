package com.focamacho.vampiresneedumbrellas.config;

import com.focamacho.vampiresneedumbrellas.VampiresNeedUmbrellas;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.DoubleValue;

public class ConfigUmbrella {
	
	private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	private static final General GENERAL = new General(BUILDER);
	public static final ModConfigSpec spec = BUILDER.build();
	
	//Config Values
	public static ModConfigSpec.IntValue configIronUmbrellaDurability;
	public static ModConfigSpec.IntValue configGoldUmbrellaDurability;
	public static ModConfigSpec.IntValue configDiamondUmbrellaDurability;
	public static ModConfigSpec.IntValue configNetheriteUmbrellaDurability;

	public static DoubleValue configIronUmbrellaSpeed;
	public static DoubleValue configGoldUmbrellaSpeed;
	public static DoubleValue configDiamondUmbrellaSpeed;
	public static DoubleValue configNetheriteUmbrellaSpeed;

	public static ModConfigSpec.BooleanValue configUmbrellaMainHand;
	public static ModConfigSpec.BooleanValue configUmbrellaOffHand;
	public static ModConfigSpec.BooleanValue configUmbrellaAnvil;
	public static ModConfigSpec.BooleanValue configUmbrellaRepair;

	public static ModConfigSpec.BooleanValue configCreativeUmbrellaConfigs;
	
	public static class General {
		public General(final ModConfigSpec.Builder builder) {
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

			builder.push("Umbrellas Speed");
			configIronUmbrellaSpeed = builder
					.comment("The Speed Modifier of the Umbrella. Set to 0 to disable.")
					.translation(VampiresNeedUmbrellas.MODID + ".config.ironUmbrellaSpeed")
					.defineInRange("ironUmbrellaSpeed", -0.35D, -1D, 1D);
			configGoldUmbrellaSpeed = builder
					.comment("The Speed Modifier of the Umbrella. Set to 0 to disable.")
					.translation(VampiresNeedUmbrellas.MODID + ".config.goldUmbrellaSpeed")
					.defineInRange("goldUmbrellaSpeed", -0.35D, -1D, 1D);
			configDiamondUmbrellaSpeed = builder
					.comment("The Speed Modifier of the Umbrella. Set to 0 to disable.")
					.translation(VampiresNeedUmbrellas.MODID + ".config.diamondUmbrellaSpeed")
					.defineInRange("diamondUmbrellaSpeed", -0.35D, -1D, 1D);
			configNetheriteUmbrellaSpeed = builder
					.comment("The Speed Modifier of the Umbrella. Set to 0 to disable.")
					.translation(VampiresNeedUmbrellas.MODID + ".config.netheriteUmbrellaSpeed")
					.defineInRange("netheriteUmbrellaSpeed", -0.35D, -1D, 1D);
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