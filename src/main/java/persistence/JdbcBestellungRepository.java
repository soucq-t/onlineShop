package persistence;

import domain.Bestellung;
import domain.BestellungsArtikel;
import domain.KundeAccount;
import domain.WarenkorbArtikel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public record JdbcBestellungRepository(Connection connection) implements BestellungRepository {


    @Override
    public Bestellung buy(KundeAccount kunde) throws SQLException {
        var sql_show_basket = "select * from warenKorbArtikel where war_kA_id = ?";

        var sql_delete_basket = "delete from warenKorbArtikel where war_kA_id = ?";

        Bestellung bestellung = null;
        try (var statement = connection.prepareStatement(sql_show_basket)) {
            statement.setInt(1, kunde.getKunde_id());
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {

                bestellung = new Bestellung(  kunde.getKunde_id());

                //BestellungsArtikel Objekt wird erzeugt und dann in die zugehörige Tabelle eingetragen
                BestellungsArtikel bestellungsArtikel = new BestellungsArtikel(bestellung.getBestellung_id(),kunde.getKunde_id());
            }

        }


        try (var statement = connection.prepareStatement(sql_delete_basket)) {
            statement.setInt(1, kunde.getKunde_id());
            statement.executeUpdate();

        }

        return bestellung;
    }


    @Override
    public SortedSet<Bestellung> show_deliveries_for_buyer(Bestellung bestellung) throws SQLException {
        var sql = "select * from bestellung where bes_kA_id = ? ";
        SortedSet<Bestellung> bestellungSortedSet = new TreeSet<>();
        try (var statement = connection.prepareStatement(sql)) {
            statement.setInt(1, bestellung.getKunde_id());
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                bestellungSortedSet.add(new Bestellung(bestellung.getBestellung_id(), bestellung.getKunde_id()));
            }
        }
        return bestellungSortedSet;
    }
}
