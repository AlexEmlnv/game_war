package com.corporation_name.unit.action;

import com.corporation_name.unit.Unit;

import static com.corporation_name.utils.LoggerUtil.log;

/**
 * Класс для реализациии действия по наложению ухудшения на воина из чужого отряда.
 */
public class MakeDegradationAction implements Action {

    private Unit initialUnit;
    private String name;

    public MakeDegradationAction(final Unit initialUnit, final String name) {

        this.initialUnit = initialUnit;
        this.name = name;
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

        log(initialUnit.getName() + " " + name + ". " + targetUnit.getName() + " снизил свою силу.");
        if (targetUnit.getPower() == 1.5) {
            targetUnit.setStandardPower();
        } else if (targetUnit.getPower() == 1.0) {
            targetUnit.setBrokenPower();
        }
    }
}
