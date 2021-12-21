package persistence;

import domain.Artikel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import persistence.setup.TestConnectionSupplier;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcArtikelRepositoryTest {

    private final TestConnectionSupplier connectionSupplier = new TestConnectionSupplier();
    private ArtikelRepository artikelRepository;
    private Connection connection;

    @BeforeEach
    void createRepository() throws SQLException {
        connection = connectionSupplier.getConnection();
        artikelRepository = new JdbcArtikelRepository(connection);

    }

    @AfterEach
    void closeConnection() throws SQLException {
        connection.close();
    }

    @Nested
    class Insert {
        @Test
        void inserts_article() throws SQLException
        {

        }
    }

}
