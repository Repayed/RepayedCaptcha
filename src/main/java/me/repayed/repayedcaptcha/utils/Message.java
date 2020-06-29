package me.repayed.repayedcaptcha.utils;

import org.bukkit.ChatColor;

public class Message {

    public static String format(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
