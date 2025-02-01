package com.focamacho.vampiresneedumbrellas.potions;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;

public class SunscreenEffectInstance extends MobEffectInstance {

    public SunscreenEffectInstance(Holder<MobEffect> sunscreenEffect) {
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
