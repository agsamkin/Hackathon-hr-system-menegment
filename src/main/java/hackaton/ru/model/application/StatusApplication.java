package hackaton.ru.model.application;

public enum StatusApplication {
    NOT_VIEWED("Не просмотрено"),
    VIEWED("Просмотрено"),
    INVITATION("Приглашение на собеседование"),
    REJECTED("Отказ");

    private final String value;

    StatusApplication(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
