/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf_addons.common.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.IGuiHandler;

import wolf_addons.common.block.container.ContainerCompressor;
import wolf_addons.common.tileentity.TileEntityCompressor;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity te = world.getTileEntity(x, y, z);
		switch (ID)
		{
		case 0:
			return new ContainerCompressor(player.inventory, (TileEntityCompressor)te);
			// case 1: return new ContainerForge();
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity te = world.getTileEntity(x, y, z);
		switch (ID)
		{
		case 0:
			return new GuiCompressor(player.inventory, (TileEntityCompressor)te);
			// case 1: return new GuiForge();
		}
		return null;
	}
}