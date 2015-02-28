/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.item.kit.silver;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

import wolf.addons.common.item.WolfItemList;
import wolf.addons.common.item.util.WolfSword;

public class SilverSword extends WolfSword
{
    public SilverSword()
    {
        super("silver_sword", WolfItemList.silverTools);
    }

    @Override
    public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(repair.getItem().equals(WolfItemList.silverIngot))
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase attackedLiving, EntityLivingBase attackerLiving)
    {
        if(attackedLiving instanceof EntityZombie || attackedLiving instanceof EntitySkeleton)
        {
            attackedLiving.attackEntityFrom(DamageSource.generic, 10.0F);// Ne prends pas en compte le +4 rajouté à l'épée.
        }
        return super.hitEntity(stack, attackedLiving, attackerLiving);
    }
}