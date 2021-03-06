package by.zercomp.application.model.pool;

import by.zercomp.application.model.exception.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayDeque;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ConnectionPool {
    private static final String CONNECTION_PROPERTIES_FILE = "mysqlConnection.properties";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/online_store";
    private static final int DEFAULT_POOL_SIZE = 32;
    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final BlockingQueue<ProxyConnection> freeConnection;
    private final Queue<ProxyConnection> givenAwayConnections;

    private final Logger log = LogManager.getLogger(ConnectionPool.class);

    private static class PoolHolder {
        private static final ConnectionPool POOL = new ConnectionPool();
    }

    public static ConnectionPool getInstance() {
        return PoolHolder.POOL;
    }

    private ConnectionPool() {
        freeConnection = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
        givenAwayConnections = new ArrayDeque<>();
        Properties prop = new Properties();
        InputStream stream = getClass().getClassLoader().getResourceAsStream(CONNECTION_PROPERTIES_FILE);
        try {
            prop.load(stream);
            Class.forName(MYSQL_DRIVER);
            for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
                freeConnection.add(new ProxyConnection(DriverManager.getConnection(URL, prop)));
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            log.fatal("cannot initialize ConnectionPool : ", e);
            throw new ConnectionPoolException("cannot initialize ConnectionPool : ", e);
        }
    }

    public Connection getConnection() {
        ProxyConnection connection = null;
        try {
            connection = freeConnection.take();
            givenAwayConnections.offer(connection);
        } catch (InterruptedException e) {
            log.error("can't get connection : ", e);
            Thread.currentThread().interrupt();
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (connection.getClass() == ProxyConnection.class) {
            givenAwayConnections.remove(connection);
            freeConnection.add((ProxyConnection) connection);
        }
    }

    public void destroyPool() {
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                freeConnection.take().  close();
            } catch (InterruptedException | SQLException e) {
                log.error("cannot destroy ConnectionPool : ", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}
