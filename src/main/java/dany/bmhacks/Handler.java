package dany.bmhacks;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry.UniqueIdentifier;

public class Handler
{
	protected static final Handler instance = new Handler();
	
	@SubscribeEvent
	public void itemUse(PlayerInteractEvent e)
	{
		if (e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK)
		{
			ItemStack heldItem = e.entityPlayer.inventory.getCurrentItem();
			if (heldItem == null)
			{
				return;
			}
			UniqueIdentifier uid = GameRegistry.findUniqueIdentifierFor(heldItem.getItem());
			String modid = uid.modId;
			String name = uid.name;
			if (modid.equals("AWWayofTime") && 
					(  name.equals("sacrificialKnife")
					|| name.equals("weakBloodOrb"))
					|| name.equals("apprenticeBloodOrb")
					|| name.equals("magicianBloodOrb")
					|| name.equals("masterBloodOrb")
					|| name.equals("archmageBloodOrb"))
			{
				if (e.entityPlayer.getHealth() <= 2.0F)
				{
					e.setCanceled(true);
				}
			}
		}
	}
}