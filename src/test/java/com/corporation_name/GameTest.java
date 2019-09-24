package com.corporation_name;

import com.corporation_name.squad.Squad;
import com.corporation_name.unit.Unit;
import com.corporation_name.unit.action.Action;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameTest {



    @Test
    public void isMayGoOn_IsTrue_WhenSquadsContainWarriors() {


        Squad lightSquad = mock(Squad.class);
        when(lightSquad.getWarriorsCount()).thenReturn(5);

        Squad darkSquad = mock(Squad.class);
        when(darkSquad.getWarriorsCount()).thenReturn(3);

        Game game = new Game();
        game.setLightSquad(lightSquad);
        game.setDarkSquad(darkSquad);

        assertTrue(game.isMayGoOn());


    }

    @Test
    public void isMayGoOnFalse_IsFalse_WhenOneSquadNotContainWarriors() {

        Squad lightSquad = mock(Squad.class);
        when(lightSquad.getWarriorsCount()).thenReturn(0);

        Squad darkSquad = mock(Squad.class);
        when(darkSquad.getWarriorsCount()).thenReturn(3);

        Game game = new Game();
        game.setLightSquad(lightSquad);
        game.setDarkSquad(darkSquad);

        assertFalse(game.isMayGoOn());
    }

    @Test
    public void step() {

        Squad activeSquad = mock(Squad.class);
        Unit activeUnit = mock(Unit.class);
        Action action = mock(Action.class);
        when(activeSquad.getRandomWarrior()).thenReturn(activeUnit);
        when(activeUnit.getRandomAction()).thenReturn(action);
        when(action.isForAlien()).thenReturn(true);

        Squad targetSquad = mock(Squad.class);
        Unit targetUnit = mock(Unit.class);
        when(targetSquad.getRandomWarrior()).thenReturn(targetUnit);
        when(targetUnit.isAlive()).thenReturn(false);

        Game game = new Game();
        game.step(activeSquad, targetSquad);
        verify(action, times(1)).execute(targetUnit);
        verify(targetSquad, times(1)).removeWarrior(targetUnit);
    }
}