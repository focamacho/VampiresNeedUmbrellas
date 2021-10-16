package com.focamacho.vampiresneedumbrellas.handlers;

import com.focamacho.vampiresneedumbrellas.VampiresNeedUmbrellas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.InterModComms;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;

import java.util.Optional;

public class CuriosHandler {

    public static void registerUmbrellaCurios() {
        InterModComms.sendTo("curios", "register_type", () -> new SlotTypeMessage.Builder("umbrella").size(1).icon(new ResourceLocation(VampiresNeedUmbrellas.MODID, "curios")).build());
    }

    public static void onBrokenCurio(String id, int index, Player consumer) {
        CuriosApi.getCuriosHelper().onBrokenCurio(id, index, consumer);
    }

    public static Optional<ImmutableTriple<String, Integer, ItemStack>> getUmbrellaEquiped(ItemStack umbrella, Player player) {
        return CuriosApi.getCuriosHelper().findEquippedCurio(umbrella.getItem(), player);
    }

}