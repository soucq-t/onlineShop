package domain;


import lombok.Getter;
import lombok.Setter;

public class KundeAccount {

    @Getter
    @Setter
    private final Integer kunde_id;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String kennwort;
    @Getter
    @Setter
    private String lieferadresse;

    public KundeAccount(Integer kunde_id, String username, String kennwort, String lieferadresse) {
        this.kunde_id = kunde_id;
        this.username = username;
        this.kennwort = kennwort;
        this.lieferadresse = lieferadresse;

    }

    public KundeAccount(String username, String kennwort, String lieferadresse) {
      this(null,username,kennwort,lieferadresse);
    }
}
