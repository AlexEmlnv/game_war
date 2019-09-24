package com.corporation_name.unit;

import com.corporation_name.unit.action.Action;
import com.corporation_name.utils.RandomUtil;

/**
 * Абстрактная боевая единица (собраны все общие свойства и поведения для реальных бойцов).
 */
public abstract class Unit {

    private Race race;
    private String name;
    private double health = 100.0;
    private double power = 1.0; /* может быть 0.5, 1.0 или 1.5 */
    private Action action1;
    private Action action2;

    public Unit(final Race race, final String name, final Action action1, final Action action2) {
        this.race = race;
        this.name = name;
        this.action1 = action1;
        this.action2 = action2;
    }

    public Unit(final Race race, final String name) {
        this.race = race;
        this.name = name;
    }

    public Action getAction1() {
        return action1;
    }

    public Action getAction2() {
        return action2;
    }

    /**
     * Получение в случайном порядке действия (либо Action1 либо Action2).
     * @return само действия
     */
    public Action getRandomAction() {
        if (RandomUtil.getRandomOneOrZero() == 1) {
            return getAction1();
        } else {
            return getAction2();
        }
    }

    /**
     * Проверка живой ли боец.
     * @return true или false
     */
    public boolean isAlive() {
        return (health > 0.0);
    }

    /**
     * Нанесение урона жизни бойцу на размер damage.
     * @param damage размер урона жизни бойцу
     */
    public void changeHealth(final double damage) {
        this.health = this.health - damage;
    }

    public void setPower(final double power) {
        this.power = power;
    }

    public void setStandardPower() {
        this.power = 1.0;
    }

    public void setPrivilegedPower() {
        this.power = 1.5;
    }

    public void setBrokenPower() {
        this.power = 0.5;
    }

    public Race getRace() {
        return race;
    }

    public double getPower() {
        return power;
    }

    public final boolean isPrivileged() {
        return (power == 1.5);
    }

    public final String getName() {
        return name;
    }

    public final double getHealth() {
        return health;
    }

    public void setRace(final Race race) {
        this.race = race;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setHealth(final double health) {
        this.health = health;
    }

    public void setAction1(final Action action1) {
        this.action1 = action1;
    }

    public void setAction2(final Action action) {
        this.action2 = action;
    }
}
