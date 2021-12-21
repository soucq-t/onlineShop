package persistence;

import domain.Artikel;
import domain.KundeAccount;
import domain.WarenkorbArtikel;

import java.sql.SQLException;
import java.util.List;
import java.util.SortedSet;

public interface WarenkorbArtikelRepository  {

    WarenkorbArtikel add_to_basket(Artikel artikel, KundeAccount kundeAccount) throws  SQLException;

    void delete_from_basket(Artikel artikel, KundeAccount kundeAccount) throws SQLException;

    SortedSet<WarenkorbArtikel> show_basket(Artikel artikel,KundeAccount kunde) throws SQLException;
}
