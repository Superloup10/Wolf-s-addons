/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://dl.dropboxusercontent.com/u/135157801/License/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import wolf.addons.common.block.container.ContainerCompressor;
import wolf.addons.common.block.container.ContainerFurnace;
import wolf.addons.common.tileentity.TileEntityCompressor;
import wolf.addons.common.tileentity.TileEntityFurnace;

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