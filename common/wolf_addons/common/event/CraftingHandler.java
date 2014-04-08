package wolf_addons.common.event;

import wolf_addons.common.achievements.WolfAchievements;
import wolf_addons.common.block.WolfBlockList;
import wolf_addons.common.item.WolfItemList;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;

public class CraftingHandler
{
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event)
	{
		if(event.crafting.getItem().equals(WolfBlockList.compressor))
		{
			event.player.addStat(WolfAchievements.craftCompressor, 1);
		}
		
		if(event.crafting.getItem().equals(WolfItemList.silverIngot))
		{
			event.player.addStat(WolfAchievements.silverIngot, 1);
		}
		
		if(event.crafting.getItem().equals(WolfItemList.redstoneIngot))
		{
			event.player.addStat(WolfAchievements.redstoneIngot, 1);
		}
		
		if(event.crafting.getItem().equals(WolfItemList.lapisIngot))
		{
			event.player.addStat(WolfAchievements.lapisIngot, 1);
		}
		
		if(event.crafting.getItem().equals(WolfItemList.emeraldIngot))
		{
			event.player.addStat(WolfAchievements.emeraldIngot, 1);
		}
	}
	
	@SubscribeEvent
	public void onSmelting(ItemSmeltedEvent event)
	{
		
	}
}