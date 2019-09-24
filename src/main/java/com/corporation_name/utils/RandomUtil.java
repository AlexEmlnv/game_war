package com.corporation_name.utils;

import com.corporation_name.unit.Race;

/**
 * Утилита для генерации случайных данных (чисел, enum и т.д).
 */
public class RandomUtil {

    /**
     * Получение или Race.ELF или Race.HUMAN.
     *
     * @return одну из светлых рас
     */
    public static Race getRandomGoodRace() {
        if (getRandomOneOrZero() == 1) {
            return Race.ELF;
        } else {
            return Race.HUMAN;
        }

    }

    /**
     * Получение или Race.ORC или Race.UNDEAD.
     *
     * @return одну из тёмных рас
     */
    public static Race getRandomBadRace() {
        if (getRandomOneOrZero() == 1) {
            return Race.ORC;
        } else {
            return Race.UNDEAD;
        }
    }

    /**
     * Получение или 1 или 0.
     *
     * @return 1/0
     */
    public static int getRandomOneOrZero() {

        if ((int) (Math.random() * 2) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
