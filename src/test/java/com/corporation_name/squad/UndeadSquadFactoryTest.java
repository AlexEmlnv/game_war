package com.corporation_name.squad;

import org.junit.Test;

import static org.junit.Assert.*;

public class UndeadSquadFactoryTest {

    @Test
    public void createSquad() {

        SquadFactory squadFactory= new UndeadSquadFactory();

        Squad actualSquad = squadFactory.createSquad();

        assertEquals("Банда нежити", actualSquad.getName());

        assertTrue( actualSquad.getWarriorsCount() == 8 );

    }
}