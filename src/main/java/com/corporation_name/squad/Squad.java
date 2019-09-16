package com.corporation_name.squad;

import com.corporation_name.Game;
import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;

import java.util.List;

public class Squad {

    private Race race;
    private String squadName;
    private List<Unit> warriors;
//    private Squad alienSquad;

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public List<Unit> getWarriors() {
        return warriors;
    }

    public void setWarriors(List<Unit> warriors) {
        this.warriors = warriors;
    }

    public Squad getAlienSquad() {

        if (race == Race.ELF || race == Race.HUMAN ) {
            return Game.getInstance().getDarkSquad();
        } else {
            return Game.getInstance().getLightSquad();
        }
    }

    public int getWarriorsCount() { return warriors.size(); }

    public Unit getRandomWarrior() { return null; }

    public Unit getRandomOtherWarrior(Unit keyUnit) { return null; }

//    public void step() {
//
//        Unit unit =  getRandomUnit();
//        Action action = unit.getRandomAction();
//        if (action.isForAlien()) {
//            alienSqued.getRandomUnit();
//        }

}
