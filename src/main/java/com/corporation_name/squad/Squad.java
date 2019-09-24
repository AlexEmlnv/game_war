package com.corporation_name.squad;

import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;

import java.util.List;

import static com.corporation_name.utils.LoggerUtil.logTitle;

public class Squad {

    private Race race;
    private String name;
    private List<Unit> warriors;
//    private Squad alienSquad;

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public List<Unit> getWarriors() {
        return warriors;
    }

    public void setWarriors(List<Unit> warriors) {
        this.warriors = warriors;
    }

    public int getWarriorsCount() { return warriors.size(); }

    public Unit getRandomWarrior() {
        Unit unit = null;
        unit = getPrivilegedWarrior();
        if (unit == null) unit = getNotPrivilegedWarrior();

        return unit;
    }

    private Unit getPrivilegedWarrior() {
        for (Unit unit: warriors){
            if (unit.getPower() == 1.5) return unit;
        }

        return null;
    }

    private Unit getNotPrivilegedWarrior() {
        for (Unit unit: warriors){
            if (unit.getPower() != 1.5) return unit;
        }

        return null;
    }

    public Unit getRandomOtherWarrior(Unit keyUnit) {

        for (Unit unit : warriors) {
            if (!unit.getName().equals( keyUnit.getName() )) return unit;
        }

        return null;
    }

    public void removeWarrior(Unit unit) {

        warriors.remove( unit );
        logTitle( unit.getName() + " погиб!" );
    }

}
