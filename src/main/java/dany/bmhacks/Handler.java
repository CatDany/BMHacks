package dany.bmhacks;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class Handler
{
	protected static final Handler instance = new Handler();
	
	@SubscribeEvent
	public void itemUse(PlayerInteractEvent e)
	{
		if (e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK && e.entityPlayer.inventory.getCurrentItem() != null)
		{
			String modid = GameRegistry.findUniqueIdentifierFor(e.entityPlayer.inventory.getCurrentItem().getItem()).modId;
			String name = GameRegistry.findUniqueIdentifierFor(e.entityPlayer.inventory.getCurrentItem().getItem()).name;
			if (modid.equals("AWWayofTime") && 
					(  name.equals("sacrificialKnife")
					|| name.equals("weakBloodOrb"))
					|| name.equals("apprenticeBloodOrb")
					|| name.equals("magicianBloodOrb")
					|| name.equals("archmageBloodOrb"))
			{
				if (e.entityPlayer.getHealth() <= 3.0F)
				{
					e.setCanceled(true);
				}
			}
		}
	}
}