package com.corporation_name;

import com.corporation_name.squad.*;
import com.corporation_name.unit.action.Action;
import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;
import com.corporation_name.utils.RandomUtil;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public class Game {

    private static Game instance;
    private static final Logger logger = Logger.getLogger("Game");
    private static int stepCount = 1;
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

    public static void log(String message) {
        logger.log( Priority.INFO, stepCount++ + ". " + message);
    }

    public static void logTitle(String message) {
        logger.log( Priority.INFO, message);
    }

    public Squad getLightSquad() {
        return lightSquad;
    }

    public Squad getDarkSquad() {
        return darkSquad;
    }

    private boolean isMayGoOn() {

        return (lightSquad.getWarriorsCount() != 0 && darkSquad.getWarriorsCount() !=0 && stepCount<=200);
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

        if (targetUnit != null) {

            action.execute(targetUnit);

            if (action.isForAlien() && !targetUnit.isAlive()) {
                squad.getAlienSquad().removeWarrior( targetUnit );
            }
        }
    }


    private void start() {

        logTitle( "\n\n" + "----------------------------- Начало новой игры -----------------------------------");

        SquadFactory squadFactory = getFactoryByRace(RandomUtil.getRandomGoodRace());
        lightSquad = squadFactory.createSquad();

        squadFactory = getFactoryByRace(RandomUtil.getRandomBadRace());
        darkSquad = squadFactory.createSquad();


        logTitle("Сражаются " + lightSquad.getName() + " и " + darkSquad.getName() + "!" + "\n");


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
                logTitle("ERROR : Неподдерживаемая раса: " + race  );
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

        logTitle(lightSquad.getName() + ": " + lightSquad.getWarriorsCount() + " живых, " +
            darkSquad.getName() + ": " + darkSquad.getWarriorsCount() + " живых. ");
        logTitle( "----------------------------- Конец игры -----------------------------------");


    }

}
