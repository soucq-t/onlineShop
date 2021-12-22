package persistence;

import domain.Artikel;
import domain.KundeAccount;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import persistence.setup.TestConnectionSupplier;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

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
            var kunde = new KundeAccount("bob","passwort","Sesamstraﬂe 123, Niederlande");
            var b = new Artikel("Stift",3.2,"ff",1,3);
           artikelRepository.insert_into_store(b);

            assertSame(artikelRepository.find_by_name("Stift").first(),b);


        }
    }

}
