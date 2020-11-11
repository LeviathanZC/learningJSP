package by.zercomp.application.model.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;

public class ProxyConnection implements Connection {
    private final Connection connection;
    private final Logger log = LogManager.getLogger(ProxyConnection.class);

    ProxyConnection(Connection connection) {
        this.connection = connection;
    }


}
