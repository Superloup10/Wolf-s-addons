/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package fr.wolf.addons.common.recipe;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class ShapedRecipesCompressor implements IRecipe
{
    private final int recipeWidth;
    private final int recipeHeight;

    private final ItemStack[] recipeItems;
    private final ItemStack recipeOutput;
    private boolean field_92101_f;

    public ShapedRecipesCompressor(int width, int height, ItemStack[] item, ItemStack item2)
    {
        recipeWidth = width;
        recipeHeight = height;
        recipeItems = item;
        recipeOutput = item2;
    }

    @Override
    public boolean matches(InventoryCrafting crafting, World world)
    {
        for(int width = 0; width <= 3 - this.recipeWidth; ++width)
        {
            for(int height = 0; height <= 3 - this.recipeHeight; ++height)
            {
                if(this.checkMatch(crafting, width, height, true))
                {
                    return true;
                }

                if(this.checkMatch(crafting, width, height, false))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkMatch(InventoryCrafting crafting, int width, int height, boolean b)
    {
        for(int k = 0; k < 3; ++k)
        {
            for(int l = 0; l < 3; ++l)
            {
                int i1 = k - width;
                int j1 = l - height;
                ItemStack itemstack = null;

                if(i1 >= 0 && j1 >= 0 && i1 < this.recipeWidth && j1 < this.recipeHeight)
                {
                    if(b)
                    {
                        itemstack = this.recipeItems[this.recipeWidth - i1 - 1 + j1 * this.recipeWidth];
                    }
                    else
                    {
                        itemstack = this.recipeItems[i1 + j1 * this.recipeWidth];
                    }
                }

                ItemStack itemstack1 = crafting.getStackInRowAndColumn(k, l);

                if(itemstack1 != null || itemstack != null)
                {
                    if(itemstack1 == null && itemstack != null || itemstack1 != null && itemstack == null)
                    {
                        return false;
                    }

                    if(itemstack.getItem() != itemstack1.getItem())
                    {
                        return false;
                    }

                    if(itemstack.getItemDamage() != 32767 && itemstack.getItemDamage() != itemstack1.getItemDamage())
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting crafting)
    {
        ItemStack itemstack = this.getRecipeOutput().copy();

        if(this.field_92101_f)
        {
            for(int i = 0; i < crafting.getSizeInventory(); ++i)
            {
                ItemStack itemstack1 = crafting.getStackInSlot(i);

                if(itemstack1 != null && itemstack1.hasTagCompound())
                {
                    itemstack.setTagCompound((NBTTagCompound)itemstack1.getTagCompound().copy());
                }
            }
        }
        return itemstack;
    }

    @Override
    public int getRecipeSize()
    {
        return this.recipeWidth * this.recipeHeight;
    }

    @Override
    public ItemStack getRecipeOutput()
    {
        return this.recipeOutput;
    }

    public ShapedRecipesCompressor func_92100_c()
    {
        this.field_92101_f = true;
        return this;
    }

    @Override
    public ItemStack[] getRemainingItems(InventoryCrafting p_179532_1_)
    {
        ItemStack[] aitemstack = new ItemStack[p_179532_1_.getSizeInventory()];

        for(int i = 0; i < aitemstack.length; ++i)
        {
            ItemStack itemstack = p_179532_1_.getStackInSlot(i);
            aitemstack[i] = ForgeHooks.getContainerItem(itemstack);
        }

        return aitemstack;
    }
}