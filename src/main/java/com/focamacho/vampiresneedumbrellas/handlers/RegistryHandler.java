package com.focamacho.vampiresneedumbrellas.handlers;

import com.focamacho.vampiresneedumbrellas.VampiresNeedUmbrellas;
import com.focamacho.vampiresneedumbrellas.config.ConfigUmbrella;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

@EventBusSubscriber
public class RegistryHandler {
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		ModObjects.initItems(event.getRegistry());
	}
	
	@SubscribeEvent(priority=EventPriority.LOWEST)
	public static void onPotionRegister(RegistryEvent.Register<Potion> event) {
		if(ConfigUmbrella.overrideSunscreen) {
			ModObjects.initPotion(event.getRegistry());
		}
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for(Item item : ModObjects.itemsList) {
			VampiresNeedUmbrellas.proxy.registerItemRenderer(item, 0, "inventory");
		}
	}
	
	public static void preInit(FMLPreInitializationEvent event) {
		ConfigUmbrella.init(new File(event.getModConfigurationDirectory(), "vampiresNeedUmbrellas.cfg"));
	}
	
	public static void init(FMLInitializationEvent event) {

	}

}
