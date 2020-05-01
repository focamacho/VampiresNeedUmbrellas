package com.focamacho.vampiresneedumbrellas.items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import com.focamacho.vampiresneedumbrellas.VampiresNeedUmbrellas;
import com.focamacho.vampiresneedumbrellas.config.ConfigUmbrella;
import com.focamacho.vampiresneedumbrellas.handlers.ModObjects;
import com.focamacho.vampiresneedumbrellas.handlers.VampirismHandler;
import com.focamacho.vampiresneedumbrellas.utils.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemUmbrellaBauble extends Item implements IBauble {

    private boolean breakable;

    public ItemUmbrellaBauble(String name, int durability, int color) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setMaxStackSize(1);
        this.setCreativeTab(VampiresNeedUmbrellas.vampiresNeedUmbrellasTab);
        if (durability != -1) {
            this.setMaxDamage(durability);
            breakable = true;
        } else breakable = false;

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
		if(Utils.isVampirismLoaded) VampirismHandler.applyEffect(stack, worldIn, entityIn, breakable);
	}
	
    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return ConfigUmbrella.umbrellaAnvil;
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.HEAD;
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        if(Utils.isVampirismLoaded) VampirismHandler.applyBaubleEffect(itemstack, player.world, player, breakable);
    }
    
	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return false;
	}

}
