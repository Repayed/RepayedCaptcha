package me.repayed.repayedcaptcha.listeners.menu;

import me.repayed.repayedcaptcha.RepayedCaptcha;
import me.repayed.repayedcaptcha.utils.Message;
import org.bukkit.Material;
import org.bukkit.Sound;
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

                player.kickPlayer(Message.format("&3&lCAPTCHA VERIFICATION " + "\n" + "\n" +
                        "&7You have failed to solve the captcha." + "\n" +
                        "&7If you'd like to play again, please log back into the server." + "\n" + "\n" +
                        "&bIf you think this is an error. Please contact the staff team at our discord."
                ));

            } else {
                RepayedCaptcha.getInstance().getCaptchaManager().remove(player.getUniqueId());
                player.closeInventory();
                player.sendMessage(Message.format("&a&l[!] &aYou have completed the captcha! Enjoy your stay."));
                player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 1.0F, 1.0F);
            }
        }
}
