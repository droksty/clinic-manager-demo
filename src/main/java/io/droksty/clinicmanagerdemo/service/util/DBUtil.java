package io.droksty.clinicmanagerdemo.service.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    private static final BasicDataSource dataSource = new BasicDataSource();
    private static Connection connection;

    private DBUtil() {}

    static {
        dataSource.setUrl("jdbc:mysql://localhost:3306/patientsdb-demo");
        dataSource.setUsername("stelios");
        dataSource.setPassword(System.getenv("PATIENTSDB_DEMO_PASSWORD"));
        dataSource.setInitialSize(2);
        dataSource.setMaxTotal(2);
    }

    public static Connection getConnection() throws SQLException {
        connection = dataSource.getConnection();
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
