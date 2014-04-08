package wolf_addons.common.event;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import wolf_addons.common.achievements.WolfAchievements;
import wolf_addons.common.item.WolfItemList;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemPickupEvent;

public class PickupHandler
{
	@SubscribeEvent
	public void onPickupHandler(ItemPickupEvent event)
	{
		if(event.pickedUp.getEntityItem().getItem().equals(WolfItemList.silverDust))
		{
			event.player.triggerAchievement(WolfAchievements.silverDust);
		}
		
		if(event.pickedUp.getEntityItem().getItem().equals(Items.redstone))
		{
			event.player.triggerAchievement(WolfAchievements.redstoneDust);
		}
		
		if(event.pickedUp.getEntityItem().getItem().equals(new ItemStack(Items.dye, 1, 4)))
		{
			event.player.triggerAchievement(WolfAchievements.lapisDust);
		}
		
		if(event.pickedUp.getEntityItem().getItem().equals(Items.emerald))
		{
			event.player.triggerAchievement(WolfAchievements.emeraldDust);
		}
	}
}