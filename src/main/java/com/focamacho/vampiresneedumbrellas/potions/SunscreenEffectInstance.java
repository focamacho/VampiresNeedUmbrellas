package com.focamacho.vampiresneedumbrellas.potions;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SunscreenEffectInstance extends MobEffectInstance {

    public SunscreenEffectInstance(MobEffect sunscreenEffect) {
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
