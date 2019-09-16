package com.corporation_name.utils;

import com.corporation_name.unit.Race;

public class RandomUtil {

    /**
     * Получение или Race.ELF или Race.HUMAN
     *
     * @return
     */
    public static Race getRandomGoodRace() {
        if (getRandomOneOrZero() == 1) {
            return Race.ELF;
        } else {
            return Race.HUMAN;
        }

    }

    /**
     * Получение или Race.ORC или Race.UNDEAD
     *
     * @return
     */
    public static Race getRandomBadRace() {
        if (getRandomOneOrZero() == 1) {
            return Race.ORC;
        } else {
            return Race.UNDEAD;
        }
    }

    /**
     * Получение или 1 или 0
     *
     * @return
     */
    public static int getRandomOneOrZero() {

        if ((int) (Math.random() * 2) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
