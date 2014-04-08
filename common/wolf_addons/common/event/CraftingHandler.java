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
			event.player.triggerAchievement(WolfAchievements.craftCompressor);
		}
		
		if(event.crafting.getItem().equals(WolfItemList.silverIngot))
		{
			event.player.triggerAchievement(WolfAchievements.silverIngot);
		}
		
		if(event.crafting.getItem().equals(WolfItemList.redstoneIngot))
		{
			event.player.triggerAchievement(WolfAchievements.redstoneIngot);
		}
		
		if(event.crafting.getItem().equals(WolfItemList.lapisIngot))
		{
			event.player.triggerAchievement(WolfAchievements.lapisIngot);
		}
		
		if(event.crafting.getItem().equals(WolfItemList.emeraldIngot))
		{
			event.player.triggerAchievement(WolfAchievements.emeraldIngot);
		}
	}
	
	@SubscribeEvent
	public void onSmelting(ItemSmeltedEvent event)
	{
		
	}
}