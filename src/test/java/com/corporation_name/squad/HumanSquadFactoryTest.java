package com.corporation_name.squad;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HumanSquadFactoryTest {

    @Test
    public void createSquad() {

        SquadFactory squadFactory= new HumanSquadFactory();

        Squad actualSquad = squadFactory.createSquad();

        Assert.assertEquals("Команда людей", actualSquad.getName() );

        Assert.assertTrue( actualSquad.getWarriorsCount() == 8 );

    }
}