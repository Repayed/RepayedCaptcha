package me.repayed.repayedcaptcha.menus;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public abstract class Menu {
    private Inventory inventory;
    private static final int ROW_SIZE = 9;

    public Menu(String menuTitle, int rows) {
        this.inventory = Bukkit.createInventory(null, (rows * ROW_SIZE), menuTitle);
    }
    protected Inventory getInventory() {
        return this.inventory;
    }


}
