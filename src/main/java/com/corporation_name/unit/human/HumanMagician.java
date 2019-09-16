package com.corporation_name.unit.human;

import com.corporation_name.unit.action.AttackAction;
import com.corporation_name.unit.action.MakeEnhancementAction;
import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;

public class HumanMagician extends Unit {

    public HumanMagician(String name) {

        super(Race.HUMAN, name);
        this.setAction1(new MakeEnhancementAction(this, "накладывает улучшение"));
        this.setAction2(new AttackAction(this, "атакует магией", 4.0));
    }
}
