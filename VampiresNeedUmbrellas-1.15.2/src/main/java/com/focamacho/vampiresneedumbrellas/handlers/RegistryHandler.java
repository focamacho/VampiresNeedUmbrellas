package com.focamacho.vampiresneedumbrellas.handlers;

import com.focamacho.vampiresneedumbrellas.VampiresNeedUmbrellas;
import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.config.ConfigUmbrella;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;

@EventBusSubscriber(modid = VampiresNeedUmbrellas.MODID, bus = EventBusSubscriber.Bus.MOD)
public class RegistryHandler {
	
	@SubscribeEvent
	public static void onItemRegister(final RegistryEvent.Register<Item> event) {
		ModObjects.initItems(event.getRegistry());
	}
	
	@SubscribeEvent
	public static void onModConfigEvent(final ModConfig.ModConfigEvent event) {
		final ModConfig config = event.getConfig();

		if (config.getSpec() == ConfigUmbrella.spec) {
			ConfigHolder.updateConfigs();
		}
	}

}
