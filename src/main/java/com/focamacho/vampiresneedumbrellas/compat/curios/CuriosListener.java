package com.focamacho.vampiresneedumbrellas.compat.curios;

import com.focamacho.vampiresneedumbrellas.items.ItemUmbrella;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.SubscribeEvent;
import top.theillusivec4.curios.api.event.CurioAttributeModifierEvent;

public class CuriosListener {

    @SubscribeEvent
    public void onItem(final CurioAttributeModifierEvent event) {
        if(event.getItemStack().getItem() instanceof ItemUmbrella) {
            event.addModifier(Attributes.MOVEMENT_SPEED, new AttributeModifier(ResourceLocation.parse("vampiresneedumbrellas:umbrella_modifier"), ((ItemUmbrella) event.getItemStack().getItem()).speedSupplier.get(), AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        }
    }

}
