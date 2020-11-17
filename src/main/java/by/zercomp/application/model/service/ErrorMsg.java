package by.zercomp.application.model.service;

public enum  ErrorMsg {
    EMAIL,
    LOGIN,
    NAME,
    HARD_PASSWORD,
    DIFFERENT_PASSWORDS;


    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
