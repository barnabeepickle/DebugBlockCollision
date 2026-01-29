package phylogeny.debugblockcollision;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import static phylogeny.debugblockcollision.DebugBlockCollision.keyBind;

class ClientEventListener {
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (Keyboard.isKeyDown(Keyboard.KEY_F3)) {
                while (keyBind.isPressed()) {
                    DebugBlockCollision.handleOverlay(event);
                }
            }
        }
    }
}
