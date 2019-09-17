package com.corporation_name.unit.action;

import com.corporation_name.Game;
import com.corporation_name.unit.Unit;

public class MakeDegradationAction implements Action{

    private Unit initialUnit;
    private String name;

    public MakeDegradationAction(Unit initialUnit, String name ) {
        this.initialUnit = initialUnit;
        this.name = name;
    }

    @Override
    public boolean isForAlien() {

        return true;
    }

    @Override
    public void execute( Unit targetUnit ) {

        Game.log(initialUnit.getName() + " " + name + ". " + targetUnit.getName() + " снизил свою силу.");
        if (targetUnit.getPower() == 1.5) {
            targetUnit.setStandartPower();
        } else if (targetUnit.getPower() == 1.0) {
            targetUnit.setBrokentPower();
        }

    }

}
