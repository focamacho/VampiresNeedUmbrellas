package com.focamacho.vampiresneedumbrellas;

import com.focamacho.vampiresneedumbrellas.handlers.ModObjects;
import com.focamacho.vampiresneedumbrellas.handlers.RegistryHandler;
import com.focamacho.vampiresneedumbrellas.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = VampiresNeedUmbrellas.MODID, name = VampiresNeedUmbrellas.NAME, version = VampiresNeedUmbrellas.VERSION, dependencies = "required-after:vampirism@[1.5.7,)")
public class VampiresNeedUmbrellas
{
    public static final String MODID = "vampiresneedumbrellas";
    public static final String NAME = "Vampires Need Umbrellas";
    public static final String VERSION = "1.2";

    @SidedProxy(clientSide = "com.focamacho.vampiresneedumbrellas.proxy.ClientProxy", serverSide = "com.focamacho.vampiresneedumbrellas.proxy.CommonProxy")
	public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        RegistryHandler.preInit(event);
        
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	RegistryHandler.init(event);
    }
    
    public static final CreativeTabs vampiresNeedUmbrellasTab = new CreativeTabs("tab.vampiresNeedUmbrellas.name") {
		
    	@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ModObjects.umbrellaIron, 1, 0);
		}
		
		@SideOnly(Side.CLIENT)
		public boolean hasSearchBar() {
			return false;
		}
	};
}
