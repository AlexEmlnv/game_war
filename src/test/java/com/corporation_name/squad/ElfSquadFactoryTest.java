package com.corporation_name.squad;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElfSquadFactoryTest {

    @Test
    public void createSquad() {

        SquadFactory squadFactory= new ElfSquadFactory();

        Squad actualSquad = squadFactory.createSquad();

        Assert.assertEquals("Команда эльфов", actualSquad.getName() );

        Assert.assertTrue( actualSquad.getWarriorsCount() == 8 );

    }
}