package me.repayed.repayedcaptcha.listeners.player;

import me.repayed.repayedcaptcha.RepayedCaptcha;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItemListener implements Listener {

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        if(RepayedCaptcha.getInstance().getCaptchaManager().contains(player.getUniqueId())) event.setCancelled(true);
    }
}
