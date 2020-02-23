package com.focamacho.vampiresneedumbrellas.potions;

import de.teamlapen.vampirism.util.REFERENCE;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

/**
 * Base class for Vampirism's potions
 */
public class VampirismPotion extends Potion {

    public VampirismPotion(String name, boolean badEffect, int potionColor) {
        super(badEffect, potionColor);
        this.setRegistryName(REFERENCE.MODID, name);
        this.setPotionName("effect.vampirism." + name);
    }


    @Override
    public boolean shouldRender(PotionEffect effect) {
    	return false;
    }
    
    @Override
    public boolean shouldRenderHUD(PotionEffect effect) {
   		return false;
   	}
    
    @Override
    public boolean shouldRenderInvText(PotionEffect effect) {
    	return false;
    }
    
    @Override
    public boolean hasStatusIcon() {
        return false;
    }

}