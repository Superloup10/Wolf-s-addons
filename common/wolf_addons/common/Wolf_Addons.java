/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf_addons.common;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraftforge.common.MinecraftForge;

import wolf_addons.common.achievements.WolfAchievements;
import wolf_addons.common.block.WolfBlockList;
import wolf_addons.common.creativestabs.WolfCT;
import wolf_addons.common.event.CraftingHandler;
import wolf_addons.common.event.LivingEvent;
import wolf_addons.common.event.PickupHandler;
import wolf_addons.common.gui.GuiHandler;
import wolf_addons.common.item.WolfItemList;
import wolf_addons.common.recipe.WolfRecipe;
import wolf_addons.common.tileentity.WolfTE;
import wolf_addons.common.worldgenerator.OreGenerator;
import wolf_addons.proxy.WolfCommonProxy;

@Mod(modid = "Wolf_Addons", name = "Wolf's Addons", version = "@version@")
public class Wolf_Addons
{
	@SidedProxy(clientSide = "wolf_addons.proxy.WolfClientProxy", serverSide = "wolf_addons.proxy.WolfCommonProxy")
	public static WolfCommonProxy proxy;

	@Instance("Wolf_Addons")
	public static Wolf_Addons instance;
	public static GuiHandler guiHandler = new GuiHandler();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		WolfCT.loadCreativeTabs();
		WolfBlockList.loadBlock();
		WolfBlockList.loadIntegration();
		WolfItemList.loadItem();
		WolfItemList.loadIntegration();
		WolfAchievements.loadAchievements();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerRender();
		MinecraftForge.EVENT_BUS.register(new LivingEvent());
		FMLCommonHandler.instance().bus().register(new CraftingHandler());
		FMLCommonHandler.instance().bus().register(new PickupHandler());

		WolfTE.loadTileEntity();
		NetworkRegistry.INSTANCE.registerGuiHandler(this.instance, new GuiHandler());

		GameRegistry.registerWorldGenerator(new OreGenerator(), 0);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		WolfRecipe.loadRecipe();
		WolfRecipe.loadSmelting();
	}
}