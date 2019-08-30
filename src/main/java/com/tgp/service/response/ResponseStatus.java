package com.tgp.service.response;

public enum ResponseStatus {
    ACCOUNT_CREATED(false, "Аккаунт успешно создан"),
    EMAIL_NOT_VACANT(true, "Такая почта уже занята"),
    LOGIN_NOT_VACANT(true, "Такой логин уже занят"),
    ACCOUNT_NOT_FOUND(true, "Аккаунт с такими данными не найден"),
    INVALID_PASSWORD(true, "Неверный пароль"),
    AUTHENTICATED_SUCCESSFULLY(false, "Пользователь авторизован успешно"),
    INTERNAL_ERROR(true, "Внутренняя ошибка сервера"),
    PASSWORD_MISS_MATCH(true, "Пароли не совпадают"),
    DATA_SUCCESSFULLY_CHANGED(false, "Данные успешно изменены");

    private boolean error;
    private String message;

    ResponseStatus(boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
