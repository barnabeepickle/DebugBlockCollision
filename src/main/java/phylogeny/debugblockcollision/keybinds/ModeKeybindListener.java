package phylogeny.debugblockcollision.keybinds;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
import phylogeny.debugblockcollision.ConfigMod;
import phylogeny.debugblockcollision.Tags;

import static phylogeny.debugblockcollision.DebugBlockCollision.*;

public class ModeKeybindListener {
    public static KeyBinding modeKeybind;

    public static void init() {
        modeKeybind = new KeyBinding("key." + Tags.MODID + ".mode", KeyConflictContext.IN_GAME, Keyboard.KEY_P, "key.category." + Tags.MODID);
        ClientRegistry.registerKeyBinding(modeKeybind);
        MinecraftForge.EVENT_BUS.register(ModeKeybindListener.class);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (Keyboard.isKeyDown(Keyboard.KEY_F3)) {
                while (modeKeybind.isPressed()) {
                    handleMode();
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public static void handleMode() {
        // Cycle mode
        ConfigMod.Mode mode = ConfigMod.CLIENT.mode;
        ConfigMod.CLIENT.mode = mode.values()[(mode.ordinal() + 1) % mode.values().length];

        // Update config file
        configFile.load();
        Property prop = configFile.get("client", "Mode", ConfigMod.Mode.BLOCK_HOVERED.name());
        prop.setValue(ConfigMod.CLIENT.mode.name());
        prop.setComment(MODE_COMMENT);
        configFile.save();

        // Send chat message
        debugFeedbackTranslated("debug." + Tags.MODID + "." + ConfigMod.CLIENT.mode.getChatKey());
    }
}
