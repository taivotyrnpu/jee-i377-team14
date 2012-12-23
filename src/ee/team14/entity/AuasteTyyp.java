package ee.team14.entity;

import javax.persistence.*;

@Entity
@Table(name = "AUASTE_TYYP")
public class AuasteTyyp extends VersionableEntity{

    private long id;

    private String kood;

    private String nimetus;

    private String kommentaar;

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

    @Column(name = "KOMMENTAAR")
    public String getKommentaar() {
        return kommentaar;
    }

    public void setKommentaar(String kommentaar) {
        this.kommentaar = kommentaar;
    }
}
