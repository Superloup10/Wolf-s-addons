/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf_addons.common.worldgenerator;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import cpw.mods.fml.common.IWorldGenerator;

import wolf_addons.common.block.WolfBlockList;

public class OreGenerator implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
		{
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateEnd(World world, Random random, int x, int z)
	{

	}

	private void generateSurface(World world, Random random, int x, int z)
	{
		this.addOreSpawn(WolfBlockList.silverOre, world, random, x, z, 16, 16, 1 + random.nextInt(3), 15, 1, 62);
	}

	private void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
	{
		assert maxY > minY : "La position Y maximum doit être supérieure à la position Y minimum.";
		assert maxX > 0 && maxX <= 16 : "X doit se trouver entre 0 et 16.";
		assert minY > 0 : "La position Y minimum doit être supérieure à 0.";
		assert maxY < 256 && maxY > 0 : "La position Y maximum doit se trouver entre 0 et 256.";
		assert maxZ > 0 && maxZ <= 16 : "Z doit se trouver entre 0 et 16.";

		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++)
		{
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
		}
	}

	private void generateNether(World world, Random random, int x, int z)
	{

	}
}
