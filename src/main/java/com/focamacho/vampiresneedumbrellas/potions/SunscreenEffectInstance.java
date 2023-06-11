package com.focamacho.vampiresneedumbrellas.potions;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;

public class SunscreenEffectInstance extends MobEffectInstance {

    public SunscreenEffectInstance(MobEffect sunscreenEffect) {
        super(sunscreenEffect, 21, 5, false, false);
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
