package com.corporation_name;

import com.corporation_name.squad.*;
import com.corporation_name.unit.action.Action;
import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;
import com.corporation_name.utils.RandomUtil;

public class Game {

    private static Game instance;
    private Squad lightSquad;
    private Squad darkSquad;

    private Game() {

    }

    public static Game getInstance() {
        if (instance==null) {
            instance = new Game();
        }

        return instance;
    }

    public void play() {

        start();

        while (isMayGoOn()) {
            step(lightSquad);
            step(darkSquad);
        }

        end();

    }

    public Squad getLightSquad() {
        return lightSquad;
    }

    public Squad getDarkSquad() {
        return darkSquad;
    }

    private boolean isMayGoOn() {

        return (lightSquad.getWarriorsCount() != 0 && darkSquad.getWarriorsCount() !=0);
    }

    private void step(Squad squad) {

        Unit srcUnit = squad.getRandomWarrior();
        Unit targetUnit= null;

        Action action = srcUnit.getRandomAction();

        if (action.isForAlien()) {
            targetUnit = squad.getAlienSquad().getRandomWarrior();
        } else {
            targetUnit = squad.getRandomOtherWarrior(srcUnit);
        }

        action.execute(targetUnit);
    }


    private void start() {

        SquadFactory squadFactory = getFactoryByRace(RandomUtil.getRandomGoodRace());
        lightSquad = squadFactory.createSquad();

        squadFactory = getFactoryByRace(RandomUtil.getRandomBadRace());
        darkSquad = squadFactory.createSquad();

        System.out.println("Игра началась!");
        System.out.println("Сражаются : " + lightSquad.getSquadName() + " и " + darkSquad.getSquadName() + "!");


    }

    private SquadFactory getFactoryByRace(Race race) {

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
                throw new RuntimeException("Неподдерживаемая раса: " + race);
        }

        return resSquadFactory;
    }

    private void end() {

        if (lightSquad.getWarriorsCount() != 0) {

            System.out.println(
                lightSquad.getSquadName() + " победила, в живых осталось " + lightSquad.getWarriorsCount() + " бойцов!"
            );
            System.out.println(darkSquad.getSquadName() + " проиграла, все бойцы погибли!");

        } else {

            System.out.println(
                darkSquad.getSquadName() + " победила, в живых осталось " + darkSquad.getWarriorsCount() + " бойцов!"
            );
            System.out.println(lightSquad.getSquadName() + " проиграла, все бойцы погибли!");

        }
    }


}
