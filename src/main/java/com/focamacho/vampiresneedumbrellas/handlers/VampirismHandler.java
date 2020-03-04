package com.focamacho.vampiresneedumbrellas.handlers;

import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;

import de.teamlapen.vampirism.api.VReference;
import de.teamlapen.vampirism.core.ModEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;

public class VampirismHandler {
	
	public static IAttribute sunDamage = VReference.sunDamage;
	
	public static void applyEffect(ItemStack stack, World worldIn, Entity entityIn, boolean breakable) {
		if(canApplyEffect(entityIn)) {
			PlayerEntity player = (PlayerEntity) entityIn;
			if((ConfigHolder.umbrellaMainHand && player.getHeldItemMainhand().equals(stack)) || (ConfigHolder.umbrellaOffHand && player.getHeldItemOffhand().equals(stack))) {
				if(!player.isPotionActive(ModEffects.sunscreen)) {
					player.addPotionEffect(new EffectInstance(ModEffects.sunscreen, ConfigHolder.umbrellaProtectionTime * 20, 5, false, false));
					if(breakable) stack.damageItem(ConfigHolder.umbrellaProtectionTime, player, (consumer) -> consumer.sendBreakAnimation(player.getActiveHand()));
				}
			}
		}
	}
	
	public static void applyCreativeEffect(ItemStack stack, World worldIn, Entity entityIn) {
		if(entityIn instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) entityIn;
			if(ConfigHolder.creativeUmbrellaConfigs && ((ConfigHolder.umbrellaMainHand && player.getHeldItemMainhand().equals(stack)) || (ConfigHolder.umbrellaOffHand && player.getHeldItemOffhand().equals(stack)))) {
				if(!player.isPotionActive(ModEffects.sunscreen)) {
					player.addPotionEffect(new EffectInstance(ModEffects.sunscreen, ConfigHolder.umbrellaProtectionTime * 20, 5, false, false));
				}
			} else if(player.getHeldItemMainhand().equals(stack) || player.getHeldItemOffhand().equals(stack)){
				if(!player.isPotionActive(ModEffects.sunscreen)) {
					player.addPotionEffect(new EffectInstance(ModEffects.sunscreen, ConfigHolder.umbrellaProtectionTime * 20, 5, false, false));
				}
			}
		}
	}
	
	private static boolean canApplyEffect(Entity entity) {
		return (!entity.world.isRemote && entity instanceof PlayerEntity && entity.world.isDaytime() && entity.world.canBlockSeeSky(entity.getPosition()));
	}
}
