package me.repayed.repayedcaptcha;

import me.repayed.repayedcaptcha.listeners.player.JoinListener;
import me.repayed.repayedcaptcha.listeners.menu.ClickMenuItemListener;
import me.repayed.repayedcaptcha.listeners.menu.MenuCloseListener;
import me.repayed.repayedcaptcha.listeners.player.PlayerDropItemListener;
import me.repayed.repayedcaptcha.listeners.player.PlayerInventoryDragListener;
import me.repayed.repayedcaptcha.listeners.player.PlayerItemHeldListener;
import me.repayed.repayedcaptcha.manager.CaptchaManager;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RepayedCaptcha extends JavaPlugin {

    private static RepayedCaptcha instance;
    private CaptchaManager captchaManager;

    @Override
    public void onEnable() {
        instance = this;
        captchaManager = new CaptchaManager();
        registerListeners();
    }

    public static RepayedCaptcha getInstance() {
        return instance;
    }

    public CaptchaManager getCaptchaManager() { return this.captchaManager; }

    private void registerListeners() {
        final PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new ClickMenuItemListener(), this);
        pluginManager.registerEvents(new MenuCloseListener(), this);
        pluginManager.registerEvents(new PlayerDropItemListener(), this);
        pluginManager.registerEvents(new PlayerItemHeldListener(), this);
        pluginManager.registerEvents(new PlayerInventoryDragListener(), this);
    }
}
