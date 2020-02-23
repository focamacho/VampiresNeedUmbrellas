package com.focamacho.vampiresneedumbrellas.items;

import com.focamacho.vampiresneedumbrellas.VampiresNeedUmbrellas;
import com.focamacho.vampiresneedumbrellas.config.ConfigUmbrella;
import com.focamacho.vampiresneedumbrellas.handlers.ModObjects;

import de.teamlapen.vampirism.core.ModPotions;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemCreativeUmbrella extends Item {
	
	public ItemCreativeUmbrella() {
		this.setRegistryName("creative_umbrella");
		this.setUnlocalizedName("creative_umbrella");
		this.setMaxStackSize(1);
		this.setCreativeTab(VampiresNeedUmbrellas.vampiresNeedUmbrellasTab);
		
		ModObjects.itemsList.add(this);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(canApplyEffect(entityIn)) {
			EntityPlayer player = (EntityPlayer) entityIn;
			int slot = player.inventory.getSlotFor(stack);
			if(ConfigUmbrella.creativeUmbrellaConfigs) {
				if((ConfigUmbrella.umbrellaMainHand && slot == player.inventory.currentItem) || (ConfigUmbrella.umbrellaOffHand && slot == -1)) {
					if(!player.isPotionActive(ModPotions.sunscreen)) {
						player.addPotionEffect(new PotionEffect(ModPotions.sunscreen, ConfigUmbrella.umbrellaProtectionTime * 20, 5, false, false));
					}
				}
			} else {
				if(slot == player.inventory.currentItem || slot == -1) {
					if(!player.isPotionActive(ModPotions.sunscreen)) {
						player.addPotionEffect(new PotionEffect(ModPotions.sunscreen, ConfigUmbrella.umbrellaProtectionTime * 20, 5, false, false));
					}
				}
			}
		}
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return false;
	}

	private boolean canApplyEffect(Entity entity) {
		return (!entity.world.isRemote && entity instanceof EntityPlayer && entity.world.isDaytime() && entity.world.canSeeSky(entity.getPosition())) ? true : false;
	}
	
}
