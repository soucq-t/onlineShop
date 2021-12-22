package domain;
import lombok.Getter;
import lombok.Setter;
import persistence.BestellungsArtikelRepository;

import java.util.Comparator;

public class BestellungsArtikel implements Comparable {
    @Getter
    @Setter
    private int bestellungsartikel_id;
    @Getter
    @Setter
    private int bestellungsartikel_artikel_fk_id;
    @Getter
    @Setter
    private int bestellnummer;

    public BestellungsArtikel(Integer bestellungsartikel_id, int bestellungsartikel_artikel_fk_id, int bestellnummer) {
        this.bestellungsartikel_id = bestellungsartikel_id;
        this.bestellungsartikel_artikel_fk_id = bestellungsartikel_artikel_fk_id;
        this.bestellnummer = bestellnummer;
    }

    public BestellungsArtikel(int bestellungsartikel_artikel_fk_id, int bestellnummer) {
      this(null,bestellungsartikel_artikel_fk_id,bestellnummer);
    }

    @Override
    public int compareTo(Object o) {
       return Comparator.comparing(BestellungsArtikel::getBestellnummer).thenComparing(BestellungsArtikel::getBestellungsartikel_artikel_fk_id).compare(this, (BestellungsArtikel) o);
    }
}
