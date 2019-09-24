package com.corporation_name.squad;

import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;

import java.util.List;

import static com.corporation_name.utils.LoggerUtil.logTitle;

/**
 * Класс реализующий общую логику отряда.
 */
public class Squad {

    private Race race;
    private String name;
    private List<Unit> warriors;

    public Race getRace() {

        return race;
    }

    public void setRace(final Race race) {

        this.race = race;
    }

    public String getName() {

        return name;
    }

    public void setName(final String name) {

        this.name = name;
    }

    /**
     * Получение коллекции бойцов отряда.
     *
     * @return List<Unit>
     */
    public List<Unit> getWarriors() {

        return warriors;
    }

    public void setWarriors(final List<Unit> warriors) {

        this.warriors = warriors;
    }

    /**
     * Возвращает число живых бойцов в отряде.
     *
     * @return int
     */
    public int getWarriorsCount() {

        return warriors.size();
    }

    /**
     * Возвращает произвольного бойца из отряда.
     *
     * @return воин
     */
    public Unit getRandomWarrior() {

        Unit unit = null;
        unit = getPrivilegedWarrior();
        if (unit == null) {
            unit = getNotPrivilegedWarrior();
        }

        return unit;
    }

    /**
     * Возвращает произвольного привелегированного (с улучшенными характеристиками) бойца из отряда.
     *
     * @return воин
     */
    private Unit getPrivilegedWarrior() {

        for (Unit unit : warriors) {
            if (unit.getPower() == 1.5) {
                return unit;
            }
        }

        return null;
    }

    /**
     * Возвращает произвольного НЕпривелегированного (с обычными характеристиками) бойца из отряда.
     *
     * @return воин
     */
    private Unit getNotPrivilegedWarrior() {

        for (Unit unit : warriors) {
            if (unit.getPower() != 1.5) {
                return unit;
            }
        }

        return null;
    }

    /**
     * Возвращает произвольного бойца из отряда, отличного от keyUnit.
     *
     * @param keyUnit воин , которому нужно подобрать отличного отнего бойца
     * @return воин, отличный от keyUnit
     */
    public Unit getRandomOtherWarrior(final Unit keyUnit) {

        for (Unit unit : warriors) {
            if (!unit.getName().equals(keyUnit.getName())) {
                return unit;
            }
        }

        return null;
    }

    /**
     * Удаляет бойца unit из отряда.
     *
     * @param unit - боец, которого нужно удалить из коллекции
     */
    public void removeWarrior(final Unit unit) {

        warriors.remove(unit);
        logTitle(unit.getName() + " погиб!");
    }
}
