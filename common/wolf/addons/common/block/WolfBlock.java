package wolf.addons.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import wolf.addons.common.Wolf_Addons;
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

        Wolf_Addons.proxy.registerBlock(this, name);
    }
}