package persistence;

import domain.Artikel;
import domain.KundeAccount;
import domain.WarenkorbArtikel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public record JdbcWarenkorbArtikelRepository(Connection connection) implements WarenkorbArtikelRepository {
    @Override
    public WarenkorbArtikel add_to_basket(Artikel artikel, KundeAccount kunde) throws SQLException {
        var sql = "Insert into warenKorbArtikel(war_art_id,war_kA_id) values (?,?)";
        WarenkorbArtikel warenkorbArtikel = null;
        try (var statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, artikel.getArtikel_id());
            statement.setInt(2, kunde.getKunde_id());
            statement.executeUpdate();
             warenkorbArtikel = new WarenkorbArtikel(statement.getGeneratedKeys().getInt(1),
                    artikel.getArtikel_id(), kunde.getKunde_id());
        }
        return warenkorbArtikel;
    }

    @Override
    public void delete_from_basket(Artikel artikel, KundeAccount kunde) throws SQLException {
        var sql = "delete from where war_kA_id = ?";
        try (var statement = connection.prepareStatement(sql)) {
            statement.setInt(1, kunde.getKunde_id());
            statement.executeUpdate();
        }
    }

    @Override
    public SortedSet<WarenkorbArtikel> show_basket(Artikel artikel, KundeAccount kunde) throws SQLException {
        var sql = "select * from warenKorbArtikel where wKA_id = ?";
        SortedSet<WarenkorbArtikel> warenkorbArtikelSortedSet = new TreeSet<>();
        try (var statement = connection.prepareStatement(sql)) {
            statement.setInt(1, kunde.getKunde_id());
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                warenkorbArtikelSortedSet.add(new WarenkorbArtikel(resultSet.getInt(1),resultSet.getInt(2),
                        resultSet.getInt(3)));
            }
        }
        return warenkorbArtikelSortedSet;
    }
}
