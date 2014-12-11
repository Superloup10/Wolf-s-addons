/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://dl.dropboxusercontent.com/u/135157801/License/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.proxy;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import wolf.addons.client.render.RenderHammer;
import wolf.addons.common.item.WolfItemList;

public class WolfClientProxy extends WolfCommonProxy
{
    @Override
    public void registerBlock(Block block, String name)
    {
        super.registerBlock(block, name);
        registerBlockTexture(block, name);
    }

    @Override
    public void registerRender()
    {
        MinecraftForgeClient.registerItemRenderer(WolfItemList.woodHammer, new RenderHammer());
        MinecraftForgeClient.registerItemRenderer(WolfItemList.stoneHammer, new RenderHammer());
        MinecraftForgeClient.registerItemRenderer(WolfItemList.ironHammer, new RenderHammer());
        MinecraftForgeClient.registerItemRenderer(WolfItemList.goldHammer, new RenderHammer());
        MinecraftForgeClient.registerItemRenderer(WolfItemList.diamondHammer, new RenderHammer());
        MinecraftForgeClient.registerItemRenderer(WolfItemList.silverHammer, new RenderHammer());
        MinecraftForgeClient.registerItemRenderer(WolfItemList.redstoneHammer, new RenderHammer());
        MinecraftForgeClient.registerItemRenderer(WolfItemList.lapisHammer, new RenderHammer());
        MinecraftForgeClient.registerItemRenderer(WolfItemList.emeraldHammer, new RenderHammer());
    }

    public static void registerItem(Item item, int metadata, String name)
    {
        ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
        mesher.register(item, metadata, new ModelResourceLocation("wolf_addons:" + name, "inventory"));
    }

    public static void registerItem(Item item, String name)
    {
        registerItem(item, 0, name);
    }

    public static void registerBlockTexture(Block block, int metadata, String name)
    {
        registerItem(Item.getItemFromBlock(block), metadata, name);
    }

    public static void registerBlockTexture(Block block, String name)
    {
        registerBlockTexture(block, 0, name);
    }
}