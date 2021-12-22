package persistence;

import domain.Bestellung;
import domain.KundeAccount;
import domain.WarenkorbArtikel;

import java.sql.SQLException;
import java.util.List;
import java.util.SortedSet;

public interface BestellungRepository {

    Bestellung buy(KundeAccount kunde) throws SQLException;



    SortedSet<Bestellung> show_deliveries_for_buyer(Bestellung bestellung) throws SQLException;

}
