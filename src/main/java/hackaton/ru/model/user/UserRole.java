package hackaton.ru.model.user;

public enum UserRole {
    RECRUITER("Рекрутер"),
    OWNER("Заказчик");

    private final String value;

    UserRole(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
