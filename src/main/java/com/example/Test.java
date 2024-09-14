/**
 * Класс Test представляет сущность теста, которая наследуется от класса TestBase.
 * Помимо полей базового класса (числовое и текстовое поле), содержит поле "тип теста".
 */
public class Test extends TestBase {
    private String testType;

    /**
     * Пустой конструктор по умолчанию.
     * Создает объект Test без начальных значений.
     */
    public Test() {}

    /**
     * Конструктор, который инициализирует объект Test с переданными значениями для числового поля,
     * текстового поля и типа теста.
     *
     * @param numberField числовое поле.
     * @param textField текстовое поле.
     * @param testType строка, представляющая тип теста.
     */
    public Test(int numberField, String textField, String testType) {
        super(numberField, textField);
        this.testType = testType;
    }

    /**
     * Возвращает тип теста.
     *
     * @return строка, представляющая тип теста.
     */
    public String getTestType() {
        return testType;
    }

    /**
     * Устанавливает тип теста.
     *
     * @param testType строка, представляющая тип теста.
     */
    public void setTestType(String testType) {
        this.testType = testType;
    }

    /**
     * Переопределяет метод equals() для сравнения объектов Test.
     * Сравнение происходит на основе полей базового класса и типа теста.
     *
     * @param o объект для сравнения.
     * @return true, если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Test test = (Test) o;
        return Objects.equals(testType, test.testType);
    }

    /**
     * Переопределяет метод hashCode() для генерации уникального хэш-кода объекта.
     * Учитывает поля базового класса и тип теста.
     *
     * @return хэш-код объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), testType);
    }

    /**
     * Переопределяет метод toString() для представления объекта Test в виде строки.
     * В строковом представлении включены числовое и текстовое поля из базового класса,
     * а также тип теста.
     *
     * @return строковое представление объекта Test.
     */
    @Override
    public String toString() {
        return "Test{" +
                "numberField=" + getNumberField() +
                ", textField='" + getTextField() + '\'' +
                ", testType='" + testType + '\'' +
                '}';
    }
}
