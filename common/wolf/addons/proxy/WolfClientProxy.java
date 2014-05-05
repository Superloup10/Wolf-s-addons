/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.proxy;

import net.minecraftforge.client.MinecraftForgeClient;

import wolf.addons.client.render.RenderHammer;
import wolf.addons.common.item.WolfItemList;

public class WolfClientProxy extends WolfCommonProxy
{
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
}