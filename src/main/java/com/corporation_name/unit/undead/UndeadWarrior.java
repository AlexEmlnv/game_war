package com.corporation_name.unit.undead;

import com.corporation_name.unit.action.AttackAction;
import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;

/**
 * Класс для производства экземпляров зомби-нежитей.
 */
public class UndeadWarrior extends Unit {

    public UndeadWarrior(final String name) {

        super(Race.UNDEAD, name);
        this.setAction1(new AttackAction(this, "бъёт копьём", 18.0));
        this.setAction2(new AttackAction(this, "бъёт копьём", 18.0));
    }
}
