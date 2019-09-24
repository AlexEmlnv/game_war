package com.corporation_name.unit.elf;

import com.corporation_name.unit.action.AttackAction;
import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;

/**
 * Класс для производства экземпляров лучников-эльфов.
 */
public class ElfArcher extends Unit {

    public ElfArcher(final String name) {

        super(Race.ELF, name);
        this.setAction1(new AttackAction(this, "стреляет из лука", 7.0));
        this.setAction2(new AttackAction(this, "атакует противника", 3.0));
    }
}
