package me.repayed.repayedcaptcha.menus.types;

import me.repayed.repayedcaptcha.menus.Menu;
import me.repayed.repayedcaptcha.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CaptchaMenu extends Menu {

    private ItemStack captchaItem;

    public CaptchaMenu(Player player, ItemStack captchaItem) {
        super("Captcha - Click the item", 3);
        this.captchaItem = captchaItem;
        this.setCaptchaItem();
        this.fillMenu(new ItemBuilder(Material.STAINED_GLASS_PANE, " ", (short) 7).build());
        player.openInventory(this.getInventory());
    }

    private ItemStack getCaptchaItem() {
        return this.captchaItem;
    }

    private void setCaptchaItem() {
        this.getInventory().setItem(getRandomSlot(), getCaptchaItem());
    }

    private int getRandomSlot() {
        return (int) (Math.random() * this.getInventory().getSize());
    }

    private void fillMenu(ItemStack fillerItem) {
            for (int i = 0; i < this.getInventory().getSize(); i++) {
                if (this.getInventory().getItem(i) == null || this.getInventory().getItem(i).getType() == Material.AIR) {
                    this.getInventory().setItem(i, fillerItem);
            }
        }
    }

}


