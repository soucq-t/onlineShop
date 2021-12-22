package persistence;

import domain.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.SortedSet;
import java.util.TreeSet;

public record JdbcBestellungsArtikel(Connection connection) implements BestellungsArtikelRepository {

    @Override
    public BestellungsArtikel add(BestellungsArtikel bestellungsArtikel) throws SQLException {
        var sql = "insert into bestellungsArtikel(bA_art_id,bA_bes_id) values (?,?)";

        try (var statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            statement.setInt(1,bestellungsArtikel.getBestellungsartikel_artikel_fk_id());
            statement.setInt(2, bestellungsArtikel.getBestellnummer());
            statement.executeUpdate();

                bestellungsArtikel = new BestellungsArtikel(statement.getGeneratedKeys().getInt(1),
                        bestellungsArtikel.getBestellungsartikel_artikel_fk_id(),
                        bestellungsArtikel.getBestellnummer());

        }
        return bestellungsArtikel;
    }
    @Override
    public SortedSet<BestellungsArtikel> show_deliveries_for_seller(VerkaeuferAccount verkaeuferAccount) throws SQLException {
        var sql = "select bestellungsArtikel.bA_id, bestellungsArtikel.bA_art_id," +
                " bestellungsArtikel.bA_bes_id from bestellungsArtikel " +
                "inner join verkaeuferAccount " +
                "on bestelleungsArtikel.bA_art_id = verkaeuferAccount.vA_id " +
                "where verkaueferAccount.vA_id = ?";
        SortedSet<BestellungsArtikel> bestellungsArtikelSortedSet= new TreeSet<>();
        try (var statement = connection.prepareStatement(sql))
        {
            statement.setInt(1,verkaeuferAccount.getKunde_id());

            var resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                bestellungsArtikelSortedSet.add(new BestellungsArtikel(resultSet.getInt(1),
                        resultSet.getInt(2), resultSet.getInt(3)));
            }
        }

        return bestellungsArtikelSortedSet;
    }


}
