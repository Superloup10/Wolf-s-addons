/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.tileentity;

import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class TileEntityCable extends TileEntity implements IUpdatePlayerListBox
{
    // public boolean[] render = new boolean[6];
    /**
     * UP, DOWN, NORTH, SOUTH, WEST, EAST
     */
    public EnumFacing[] direction = new EnumFacing[6];

    @Override
    public void update()
    {
        this.updateConnections();
        /*
         * render[0] = this.canConnectCableTo(this.worldObj, pos.south()); render[1] = this.canConnectCableTo(this.worldObj, pos.north()); render[2] = this.canConnectCableTo(this.worldObj, pos.west()); render[3] = this.canConnectCableTo(this.worldObj, pos.east()); render[4] = this.canConnectCableTo(this.worldObj, pos.down()); render[5] = this.canConnectCableTo(this.worldObj, pos.up());
         */
    }

    public void updateConnections()
    {
        if(this.worldObj.getTileEntity(getPos().up()) instanceof TileEntityCable)
            direction[0] = EnumFacing.UP;
        direction[0] = null;
        if(this.worldObj.getTileEntity(getPos().down()) instanceof TileEntityCable)
            direction[1] = EnumFacing.DOWN;
        direction[1] = null;
        if(this.worldObj.getTileEntity(getPos().north()) instanceof TileEntityCable)
            direction[2] = EnumFacing.NORTH;
        direction[2] = null;
        if(this.worldObj.getTileEntity(getPos().south()) instanceof TileEntityCable)
            direction[3] = EnumFacing.SOUTH;
        direction[3] = null;
        if(this.worldObj.getTileEntity(getPos().west()) instanceof TileEntityCable)
            direction[4] = EnumFacing.WEST;
        direction[4] = null;
        if(this.worldObj.getTileEntity(getPos().east()) instanceof TileEntityCable)
            direction[5] = EnumFacing.EAST;
        direction[5] = null;
    }

    /*
     * private boolean canConnectCableTo(World world, BlockPos pos) { Block block = world.getBlockState(pos).getBlock(); // TileEntity te = world.getTileEntity(new BlockPos(x, y, z)); if(block != null && block == WolfBlockList.cable) return true; return false; }
     */
}