package utility;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class ContextForConnectionPool {
    private static ConnectionPool connectionPool;

    @Bean
    public static ConnectionPool get() throws SQLException, ClassNotFoundException {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
            connectionPool.init();
        }
        return connectionPool;
    }
}
