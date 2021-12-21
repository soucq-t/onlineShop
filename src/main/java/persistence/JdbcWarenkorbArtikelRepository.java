package persistence;

import domain.Artikel;
import domain.KundeAccount;
import domain.WarenkorbArtikel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public record JdbcWarenkorbArtikelRepository(Connection connection) implements WarenkorbArtikelRepository {
    @Override
    public WarenkorbArtikel add_to_basket(Artikel artikel, KundeAccount kunde) throws SQLException {
        var sql = "Insert into warenKorbArtikel values (?,?,?)";

        try (var statement = connection.prepareStatement(sql)) {
            statement.setInt(1, kunde.getOrder_count());
            statement.setInt(2, artikel.getArtikel_id());
            statement.setInt(3, kunde.getKunde_id());
            statement.executeUpdate();
        }
        return new WarenkorbArtikel(kunde.getOrder_count(), artikel.getArtikel_id(), kunde.getKunde_id());
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
                warenkorbArtikelSortedSet.add(new WarenkorbArtikel(kunde.getOrder_count(), artikel.getArtikel_id(), kunde.getKunde_id()));
            }
        }
        return warenkorbArtikelSortedSet;
    }
}
