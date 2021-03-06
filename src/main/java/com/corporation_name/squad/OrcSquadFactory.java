package com.corporation_name.squad;

import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;
import com.corporation_name.unit.orc.OrcArcher;
import com.corporation_name.unit.orc.OrcMagician;
import com.corporation_name.unit.orc.OrcWarrior;

import java.util.ArrayList;
import java.util.List;

import static com.corporation_name.utils.LoggerUtil.logTitle;

/**
 * Абстрактная фабрика создания отряда орков.
 */
public class OrcSquadFactory implements SquadFactory {

    /**
     * Создание отряда орков.
     * @param magicianCount - количество шаманов
     * @param archerCount - количество лучников
     * @param warriorCount - количество гоблинов
     * @return отряд орков
     */
    public Squad createSquad(final int magicianCount, final int archerCount, final int warriorCount) {
        Squad squad = new Squad();
        squad.setRace(Race.ORC);
        squad.setName("Банда орков");
        List<Unit> list = new ArrayList<>();

        for (int i = 0; i < magicianCount; i++) {
            OrcMagician orcMagician = new OrcMagician("Шаман-орк_" + i);
            list.add(orcMagician);
        }
        for (int i = 0; i < archerCount; i++) {
            OrcArcher orcArcher = new OrcArcher("Лучник-орк_" + i);
            list.add(orcArcher);
        }
        for (int i = 0; i < warriorCount; i++) {
            OrcWarrior orcWarrior = new OrcWarrior("Гоблин-орк_" + i);
            list.add(orcWarrior);
        }

        squad.setWarriors(list);

        logTitle("Создана " + squad.getName() + ", количество бойцов " + squad.getWarriors().size());

        return squad;
    }
}
