package com.focamacho.vampiresneedumbrellas;

import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.config.ConfigUmbrella;
import com.focamacho.vampiresneedumbrellas.handlers.ModObjects;
import com.focamacho.vampiresneedumbrellas.handlers.TooltipHandler;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(VampiresNeedUmbrellas.MODID)
public class VampiresNeedUmbrellas {

    public static final String MODID = "vampiresneedumbrellas";

    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TAB_REGISTRY
            .register("creative_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.vampiresneedumbrellas"))
                    .icon(() -> new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("vampiresneedumbrellas:iron_umbrella"))))
                    .displayItems((params, output) -> {
                        for (RegistryObject<Item> entry : ModObjects.registry.getEntries()) {
                            output.accept(entry.get());
                        }
                    })
                    .build());

    public VampiresNeedUmbrellas() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigUmbrella.spec);
        ConfigHolder.updateConfigs();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        ModObjects.initItems(FMLJavaModLoadingContext.get().getModEventBus());
        CREATIVE_MODE_TAB_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new TooltipHandler());
    }

}
