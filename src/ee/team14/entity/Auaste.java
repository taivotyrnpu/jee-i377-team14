package ee.team14.entity;

import javax.persistence.*;

@Entity
@Table(name = "AUASTE")
public class Auaste extends VersionableEntity{

    private long id;

    private String kood;

    private String nimetus;

    private int tyyp;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "KOOD")
    public String getKood() {
        return kood;
    }

    public void setKood(String kood) {
        this.kood = kood;
    }

    @Column(name = "NIMETUS")
    public String getNimetus() {
        return nimetus;
    }

    public void setNimetus(String nimetus) {
        this.nimetus = nimetus;
    }

    @Column(name = "TYYP")
    public int getTyyp() {
        return tyyp;
    }

    public void setTyyp(int tyyp) {
        this.tyyp = tyyp;
    }
}
