package com.focamacho.vampiresneedumbrellas.handlers;

import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.items.ItemCreativeUmbrella;
import com.focamacho.vampiresneedumbrellas.items.ItemDiamondUmbrella;
import com.focamacho.vampiresneedumbrellas.items.ItemGoldUmbrella;
import com.focamacho.vampiresneedumbrellas.items.ItemIronUmbrella;
import com.focamacho.vampiresneedumbrellas.utils.Utils;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TooltipHandler {

    @SubscribeEvent
    public void onTooltipEvent(ItemTooltipEvent event) {
        if((Utils.isCuriosLoaded && !ConfigHolder.umbrellaBauble) && (event.getItemStack().getItem() instanceof ItemIronUmbrella || event.getItemStack().getItem() instanceof ItemGoldUmbrella || event.getItemStack().getItem() instanceof ItemDiamondUmbrella || event.getItemStack().getItem() instanceof ItemCreativeUmbrella)) {
            ITextComponent toRemove = null;
            for(ITextComponent text : event.getToolTip()){
                if(text.getFormattedText().contains(new TranslationTextComponent("curios.slot").getFormattedText())){
                    toRemove = text;
                    break;
                }
            }
            if(toRemove != null) event.getToolTip().remove(toRemove);
        }
    }

}
