package com.github.manolo8.darkbot.core.objects.itf;

public interface HealthHolder {

    int getHp();
    int getMaxHp();
    int getHull();
    int getMaxHull();
    int getShield();
    int getMaxShield();

    default double hpPercent() {
        return getMaxHp() == 0 ? 1 : ((double) getHp() / (double) getMaxHp());
    }
    default double shieldPercent() {
        return getMaxShield() == 0 ? 1 : ((double) getShield() / (double) getMaxShield());
    }

}
