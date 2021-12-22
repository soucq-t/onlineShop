package persistence;

import domain.Artikel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public record JdbcArtikelRepository(Connection connection) implements ArtikelRepository {
    @Override
    public Artikel insert_into_store(Artikel artikel) throws SQLException {
        var sql = "insert into artikel(art_name,art_price,art_Description,art_kat_id,art_vA_id) values (?,?,?,?,?)";

        try (var statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, artikel.getArtikel_name());
            statement.setDouble(2, artikel.getArtikel_price());
            statement.setString(3, artikel.getArtikel_description());
            statement.setInt(4, artikel.getKategorie_id());
            statement.setInt(5, artikel.getVerkäufer_id());
            statement.executeUpdate();

            var resultSet = statement.getGeneratedKeys();
            while (resultSet.next()) {
                artikel = new Artikel(resultSet.getInt(1), artikel.getArtikel_name(), artikel.getArtikel_price(),
                        artikel.getArtikel_description(), artikel.getKategorie_id(), artikel.getVerkäufer_id());
            }
        }

        return artikel;

    }

    @Override
    public void delete_from_store(Artikel artikel) throws SQLException {

        var sql = "delete from artikel " +
                " where art_id = ?";

        try (var statement = connection.prepareStatement(sql)) {
            statement.setInt(1, artikel.getArtikel_id());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Artikel artikel) throws SQLException {

        var sql_update = "update artikel " +
                " set art_name = ?, art_price = ?, art_Description, art_kat_id = ?, art_vA_id = ? " +
                " where art_id = ?";
        try (var statement = connection.prepareStatement(sql_update)) {
            statement.setString(1, artikel.getArtikel_name());
            statement.setDouble(2, artikel.getArtikel_price());
            statement.setString(3, artikel.getArtikel_description());
            statement.setInt(4, artikel.getKategorie_id());
            statement.setInt(5, artikel.getVerkäufer_id());
            statement.executeUpdate();
        }
    }

    @Override
    public SortedSet<Artikel> find_by_name(String name) throws SQLException {
        SortedSet<Artikel> artikel_set = new TreeSet();
        var sql = "select * from artikel where art_name like *?*";

        try (var statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                artikel_set.add(new Artikel(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getDouble(3), resultSet.getString(4)
                        , resultSet.getInt(5), resultSet.getInt(6)));
            }
        }

        return artikel_set;
    }

    @Override
    public List<Artikel> return_articles_by_category(String kategorie_name) throws SQLException {
        List<Artikel> artikelList = new LinkedList<>();
        var sql = "select art_id,art_name,art_price,art_Description, art_kat_id, art_vA_id" +
                " from artikel" +
                " inner join kategorie" +
                " on artikel.art_kat_id = kategorie.kat_id" +
                " where art_kat_id = ?";

        try (var statement = connection.prepareStatement(sql)) {

            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                artikelList.add(new Artikel(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getDouble(3), resultSet.getString(4)
                        , resultSet.getInt(5), resultSet.getInt(6)));
            }
        }
        return artikelList;
    }
}
