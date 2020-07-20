package com.focamacho.vampiresneedumbrellas.handlers;

import com.focamacho.vampiresneedumbrellas.VampiresNeedUmbrellas;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.InterModComms;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;

public class CuriosHandler {
    public static void registerUmbrellaCurios() {
        InterModComms.sendTo("curios", "register_type", () -> new SlotTypeMessage.Builder("umbrella").size(1).icon(new ResourceLocation(VampiresNeedUmbrellas.MODID, "curios")).build());
    }

    public static boolean isUmbrellaEquipped(ItemStack umbrella, PlayerEntity player) {
        return CuriosApi.getCuriosHelper().findEquippedCurio(umbrella.getItem(), player).isPresent();
    }

    public static void onBrokenCurio(String id, int index, PlayerEntity consumer) {
        CuriosApi.getCuriosHelper().onBrokenCurio(id, index, consumer);
    }

    public static ImmutableTriple<String, Integer, ItemStack> getUmbrellaEquiped(ItemStack umbrella, PlayerEntity player) {
        return CuriosApi.getCuriosHelper().findEquippedCurio(umbrella.getItem(), player).get();
    }

}