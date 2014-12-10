/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://dl.dropboxusercontent.com/u/135157801/License/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.item;

import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import wolf.addons.common.creativestabs.WolfCT;

public class Hammer extends Item
{
    public Hammer(int damage, String name)
    {
        this.maxStackSize = 1;
        this.setUnlocalizedName(name);
        this.setMaxDamage(damage);
        this.setCreativeTab(WolfCT.creativeTabsTools);
        // TODO à implémenter dans le futur
        // GameRegistry.registerItem(this, name);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean isFull3D()
    {
        return true;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemStack)
    {
        return 72000;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.BLOCK;
    }

    // @Override
    // @SideOnly(Side.CLIENT)
    // public void registerIcons(IIconRegister register)
    // {
    // itemIcon = register.registerIcon("wolf_addons:" + texture);
    // }
}