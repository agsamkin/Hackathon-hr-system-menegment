package hackaton.ru.model.candidate;

public enum DegreeStatus {
    SECONDARY("Среднее образование"),
    SECONDARY_SPECIAL("Среднее специальное образование"),
    INCOMPLETE_HIGHER("Неоконченное высшее образование"),
    HIGHER("Высшее образование"),
    BACHELOR("Бакалавр"),
    MASTER("Магистр"),
    CANDIDATE("Кандидат наук"),
    PH("Доктор наук");


    private final String value;

    DegreeStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
