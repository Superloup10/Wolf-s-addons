/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://dl.dropboxusercontent.com/u/135157801/License/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.event;

import net.minecraft.item.Item;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;

import wolf.addons.common.achievements.WolfAchievements;
import wolf.addons.common.block.WolfBlockList;
import wolf.addons.common.item.WolfItemList;

public class CraftingHandler
{
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event)
	{
		if (event.crafting.getItem().equals(Item.getItemFromBlock(WolfBlockList.compressor)))
		{
			event.player.addStat(WolfAchievements.craftCompressor, 1);
		}

		if (event.crafting.getItem().equals(WolfItemList.silverIngot))
		{
			event.player.addStat(WolfAchievements.silverIngot, 1);
		}

		if (event.crafting.getItem().equals(WolfItemList.redstoneIngot))
		{
			event.player.addStat(WolfAchievements.redstoneIngot, 1);
		}

		if (event.crafting.getItem().equals(WolfItemList.lapisIngot))
		{
			event.player.addStat(WolfAchievements.lapisIngot, 1);
		}

		if (event.crafting.getItem().equals(WolfItemList.emeraldIngot))
		{
			event.player.addStat(WolfAchievements.emeraldIngot, 1);
		}
	}

	@SubscribeEvent
	public void onSmelting(ItemSmeltedEvent event)
	{

	}
}
