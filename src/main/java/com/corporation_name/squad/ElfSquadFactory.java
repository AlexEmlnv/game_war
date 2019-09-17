package com.corporation_name.squad;

import com.corporation_name.Game;
import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;
import com.corporation_name.unit.elf.ElfArcher;
import com.corporation_name.unit.elf.ElfMagician;
import com.corporation_name.unit.elf.ElfWarrior;

import java.util.ArrayList;
import java.util.List;

public class ElfSquadFactory implements SquadFactory {

    final int MAGICIAN_COUNT = 1;
    final int ARCHER_COUNT = 3;
    final int WARRIOR_COUNT = 4;

    public Squad createSquad() {
        Squad squad = new Squad();
        squad.setRace(Race.ELF);
        squad.setName("Команда эльфов");
        List<Unit> list = new ArrayList<>();

        for (int i = 0; i < MAGICIAN_COUNT; i++) {
            ElfMagician elfMagician = new ElfMagician("Маг-эльф_" + i);
            list.add(elfMagician);
        }
        for (int i = 0; i < ARCHER_COUNT; i++) {
            ElfArcher elfArcher = new ElfArcher("Лучник-эльф_" + i);
            list.add(elfArcher);
        }
        for (int i = 0; i < WARRIOR_COUNT; i++) {
            ElfWarrior elfWarrior = new ElfWarrior("Воин-эльф_" + i);
            list.add(elfWarrior);
        }

        squad.setWarriors(list);

        Game.logTitle("Создана " + squad.getName() + ", количество бойцов " + squad.getWarriors().size());

        return squad;
    }
}
