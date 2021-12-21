package persistence;

import domain.Artikel;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.SortedSet;

public interface ArtikelRepository {

    Artikel insert_into_store(Artikel artikel) throws SQLException;

    void delete_from_store(Artikel artikel) throws SQLException;

    void update(Artikel artikel) throws SQLException;

    SortedSet<Artikel> find_by_name(String name) throws SQLException;

    List<Artikel> return_articles_by_category(String kategorie_name) throws SQLException;
}
