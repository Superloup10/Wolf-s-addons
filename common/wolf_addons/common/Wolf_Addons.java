package wolf_addons.common;

import wolf_addons.common.block.WolfBlockList;
import wolf_addons.common.item.WolfItemList;
import wolf_addons.common.recipe.WolfRecipe;
import wolf_addons.proxy.WolfCommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="Wolf's Addons", name="Wolf's Addons", version="%version%")
public class Wolf_Addons
{
	@SidedProxy(clientSide = "wolf_addons.proxy.WolfClientProxy", serverSide = "wolf_addons.proxy.WolfCommonProxy")
	public static WolfCommonProxy proxy;
	
	@Instance("Wolf's Addons")
	public static Wolf_Addons instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		WolfBlockList.loadBlock();
		WolfItemList.loadItem();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerRender();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		WolfRecipe.loadRecipe();
		WolfRecipe.loadSmelting();
	}
}