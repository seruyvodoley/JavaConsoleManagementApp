/**
 * Класс Exam представляет собой сущность экзамена, которая наследуется от класса TestBase.
 * Помимо полей базового класса (числовое и текстовое поля), содержит поле с датой экзамена.
 */
public class Exam extends TestBase {
    private String examDate;

    /**
     * Пустой конструктор по умолчанию.
     * Создает объект Exam без начальных значений.
     */
    public Exam() {}

    /**
     * Конструктор, который инициализирует объект Exam с переданными значениями для числового поля,
     * текстового поля и даты экзамена.
     *
     * @param numberField числовое поле.
     * @param textField текстовое поле.
     * @param examDate дата экзамена.
     */
    public Exam(int numberField, String textField, String examDate) {
        super(numberField, textField);
        this.examDate = examDate;
    }

    /**
     * Возвращает дату экзамена.
     *
     * @return строка, представляющая дату экзамена.
     */
    public String getExamDate() {
        return examDate;
    }

    /**
     * Устанавливает дату экзамена.
     *
     * @param examDate строка, представляющая дату экзамена.
     */
    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    /**
     * Переопределяет метод equals() для сравнения объектов Exam.
     * Сравнение происходит на основе полей базового класса (числовое и текстовое поля)
     * и поля даты экзамена.
     *
     * @param o объект для сравнения.
     * @return true, если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Exam exam = (Exam) o;
        return Objects.equals(examDate, exam.examDate);
    }

    /**
     * Переопределяет метод hashCode() для генерации уникального хэш-кода объекта.
     * Учитывает поля базового класса и поле даты экзамена.
     *
     * @return хэш-код объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), examDate);
    }

    /**
     * Переопределяет метод toString() для представления объекта Exam в виде строки.
     * В строковом представлении включены числовое и текстовое поля из базового класса,
     * а также дата экзамена.
     *
     * @return строковое представление объекта Exam.
     */
    @Override
    public String toString() {
        return "Exam{" +
                "numberField=" + getNumberField() +
                ", textField='" + getTextField() + '\'' +
                ", examDate='" + examDate + '\'' +
                '}';
    }
}
