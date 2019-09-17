package com.corporation_name.squad;

import com.corporation_name.Game;
import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;
import com.corporation_name.unit.human.HumanArcher;
import com.corporation_name.unit.human.HumanMagician;
import com.corporation_name.unit.human.HumanWarrior;

import java.util.ArrayList;
import java.util.List;

public class HumanSquadFactory implements SquadFactory {

    final int MAGICIAN_COUNT = 1;
    final int ARCHER_COUNT = 3;
    final int WARRIOR_COUNT = 4;

    public Squad createSquad() {
        Squad squad = new Squad();
        squad.setRace(Race.HUMAN);
        squad.setName("Команда людей");
        List<Unit> list = new ArrayList<>();

        for (int i = 0; i < MAGICIAN_COUNT; i++) {
            HumanMagician elfMagician = new HumanMagician("Маг-человек_" + i);
            list.add(elfMagician);
        }
        for (int i = 0; i < ARCHER_COUNT; i++) {
            HumanArcher elfArcher = new HumanArcher("Арбалетчик-человек_" + i);
            list.add(elfArcher);
        }
        for (int i = 0; i < WARRIOR_COUNT; i++) {
            HumanWarrior elfWarrior = new HumanWarrior("Воин-человек_" + i);
            list.add(elfWarrior);
        }

        squad.setWarriors(list);

        Game.logTitle("Создана " + squad.getName() + ", количество бойцов " + squad.getWarriors().size());

        return squad;
    }
}
