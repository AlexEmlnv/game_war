package com.corporation_name.unit.elf;

import com.corporation_name.unit.action.AttackAction;
import com.corporation_name.unit.action.MakeEnhancementAction;
import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;

/**
 * Класс для производства экземпляров магов-эльфов.
 */
public class ElfMagician extends Unit {

    public ElfMagician(final String name) {

        super(Race.ELF, name);
        this.setAction1(new MakeEnhancementAction(this, "накладывает улучшение"));
        this.setAction2(new AttackAction(this, "наносит магией урон", 10.0));
    }
}
