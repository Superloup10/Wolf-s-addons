package wolf.addons.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

import wolf.addons.common.creativestabs.WolfCT;

public class WolfBlock extends Block
{
    public WolfBlock(Material material, String name, float hardness, float resistance, SoundType soundType)
    {
        super(material);
        this.setUnlocalizedName(name);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setCreativeTab(WolfCT.creativeTabsBlocks);
        this.setStepSound(soundType);
        GameRegistry.registerBlock(this, name);
    }
}