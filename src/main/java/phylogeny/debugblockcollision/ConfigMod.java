package phylogeny.debugblockcollision;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.*;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Config(modid = Tags.MODID, category = "")
@LangKey(Tags.MODID + ".config.title")
@EventBusSubscriber(Side.CLIENT)
public class ConfigMod
{
	private static final String PREFIX = "config." + Tags.MODID + ".client";

	@Name("Client")
	@Comment("Client-only configs.")
	@LangKey(PREFIX)
	public static final Client CLIENT = new Client();

	public static class Client
	{
		@Name("Mode")
		@Comment(DebugBlockCollision.MODE_COMMENT)
		@LangKey(PREFIX + ".mode")
		public Mode mode = Mode.BLOCKS_IN_RADIUS;

		@Name("Show Color Key")
		@Comment("If enabled when toggling the overlay on/off it will send the color key in chat for the box colors.")
		@LangKey(PREFIX + ".colorkey")
		public boolean colorKey = true;

		@Name("Show Mode Description")
		@Comment("If enabled the descriptions for what each mode does will be sent in chat when you switch modes.")
		@LangKey(PREFIX + ".modedescription")
		public boolean modeDescription = true;

		@Name("Render Radius")
		@Comment("If mode is set to 'Blocks In Radius', this sets the radius in meters that those block boxes will render within.")
		@LangKey(PREFIX + ".radius")
		@RangeDouble(min = 0)
		public double renderRadius = 10;

		@Name("Box Line Width")
		@Comment("The width that the lines of the boxes render with.")
		@LangKey(PREFIX + ".line_width")
		@RangeDouble(min = 0)
		public float lineWidth = 3;

		@Name("Render Obscured Lines")
		@Comment("If true, lines that would otherwise be obscured from view will render, but with decreased opacity.")
		@LangKey(PREFIX + ".obscured")
		public boolean renderObscuredLines = true;
	}

	public enum Mode
	{
		BLOCKS_IN_RADIUS("radius"),
		BOXES_COLLIDED("collided"),
		BLOCK_CROSSHAIR("hovered");

		private String name;
        private final String chatKey;

		Mode(String chatKey)
		{
			this.chatKey = chatKey;
			name = "";
			for (String word : name().split("_"))
				name += word.charAt(0) + word.substring(1).toLowerCase() + " ";

			name = name.substring(0, name.length() - 1);
		}

		@Override
		public String toString()
		{
			return name;
		}

		public String getChatKey()
		{
			return chatKey;
		}
	}

	@SubscribeEvent
	public static void onConfigChanged(OnConfigChangedEvent event)
	{
		if (event.getModID().equalsIgnoreCase(Tags.MODID))
			ConfigManager.sync(Tags.MODID, Type.INSTANCE);
	}
}