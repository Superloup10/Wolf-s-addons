package wolf_addons.common.event;

import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import wolf_addons.common.item.WolfItemList;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class LivingEvent
{
	@SubscribeEvent
	public void onLivingHurt(LivingHurtEvent event)
	{
		ItemStack helmet = event.entityLiving.getEquipmentInSlot(4);
		ItemStack chestplate = event.entityLiving.getEquipmentInSlot(3);
		ItemStack leggings = event.entityLiving.getEquipmentInSlot(2);
		ItemStack boots = event.entityLiving.getEquipmentInSlot(1);
		
		if(helmet != null && helmet.getItem() == WolfItemList.redstoneHelmet && chestplate != null &&  chestplate.getItem() == WolfItemList.redstoneChestplate && leggings != null && leggings.getItem() == WolfItemList.redstoneLeggings && boots != null && boots.getItem() == WolfItemList.redstoneBoots)
		{
			if(event.source.getDamageType().equals("inFire") || event.source.getDamageType().equals("onFire") || event.source.getDamageType().equals("lava"))
			{
				boots.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				leggings.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				chestplate.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				helmet.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				event.ammount = 0;
			}
		}
		
		if(helmet != null && helmet.getItem() == WolfItemList.lapisHelmet && chestplate != null &&  chestplate.getItem() == WolfItemList.lapisChestplate && leggings != null && leggings.getItem() == WolfItemList.lapisLeggings && boots != null && boots.getItem() == WolfItemList.lapisBoots)
		{
			if(event.source.getDamageType().equals("drown"))
			{
				boots.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				leggings.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				chestplate.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				helmet.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				event.ammount = 0;
			}
		}
		
		if(helmet != null && helmet.getItem() == WolfItemList.emeraldHelmet && chestplate != null &&  chestplate.getItem() == WolfItemList.emeraldChestplate && leggings != null && leggings.getItem() == WolfItemList.emeraldLeggings && boots != null && boots.getItem() == WolfItemList.emeraldBoots)
		{
			if(event.source.getDamageType().equals("cactus") || event.source.getDamageType().equals("fall") || event.source.getDamageType().equals("wither") || event.source.getDamageType().equals("inWall"))
			{
				boots.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				leggings.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				chestplate.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				helmet.damageItem(MathHelper.floor_float(event.ammount / 4), event.entityLiving);
				event.ammount = 0;
			}
		}
	}
}