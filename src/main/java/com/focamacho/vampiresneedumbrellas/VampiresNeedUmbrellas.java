package com.focamacho.vampiresneedumbrellas;

import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.config.ConfigUmbrella;
import com.focamacho.vampiresneedumbrellas.handlers.ModObjects;
import com.focamacho.vampiresneedumbrellas.handlers.TooltipHandler;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@Mod(VampiresNeedUmbrellas.MODID)
public class VampiresNeedUmbrellas {

    public static final String MODID = "vampiresneedumbrellas";

    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final Supplier<CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TAB_REGISTRY
            .register("creative_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.vampiresneedumbrellas"))
                    .icon(() -> new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation("vampiresneedumbrellas:iron_umbrella"))))
                    .displayItems((params, output) -> {
                        for (DeferredHolder<Item, ? extends Item> entry : ModObjects.registry.getEntries()) {
                            output.accept(entry.get());
                        }
                    })
                    .build());

    public VampiresNeedUmbrellas(IEventBus bus) {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigUmbrella.spec);
        ConfigHolder.updateConfigs();

        bus.addListener(this::doClientStuff);

        ModObjects.initItems(bus);
        CREATIVE_MODE_TAB_REGISTRY.register(bus);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        NeoForge.EVENT_BUS.register(new TooltipHandler());
    }

}
