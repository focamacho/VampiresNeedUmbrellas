package com.focamacho.vampiresneedumbrellas.potions;

import de.teamlapen.vampirism.core.ModEffects;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SunscreenEffectInstance extends EffectInstance {

    public SunscreenEffectInstance() {
        super(ModEffects.sunscreen, 21, 5, false, false);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public boolean getIsPotionDurationMax() {
        return true;
    }

    @Override
    public boolean isShowIcon() {
        return false;
    }
}
