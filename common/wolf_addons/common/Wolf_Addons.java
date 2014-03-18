package wolf_addons.common;

import net.minecraftforge.common.MinecraftForge;
import wolf_addons.common.block.WolfBlockList;
import wolf_addons.common.creativestabs.WolfCT;
import wolf_addons.common.event.LivingEvent;
import wolf_addons.common.gui.GuiHandler;
import wolf_addons.common.item.WolfItemList;
import wolf_addons.common.recipe.WolfRecipe;
import wolf_addons.common.tileentity.WolfTE;
import wolf_addons.proxy.WolfCommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid="Wolf_Addons", name="Wolf's Addons", version="%version%")
public class Wolf_Addons
{
	@SidedProxy(clientSide = "wolf_addons.proxy.WolfClientProxy", serverSide = "wolf_addons.proxy.WolfCommonProxy")
	public static WolfCommonProxy proxy;
	
	@Instance("Wolf's Addons")
	public static Wolf_Addons instance;
	public static GuiHandler guiHandler = new GuiHandler();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		WolfCT.loadCreativeTabs();
		WolfBlockList.loadBlock();
		WolfItemList.loadItem();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerRender();
		MinecraftForge.EVENT_BUS.register(new LivingEvent());
		
		WolfTE.loadTileEntity();
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, guiHandler);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		WolfRecipe.loadRecipe();
		WolfRecipe.loadSmelting();
	}
}