package com.focamacho.vampiresneedumbrellas;

import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.config.ConfigUmbrella;
import com.focamacho.vampiresneedumbrellas.handlers.CuriosHandler;
import com.focamacho.vampiresneedumbrellas.handlers.ModObjects;
import com.focamacho.vampiresneedumbrellas.handlers.TooltipHandler;
import com.focamacho.vampiresneedumbrellas.utils.Utils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(VampiresNeedUmbrellas.MODID)
public class VampiresNeedUmbrellas {

    public static final String MODID = "vampiresneedumbrellas";

    public VampiresNeedUmbrellas() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigUmbrella.spec);
        ConfigHolder.updateConfigs();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueue);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCreativeTab);

        ModObjects.initItems(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new TooltipHandler());
    }

    private void enqueue(InterModEnqueueEvent event) {
        if(Utils.isCuriosLoaded && ConfigHolder.umbrellaBauble) CuriosHandler.registerUmbrellaCurios();
    }

    public void onCreativeTab(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(MODID, "creative_tab"), (builder) ->
                builder.title(Component.translatable("itemGroup.vampiresneedumbrellas"))
                        .icon(() -> new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("vampiresneedumbrellas:iron_umbrella"))))
                        .displayItems((params, output) -> {
                            for (RegistryObject<Item> entry : ModObjects.registry.getEntries()) {
                                output.accept(entry.get());
                            }
                        })
        );
    }

}
