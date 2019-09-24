package com.corporation_name.squad;

import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;
import com.corporation_name.unit.undead.UndeadArcher;
import com.corporation_name.unit.undead.UndeadMagician;
import com.corporation_name.unit.undead.UndeadWarrior;

import java.util.ArrayList;
import java.util.List;

import static com.corporation_name.utils.LoggerUtil.logTitle;

/**
 * Абстрактная фабрика создания отряда нежити.
 */
public class UndeadSquadFactory implements SquadFactory {

    /**
     * Создание отряда нежити.
     *
     * @param magicianCount - количество некромантов
     * @param archerCount   - количество охотников
     * @param warriorCount  - количество зомби
     * @return отряд нежити
     */
    public Squad createSquad(final int magicianCount, final int archerCount, final int warriorCount) {

        Squad squad = new Squad();
        squad.setRace(Race.UNDEAD);
        squad.setName("Банда нежити");
        List<Unit> list = new ArrayList<>();

        for (int i = 0; i < magicianCount; i++) {
            UndeadMagician undeadMagician = new UndeadMagician("Некромант-нежить_" + i);
            list.add(undeadMagician);
        }
        for (int i = 0; i < archerCount; i++) {
            UndeadArcher undeadArcher = new UndeadArcher("Охотник-нежить_" + i);
            list.add(undeadArcher);
        }
        for (int i = 0; i < warriorCount; i++) {
            UndeadWarrior undeadWarrior = new UndeadWarrior("Зомби-нежить_" + i);
            list.add(undeadWarrior);
        }

        squad.setWarriors(list);

        logTitle("Создана " + squad.getName() + ", количество бойцов " + squad.getWarriors().size());

        return squad;
    }
}
