package me.repayed.repayedcaptcha.manager;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class CaptchaManager {
    /**
     * Players who still haven't completed the captcha
     */
    private Set<UUID> captchaPlayers;

    public CaptchaManager() {
        this.captchaPlayers = new HashSet<UUID>();
    }

    public void add(UUID uuid) {
        if(!this.captchaPlayers.contains(uuid))  {
            this.captchaPlayers.add(uuid);
        }
    }

    public void remove(UUID uuid) {
        if(this.captchaPlayers.contains(uuid)) {
           this.captchaPlayers.remove(uuid);
        }
    }

    public boolean contains(UUID uuid) {
        return this.captchaPlayers.contains(uuid);
    }
}
