package me.repayed.repayedcaptcha.listeners.player;

import me.repayed.repayedcaptcha.RepayedCaptcha;
import me.repayed.repayedcaptcha.menus.types.CaptchaMenu;
import me.repayed.repayedcaptcha.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        final Player player = event.getPlayer();

        if (player.hasPermission("Captcha.bypass")) return;

        RepayedCaptcha.getInstance().getCaptchaManager().add(player.getUniqueId());

        if (RepayedCaptcha.getInstance().getCaptchaManager().contains(player.getUniqueId())) {

            Bukkit.getScheduler().runTaskLater(RepayedCaptcha.getInstance(), new Runnable() {

                public void run() {
                    new CaptchaMenu(player, new ItemBuilder(Material.EYE_OF_ENDER, "&aVerification Item")
                            .withEnchantment()
                            .withLore(
                                    "&7You must click this item to access the server.",
                                    "",
                                    "&cIf you click anything else, you will be &4kicked&c."
                            ).build());
                }
            }, 20L);


        }
    }
}

