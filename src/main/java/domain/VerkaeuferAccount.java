package domain;

public class VerkaeuferAccount {
    private int kunde_id;
    private String username;
    private String kennwort;
    private String sitz;

    public VerkaeuferAccount(int kunde_id, String username, String kennwort, String sitz) {
        this.kunde_id = kunde_id;
        this.username = username;
        this.kennwort = kennwort;
        this.sitz = sitz;
    }


}
