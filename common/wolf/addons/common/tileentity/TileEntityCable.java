/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.tileentity;

import net.minecraft.block.Block;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import wolf.addons.common.block.WolfBlockList;

public class TileEntityCable extends TileEntity implements IUpdatePlayerListBox
{
    public static boolean[] render = new boolean[6];

    @Override
    public void update()
    {
        int x = this.getPos().getX();
        int y = this.getPos().getY();
        int z = this.getPos().getZ();

        boolean flag = this.canConnectCableTo(this.worldObj, x, y, z - 1, true);
        boolean flag1 = this.canConnectCableTo(this.worldObj, x, y, z + 1, true);
        boolean flag2 = this.canConnectCableTo(this.worldObj, x - 1, y, z, true);
        boolean flag3 = this.canConnectCableTo(this.worldObj, x + 1, y, z, true);
        boolean flag4 = this.canConnectCableTo(this.worldObj, x, y - 1, z, true);
        boolean flag5 = this.canConnectCableTo(this.worldObj, x, y + 1, z, true);

        if(flag)
        {
            render[0] = true;
        }
        else
        {
            render[0] = false;
        }

        if(flag1)
        {
            render[1] = true;
        }
        else
        {
            render[1] = false;
        }

        if(flag2)
        {
            render[2] = true;
        }
        else
        {
            render[2] = false;
        }

        if(flag3)
        {
            render[3] = true;
        }
        else
        {
            render[3] = false;
        }

        if(flag4)
        {
            render[4] = true;
        }
        else
        {
            render[4] = false;
        }

        if(flag5)
        {
            render[5] = true;
        }
        else
        {
            render[5] = false;
        }
    }

    private boolean canConnectCableTo(World world, int x, int y, int z, boolean b)
    {
        Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        if(block != null && block == WolfBlockList.cable)
            return true;
        return false;
    }
}