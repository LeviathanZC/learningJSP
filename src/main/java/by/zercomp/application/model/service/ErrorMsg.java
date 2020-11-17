package by.zercomp.application.model.service;

public enum  ErrorMsg {
    EMAIL,
    LOGIN,
    NAME;


    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
