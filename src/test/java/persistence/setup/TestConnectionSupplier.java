package persistence.setup;

import java.sql.*;
import java.util.Properties;

public class TestConnectionSupplier {

    public Connection getConnection() throws SQLException {
        var properties = new Properties();
        properties.put("user", "sa");
        properties.put("password","");
        return DriverManager.getConnection("""
                jdbc:sqlserver://IFSQL-03.htl-stp.if
                """,properties);
    }

}
