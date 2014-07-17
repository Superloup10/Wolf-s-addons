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
import net.minecraft.world.World;

import cpw.mods.fml.common.network.IGuiHandler;

import wolf.addons.common.block.container.ContainerCompressor;
import wolf.addons.common.tileentity.TileEntityCompressor;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity te = world.getTileEntity(x, y, z);
		switch (id)
		{
		case 0:
			return new ContainerCompressor(player.inventory, (TileEntityCompressor)te);
			// case 1: return new ContainerForge();
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity te = world.getTileEntity(x, y, z);
		switch (id)
		{
		case 0:
			return new GuiCompressor(player.inventory, (TileEntityCompressor)te);
			// case 1: return new GuiForge();
		}
		return null;
	}
}
