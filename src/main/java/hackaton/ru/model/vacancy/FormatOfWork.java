package hackaton.ru.model.vacancy;

public enum FormatOfWork {
    FULL_TIME("Полная занятость"),
    PART_TIME("Частичная занятость"),
    PROJECT("Проектная работа"),
    OFFICE("В офисе"),
    REMOTE("Удаленная работа"),
    HYBRID("Гибрид"),
    FLEXIBLE("Гибкий график");


    private final String value;

    FormatOfWork(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
