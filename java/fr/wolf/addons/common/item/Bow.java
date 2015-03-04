/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package fr.wolf.addons.common.item;

import fr.wolf.addons.common.creativestabs.WolfCT;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Bow extends Item
{
    private static String[] bowpullname = new String[] {"_pull1", "_pull2", "_pull3"};

    // private IIcon[] iconArray;

    public Bow(int damage, String name)
    {
        this.setUnlocalizedName(name);
        this.setFull3D();
        this.maxStackSize = 1;
        this.setMaxDamage(damage);
        this.setCreativeTab(WolfCT.creativeTabsTools);
        GameRegistry.registerItem(this, name);
    }

    /*
     * @Override public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) { if(usingItem != null && usingItem.getItem() == this) { int k = usingItem.getMaxItemUseDuration() - useRemaining; if(k >= 18) { return iconArray[2]; } if(k > 13) { return iconArray[1]; } if(k > 0) { return iconArray[0]; } } return getIconIndex(stack); }
     */

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer player, int itemUseCount)
    {
        int j = this.getMaxItemUseDuration(itemStack) - itemUseCount;

        ArrowLooseEvent event = new ArrowLooseEvent(player, itemStack, j);
        MinecraftForge.EVENT_BUS.post(event);
        if(event.isCanceled())
        {
            return;
        }
        j = event.charge;

        boolean flag = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, itemStack) > 0;

        if(flag || player.inventory.hasItem(Items.arrow))
        {
            float f = j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if(f < 0.1D)
            {
                return;
            }

            if(f > 1.0F)
            {
                f = 1.0F;
            }

            EntityArrow entityarrow = new EntityArrow(world, player, f * 2.0F);

            if(f == 1.0F)
            {
                entityarrow.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, itemStack);

            if(k > 0)
            {
                entityarrow.setDamage(entityarrow.getDamage() + k * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, itemStack);

            if(l > 0)
            {
                entityarrow.setKnockbackStrength(l);
            }

            if(EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, itemStack) > 0)
            {
                entityarrow.setFire(100);
            }

            itemStack.damageItem(1, player);
            world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if(flag)
            {
                entityarrow.canBePickedUp = 2;
            }
            else
            {
                player.inventory.consumeInventoryItem(Items.arrow);
            }

            if(!world.isRemote)
            {
                world.spawnEntityInWorld(entityarrow);
            }
        }
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack itemStack, World world, EntityPlayer player)
    {
        return itemStack;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemStack)
    {
        return 72000;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.BOW;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        ArrowNockEvent event = new ArrowNockEvent(player, itemStack);
        MinecraftForge.EVENT_BUS.post(event);
        if(event.isCanceled())
        {
            return event.result;
        }

        if(player.capabilities.isCreativeMode || player.inventory.hasItem(Items.arrow))
        {
            player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        }

        return itemStack;
    }

    @Override
    public int getItemEnchantability()
    {
        return 1;
    }

    /*
     * @Override public void registerIcons(IIconRegister iconregister) { iconArray = new IIcon[bowpullname.length]; itemIcon = iconregister.registerIcon(this.getIconString()); for(int i = 0; i < bowpullname.length; i++) { iconArray[i] = iconregister.registerIcon(this.getIconString() + bowpullname[i]); } }
     * @SideOnly(Side.CLIENT) public IIcon getItemIconForUseDuration(int par1) { return this.iconArray[par1]; }
     */
}