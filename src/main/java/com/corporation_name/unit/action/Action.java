package com.corporation_name.unit.action;

import com.corporation_name.unit.Unit;

public interface Action {

    boolean isForAlien();

    void execute( Unit unit);
}
