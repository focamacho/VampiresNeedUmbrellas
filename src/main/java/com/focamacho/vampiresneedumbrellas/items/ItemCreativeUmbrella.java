package com.focamacho.vampiresneedumbrellas.items;

import com.focamacho.vampiresneedumbrellas.VampiresNeedUmbrellas;
import com.focamacho.vampiresneedumbrellas.config.ConfigUmbrella;
import com.focamacho.vampiresneedumbrellas.handlers.ModObjects;

import de.teamlapen.vampirism.core.ModPotions;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
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
		if(entityIn instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityIn;
			if(ConfigUmbrella.creativeUmbrellaConfigs && ((ConfigUmbrella.umbrellaMainHand && player.getHeldItemMainhand().equals(stack)) || (ConfigUmbrella.umbrellaOffHand && player.getHeldItemOffhand().equals(stack)))) {
				if(!player.isPotionActive(ModPotions.sunscreen)) {
					player.addPotionEffect(new PotionEffect(ModPotions.sunscreen, ConfigUmbrella.umbrellaProtectionTime * 20, 5, false, false));
				}
			} else if(player.getHeldItemMainhand().equals(stack) || player.getHeldItemOffhand().equals(stack)){
				if(!player.isPotionActive(ModPotions.sunscreen)) {
					player.addPotionEffect(new PotionEffect(ModPotions.sunscreen, ConfigUmbrella.umbrellaProtectionTime * 20, 5, false, false));
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
	
}
