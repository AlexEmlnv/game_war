package com.corporation_name.unit.action;

import com.corporation_name.unit.Unit;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MakeDegradationActionTest {

    @Test
    public void isForAlien() {

        Unit unit = mock(Unit.class);

        MakeDegradationAction makeDegradationAction = new MakeDegradationAction(unit, "насылает недуг");
        Boolean actual = makeDegradationAction.isForAlien();

        Assert.assertEquals(true, actual);

    }

    @Test
    public void execute() {

        Unit unit = mock(Unit.class);
        MakeDegradationAction makeDegradationAction = new MakeDegradationAction(unit, "насылает недуг");

        Unit targetUnit = mock(Unit.class);
        when(targetUnit.getPower()).thenReturn(1.5);

        makeDegradationAction.execute(targetUnit);

        verify(targetUnit, times(1)).setStandardPower();

    }
}