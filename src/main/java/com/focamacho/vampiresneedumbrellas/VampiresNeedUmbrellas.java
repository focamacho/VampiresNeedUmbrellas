package com.focamacho.vampiresneedumbrellas;

import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.config.ConfigUmbrella;
import com.focamacho.vampiresneedumbrellas.handlers.CuriosHandler;
import com.focamacho.vampiresneedumbrellas.handlers.TooltipHandler;
import com.focamacho.vampiresneedumbrellas.utils.Utils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
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
import net.minecraftforge.registries.ForgeRegistries;

@Mod(VampiresNeedUmbrellas.MODID)
public class VampiresNeedUmbrellas {

    public static final String MODID = "vampiresneedumbrellas";
    public static final CreativeModeTab CREATIVETAB = new CreativeModeTab(VampiresNeedUmbrellas.MODID) {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("vampiresneedumbrellas:iron_umbrella")));
        }

    };

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

    @Mod.EventBusSubscriber(modid = MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientProxy {

        @SubscribeEvent
        public static void stitchTextures(TextureStitchEvent.Pre evt) {
            if (Utils.isCuriosLoaded && ConfigHolder.umbrellaBauble) {
                if (evt.getAtlas().location() == InventoryMenu.BLOCK_ATLAS) {
                    evt.addSprite(new ResourceLocation(MODID, "curios"));
                }
            }
        }
    }

}
