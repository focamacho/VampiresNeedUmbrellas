package com.focamacho.vampiresneedumbrellas.potions;

import de.teamlapen.vampirism.util.REFERENCE;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;

/**
 * Base class for Vampirism's potions
 */
public class VampirismPotion extends Effect {
	
    public VampirismPotion(String name, EffectType effectType, int potionColor) {
        super(effectType, potionColor);
        this.setRegistryName(REFERENCE.MODID, name);
    }

    @Override
    public boolean shouldRender(EffectInstance effect) {
    	return false;
    }
    
    @Override
    public boolean shouldRenderHUD(EffectInstance effect) {
    	return false;
    }
    
    @Override
    public boolean shouldRenderInvText(EffectInstance effect) {
    	return false;
    }

}