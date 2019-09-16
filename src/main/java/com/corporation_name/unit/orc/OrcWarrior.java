package com.corporation_name.unit.orc;

import com.corporation_name.unit.action.AttackAction;
import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;

public class OrcWarrior extends Unit {
    public OrcWarrior(String name) {

        super(Race.ORC,name);
        this.setAction1(new AttackAction(this, "атакует дубиной",20.0 ));
        this.setAction2(new AttackAction(this, "атакует дубиной",20.0 ));
    }
}
