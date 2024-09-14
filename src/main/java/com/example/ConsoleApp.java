/**
 * Основной класс консольного приложения для управления списком сущностей
 * (Test, Exam, GraduationExam). Предоставляет меню для добавления, удаления,
 * вывода и сравнения сущностей.
 */
public class ConsoleApp {

    /**
     * Главный метод программы. Выводит меню и обрабатывает пользовательский ввод,
     * позволяя добавлять, удалять, выводить сущности и завершать работу программы.
     *
     * @param args аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Добавить новый элемент");
            System.out.println("2. Удалить элемент по индексу");
            System.out.println("3. Вывод всех элементов");
            System.out.println("4. Сравнение двух элементов на равенство");
            System.out.println("5. Завершение работы");

            int choice = getIntInput("Введите ваш выбор: ");

            switch (choice) {
                case 1:
                    addNewEntity();
                    break;
                case 2:
                    removeEntityByIndex();
                    break;
                case 3:
                    printAllEntities();
                    break;
                case 4:
                    compareEntities();
                    break;
                case 5:
                    System.out.println("Завершение работы.");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    /**
     * Метод для добавления новой сущности в список. Пользователь выбирает тип
     * сущности, вводит числовое и текстовое поля, и сущность добавляется в общий
     * список.
     */
    private static void addNewEntity() {
        int type;
        while (true) {
            System.out.println("Введите тип элемента (1 - Тест, 2 - Экзамен, 3 - ВыпускнойЭкзамен):");
            type = getIntInput("Введите тип элемента: ");
            if (type == 1 || type == 2 || type == 3) {
                break; // Правильный ввод, выходим из цикла
            } else {
                System.out.println("Неверный тип элемента. Пожалуйста, введите 1, 2 или 3.");
            }
        }

        int numberField = getIntInput("Введите числовое поле: ");
        String textField = getStringInput("Введите текстовое поле: ");

        TestBase entity = null;
        switch (type) {
            case 1:
                String testType = getStringInput("Введите тип теста: ");
                entity = new Test(numberField, textField, testType);
                break;
            case 2:
                String examDate = getStringInput("Введите дату экзамена: ");
                entity = new Exam(numberField, textField, examDate);
                break;
            case 3:
                String graduationYear = getStringInput("Введите год выпуска: ");
                entity = new GraduationExam(numberField, textField, graduationYear);
                break;
        }

        entityList.add(entity);
        System.out.println("Элемент добавлен.");
    }

    /**
     * Метод для удаления сущности по индексу. Пользователь вводит индекс элемента,
     * и если индекс верен, элемент удаляется из списка.
     */
    private static void removeEntityByIndex() {
        int index = getIntInput("Введите индекс элемента для удаления: ");

        if (index >= 0 && index < entityList.size()) {
            entityList.remove(index);
            System.out.println("Элемент удален.");
        } else {
            System.out.println("Неверный индекс.");
        }
    }

    /**
     * Метод для вывода всех сущностей в списке. Если список пуст, выводится
     * сообщение об этом.
     */
    private static void printAllEntities() {
        if (entityList.isEmpty()) {
            System.out.println("Список пуст.");
        } else {
            for (int i = 0; i < entityList.size(); i++) {
                System.out.println("Индекс " + i + ": " + entityList.get(i));
            }
        }
    }

    /**
     * Метод для сравнения двух сущностей на равенство. Пользователь вводит индексы
     * двух элементов, и если оба индекса верны, сравниваются объекты. Выводится
     * сообщение, равны ли они или нет.
     */
    private static void compareEntities() {
        int index1 = getIntInput("Введите индекс первого элемента: ");
        int index2 = getIntInput("Введите индекс второго элемента: ");

        if (index1 >= 0 && index1 < entityList.size() && index2 >= 0 && index2 < entityList.size()) {
            TestBase entity1 = entityList.get(index1);
            TestBase entity2 = entityList.get(index2);
            if (entity1.equals(entity2)) {
                System.out.println("Элементы равны.");
            } else {
                System.out.println("Элементы не равны.");
            }
        } else {
            System.out.println("Один или оба индекса неверны.");
        }
    }

    /**
     * Метод для безопасного получения целочисленного ввода от пользователя. Если
     * пользователь вводит некорректное значение, программа повторяет запрос ввода.
     *
     * @param prompt строка с приглашением для ввода.
     * @return введённое целое число.
     */
    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
            }
        }
    }

    /**
     * Метод для безопасного получения строкового ввода от пользователя. Если
     * пользователь вводит пустую строку, программа повторяет запрос ввода.
     *
     * @param prompt строка с приглашением для ввода.
     * @return введённая непустая строка.
     */
    private static String getStringInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Неверный ввод. Пожалуйста, введите непустое значение.");
            }
        }
    }
}
