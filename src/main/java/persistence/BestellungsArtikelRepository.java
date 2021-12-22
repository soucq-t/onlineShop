package persistence;

import domain.Bestellung;
import domain.BestellungsArtikel;
import domain.VerkaeuferAccount;
import domain.WarenkorbArtikel;

import java.sql.SQLException;
import java.util.SortedSet;

public interface BestellungsArtikelRepository {

    BestellungsArtikel add(BestellungsArtikel bestellungsArtikel) throws SQLException;

    SortedSet<BestellungsArtikel> show_deliveries_for_seller(VerkaeuferAccount verkaeuferAccount) throws SQLException;
}
