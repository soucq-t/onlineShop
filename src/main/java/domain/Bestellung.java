package domain;

import java.util.Comparator;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

public class Bestellung implements Comparable {
    @Setter
    @Getter
    private int bestellung_id;
    @Setter
    @Getter
    private int kunde_id;


    public Bestellung(Integer bestellung_id, int kunde_id) {
        this.bestellung_id = bestellung_id;
        this.kunde_id = kunde_id;

    }

    public Bestellung(int kunde_id) {
        this(null,kunde_id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bestellung that = (Bestellung) o;
        return bestellung_id == that.bestellung_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bestellung_id);
    }

    @Override
    public int compareTo(Object o) {
        return Comparator.comparing(Bestellung::getBestellung_id).thenComparing(Bestellung::getKunde_id).compare(this, (Bestellung) o);
    }
}
