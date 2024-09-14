package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConsoleAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final ByteArrayInputStream inContent = new ByteArrayInputStream(new byte[0]);

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setIn(inContent);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(System.in);
    }

    @Test
    public void testMainMenu() {
        String input = "1\n2\n3\n4\n5\n";
        inContent.reset();
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        // Запустите метод main вашего класса ConsoleApp
        ConsoleApp.main(new String[]{});

        String expectedOutput = "Меню:\n" +
                                "1. Добавить новый элемент\n" +
                                "2. Удалить элемент по индексу\n" +
                                "3. Вывод всех элементов в консоль\n" +
                                "4. Сравнение двух элементов на равенство\n" +
                                "5. Завершение работы приложения\n" +
                                "Введите номер действия: ";

        // Проверьте, что вывод соответствует ожидаемому
        Assertions.assertTrue(outContent.toString().contains(expectedOutput));
    }
}
