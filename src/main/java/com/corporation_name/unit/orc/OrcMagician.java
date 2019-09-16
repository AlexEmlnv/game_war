package com.corporation_name.unit.orc;

import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;
import com.corporation_name.unit.action.MakeDegradationAction;
import com.corporation_name.unit.action.MakeEnhancementAction;

public class OrcMagician extends Unit {

    public OrcMagician(String name) {

        super(Race.ORC, name);
        this.setAction1(new MakeEnhancementAction(this, "накладывает улучшение"));
        this.setAction2(new MakeDegradationAction(this, "накладывает проклятие"));
    }
}
