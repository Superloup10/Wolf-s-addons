/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://dl.dropboxusercontent.com/u/135157801/License/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.event;

import org.lwjgl.input.Keyboard;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import wolf.addons.common.item.WolfItemList;

public class LivingEvent
{
	@SubscribeEvent
	public void onLivingHurt(LivingHurtEvent event)
	{
		ItemStack helmet = event.entityLiving.getEquipmentInSlot(4);
		ItemStack chestplate = event.entityLiving.getEquipmentInSlot(3);
		ItemStack leggings = event.entityLiving.getEquipmentInSlot(2);
		ItemStack boots = event.entityLiving.getEquipmentInSlot(1);

		if (helmet != null && helmet.getItem() == WolfItemList.redstoneHelmet && chestplate != null && chestplate.getItem() == WolfItemList.redstoneChestplate && leggings != null && leggings.getItem() == WolfItemList.redstoneLeggings && boots != null && boots.getItem() == WolfItemList.redstoneBoots)
		{
			if (!helmet.hasTagCompound())
			{
				helmet.setTagCompound(new NBTTagCompound());
			}

			if (helmet.getTagCompound().getByte("Mode") == 1)
			{
				if ("inFire".equals(event.source.getDamageType()) || "onFire".equals(event.source.getDamageType()) || "lava".equals(event.source.getDamageType()))
				{
					boots.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
					leggings.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
					chestplate.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
					helmet.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
					event.ammount = 0;
				}
			}
		}

		if (helmet != null && helmet.getItem() == WolfItemList.lapisHelmet && chestplate != null && chestplate.getItem() == WolfItemList.lapisChestplate && leggings != null && leggings.getItem() == WolfItemList.lapisLeggings && boots != null && boots.getItem() == WolfItemList.lapisBoots)
		{
			if ("drown".equals(event.source.getDamageType()))
			{
				boots.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				leggings.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				chestplate.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				helmet.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				event.ammount = 0;
			}
		}

		if (helmet != null && helmet.getItem() == WolfItemList.emeraldHelmet && chestplate != null && chestplate.getItem() == WolfItemList.emeraldChestplate && leggings != null && leggings.getItem() == WolfItemList.emeraldLeggings && boots != null && boots.getItem() == WolfItemList.emeraldBoots)
		{
			if ("cactus".equals(event.source.getDamageType()) || "wither".equals(event.source.getDamageType()) || "inWall".equals(event.source.getDamageType()))
			{
				boots.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				leggings.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				chestplate.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				helmet.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				event.ammount = 0;
			}
			else if ("fall".equals(event.source.getDamageType()))
			{
				boots.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				event.ammount = 0;
			}
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onTooltip(ItemTooltipEvent event)
	{
		if (event.itemStack.getItem() == WolfItemList.redstoneSword)
		{
			if (!event.itemStack.hasTagCompound())
			{
				event.itemStack.setTagCompound(new NBTTagCompound());
			}

			if (event.itemStack.getTagCompound().getByte("Mode") == 0)
			{
				if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
				{
					event.toolTip.add(StatCollector.translateToLocal("sword.info.not_secret.0"));
				}
				else
				{
					event.toolTip.add(StatCollector.translateToLocal("sword.info.secret"));
				}
			}
			else
			{
				if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
				{
					event.toolTip.add(StatCollector.translateToLocal("sword.info.not_secret.1"));
				}
				else
				{
					event.toolTip.add(StatCollector.translateToLocal("sword.info.secret"));
				}
			}
		}
	}
}
