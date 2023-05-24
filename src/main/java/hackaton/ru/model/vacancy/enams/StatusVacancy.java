package hackaton.ru.model.vacancy.enams;

public enum StatusVacancy {
    OPEN ("Открыта"),
    SUSPENDED ("Приостановлена"),
    CANCELLED ("Отменена"),
    CLOSED ("Закрыта");

    private final String value;

    StatusVacancy(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
