package com.tgp.service.response;

public enum ResponseStatus {
    ACCOUNT_CREATED(false), EMAIL_NOT_VACANT(true), LOGIN_NOT_VACANT(true), ACCOUNT_NOT_FOUND(true),
    INVALID_PASSWORD(true), AUTHENTICATED_SUCCESSFULLY(false), INTERNAL_ERROR(true);

    private boolean error;

    ResponseStatus(boolean error) {
        this.error = error;
    }

    public boolean isError() {
        return error;
    }
}
