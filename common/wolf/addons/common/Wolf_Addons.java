/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wolf.addons.common.achievements.WolfAchievements;
import wolf.addons.common.block.WolfBlockList;
import wolf.addons.common.creativestabs.WolfCT;
import wolf.addons.common.event.CraftingHandler;
import wolf.addons.common.event.LivingEvent;
import wolf.addons.common.event.PickupHandler;
import wolf.addons.common.gui.GuiHandler;
import wolf.addons.common.item.WolfItemList;
import wolf.addons.common.recipe.WolfRecipe;
import wolf.addons.common.tileentity.WolfTE;
import wolf.addons.common.worldgenerator.OreGenerator;
import wolf.addons.proxy.WolfCommonProxy;

@Mod(modid = Wolf_Addons.MODID, name = "Wolf's Addons", version = "@version@")
public class Wolf_Addons
{
    public static final String MODID = "wolf_addons";

    @SidedProxy(clientSide = "wolf.addons.proxy.WolfClientProxy", serverSide = "wolf.addons.proxy.WolfCommonProxy")
    public static WolfCommonProxy proxy;

    @Instance("Wolf_Addons")
    public static Wolf_Addons instance;

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
        proxy.registerTESR();
        proxy.registerTexture();
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