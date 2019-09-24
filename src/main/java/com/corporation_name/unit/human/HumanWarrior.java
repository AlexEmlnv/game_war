package com.corporation_name.unit.human;

import com.corporation_name.unit.action.AttackAction;
import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;

/**
 * Класс для производства экземпляров воинов-людей.
 */
public class HumanWarrior extends Unit {

    public HumanWarrior(final String name) {

        super(Race.HUMAN, name);
        this.setAction1(new AttackAction(this, "атакует мечом", 18.0));
        this.setAction2(new AttackAction(this, "атакует мечом", 18.0));
    }
}
