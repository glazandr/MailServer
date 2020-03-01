public class Salary extends MailMessage {  // Параметры класса Salary унаследуем от супер-класса MailMessage

    private Integer Salary; // введём переменную Salary (зарплата)

    // конструктор сообщения о зарплате на основе класса MailMessage
    public Salary(String From, String To, Integer Salary) {
        super(From, To, null);
        this.Salary = Salary;
    }

    // добавим геттер и сеттер для Salary для возможности устанавливать зарплату из класса Main
    public Integer getSalary() {
        return Salary;
    }

    public void setSalary(Integer salary) {
        Salary = salary;
    }

    // Переназначим метод из MalMessage для возможности использования значений
// параметра Salary в дженерике вместо Content
    @Override
    public <T> T getValue() {
        return (T) this.getSalary();
    }

}
