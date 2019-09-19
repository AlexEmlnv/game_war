package com.corporation_name.unit.action;

import com.corporation_name.unit.Unit;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MakeEnhancementActionTest {

    @Test
    public void isForAlien() {

        Unit unit = mock(Unit.class);

        MakeEnhancementAction makeEnhancementAction = new MakeEnhancementAction(unit, "накладывает улучшение");
        Boolean actual = makeEnhancementAction.isForAlien();

        Assert.assertEquals(false, actual);

    }

    @Test
    public void execute() {

        Unit unit = mock(Unit.class);
        MakeEnhancementAction makeEnhancementAction = new MakeEnhancementAction(unit, "накладывает улучшение");

        Unit targetUnit = mock(Unit.class);
        when(targetUnit.getPower()).thenReturn(1.0);

        makeEnhancementAction.execute(targetUnit);

        verify(targetUnit, times(1)).setPrivilegedPower();

    }
}