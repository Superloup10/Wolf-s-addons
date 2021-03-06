/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package fr.wolf.addons.common.gui;

import fr.wolf.addons.common.block.container.ContainerCompressor;
import fr.wolf.addons.common.block.container.ContainerFurnace;
import fr.wolf.addons.common.tileentity.TileEntityCompressor;
import fr.wolf.addons.common.tileentity.TileEntityFurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        switch(id)
        {
        case 0:
            return new ContainerCompressor(player.inventory, (TileEntityCompressor)te);
            // case 1: return new ContainerForge();
        case 2:
            return new ContainerFurnace(player.inventory, (TileEntityFurnace)te);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        switch(id)
        {
        case 0:
            return new GuiCompressor(player.inventory, (TileEntityCompressor)te);
            // case 1: return new GuiForge();
        case 2:
            return new GuiFurnace(player.inventory, (TileEntityFurnace)te);
        }
        return null;
    }
}