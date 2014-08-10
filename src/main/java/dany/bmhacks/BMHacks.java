package dany.bmhacks;

import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLModDisabledEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

@Mod
(
	modid = Refs.MOD_ID,
	name = Refs.MOD_NAME,
	dependencies = Refs.DEPENDENCIES,
	version = Refs.VERSION,
	acceptedMinecraftVersions = ""
)
public class BMHacks
{
	public static Logger logger;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		logger = e.getModLog();
		if (FMLCommonHandler.instance().getSide().isServer())
		{
			String errorMsg = Refs.MOD_ID + " mod is clientside only!";
			logger.error(errorMsg);
			logger.catching(new IncompatibleWithServerException(errorMsg));
		}
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent e)
	{
		MinecraftForge.EVENT_BUS.register(Handler.instance);
	}
}