/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package fr.wolf.addons.common.tileentity;

import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class TileEntityCable extends TileEntity implements IUpdatePlayerListBox
{
    /**
     * UP, DOWN, NORTH, SOUTH, WEST, EAST
     */
    public EnumFacing[] direction = new EnumFacing[6];

    @Override
    public void update()
    {
        this.updateConnections();
    }

    public void updateConnections()
    {
        if(this.worldObj.getTileEntity(this.pos.up()) instanceof TileEntityCable)
            direction[0] = EnumFacing.UP;
        else
            direction[0] = null;
        if(this.worldObj.getTileEntity(this.pos.down()) instanceof TileEntityCable)
            direction[1] = EnumFacing.DOWN;
        else
            direction[1] = null;
        if(this.worldObj.getTileEntity(this.pos.north()) instanceof TileEntityCable)
            direction[2] = EnumFacing.NORTH;
        else
            direction[2] = null;
        if(this.worldObj.getTileEntity(this.pos.south()) instanceof TileEntityCable)
            direction[3] = EnumFacing.SOUTH;
        else
            direction[3] = null;
        if(this.worldObj.getTileEntity(this.pos.west()) instanceof TileEntityCable)
            direction[4] = EnumFacing.WEST;
        else
            direction[4] = null;
        if(this.worldObj.getTileEntity(this.pos.east()) instanceof TileEntityCable)
            direction[5] = EnumFacing.EAST;
        else
            direction[5] = null;
    }
}