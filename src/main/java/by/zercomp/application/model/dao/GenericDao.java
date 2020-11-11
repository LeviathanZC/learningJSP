package by.zercomp.application.model.dao;

import by.zercomp.application.model.entity.Identifiable;
import by.zercomp.application.model.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class GenericDao<T extends Identifiable> {
    private static final Logger log = LogManager.getLogger(GenericDao.class);
    protected static final ConnectionPool pool = ConnectionPool.getInstance();

    protected GenericDao() {
    }

    protected void startTransaction(Connection connection) throws SQLException {
        connection.setAutoCommit(false);
        connection.setTransactionIsolation(connection.TRANSACTION_SERIALIZABLE);
    }



}
