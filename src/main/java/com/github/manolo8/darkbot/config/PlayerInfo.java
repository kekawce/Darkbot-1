package com.github.manolo8.darkbot.config;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PlayerInfo {
    public String username;
    public int userId;

    public long lastUpdate = System.currentTimeMillis();

    private Map<PlayerTag, Long> subscriptions = new HashMap<>();

    public PlayerInfo() {}

    public PlayerInfo(String username, int userId) {
        this.username = username;
        this.userId = userId;
    }

    public void setTag(PlayerTag tag, Long until) {
        subscriptions.put(tag, until);
    }

    public void removeTag(PlayerTag tag) {
        subscriptions.remove(tag);
    }

    public boolean hasTag(PlayerTag tag) {
        Long until = subscriptions.get(tag);
        if (until != null && until > System.currentTimeMillis()) return true;
        subscriptions.remove(tag);
        return false;
    }

    public Collection<PlayerTag> getTags() {
        return subscriptions.keySet();
    }

    public boolean filter(String string) {
        return string == null
                || username.toLowerCase(Locale.ROOT).contains(string.toLowerCase(Locale.ROOT))
                || String.valueOf(userId).contains(string);
    }

    @Override
    public String toString() {
        return username + "(" + userId +")";
    }
}
