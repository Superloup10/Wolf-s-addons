package wolf_addons.proxy;

import wolf_addons.client.render.RenderHammer;
import wolf_addons.common.item.WolfItemList;
import net.minecraftforge.client.MinecraftForgeClient;

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