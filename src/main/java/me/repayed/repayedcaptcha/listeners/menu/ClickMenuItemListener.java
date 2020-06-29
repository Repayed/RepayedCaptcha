package me.repayed.repayedcaptcha.listeners.menu;

import me.repayed.repayedcaptcha.RepayedCaptcha;
import me.repayed.repayedcaptcha.utils.Message;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickMenuItemListener implements Listener {

    @EventHandler
    public void onPlayerClickMenuItem(InventoryClickEvent event) {
            Player player = (Player) event.getWhoClicked();

            if (event.getClickedInventory() == null) return;

            if (!event.getClickedInventory().getTitle().equalsIgnoreCase("Captcha - Click the item")) return;

            if (event.getCurrentItem() == null) return;

            if (event.getCurrentItem().getType() != Material.EYE_OF_ENDER ||
                    !event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Message.format("&aVerification Item"))) {
                event.setCancelled(true);
                // Kick player from server
                player.kickPlayer(Message.format("&3&lCAPTCHA VERIFICATION " + "\n" + "\n" +
                        "&7You have failed to solve the captcha." + "\n" +
                        "&7If you'd like to play again, please log back into the server." + "\n" + "\n" +
                        "&bIf you think this is an error. Please contact the staff team at our discord."
                ));

            } else {
                RepayedCaptcha.getInstance().getCaptchaManager().remove(player.getUniqueId());
                player.closeInventory();
                player.sendMessage("you passed.");
                // Send message to player that he passed and also a success sound
            }
        }
}
