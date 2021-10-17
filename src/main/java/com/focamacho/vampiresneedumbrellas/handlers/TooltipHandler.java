package com.focamacho.vampiresneedumbrellas.handlers;

import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.items.ItemUmbrella;
import com.focamacho.vampiresneedumbrellas.utils.Utils;
import com.google.common.collect.Lists;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Collections;
import java.util.List;

public class TooltipHandler {

    @SubscribeEvent(priority = EventPriority.LOW)
    public void onTooltipEvent(ItemTooltipEvent event) {
        Item item = event.getItemStack().getItem();
        if (item instanceof ItemUmbrella) {
            List<Component> tooltip = event.getToolTip();
            List<Integer> indexesToRemove = Lists.newArrayList();
            int indexToReplace = -1;

            for (int i = 0; i < tooltip.size(); i++) {
                Component text = tooltip.get(i);
                String string = text.getString();

                if (Utils.isCuriosLoaded) {
                    if (!ConfigHolder.umbrellaBauble && string.contains(new TranslatableComponent("curios.slot").getString())) {
                        indexesToRemove.add(i);
                        continue;
                    }
                }

                if (string.contains(new TranslatableComponent("item.modifiers.mainhand").getString())) {
                    indexToReplace = i;
                } else if (string.contains(new TranslatableComponent("item.modifiers.offhand").getString())) {
                    if (i - 1 >= 0) indexesToRemove.add(i - 1);
                    indexesToRemove.add(i);
                    if (tooltip.size() > i + 1) indexesToRemove.add(i + 1);
                }
            }

            if(indexToReplace != -1) event.getToolTip().set(indexToReplace, new TranslatableComponent("modifiers.vampiresneedumbrellas.use").withStyle(ChatFormatting.GRAY));
            Collections.reverse(indexesToRemove);
            indexesToRemove.forEach(index -> event.getToolTip().remove((int) index));
        }

    }

}