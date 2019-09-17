package com.corporation_name.squad;

import com.corporation_name.Game;
import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;
import com.corporation_name.unit.undead.UndeadArcher;
import com.corporation_name.unit.undead.UndeadMagician;
import com.corporation_name.unit.undead.UndeadWarrior;

import java.util.ArrayList;
import java.util.List;

public class UndeadSquadFactory implements SquadFactory {

    final int MAGICIAN_COUNT = 1;
    final int ARCHER_COUNT = 3;
    final int WARRIOR_COUNT = 4;

    public Squad createSquad() {
        Squad squad = new Squad();
        squad.setRace(Race.UNDEAD);
        squad.setName("Банда нежити");
        List<Unit> list = new ArrayList<>();

        for (int i = 0; i < MAGICIAN_COUNT; i++) {
            UndeadMagician undeadMagician = new UndeadMagician("Некромант-нежить_" + i);
            list.add(undeadMagician);
        }
        for (int i = 0; i < ARCHER_COUNT; i++) {
            UndeadArcher undeadArcher = new UndeadArcher("Охотник-нежить_" + i);
            list.add(undeadArcher);
        }
        for (int i = 0; i < WARRIOR_COUNT; i++) {
            UndeadWarrior undeadWarrior = new UndeadWarrior("Зомби-нежить_" + i);
            list.add(undeadWarrior);
        }

        squad.setWarriors(list);

        Game.logTitle("Создана " + squad.getName() + ", количество бойцов " + squad.getWarriors().size());

        return squad;
    }
}