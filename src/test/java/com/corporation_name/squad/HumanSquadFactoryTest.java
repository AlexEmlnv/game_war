package com.corporation_name.squad;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HumanSquadFactoryTest {

    @Test
    public void createSquad() {

        SquadFactory squadFactory= new HumanSquadFactory();

        Squad actualSquad = squadFactory.createSquad(1, 3, 4);

        Assert.assertEquals("Команда людей", actualSquad.getName() );

        Assert.assertTrue( actualSquad.getWarriorsCount() == 8 );

    }
}