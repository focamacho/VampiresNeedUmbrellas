package com.focamacho.vampiresneedumbrellas.handlers;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.SlotResult;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

import java.util.Optional;

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

}