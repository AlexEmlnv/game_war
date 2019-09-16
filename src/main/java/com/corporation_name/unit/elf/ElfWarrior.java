package com.corporation_name.unit.elf;

import com.corporation_name.unit.action.AttackAction;
import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;

public class ElfWarrior extends Unit {
    public ElfWarrior(String name) {

        super(Race.ELF, name);
        this.setAction1(new AttackAction(this, "атакует мечом", 15.0));
        this.setAction2(new AttackAction(this, "атакует мечом", 15.0));
    }
}
