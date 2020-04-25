package com.focamacho.vampiresneedumbrellas.config;

public class ConfigHolder {

	public static int ironUmbrellaDurability = ConfigUmbrella.configIronUmbrellaDurability.get();
	public static int goldUmbrellaDurability = ConfigUmbrella.configGoldUmbrellaDurability.get();
	public static int diamondUmbrellaDurability = ConfigUmbrella.configDiamondUmbrellaDurability.get();
	
	//public static boolean overrideSunscreen = ConfigUmbrella.configOverrideSunscreen.get();
	
	public static boolean umbrellaMainHand = ConfigUmbrella.configUmbrellaMainHand.get();
	public static boolean umbrellaOffHand = ConfigUmbrella.configUmbrellaOffHand.get();
	public static int umbrellaProtectionTime = ConfigUmbrella.configUmbrellaProtectionTime.get();
	public static boolean umbrellaAnvil = ConfigUmbrella.configUmbrellaAnvil.get();
	public static boolean umbrellaBauble = ConfigUmbrella.configUmbrellaBauble.get();
	
	public static boolean creativeUmbrellaConfigs = ConfigUmbrella.configCreativeUmbrellaConfigs.get();
	
	public static void updateConfigs() {
		ironUmbrellaDurability = ConfigUmbrella.configIronUmbrellaDurability.get();
		goldUmbrellaDurability = ConfigUmbrella.configGoldUmbrellaDurability.get();
		diamondUmbrellaDurability = ConfigUmbrella.configDiamondUmbrellaDurability.get();
		
		//overrideSunscreen = ConfigUmbrella.configOverrideSunscreen.get();
		
		umbrellaMainHand = ConfigUmbrella.configUmbrellaMainHand.get();
		umbrellaOffHand = ConfigUmbrella.configUmbrellaOffHand.get();
		umbrellaProtectionTime = ConfigUmbrella.configUmbrellaProtectionTime.get();
		umbrellaAnvil = ConfigUmbrella.configUmbrellaAnvil.get();
		umbrellaBauble = ConfigUmbrella.configUmbrellaBauble.get();
		
		creativeUmbrellaConfigs = ConfigUmbrella.configCreativeUmbrellaConfigs.get();
	}

}
