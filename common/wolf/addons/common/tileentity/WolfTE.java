/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://dl.dropboxusercontent.com/u/135157801/License/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class WolfTE
{
    public static void loadTileEntity()
    {
        GameRegistry.registerTileEntity(TileEntityCompressor.class, "TileEntityCompressor");
        GameRegistry.registerTileEntity(TileEntityFurnace.class, "TileEntityFurnace");
        GameRegistry.registerTileEntity(TileEntityCable.class, "TileEntityPipe");
        // GameRegistry.registerTileEntity(TileEntityForge.class,
        // "TileEntityForge");
    }
}
