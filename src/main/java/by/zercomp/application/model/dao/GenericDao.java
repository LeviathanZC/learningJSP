package by.zercomp.application.model.dao;

import by.zercomp.application.model.entity.Identifiable;
import by.zercomp.application.model.exception.DaoException;
import by.zercomp.application.model.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class GenericDao<T extends Identifiable> {
    private static final Logger log = LogManager.getLogger(GenericDao.class);
    protected static final ConnectionPool pool = ConnectionPool.getInstance();

    protected GenericDao() {
    }

    protected void startTransaction(Connection connection) throws SQLException {
        connection.setAutoCommit(false);
        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
    }

    protected void endTransaction(Connection connection) throws SQLException {
        connection.commit();
        connection.setAutoCommit(true);
        connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
    }

    protected void cancelTransaction(Connection connection) {
        try {
            connection.rollback();
            connection.setAutoCommit(true);
        } catch (SQLException throwables) {
            log.error("cannot rollback", throwables);
        }
    }

    protected void executeUpdate(String query, Connection connection, Object... params) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
            setParameters(ps, params);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new DaoException("cannot execute update or get access to database : ", e);
        } finally {
            closeResource(ps);
        }
    }

    protected void executeUpdate(String query, Object... params) {
        Connection connection = pool.getConnection();
        try {
            executeUpdate(query, connection, params);
        } finally {
            pool.releaseConnection(connection);
        }
    }

    protected void setParameters(PreparedStatement preparedStatement, Object... params) throws SQLException {
        for (int i = 0, paramIndex = 1; i < params.length; i++, paramIndex++) {
            if (params[i] != null) {
                preparedStatement.setObject(paramIndex, params[i]);
            } else {
                preparedStatement.setNull(paramIndex, Types.NULL);
            }
        }
    }

    protected void closeResource(AutoCloseable resource) {
        try {
            resource.close();
        } catch (Exception e) {
            log.error("couldn't close resource : ", e);
        }
    }
}
