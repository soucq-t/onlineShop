package domain;


import lombok.Getter;
import lombok.Setter;

public class KundeAccount {

    @Getter
    @Setter
    private final int kunde_id;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String kennwort;
    @Getter
    private int order_count=0;

    public KundeAccount(int kunde_id, String username, String kennwort) {
        this.kunde_id = kunde_id;
        this.username = username;
        this.kennwort = kennwort;

    }

    public int increment_order_count()
    {
        return order_count++;
    }

}
