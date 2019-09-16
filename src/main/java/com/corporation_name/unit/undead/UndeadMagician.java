package com.corporation_name.unit.undead;

import com.corporation_name.unit.action.AttackAction;
import com.corporation_name.unit.action.MakeDegradationAction;
import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;

public class UndeadMagician  extends Unit {

    public UndeadMagician(String name) {

        super(Race.UNDEAD, name);
        this.setAction1(new MakeDegradationAction(this, "насылает недуг"));
        this.setAction2(new AttackAction(this, "атакует ", 5.0));
    }
}
