package by.zercomp.application.model.service;

public enum  ErrorMsg {
    EMAIL,
    LOGIN;


    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
