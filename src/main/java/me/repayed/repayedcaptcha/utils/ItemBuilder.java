package me.repayed.repayedcaptcha.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemBuilder {
    private ItemStack itemStack;
    private ItemMeta itemMeta;
    private ArrayList<String> lore;

    public ItemBuilder(Material material, String name) {
        this.itemStack = new ItemStack(material);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(Message.format(name));
        this.lore = new ArrayList<String>();
    }

    public ItemBuilder(Material material, String name, short id) {
        this.itemStack = new ItemStack(material, 1, id);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(Message.format(name));
        this.lore = new ArrayList<String>();
    }

    public ItemBuilder withLore(String... loreLines) {
        for(String line : loreLines) {
            this.lore.add(Message.format(line));
        }
        this.itemMeta.setLore(this.lore);

        return this;
    }

    public ItemBuilder withEnchantment() {
        this.itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        this.itemMeta.addEnchant(Enchantment.LUCK, 1, true);
        return this;
    }

    public ItemStack build() {
        this.itemStack.setItemMeta(this.itemMeta);
        return itemStack;
    }

}
