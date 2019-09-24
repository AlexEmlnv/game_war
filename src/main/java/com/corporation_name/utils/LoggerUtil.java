package com.corporation_name.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

/**
 * Утилитарный класс предназнначенный для журналирования игры (в консоль и в файл).
 */
public class LoggerUtil {

    private static int stepCount = 1;
    private static final Logger LOGGER = Logger.getLogger("Game");

    /**
     * Вывод в лог сообщения c указанием номера этого сообщения.
     * @param message текст сообщения
     */
    public static void log(final String message) {
        LOGGER.log(Priority.INFO, stepCount++ + ". " + message);
    }

    /**
     * Вывод в лог сообщения.
     * @param message текст сообщения
     */
    public static void logTitle(final String message) {
        LOGGER.log(Priority.INFO, message);
    }

}
