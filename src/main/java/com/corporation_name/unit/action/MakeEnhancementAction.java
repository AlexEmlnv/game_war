package com.corporation_name.unit.action;

import com.corporation_name.unit.Unit;

import static com.corporation_name.utils.LoggerUtil.log;

/**
 * Класс для реализациии действия по наложению улучшения на воина из своего отряда.
 */
public class MakeEnhancementAction implements Action {

    private Unit initialUnit;
    private String name;

    public MakeEnhancementAction(final Unit initialUnit, final String name) {

        this.initialUnit = initialUnit;
        this.name = name;
    }

    /**
     * Направление действия (на своего или на чужого).
     * @return на своего
     */
    @Override
    public boolean isForAlien() {

        return false;
    }

    /**
     * Логика самого действия.
     */
    @Override
    public void execute(final Unit targetUnit) {

        log(initialUnit.getName() + " " + name + ". " + targetUnit.getName() + " получил улучшение.");
        targetUnit.setPrivilegedPower();
    }
}
