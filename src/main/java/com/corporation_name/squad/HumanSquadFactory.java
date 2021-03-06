package com.corporation_name.squad;

import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;
import com.corporation_name.unit.human.HumanArcher;
import com.corporation_name.unit.human.HumanMagician;
import com.corporation_name.unit.human.HumanWarrior;

import java.util.ArrayList;
import java.util.List;

import static com.corporation_name.utils.LoggerUtil.logTitle;

/**
 * Абстрактная фабрика создания отряда людей.
 */
public class HumanSquadFactory implements SquadFactory {

    /**
     * Создание отряда людей.
     * @param magicianCount - количество магов
     * @param archerCount - количество арбалетчиков
     * @param warriorCount - количество простых воинов
     * @return отряд людей
     */
    public Squad createSquad(final int magicianCount, final int archerCount, final int warriorCount) {

        Squad squad = new Squad();
        squad.setRace(Race.HUMAN);
        squad.setName("Команда людей");
        List<Unit> list = new ArrayList<>();

        for (int i = 0; i < magicianCount; i++) {
            HumanMagician elfMagician = new HumanMagician("Маг-человек_" + i);
            list.add(elfMagician);
        }
        for (int i = 0; i < archerCount; i++) {
            HumanArcher elfArcher = new HumanArcher("Арбалетчик-человек_" + i);
            list.add(elfArcher);
        }
        for (int i = 0; i < warriorCount; i++) {
            HumanWarrior elfWarrior = new HumanWarrior("Воин-человек_" + i);
            list.add(elfWarrior);
        }

        squad.setWarriors(list);

        logTitle("Создана " + squad.getName() + ", количество бойцов " + squad.getWarriors().size());

        return squad;
    }
}
