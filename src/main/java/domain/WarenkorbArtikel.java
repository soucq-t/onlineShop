package domain;

public class WarenkorbArtikel {
    private int warenkorb_id;
    private int warenkorb_artikel;
    private int warenkorb_kunde_id;

    public WarenkorbArtikel(int warenkorb_id, int warenkorb_artikel, int warenkorb_kunde_id) {
        this.warenkorb_id = warenkorb_id;
        this.warenkorb_artikel = warenkorb_artikel;
        this.warenkorb_kunde_id = warenkorb_kunde_id;
    }

}