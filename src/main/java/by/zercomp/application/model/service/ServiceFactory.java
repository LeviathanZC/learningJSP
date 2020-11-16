package by.zercomp.application.model.service;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }
}
