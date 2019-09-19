package com.corporation_name.unit.action;

import com.corporation_name.unit.Unit;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class AttackActionTest {

    @Test
    public void isForAlien() {

        Unit unit = mock(Unit.class);

        AttackAction attackAction = new AttackAction(unit, "тест атака", 5.0);
        Boolean actual = attackAction.isForAlien();

        Assert.assertEquals(true, actual);
    }

    @Test
    public void execute() {

        Unit unit = mock(Unit.class);
        when(unit.getPower()).thenReturn(1.5);

        AttackAction attackAction = new AttackAction(unit, "тест атака", 5.0);
        Unit targetUnit = mock(Unit.class);

        attackAction.execute(targetUnit);

        verify(targetUnit, times(1)).changeHealth(7.5);

    }
}