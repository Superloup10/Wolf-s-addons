/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://dl.dropboxusercontent.com/u/135157801/License/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.item.kit.redstone;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import wolf.addons.common.item.WolfArmor;
import wolf.addons.common.item.WolfItemList;

public class RedstoneArmor extends WolfArmor
{
    // private IIcon[] textures = new IIcon[2];

    public RedstoneArmor(int type, String name)
    {
        super(/* WolfItemList.redstoneArmor, */0, type, name);
    }

    @Override
    public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type)
    {
        if(!itemStack.hasTagCompound())
        {
            itemStack.setTagCompound(new NBTTagCompound());
        }

        if(itemStack.getTagCompound().getByte("Mode") == 0)
        {
            if(slot == 2)
            {
                return "wolf_addons:textures/models/armor/redstone_layer_off_2.png";
            }
            return "wolf_addons:textures/models/armor/redstone_layer_off_1.png";
        }
        else
        {
            if(slot == 2)
            {
                return "wolf_addons:textures/models/armor/redstone_layer_on_2.png";
            }
            return "wolf_addons:textures/models/armor/redstone_layer_on_1.png";
        }
    }

    @Override
    public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(repair.getItem().equals(WolfItemList.redstoneIngot))
        {
            return true;
        }
        return false;
    }

    // @SideOnly(Side.CLIENT)
    // public IIcon getIconIndex(ItemStack itemStack)
    // {
    // if(!itemStack.hasTagCompound())
    // {
    // itemStack.setTagCompound(new NBTTagCompound());
    // }
    //
    // if(itemStack.getTagCompound().getByte("Mode") == 0)
    // {
    // return textures[0];
    // }
    // else
    // {
    // return textures[1];
    // }
    // }
    //
    // @Override
    // public void registerIcons(IIconRegister register)
    // {
    // if(armorType == 0)
    // {
    // textures[0] = register.registerIcon("wolf_addons:redstone_helmet_off");
    // textures[1] = register.registerIcon("wolf_addons:redstone_helmet_on");
    // }
    // else if(armorType == 1)
    // {
    // textures[0] = register.registerIcon("wolf_addons:redstone_chestplate_off");
    // textures[1] = register.registerIcon("wolf_addons:redstone_chestplate_on");
    // }
    // else if(armorType == 2)
    // {
    // textures[0] = register.registerIcon("wolf_addons:redstone_leggings_off");
    // textures[1] = register.registerIcon("wolf_addons:redstone_leggings_on");
    // }
    // else
    // {
    // textures[0] = register.registerIcon("wolf_addons:redstone_boots_off");
    // textures[1] = register.registerIcon("wolf_addons:redstone_boots_on");
    // }
    // }
}