package com.corporation_name;

import com.corporation_name.squad.*;
import com.corporation_name.unit.action.Action;
import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;
import com.corporation_name.utils.RandomUtil;

import static com.corporation_name.utils.LoggerUtil.logTitle;

/**
 * Класс реализующий общую логику игры.
 */
public class Game {

    private Squad lightSquad;
    private Squad darkSquad;

    void setLightSquad(Squad lightSquad) {
        this.lightSquad = lightSquad;
    }

    void setDarkSquad(Squad darkSquad) {
        this.darkSquad = darkSquad;
    }

    /**
     * Само действие игры.
     */
    public void play() {

        start();

        while (isMayGoOn()) {
            step(lightSquad, darkSquad);

            step(darkSquad, lightSquad);
        }

        end();
    }

    /**
     * Проверка на возможности продолжения игры.
     * @return можно ли играть дальше
     */
    boolean isMayGoOn() {

        return (lightSquad.getWarriorsCount() != 0 && darkSquad.getWarriorsCount() != 0);
    }

    void step(final Squad initialSquad, final Squad targetSquad) {

        Unit srcUnit = initialSquad.getRandomWarrior();
        Unit targetUnit = null;

        Action action = srcUnit.getRandomAction();

        if (action.isForAlien()) {
            targetUnit = targetSquad.getRandomWarrior();
        } else {
            targetUnit = initialSquad.getRandomOtherWarrior(srcUnit);
        }

        if (targetUnit != null) {

            action.execute(targetUnit);

            if (action.isForAlien() && !targetUnit.isAlive()) {
                targetSquad.removeWarrior(targetUnit);
            }
        }
    }


    private void start() {

        logTitle("\n\n" + "----------------------------- Начало новой игры -----------------------------------");

        SquadFactory squadFactory = getFactoryByRace(RandomUtil.getRandomGoodRace());
        lightSquad = squadFactory.createSquad(1, 3, 4);

        squadFactory = getFactoryByRace(RandomUtil.getRandomBadRace());
        darkSquad = squadFactory.createSquad(1, 3, 4);

        logTitle("Сражаются " + lightSquad.getName() + " и " + darkSquad.getName() + "!" + "\n");
    }

    private SquadFactory getFactoryByRace(final Race race) {

        SquadFactory resSquadFactory = null;

        switch (race) {

            case ELF:
                resSquadFactory = new ElfSquadFactory();
                break;
            case HUMAN:
                resSquadFactory = new HumanSquadFactory();
                break;
            case ORC:
                resSquadFactory = new OrcSquadFactory();
                break;
            case UNDEAD:
                resSquadFactory = new UndeadSquadFactory();
                break;
            default:
                logTitle("ERROR : Неподдерживаемая раса: " + race);
                throw new RuntimeException("Неподдерживаемая раса: " + race);
        }

        return resSquadFactory;
    }

    private void end() {

        if (lightSquad.getWarriorsCount() == 0) {

            logTitle("\n" + lightSquad.getName() + " проиграла, все бойцы погибли!");
        } else if (darkSquad.getWarriorsCount() == 0) {

            logTitle("\n" + darkSquad.getName() + " проиграла, все бойцы погибли!");
        } else {

            logTitle("\n" + "Пока бой продолжается!");
        }

        logTitle(lightSquad.getName() + ": " + lightSquad.getWarriorsCount() + " живых, "
            + darkSquad.getName() + ": " + darkSquad.getWarriorsCount() + " живых. ");
        logTitle("----------------------------- Конец игры -----------------------------------");
    }
}
