package by.zercomp.application.model.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private static final String CONNECTION_PROPERTIES_FILE = "mysqlConnection.properties";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/online_store";
    private static final int DEFAULT_POOL_SIZE = 32;
    private final BlockingQueue<Connection> freeConnection;
    private final Queue<Connection> givenAwayConnections;

    private final Logger log = LogManager.getLogger(ConnectionPool.class);

    private static class PoolHolder {
        private static final ConnectionPool POOL = new ConnectionPool();
    }

    public static ConnectionPool getInstance() {
        return PoolHolder.POOL;
    }

    /*public static void main(String[] args) {
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "pass");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");

        Connection cn = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            cn = DriverManager.getConnection(URL, "leviathan", "1591310486+");
            try (Statement st = cn.createStatement()) {
                ResultSet rs = st.executeQuery("SELECT email, pw_hash FROM users;");
                System.out.println(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }*/
}
