package phylogeny.debugblockcollision.keybinds;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
import phylogeny.debugblockcollision.ConfigMod;
import phylogeny.debugblockcollision.Tags;

import java.util.ArrayList;
import java.util.List;

import static phylogeny.debugblockcollision.DebugBlockCollision.debugFeedbackTranslated;
import static phylogeny.debugblockcollision.DebugBlockCollision.overlayEnabled;

public class OverlayKeybindListener {
    public static KeyBinding overlayKeybind;

    public static void init() {
        overlayKeybind = new KeyBinding("key." + Tags.MODID + ".overlay", KeyConflictContext.IN_GAME, Keyboard.KEY_O, "key.category." + Tags.MODID);
        ClientRegistry.registerKeyBinding(overlayKeybind);
        MinecraftForge.EVENT_BUS.register(OverlayKeybindListener.class);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (Keyboard.isKeyDown(Keyboard.KEY_F3)) {
                while (overlayKeybind.isPressed()) {
                    handleOverlay();
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public static void handleOverlay() {
        // Toggle enabled and prevent debug screen from toggling on/off
        // Simplified with the wonders of an AT entry
        Minecraft.getMinecraft().actionKeyF3 = true;

        overlayEnabled ^=true;

        // Send chat message
        debugFeedbackTranslated("debug." + Tags.MODID + (overlayEnabled ? ".on" : ".off"));

        // Display the color key if overlay enabled and it's enabled in the config
        if (overlayEnabled && ConfigMod.CLIENT.colorKey) {
            debugFeedbackTranslated("debug." + Tags.MODID + ".color_key");

            List<String> colors = new ArrayList<>();
            colors.add("green");
            colors.add("blue");
            colors.add("red");

            for (int i = 0; !(i >= 3); i++) {
                Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(
                        new TextComponentTranslation("debug." + Tags.MODID + ".color_key." + colors.get(i))
                                .setStyle(new Style().setColor(TextFormatting.DARK_GREEN)));
            }

        }
    }
}
