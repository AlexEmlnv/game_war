package com.corporation_name.unit.undead;

import com.corporation_name.unit.action.AttackAction;
import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;

public class UndeadArcher extends Unit {

    public UndeadArcher(String name) {

        super(Race.UNDEAD, name);
        this.setAction1(new AttackAction(this, "стреляет из лука", 4.0));
        this.setAction2(new AttackAction(this, "атакует противника", 2.0));

    }
}
