package com.focamacho.vampiresneedumbrellas.potions;

import de.teamlapen.vampirism.core.ModEffects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;

public class VampirismSunscreenEffect extends EffectInstance {

    public VampirismSunscreenEffect(World world) {
        super(ModEffects.sunscreen, 21, 5, false, false);
        if(world.isRemote) setPotionDurationMax(true);
    }

}
