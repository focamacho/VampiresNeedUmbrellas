package com.focamacho.vampiresneedumbrellas.handlers;

import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.items.*;
import com.focamacho.vampiresneedumbrellas.utils.Utils;
import net.minecraft.item.Item;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TooltipHandler {

    @SubscribeEvent(priority = EventPriority.LOW)
    public void onTooltipEvent(ItemTooltipEvent event) {
        Item item = event.getItemStack().getItem();
        if((Utils.isCuriosLoaded && !ConfigHolder.umbrellaBauble) && (item instanceof ItemIronUmbrella || item instanceof ItemGoldUmbrella || item instanceof ItemDiamondUmbrella || item instanceof ItemNetheriteUmbrella || item instanceof ItemCreativeUmbrella)) {
            ITextComponent toRemove = null;
            for(ITextComponent text : event.getToolTip()){
                if(text.getString().contains(new TranslationTextComponent("curios.slot").getString())) {
                    toRemove = text;
                    break;
                }
            }
            if(toRemove != null) event.getToolTip().remove(toRemove);
        }
    }

}
