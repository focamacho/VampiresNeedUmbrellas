package com.focamacho.vampiresneedumbrellas.utils;

import net.minecraftforge.fml.ModList;

public class Utils {

	public static final boolean isVampirismLoaded = ModList.get().isLoaded("vampirism");
	public static final boolean isCuriosLoaded = ModList.get().isLoaded("curios");

	public static String getColorNameFromNumber(int number) {
		return switch (number) {
			case 0 -> "black";
			case 1 -> "red";
			case 2 -> "cactus_green";
			case 3 -> "brown";
			case 4 -> "lapis_blue";
			case 5 -> "purple";
			case 6 -> "cyan";
			case 7 -> "light_gray";
			case 8 -> "gray";
			case 9 -> "pink";
			case 10 -> "lime_green";
			case 11 -> "yellow";
			case 12 -> "light_blue";
			case 13 -> "magenta";
			case 14 -> "orange";
			case 15 -> "white";
			default -> "";
		};
	}

}
