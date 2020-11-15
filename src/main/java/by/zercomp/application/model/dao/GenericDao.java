package by.zercomp.application.model.dao;

import by.zercomp.application.model.dao.builder.CommonBuilder;
import by.zercomp.application.model.entity.Identifiable;
import by.zercomp.application.model.exception.DaoException;
import by.zercomp.application.model.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericDao<T extends Identifiable> {
    private static final Logger log = LogManager.getLogger(GenericDao.class);
    protected static final ConnectionPool pool = ConnectionPool.getInstance();
    private final CommonBuilder<T> builder;

    protected GenericDao(CommonBuilder<T> builder) {
        this.builder = builder;
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

    protected void executeUpdate(String query, Connection connection, Object... params) throws DaoException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
            setParameters(ps, params);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("cannot execute update or get access to database : ", e);
        } finally {
            closeResource(ps);
        }
    }

    protected void executeUpdate(String query, Object... params) throws DaoException {
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

    protected List<T> executeQuery(String query, Connection connection, Object... params) throws DaoException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> entites = new ArrayList<>();
        try {
            ps = connection.prepareStatement(query);
            setParameters(ps, params);
            rs = ps.executeQuery();
            while (rs.next()) {
                T entity = builder.build(rs);
                entites.add(entity);
            }
        } catch (SQLException throwables) {
            throw new DaoException("cannot get access to db : ", throwables);
        } finally {
            try {
                closeResource(rs);
            } finally {
                closeResource(ps);
            }
        }
        return entites;
    }

    protected List<T> executeQuery(String query, Object... params) throws DaoException {
        Connection connection = pool.getConnection();
        try {
            return executeQuery(query, connection, params);
        } finally {
            pool.releaseConnection(connection);
        }
    }

    private Optional<Object> findObject(String query, Connection connection, String columnName, Object... params)
            throws DaoException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Optional<Object> object = Optional.empty();
        try {
            ps = connection.prepareStatement(query);
            setParameters(ps, params);
            rs = ps.executeQuery();
            if (rs.next()) {
                object = Optional.of(rs.getObject(columnName));
            }
        } catch (SQLException throwables) {
            throw new DaoException("cannot get access to db : ", throwables);
        } finally {
            try {
                closeResource(rs);
            } finally {
                closeResource(ps);
            }
        }
        return object;
    }

    protected Optional<String> findString(String query, Connection connection, String columnName, Object... params)
            throws DaoException {
        Optional<Object> foundString = findObject(query, connection, columnName, params);
        return foundString.map(String::valueOf);
    }

    protected Optional<String> findString(String query, String columnName, Object... params) throws DaoException {
        Connection connection = pool.getConnection();
        try {
            return findString(query, connection, columnName, params);
        } finally {
            pool.releaseConnection(connection);
        }
    }

    protected boolean findBoolean(String query, String columnName, Object... params)
            throws DaoException {
        Connection connection = pool.getConnection();
        try {
            return (boolean)findObject(query, connection, columnName, params).orElseThrow(DaoException::new);
        } finally {
            pool.releaseConnection(connection);
        }
    }

    protected Optional<Long> findLong(String query, Connection connection, String columnName, Object... params)
            throws DaoException {
        Optional<Object> foundLong = findObject(query, connection, columnName, params);
        return foundLong.map(o -> Long.parseLong(String.valueOf(o)));
    }

    protected Optional<Long> findLong(String query, String columnName, Object... params) throws DaoException {
        Connection connection = pool.getConnection();
        try {
            return findLong(query, connection, columnName, params);
        } finally {
            pool.releaseConnection(connection);
        }
    }

    protected Optional<T> executeForSingle(String query, Connection connection, Object... params) throws DaoException {
        List<T> entities = executeQuery(query, connection, params);
        if (entities.size() == 1) {
            return Optional.of(entities.get(0));
        } else {
            return Optional.empty();
        }
    }

    protected Optional<T> executeForSingle(String query, Object... params) throws DaoException {
        Connection connection = pool.getConnection();
        try {
            return executeForSingle(query, connection, params);
        } finally {
            pool.releaseConnection(connection);
        }
    }

}
