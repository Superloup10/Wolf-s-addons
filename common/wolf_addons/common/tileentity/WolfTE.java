package wolf_addons.common.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

public class WolfTE
{
	public static void loadTileEntity()
	{
		GameRegistry.registerTileEntity(TileEntityCompressor.class, "TileEntityCompressor");
	}
}