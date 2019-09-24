package com.corporation_name.unit.action;

import com.corporation_name.unit.Unit;

import static com.corporation_name.utils.LoggerUtil.log;

public class AttackAction implements Action {

    private Unit initialUnit;
    private String name;
    private double damage;


    public AttackAction(Unit initialUnit, String name, double damage ) {
        this.initialUnit = initialUnit;
        this.name = name;
        this.damage = damage;
    }

    @Override
    public boolean isForAlien() {
        return true;
    }

    @Override
    public void execute(Unit targetUnit) {

        log(initialUnit.getName() + " " + name + ". " +
                targetUnit.getName() + " понёс урон " + initialUnit.getPower() * damage + ".");
        targetUnit.changeHealth(initialUnit.getPower() * damage);

        initialUnit.setStandardPower();

    }
}
