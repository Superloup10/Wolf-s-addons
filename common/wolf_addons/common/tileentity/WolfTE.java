package wolf_addons.common.tileentity;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;

public class WolfTE
{
	public static void loadTileEntity()
	{
		try
		{
			GameRegistry.registerTileEntity(TileEntityCompressor.class, "TileEntityCompressor");
		}
		catch(Exception e)
		{
			FMLLog.severe("Erreur");
		}
	}
}