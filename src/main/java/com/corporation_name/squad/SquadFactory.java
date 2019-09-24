package com.corporation_name.squad;

/**
 * Абстрактная фабрика создания отряда воинов.
 */
public interface SquadFactory {

    /**
     * Создает отряд воинов.
     * @param magicianCount - количество магов
     * @param archerCount - количество лучников
     * @param warriorCount - количество простых воинов
     * @return отряд воинов
     */
    Squad createSquad(int magicianCount, int archerCount, int warriorCount);
}
