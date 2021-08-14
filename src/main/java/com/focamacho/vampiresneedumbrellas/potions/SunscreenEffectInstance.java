package com.focamacho.vampiresneedumbrellas.potions;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SunscreenEffectInstance extends EffectInstance {

    public SunscreenEffectInstance(Effect sunscreenEffect) {
        super(sunscreenEffect, 21, 5, false, false);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public boolean isNoCounter() {
        return true;
    }

    @Override
    public boolean showIcon() {
        return false;
    }

    @Override
    public boolean isVisible() {
        return false;
    }
}
