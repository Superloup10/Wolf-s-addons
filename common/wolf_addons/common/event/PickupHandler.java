/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf_addons.common.event;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemPickupEvent;

import wolf_addons.common.achievements.WolfAchievements;
import wolf_addons.common.item.WolfItemList;

public class PickupHandler
{
	@SubscribeEvent
	public void onPickupHandler(ItemPickupEvent event)
	{
		if (event.pickedUp.getEntityItem().getItem().equals(WolfItemList.silverDust))
		{
			event.player.triggerAchievement(WolfAchievements.silverDust);
		}

		if (event.pickedUp.getEntityItem().getItem().equals(Items.redstone))
		{
			event.player.triggerAchievement(WolfAchievements.redstoneDust);
		}

		if (event.pickedUp.getEntityItem().getItem().equals(new ItemStack(Items.dye, 1, 4)))
		{
			event.player.triggerAchievement(WolfAchievements.lapisDust);
		}

		if (event.pickedUp.getEntityItem().getItem().equals(Items.emerald))
		{
			event.player.triggerAchievement(WolfAchievements.emeraldDust);
		}
	}
}