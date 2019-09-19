package com.corporation_name.unit.elf;

import com.corporation_name.unit.action.Action;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ElfArcherTest {

    private ElfArcher elfArcher = null;

    @Before
    public void setUp() {
        elfArcher = new ElfArcher("эльф-лучник_1");
    }

    @Test
    public void getRandomAction() {
        Action action = elfArcher.getRandomAction();
        assertTrue(action.equals(elfArcher.getAction1() )|| action.equals(elfArcher.getAction2()));

    }

    @Test
    public void isAlive() {

        assertTrue( elfArcher.isAlive() );
    }

    @Test
    public void changeHealth() {

        elfArcher.changeHealth(20.0);

        assertTrue( elfArcher.getHealth() == 80.0 );
    }

    @Test
    public void setStandartPower() {

        elfArcher.setPrivilegedPower();
        assertTrue( elfArcher.getPower() == 1.5 );

        elfArcher.setStandartPower();
        assertTrue( elfArcher.getPower() == 1.0 );


    }

    @Test
    public void setPrivilegedPower() {

        elfArcher.setPrivilegedPower();

        assertTrue( elfArcher.getPower() == 1.5 );
    }

    @Test
    public void setBrokentPower() {

        elfArcher.setBrokentPower();

        assertTrue( elfArcher.getPower() == 0.5 );
    }

    @Test
    public void isPrivileged() {

        elfArcher.setPrivilegedPower();

        assertTrue( elfArcher.isPrivileged() );
    }

    @Test
    public void getName() {

        assertEquals( "эльф-лучник_1", elfArcher.getName() );

    }
}