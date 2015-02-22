/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.worldgenerator;

import java.util.Random;

import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import wolf.addons.common.block.WolfBlockList;

public class OreGenerator implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch(world.provider.getDimensionId())
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
        for(int i = 0; i < 15; i++)
        {
            (new WorldGenMinable(WolfBlockList.silverOre.getDefaultState(), 3, BlockHelper.forBlock(Blocks.end_stone))).generate(world, random, new BlockPos(x + random.nextInt(16), 62, z + random.nextInt(16)));
        }
    }

    private void generateSurface(World world, Random random, int x, int z)
    {
        for(int i = 0; i < 15; i++)
        {
            (new WorldGenMinable(WolfBlockList.silverOre.getDefaultState(), 3, BlockHelper.forBlock(Blocks.stone))).generate(world, random, new BlockPos(x + random.nextInt(16), 62, z + random.nextInt(16)));
        }
    }

    private void generateNether(World world, Random random, int x, int z)
    {
        for(int i = 0; i < 15; i++)
        {
            (new WorldGenMinable(WolfBlockList.silverOre.getDefaultState(), 3, BlockHelper.forBlock(Blocks.netherrack))).generate(world, random, new BlockPos(x + random.nextInt(16), 62, z + random.nextInt(16)));
        }
    }
}