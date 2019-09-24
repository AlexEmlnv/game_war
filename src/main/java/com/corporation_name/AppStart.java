package com.corporation_name;

/**
 * Класс запускающий приложение.
 */
public class AppStart {

    /**
     * Точка входа в приложение.
     * @param args не используется
     */
    public static void main(String[] args) {

        Game game = new Game();
        game.play();
    }
}
