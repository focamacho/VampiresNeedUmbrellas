package com.focamacho.vampiresneedumbrellas.handlers;

import com.focamacho.vampiresneedumbrellas.config.ConfigHolder;
import com.focamacho.vampiresneedumbrellas.potions.SunscreenEffectInstance;
import com.focamacho.vampiresneedumbrellas.utils.Utils;
import de.teamlapen.vampirism.api.VReference;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ObjectHolder;
import top.theillusivec4.curios.api.SlotResult;

import java.util.Optional;

public class VampirismHandler {

	@ObjectHolder(registryName = "mob_effect", value = "vampirism:sunscreen")
	public static MobEffect vampirism_sunscreen;

	public static void applyEffect(ItemStack stack, Level world, Entity entityIn, boolean breakable) {
		if (canApplyEffect(entityIn)) {
			Player player = (Player) entityIn;
			if ((ConfigHolder.umbrellaMainHand && player.getMainHandItem().equals(stack)) || (ConfigHolder.umbrellaOffHand && player.getOffhandItem().equals(stack))) {
				player.addEffect(new SunscreenEffectInstance(vampirism_sunscreen));
				if (breakable && VReference.VAMPIRE_FACTION.getPlayerCapability(player).map(v->v.isGettingSundamage(world)).orElse(false)) {
					stack.hurtAndBreak(1, player, consumer -> consumer.broadcastBreakEvent(player.getUsedItemHand()));
				}
				return;
			}

			if (Utils.isCuriosLoaded && ConfigHolder.umbrellaBauble) {
				Optional<SlotResult> opt = CuriosHandler.getUmbrellaEquiped(stack, player);
				if(opt.isPresent()) {
					SlotResult umbrella = opt.get();
					player.addEffect(new SunscreenEffectInstance(vampirism_sunscreen));

					if (breakable && VReference.VAMPIRE_FACTION.getPlayerCapability(player).map(v->v.isGettingSundamage(world)).orElse(false)) {
						String id = umbrella.slotContext().identifier();
						int index = umbrella.slotContext().index();

						stack.hurtAndBreak(1, player, consumer -> CuriosHandler.onBrokenCurio(id, index, consumer));
					}
				}
			}
		}
	}

	public static void applyCreativeEffect(ItemStack stack, Entity entityIn) {
		if (canApplyEffect(entityIn)) {
			Player player = (Player)entityIn;
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
		if(!(entity instanceof Player player)) return false;
		MobEffectInstance effectInstance = player.getEffect(vampirism_sunscreen);
		return effectInstance == null || effectInstance.getDuration() <= 1;
	}

}