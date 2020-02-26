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

public class ItemUmbrella extends Item {
	
	private boolean breakable;
	
	public ItemUmbrella(String name, int durability, int color) {
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
		this.setCreativeTab(VampiresNeedUmbrellas.vampiresNeedUmbrellasTab);
		if(durability != -1) { this.setMaxDamage(durability); breakable = true; }
		else breakable = false;
		
		this.addPropertyOverride(new ResourceLocation(VampiresNeedUmbrellas.MODID, "color"), new IItemPropertyGetter() {

			@Override
			public float apply(ItemStack stack, World worldIn, EntityLivingBase entityIn) {
				return color;
			}

		});
		
		ModObjects.itemsList.add(this);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(canApplyEffect(entityIn)) {
			EntityPlayer player = (EntityPlayer) entityIn;
			if((ConfigUmbrella.umbrellaMainHand && player.getHeldItemMainhand().equals(stack)) || (ConfigUmbrella.umbrellaOffHand && player.getHeldItemOffhand().equals(stack))) {
				if(!player.isPotionActive(ModPotions.sunscreen)) {
					player.addPotionEffect(new PotionEffect(ModPotions.sunscreen, ConfigUmbrella.umbrellaProtectionTime * 20, 5, false, false));
					if(breakable) stack.damageItem(ConfigUmbrella.umbrellaProtectionTime, player);
				}
			}
		}
	}
	
	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
		return ConfigUmbrella.umbrellaAnvil;
	}
	
	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return false;
	}

	private boolean canApplyEffect(Entity entity) {
		return (!entity.world.isRemote && entity instanceof EntityPlayer && entity.world.isDaytime() && entity.world.canSeeSky(entity.getPosition())) ? true : false;
	}
	
}
