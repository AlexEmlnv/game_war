package com.corporation_name.unit;

import com.corporation_name.Game;
import com.corporation_name.unit.action.Action;
import com.corporation_name.utils.RandomUtil;

public abstract class Unit {

    private Race race;
    private String name;
    private double health = 100.0;
    private double power = 1.0; /* может быть 0.5, 1.0 или 1.5 */
    private Action action1;
    private Action action2;

    public Unit(Race race, String name, Action action1, Action action2) {
        this.race = race;
        this.name = name;
        this.action1 = action1;
        this.action2 = action2;
    }

    public Unit(Race race, String name) {
        this.race = race;
        this.name = name;
    }

    public Action getAction1() {
        return action1;
    }

    public Action getAction2() {
        return action2;
    }

    public Action getRandomAction() {
        if (RandomUtil.getRandomOneOrZero() == 1) {
            return getAction1();
        } else {
            return getAction2();
        }
    }

    public boolean isAlive() {
        return (health > 0.0);
    }

    public void changeHealth(double damage) {
        this.health = this.health - damage;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public void setStandartPower() {
        this.power = 1.0;
    }

    public void setPrivilegedPower() {
        this.power = 1.5;
    }

    public void setBrokentPower() {
        this.power = 0.5;
    }

    public Race getRace() {
        return race;
    }

    public double getPower() {
        return power;
    }

    public boolean isPrivileged() {
        return (power == 1.5);
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setAction1(Action action1) {
        this.action1 = action1;
    }

    public void setAction2(Action action2) {
        this.action2 = action2;
    }
}
