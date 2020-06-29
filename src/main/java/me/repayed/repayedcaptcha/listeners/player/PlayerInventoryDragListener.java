package me.repayed.repayedcaptcha.listeners.player;

import me.repayed.repayedcaptcha.RepayedCaptcha;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;

public class PlayerInventoryDragListener implements Listener {

    @EventHandler
    public void onPlayerInventoryDragListener(InventoryDragEvent event) {
        Player player = (Player) event.getWhoClicked();

        if(RepayedCaptcha.getInstance().getCaptchaManager().contains(player.getUniqueId())) event.setCancelled(true);
    }
}
