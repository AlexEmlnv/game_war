package com.corporation_name.unit.action;

import com.corporation_name.unit.Unit;

import static com.corporation_name.utils.LoggerUtil.log;

/**
 * Класс для реализациии действия по атаке на воина противника, с нанесением урона его жизни.
 */
public class AttackAction implements Action {

    private Unit initialUnit;
    private String name;
    private double damage;


    public AttackAction(final Unit initialUnit, final String name, final double damage) {

        this.initialUnit = initialUnit;
        this.name = name;
        this.damage = damage;
    }

    /**
     * Направление действия (на своего или на чужого).
     *
     * @return на чужого
     */
    @Override
    public boolean isForAlien() {

        return true;
    }

    /**
     * Логика самого действия.
     */
    @Override
    public void execute(final Unit targetUnit) {

        log(initialUnit.getName() + " " + name + ". "
            + targetUnit.getName() + " понёс урон " + initialUnit.getPower() * damage + ".");
        targetUnit.changeHealth(initialUnit.getPower() * damage);

        initialUnit.setStandardPower();
    }
}
