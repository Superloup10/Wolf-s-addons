package wolf_addons.common.item.kit.silver;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import wolf_addons.common.item.WolfItemList;

public class SilverSword extends ItemSword
{
	public SilverSword(ToolMaterial material)
	{
		super(material);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair)
	{
		if(repair.getItem().equals(WolfItemList.silverIngot))
		{
			return true;
		}
		return false;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase attackedLiving, EntityLivingBase attackerLiving)
	{
		if(attackedLiving instanceof EntityZombie || attackedLiving instanceof EntitySkeleton)
		{
			attackedLiving.attackEntityFrom(DamageSource.generic, 10.0F);//Ne prends pas en compte le +4 rajouté à l'épée.
		}
		return super.hitEntity(stack, attackedLiving, attackerLiving);
	}
}