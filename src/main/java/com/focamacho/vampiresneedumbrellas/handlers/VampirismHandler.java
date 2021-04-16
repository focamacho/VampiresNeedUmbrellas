package com.focamacho.vampiresneedumbrellas.handlers;

import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.potions.SunscreenEffectInstance;
import com.focamacho.vampiresneedumbrellas.utils.Utils;
import de.teamlapen.vampirism.core.ModEffects;
import de.teamlapen.vampirism.player.vampire.VampirePlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.ImmutableTriple;

import java.util.Optional;

public class VampirismHandler {

	public static void applyEffect(ItemStack stack, World world, Entity entityIn, boolean breakable) {
		if (canApplyEffect(entityIn)) {
			PlayerEntity player = (PlayerEntity) entityIn;
			if ((ConfigHolder.umbrellaMainHand && player.getHeldItemMainhand().equals(stack)) || (ConfigHolder.umbrellaOffHand && player.getHeldItemOffhand().equals(stack))) {
				player.addPotionEffect(new SunscreenEffectInstance());
				if (breakable && VampirePlayer.get(player).isGettingSundamage(world)) {
					stack.damageItem(1, player, consumer -> consumer.sendBreakAnimation(player.getActiveHand()));
				}
				return;
			}

			if (Utils.isCuriosLoaded && ConfigHolder.umbrellaBauble) {
				Optional<ImmutableTriple<String, Integer, ItemStack>> opt = CuriosHandler.getUmbrellaEquiped(stack, player);
				if(opt.isPresent()) {
					ImmutableTriple<String, Integer, ItemStack> umbrella = opt.get();
					player.addPotionEffect(new SunscreenEffectInstance());

					if (breakable && VampirePlayer.get(player).isGettingSundamage(world)) {
						String id = umbrella.getLeft();
						Integer index = umbrella.getMiddle();

						stack.damageItem(1, player, consumer -> CuriosHandler.onBrokenCurio(id, index, consumer));
					}
				}
			}
		}
	}

	public static void applyCreativeEffect(ItemStack stack, Entity entityIn) {
		if (canApplyEffect(entityIn)) {
			PlayerEntity player = (PlayerEntity)entityIn;
			if ((ConfigHolder.creativeUmbrellaConfigs && ((ConfigHolder.umbrellaMainHand && player.getHeldItemMainhand().equals(stack)) || (ConfigHolder.umbrellaOffHand && player.getHeldItemOffhand().equals(stack))))) {
				player.addPotionEffect(new SunscreenEffectInstance());
			} else if ((player.getHeldItemMainhand().equals(stack) || player.getHeldItemOffhand().equals(stack) || (Utils.isCuriosLoaded && ConfigHolder.umbrellaBauble && CuriosHandler.getUmbrellaEquiped(stack, player).isPresent()))) {
				player.addPotionEffect(new SunscreenEffectInstance());
			} else if(Utils.isCuriosLoaded && ConfigHolder.umbrellaBauble && CuriosHandler.getUmbrellaEquiped(stack, player).isPresent()) {
				player.addPotionEffect(new SunscreenEffectInstance());
			}
		}
	}

	private static boolean canApplyEffect(Entity entity) {
		if(!(entity instanceof PlayerEntity)) return false;
		PlayerEntity player = (PlayerEntity) entity;
		EffectInstance effectInstance = player.getActivePotionEffect(ModEffects.sunscreen);
		return effectInstance == null || effectInstance.getDuration() <= 1;
	}

}