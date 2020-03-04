package com.focamacho.vampiresneedumbrellas;

import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.config.ConfigUmbrella;
import com.focamacho.vampiresneedumbrellas.handlers.ModObjects;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(VampiresNeedUmbrellas.MODID)
public class VampiresNeedUmbrellas
{
    public static final String MODID = "vampiresneedumbrellas";
    public static final String NAME = "Vampires Need Umbrellas";
    public static final String VERSION = "1.0";

    public VampiresNeedUmbrellas() {
    	ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigUmbrella.spec);
    	ConfigHolder.updateConfigs();
    	
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        
    }

    public static final ItemGroup CREATIVETAB = new ItemGroup(VampiresNeedUmbrellas.MODID) {

		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModObjects.umbrellaIron);
		}};
}
