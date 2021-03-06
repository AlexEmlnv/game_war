package com.corporation_name.unit.human;

import com.corporation_name.unit.action.AttackAction;
import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;

/**
 * Класс для производства экземпляров арбалетчиков-людей.
 */
public class HumanArcher extends Unit {

    public HumanArcher(final String name) {
        super(Race.HUMAN, name);
        this.setAction1(new AttackAction(this, "стреляет из арбалета", 5.0));
        this.setAction2(new AttackAction(this, "атакует противника", 3.0));
    }
}
