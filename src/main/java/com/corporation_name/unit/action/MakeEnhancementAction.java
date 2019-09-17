package com.corporation_name.unit.action;

import com.corporation_name.Game;
import com.corporation_name.unit.Unit;

public class MakeEnhancementAction implements Action{

    private Unit initialUnit;
    private String name;

    public MakeEnhancementAction(Unit initialUnit, String name ) {
        this.initialUnit = initialUnit;
        this.name = name;
    }

    @Override
    public boolean isForAlien() {

        return false;
    }

    @Override
    public void execute( Unit targetUnit ) {
        Game.log( initialUnit.getName() + " " + name + ". " + targetUnit.getName() + " получил улучшение.");
        targetUnit.setPrivilegedPower();

    }
}
