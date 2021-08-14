package com.focamacho.vampiresneedumbrellas.utils;

import net.minecraftforge.fml.ModList;

public class Utils {

	public static final boolean isVampirismLoaded = ModList.get().isLoaded("vampirism");
	public static final boolean isCuriosLoaded = ModList.get().isLoaded("curios");

	public static String getColorNameFromNumber(int number) {
		switch(number){
			case 0:
				return "black";
			case 1:
				return "red";
			case 2:
				return "cactus_green";
			case 3:
				return "brown";
			case 4:
				return "lapis_blue";
			case 5:
				return "purple";
			case 6:
				return "cyan";
			case 7:
				return "light_gray";
			case 8:
				return "gray";
			case 9:
				return "pink";
			case 10:
				return "lime_green";
			case 11:
				return "yellow";
			case 12:
				return "light_blue";
			case 13:
				return "magenta";
			case 14:
				return "orange";
			case 15:
				return "white";
		}
		return "";
	}

}
