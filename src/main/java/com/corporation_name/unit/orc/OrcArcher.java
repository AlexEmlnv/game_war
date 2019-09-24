package com.corporation_name.unit.orc;

import com.corporation_name.unit.action.AttackAction;
import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;

/**
 * Класс для производства экземпляров лучников-орков.
 */
public class OrcArcher extends Unit {

    public OrcArcher(final String name) {
        super(Race.ORC, name);
        this.setAction1(new AttackAction(this, "стреляет из лука", 3.0));
        this.setAction2(new AttackAction(this, "атакует противника", 2.0));
    }
}
