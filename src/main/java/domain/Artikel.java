package domain;

import java.util.Comparator;
import java.util.Objects;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class Artikel implements Comparable {

    @Getter
    @Setter
    private final Integer artikel_id;
    @Getter
    @Setter
    private String artikel_name;
    @Getter
    @Setter
    private int kategorie_id;
    @Getter
    @Setter
    private int verkäufer_id;
    @Getter
    @Setter
    private double artikel_price;
    @Getter
    @Setter
    private String artikel_description;


    public Artikel(Integer artikel_id, String artikel_name, double artikel_price, String artikel_description, int kategorie_id, int verkäufer_id) {
        this.artikel_id = artikel_id;
        this.artikel_name = artikel_name;
        this.kategorie_id = kategorie_id;
        this.verkäufer_id = verkäufer_id;
        this.artikel_price = artikel_price;
        this.artikel_description = artikel_description;
    }

    public Artikel(String artikel_name, double artikel_price, String artikel_description, int kategorie_id, int verkäufer_id) {
      this(null,artikel_name, artikel_price,  artikel_description,  kategorie_id,  verkäufer_id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artikel artikel = (Artikel) o;
        return artikel_id == artikel.artikel_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(artikel_id);
    }


    @Override
    public int compareTo(Object o) {
        return Comparator.comparing(Artikel::getArtikel_name).
                thenComparing(Artikel::getArtikel_price).
                thenComparing(Artikel::getKategorie_id).
                compare(this, (Artikel) o);
    }
}
