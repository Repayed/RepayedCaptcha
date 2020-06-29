package me.repayed.repayedcaptcha.listeners.menu;

import me.repayed.repayedcaptcha.RepayedCaptcha;
import me.repayed.repayedcaptcha.utils.Message;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class MenuCloseListener implements Listener {

    @EventHandler
    public void onMenuClose(InventoryCloseEvent event) {
        if(!event.getInventory().getTitle().equalsIgnoreCase("Captcha - Click the item")) return;

        Player player = (Player) event.getPlayer();
        if(RepayedCaptcha.getInstance().getCaptchaManager().contains(player.getUniqueId())) {
            player.kickPlayer(Message.format("&3&lCAPTCHA VERIFICATION " + "\n" + "\n" +
                    "&7You have failed to solve the captcha." + "\n" +
                    "&7If you'd like to play again, please log back into the server." + "\n" + "\n" +
                    "&bIf you think this is an error. Please contact the staff team at our discord."
            ));
        }

    }
}
