package com.focamacho.vampiresneedumbrellas.compat.curios;

import com.focamacho.vampiresneedumbrellas.handlers.ModObjects;
import com.focamacho.vampiresneedumbrellas.items.ItemUmbrella;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.SlotResult;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

import java.util.*;

public class CuriosHandler {

    public static void onBrokenCurio(String id, int index, Player consumer) {
        CuriosApi.broadcastCurioBreakEvent(new SlotContext(id, consumer, index, false, false));
    }

    public static Optional<SlotResult> getUmbrellaEquiped(ItemStack umbrella, Player player) {
        Optional<ICuriosItemHandler> inventory = CuriosApi.getCuriosInventory(player);
        if(inventory.isPresent()) {
            return inventory.get().findFirstCurio(umbrella.getItem());
        }

        return Optional.empty();
    }

    @SubscribeEvent
    public void registerCapabilities(final RegisterCapabilitiesEvent event) {
        event.registerItem(
                CuriosCapability.ITEM,
                (stack, context) -> new ICurio() {

                    @Override
                    public ItemStack getStack() {
                        return stack;
                    }

                    @Override
                    public List<Component> getAttributesTooltip(List<Component> tooltips) {
                        return Collections.emptyList();
                    }

                },
                ModObjects.registry.getEntries().stream()
                        .map(DeferredHolder::get)
                        .filter(item -> item instanceof ItemUmbrella)
                        .toArray(Item[]::new)
        );
    }

}