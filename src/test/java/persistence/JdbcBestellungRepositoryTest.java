package persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import persistence.setup.TestConnectionSupplier;

import java.sql.*;

public class JdbcBestellungRepositoryTest {

    private final TestConnectionSupplier connectionSupplier = new TestConnectionSupplier();
    private BestellungRepository bestellungRepository;
    private Connection connection;

    @BeforeEach
    void createRepository() throws SQLException {
        connection = connectionSupplier.getConnection();
        bestellungRepository = new JdbcBestellungRepository(connection);

    }

    @AfterEach
    void closeConnection() throws SQLException {
        connection.close();
    }

}
