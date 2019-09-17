package com.corporation_name.squad;

import com.corporation_name.Game;
import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;
import com.corporation_name.unit.orc.OrcArcher;
import com.corporation_name.unit.orc.OrcMagician;
import com.corporation_name.unit.orc.OrcWarrior;

import java.util.ArrayList;
import java.util.List;

public class OrcSquadFactory implements SquadFactory {

    final int MAGICIAN_COUNT = 1;
    final int ARCHER_COUNT = 3;
    final int WARRIOR_COUNT = 4;

    public Squad createSquad() {
        Squad squad = new Squad();
        squad.setRace(Race.ORC);
        squad.setName("Банда орков");
        List<Unit> list = new ArrayList<>();

        for (int i = 0; i < MAGICIAN_COUNT; i++) {
            OrcMagician orcMagician = new OrcMagician("Шаман-орк_" + i);
            list.add(orcMagician);
        }
        for (int i = 0; i < ARCHER_COUNT; i++) {
            OrcArcher orcArcher = new OrcArcher("Лучник-орк_" + i);
            list.add(orcArcher);
        }
        for (int i = 0; i < WARRIOR_COUNT; i++) {
            OrcWarrior orcWarrior = new OrcWarrior("Гоблин-орк_" + i);
            list.add(orcWarrior);
        }

        squad.setWarriors(list);

        Game.logTitle("Создана " + squad.getName() + ", количество бойцов " + squad.getWarriors().size());

        return squad;
    }
}
