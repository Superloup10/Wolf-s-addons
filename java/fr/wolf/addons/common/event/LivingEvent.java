/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package fr.wolf.addons.common.event;

import fr.wolf.addons.common.item.WolfItemList;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.input.Keyboard;

public class LivingEvent
{
    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event)
    {
        ItemStack helmet = event.entityLiving.getEquipmentInSlot(4);
        ItemStack chestplate = event.entityLiving.getEquipmentInSlot(3);
        ItemStack leggings = event.entityLiving.getEquipmentInSlot(2);
        ItemStack boots = event.entityLiving.getEquipmentInSlot(1);

        if(helmet != null && helmet.getItem() == WolfItemList.redstoneHelmet && chestplate != null && chestplate.getItem() == WolfItemList.redstoneChestplate && leggings != null && leggings.getItem() == WolfItemList.redstoneLeggings && boots != null && boots.getItem() == WolfItemList.redstoneBoots)
        {
            if(!helmet.hasTagCompound())
            {
                helmet.setTagCompound(new NBTTagCompound());
            }

            if(helmet.getTagCompound().getByte("Mode") == 1)
            {
                if("inFire".equals(event.source.getDamageType()) || "onFire".equals(event.source.getDamageType()) || "lava".equals(event.source.getDamageType()))
                {
                    boots.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
                    leggings.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
                    chestplate.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
                    helmet.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
                    event.ammount = 0;
                }
            }
        }

        if(helmet != null && helmet.getItem() == WolfItemList.lapisHelmet && chestplate != null && chestplate.getItem() == WolfItemList.lapisChestplate && leggings != null && leggings.getItem() == WolfItemList.lapisLeggings && boots != null && boots.getItem() == WolfItemList.lapisBoots)
        {
            if("drown".equals(event.source.getDamageType()))
            {
                boots.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
                leggings.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
                chestplate.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
                helmet.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
                event.ammount = 0;
            }
        }

        if(helmet != null && helmet.getItem() == WolfItemList.emeraldHelmet && chestplate != null && chestplate.getItem() == WolfItemList.emeraldChestplate && leggings != null && leggings.getItem() == WolfItemList.emeraldLeggings && boots != null && boots.getItem() == WolfItemList.emeraldBoots)
        {
            if("cactus".equals(event.source.getDamageType()) || "wither".equals(event.source.getDamageType()) || "inWall".equals(event.source.getDamageType()))
            {
                boots.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
                leggings.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
                chestplate.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
                helmet.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
                event.ammount = 0;
            }
            else if("fall".equals(event.source.getDamageType()))
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
        if(event.itemStack.getItem() == WolfItemList.redstoneSword)
        {
            if(!event.itemStack.hasTagCompound())
            {
                event.itemStack.setTagCompound(new NBTTagCompound());
            }

            if(event.itemStack.getTagCompound().getByte("Mode") == 0)
            {
                if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
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
                if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
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