package com.corporation_name.squad;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrcSquadFactoryTest {

    @Test
    public void createSquad() {

        SquadFactory squadFactory= new OrcSquadFactory();

        Squad actualSquad = squadFactory.createSquad(1, 3, 4);

        assertEquals("Банда орков", actualSquad.getName());

        assertTrue( actualSquad.getWarriorsCount() == 8 );

    }
}