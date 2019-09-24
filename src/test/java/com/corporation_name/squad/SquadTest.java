package com.corporation_name.squad;

import com.corporation_name.unit.Race;
import com.corporation_name.unit.Unit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SquadTest {

    private Squad squad;

    @Before
    public void setUp() throws Exception {
        squad = (new ElfSquadFactory()).createSquad(1, 3, 4);
    }

    @Test
    public void getRace() {

        Race expected = Race.ELF;

        Race actual = squad.getRace();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void setRace() {

        squad.setRace( Race.HUMAN );

        Assert.assertEquals(Race.HUMAN, squad.getRace());

    }

    @Test
    public void getName() {
        Assert.assertEquals("Команда эльфов", squad.getName());
    }

    @Test
    public void setName() {
        squad.setName( "Банда орков" );
        assertEquals("Банда орков", squad.getName());
    }

    @Test
    public void getWarriors() {
//        final int MAGICIAN_COUNT = 1;
//        final int ARCHER_COUNT = 3;
//        final int WARRIOR_COUNT = 4;
//        List<Unit> expectedList = new ArrayList<>();
//
//        for (int i = 0; i < MAGICIAN_COUNT; i++) {
//            ElfMagician elfMagician = new ElfMagician("Маг-эльф_" + i);
//            expectedList.add(elfMagician);
//        }
//        for (int i = 0; i < ARCHER_COUNT; i++) {
//            ElfArcher elfArcher = new ElfArcher("Лучник-эльф_" + i);
//            expectedList.add(elfArcher);
//        }
//        for (int i = 0; i < WARRIOR_COUNT; i++) {
//            ElfWarrior elfWarrior = new ElfWarrior("Воин-эльф_" + i);
//            expectedList.add(elfWarrior);
//        }
//
//
//
//        assertEquals( squad.getWarriors(), expectedList );

    }

    @Test
    public void setWarriors() {

    }

    @Test
    public void getAlienSquad() {

    }

    @Test
    public void getWarriorsCount() {

        assertTrue( squad.getWarriorsCount() == 8 );

    }

    @Test
    public void getRandomWarrior() {

        Unit actualUnit = squad.getRandomWarrior();

        assertTrue( squad.getWarriors().contains( actualUnit ) );

    }

    @Test
    public void getRandomOtherWarrior() {

        Unit initialUnit = squad.getRandomWarrior();

        Unit actualUnit = squad.getRandomOtherWarrior(initialUnit);

        assertTrue( squad.getWarriors().contains( actualUnit ) && !actualUnit.equals( initialUnit ));

    }

    @Test
    public void removeWarrior() {

        Unit unit = squad.getRandomWarrior();

        squad.removeWarrior( unit );

        assertTrue( !squad.getWarriors().contains( unit ) );

    }
}