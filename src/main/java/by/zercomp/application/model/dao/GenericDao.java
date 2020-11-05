package by.zercomp.application.model.dao;

import by.zercomp.application.model.entity.Identifiable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GenericDao<T extends Identifiable> {
    private static final Logger log = LogManager.getLogger(GenericDao.class);
}
