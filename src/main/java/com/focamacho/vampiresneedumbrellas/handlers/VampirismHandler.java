package com.focamacho.vampiresneedumbrellas.handlers;

import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.potions.SunscreenEffectInstance;
import com.focamacho.vampiresneedumbrellas.utils.Utils;
import de.teamlapen.vampirism.api.VReference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;
import net.minecraftforge.registries.ObjectHolder;
import org.apache.commons.lang3.tuple.ImmutableTriple;

import java.util.Optional;

public class VampirismHandler {

	@ObjectHolder("vampirism:sunscreen")
	private static Effect vampirism_sunscreen;

	public static void applyEffect(ItemStack stack, World world, Entity entityIn, boolean breakable) {
		if (canApplyEffect(entityIn)) {
			PlayerEntity player = (PlayerEntity) entityIn;
			if ((ConfigHolder.umbrellaMainHand && player.getMainHandItem().equals(stack)) || (ConfigHolder.umbrellaOffHand && player.getOffhandItem().equals(stack))) {
				player.addEffect(new SunscreenEffectInstance(vampirism_sunscreen));
				if (breakable && VReference.VAMPIRE_FACTION.getPlayerCapability(player).map(v->v.isGettingSundamage(world)).orElse(false)) {
					stack.hurtAndBreak(1, player, consumer -> consumer.broadcastBreakEvent(player.getUsedItemHand()));
				}
				return;
			}

			if (Utils.isCuriosLoaded && ConfigHolder.umbrellaBauble) {
				Optional<ImmutableTriple<String, Integer, ItemStack>> opt = CuriosHandler.getUmbrellaEquiped(stack, player);
				if(opt.isPresent()) {
					ImmutableTriple<String, Integer, ItemStack> umbrella = opt.get();
					player.addEffect(new SunscreenEffectInstance(vampirism_sunscreen));

					if (breakable && VReference.VAMPIRE_FACTION.getPlayerCapability(player).map(v->v.isGettingSundamage(world)).orElse(false)) {
						String id = umbrella.getLeft();
						Integer index = umbrella.getMiddle();

						stack.hurtAndBreak(1, player, consumer -> CuriosHandler.onBrokenCurio(id, index, consumer));
					}
				}
			}
		}
	}

	public static void applyCreativeEffect(ItemStack stack, Entity entityIn) {
		if (canApplyEffect(entityIn)) {
			PlayerEntity player = (PlayerEntity)entityIn;
			if ((ConfigHolder.creativeUmbrellaConfigs && ((ConfigHolder.umbrellaMainHand && player.getMainHandItem().equals(stack)) || (ConfigHolder.umbrellaOffHand && player.getOffhandItem().equals(stack))))) {
				player.addEffect(new SunscreenEffectInstance(vampirism_sunscreen));
			} else if ((player.getMainHandItem().equals(stack) || player.getOffhandItem().equals(stack) || (Utils.isCuriosLoaded && ConfigHolder.umbrellaBauble && CuriosHandler.getUmbrellaEquiped(stack, player).isPresent()))) {
				player.addEffect(new SunscreenEffectInstance(vampirism_sunscreen));
			} else if(Utils.isCuriosLoaded && ConfigHolder.umbrellaBauble && CuriosHandler.getUmbrellaEquiped(stack, player).isPresent()) {
				player.addEffect(new SunscreenEffectInstance(vampirism_sunscreen));
			}
		}
	}

	private static boolean canApplyEffect(Entity entity) {
		if(!(entity instanceof PlayerEntity)) return false;
		PlayerEntity player = (PlayerEntity) entity;
		EffectInstance effectInstance = player.getEffect(vampirism_sunscreen);
		return effectInstance == null || effectInstance.getDuration() <= 1;
	}

}