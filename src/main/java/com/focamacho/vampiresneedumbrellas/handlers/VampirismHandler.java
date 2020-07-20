package com.focamacho.vampiresneedumbrellas.handlers;

import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.potions.VampirismSunscreenEffect;
import com.focamacho.vampiresneedumbrellas.utils.Utils;
import de.teamlapen.vampirism.core.ModEffects;
import de.teamlapen.vampirism.player.vampire.VampirePlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.world.World;

public class VampirismHandler {

	public static Effect sunscreen;

	public static void applyEffect(ItemStack stack, World world, Entity entityIn, boolean breakable) {
		if (canApplyEffect(entityIn)) {
			PlayerEntity player = (PlayerEntity)entityIn;
			if (((ConfigHolder.umbrellaMainHand && player.getHeldItemMainhand().equals(stack)) || (ConfigHolder.umbrellaOffHand && player.getHeldItemOffhand().equals(stack)))) {
				player.addPotionEffect(new VampirismSunscreenEffect(world));
				if (breakable && VampirePlayer.get(player).isGettingSundamage(world)) {
					stack.damageItem(1, player, consumer -> consumer.sendBreakAnimation(player.getActiveHand()));
				}
				return;
			}

			if ((Utils.isCuriosLoaded && ConfigHolder.umbrellaBauble && CuriosHandler.isUmbrellaEquipped(stack, player))) {
				player.addPotionEffect(new VampirismSunscreenEffect(world));
				if (breakable && VampirePlayer.get(player).isGettingSundamage(world)) {
					String id = CuriosHandler.getUmbrellaEquiped(stack, player).getLeft();
					Integer index = CuriosHandler.getUmbrellaEquiped(stack, player).getMiddle();

					stack.damageItem(1, player, consumer -> CuriosHandler.onBrokenCurio(id, index, consumer));
				}
			}
		}
	}

	public static void applyCreativeEffect(ItemStack stack, World world, Entity entityIn) {
		if (canApplyEffect(entityIn)) {
			PlayerEntity player = (PlayerEntity)entityIn;
			if ((ConfigHolder.creativeUmbrellaConfigs && ((ConfigHolder.umbrellaMainHand && player.getHeldItemMainhand().equals(stack)) || (ConfigHolder.umbrellaOffHand && player.getHeldItemOffhand().equals(stack))))) {
				player.addPotionEffect(new VampirismSunscreenEffect(world));
			} else if ((player.getHeldItemMainhand().equals(stack) || player.getHeldItemOffhand().equals(stack) || (Utils.isCuriosLoaded && ConfigHolder.umbrellaBauble && CuriosHandler.isUmbrellaEquipped(stack, player)))) {
				player.addPotionEffect(new VampirismSunscreenEffect(world));
			} else if(Utils.isCuriosLoaded && ConfigHolder.umbrellaBauble && CuriosHandler.isUmbrellaEquipped(stack, player)) {
				player.addPotionEffect(new VampirismSunscreenEffect(world));
			}
		}
	}

	private static boolean canApplyEffect(Entity entity) {
		if(!(entity instanceof PlayerEntity)) return false;
		PlayerEntity player = (PlayerEntity) entity;
		if(player.getActivePotionEffect(ModEffects.sunscreen) != null && player.getActivePotionEffect(ModEffects.sunscreen).getDuration() > 1) return false;
		return true;
	}

}