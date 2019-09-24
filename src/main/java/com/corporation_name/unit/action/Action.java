package com.corporation_name.unit.action;

import com.corporation_name.unit.Unit;

/**
 * Интерфес описывающий возможное дествие воина.
 */
public interface Action {

    /**
     * Направлено действие на своего или на чужого.
     *
     * @return true/false
     */
    boolean isForAlien();

    /**
     * Логика самого действия.
     *
     * @param unit - воин либо свой либо чужой
     */
    void execute(final Unit unit);
}
