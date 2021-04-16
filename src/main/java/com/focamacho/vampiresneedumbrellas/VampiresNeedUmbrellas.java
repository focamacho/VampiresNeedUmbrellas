package com.focamacho.vampiresneedumbrellas;

import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.config.ConfigUmbrella;
import com.focamacho.vampiresneedumbrellas.handlers.CuriosHandler;
import com.focamacho.vampiresneedumbrellas.handlers.ModObjects;
import com.focamacho.vampiresneedumbrellas.handlers.TooltipHandler;
import com.focamacho.vampiresneedumbrellas.utils.Utils;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(VampiresNeedUmbrellas.MODID)
public class VampiresNeedUmbrellas {

    public static final String MODID = "vampiresneedumbrellas";

    public VampiresNeedUmbrellas() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigUmbrella.spec);
        ConfigHolder.updateConfigs();
        
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueue);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new TooltipHandler());
    }

    private void enqueue(InterModEnqueueEvent event) {
        if(Utils.isCuriosLoaded && ConfigHolder.umbrellaBauble) CuriosHandler.registerUmbrellaCurios();
    }

    public static final ItemGroup CREATIVETAB = new ItemGroup(VampiresNeedUmbrellas.MODID) {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModObjects.umbrellaIron);
        }};

    @Mod.EventBusSubscriber(modid = MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientProxy {

        @SubscribeEvent
        public static void stitchTextures(TextureStitchEvent.Pre evt) {
            if (Utils.isCuriosLoaded && ConfigHolder.umbrellaBauble) {
                if (evt.getMap().getTextureLocation() == PlayerContainer.LOCATION_BLOCKS_TEXTURE) {
                    evt.addSprite(new ResourceLocation(MODID, "curios"));
                }
            }
        }
    }
}
