/**
 * Класс GraduationExam представляет собой сущность выпускного экзамена, наследуется от класса TestBase.
 * Помимо полей базового класса (числовое и текстовое поля), содержит поле "год выпуска".
 */
public class GraduationExam extends TestBase {
    private String graduationYear;

    /**
     * Пустой конструктор по умолчанию.
     * Создает объект GraduationExam без начальных значений.
     */
    public GraduationExam() {}

    /**
     * Конструктор, который инициализирует объект GraduationExam с переданными значениями для числового поля,
     * текстового поля и года выпуска.
     *
     * @param numberField числовое поле.
     * @param textField текстовое поле.
     * @param graduationYear год выпуска.
     */
    public GraduationExam(int numberField, String textField, String graduationYear) {
        super(numberField, textField);
        this.graduationYear = graduationYear;
    }

    /**
     * Возвращает год выпуска.
     *
     * @return строка, представляющая год выпуска.
     */
    public String getGraduationYear() {
        return graduationYear;
    }

    /**
     * Устанавливает год выпуска.
     *
     * @param graduationYear строка, представляющая год выпуска.
     */
    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    /**
     * Переопределяет метод equals() для сравнения объектов GraduationExam.
     * Сравнение происходит на основе полей базового класса (числовое и текстовое поля) и года выпуска.
     *
     * @param o объект для сравнения.
     * @return true, если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GraduationExam that = (GraduationExam) o;
        return Objects.equals(graduationYear, that.graduationYear);
    }

    /**
     * Переопределяет метод hashCode() для генерации уникального хэш-кода объекта.
     * Учитывает поля базового класса и год выпуска.
     *
     * @return хэш-код объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), graduationYear);
    }

    /**
     * Переопределяет метод toString() для представления объекта GraduationExam в виде строки.
     * В строковом представлении включены числовое и текстовое поля из базового класса,
     * а также год выпуска.
     *
     * @return строковое представление объекта GraduationExam.
     */
    @Override
    public String toString() {
        return "GraduationExam{" +
                "numberField=" + getNumberField() +
                ", textField='" + getTextField() + '\'' +
                ", graduationYear='" + graduationYear + '\'' +
                '}';
    }
}
