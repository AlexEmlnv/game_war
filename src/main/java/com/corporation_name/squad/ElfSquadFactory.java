package com.corporation_name.squad;

import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;
import com.corporation_name.unit.elf.ElfArcher;
import com.corporation_name.unit.elf.ElfMagician;
import com.corporation_name.unit.elf.ElfWarrior;

import java.util.ArrayList;
import java.util.List;

import static com.corporation_name.utils.LoggerUtil.logTitle;

/**
 * Абстрактная фабрика создания отряда эльфов.
 */
public class ElfSquadFactory implements SquadFactory {

    /**
     * @param magicianCount - количество магов
     * @param archerCount   - количество лучников
     * @param warriorCount  - количество простых воинов
     * @return отряд эльфов
     */
    public Squad createSquad(final int magicianCount, final int archerCount, final int warriorCount) {

        Squad squad = new Squad();
        squad.setRace(Race.ELF);
        squad.setName("Команда эльфов");
        List<Unit> list = new ArrayList<>();

        for (int i = 0; i < magicianCount; i++) {
            ElfMagician elfMagician = new ElfMagician("Маг-эльф_" + i);
            list.add(elfMagician);
        }
        for (int i = 0; i < archerCount; i++) {
            ElfArcher elfArcher = new ElfArcher("Лучник-эльф_" + i);
            list.add(elfArcher);
        }
        for (int i = 0; i < warriorCount; i++) {
            ElfWarrior elfWarrior = new ElfWarrior("Воин-эльф_" + i);
            list.add(elfWarrior);
        }

        squad.setWarriors(list);

        logTitle("Создана " + squad.getName() + ", количество бойцов " + squad.getWarriors().size());

        return squad;
    }
}
