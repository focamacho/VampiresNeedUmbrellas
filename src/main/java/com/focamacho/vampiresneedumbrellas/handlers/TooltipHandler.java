package com.focamacho.vampiresneedumbrellas.handlers;

import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.utils.Utils;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TooltipHandler {

    @SubscribeEvent
    public void onTooltipEvent(ItemTooltipEvent event) {
        if (Utils.isCuriosLoaded && !ConfigHolder.umbrellaBauble && (event.getItemStack().getItem() instanceof com.focamacho.vampiresneedumbrellas.items.ItemIronUmbrella || event.getItemStack().getItem() instanceof com.focamacho.vampiresneedumbrellas.items.ItemGoldUmbrella || event.getItemStack().getItem() instanceof com.focamacho.vampiresneedumbrellas.items.ItemDiamondUmbrella || event.getItemStack().getItem() instanceof com.focamacho.vampiresneedumbrellas.items.ItemCreativeUmbrella)) {
            ITextComponent toRemove = null;
            for (ITextComponent text : event.getToolTip()) {
                if (text.getFormattedText().contains((new TranslationTextComponent("curios.slot", new Object[0])).getFormattedText())) {
                    toRemove = text;
                    break;
                }
            }
            if (toRemove != null)
                event.getToolTip().remove(toRemove);
        }
    }
}
