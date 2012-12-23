package ee.team14.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "PIIRIVALVUR_AUASTE")
public class PiirivalvurAuaste extends VersionableEntity{


    private long id;
    private Timestamp alates;
    private Timestamp kuni;
    private String kommentaar;
    private Auaste auaste;
    private long piirivalvur_id;
   // private String piirivalvurNimi;
   // private String auasteNimi;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "ALATES")
    public Timestamp getAlates() {
        return alates;
    }

    public void setAlates(Timestamp alates) {
        this.alates = alates;
    }

    @Column(name = "KUNI")
    public Timestamp getKuni() {
        return kuni;
    }

    public void setKuni(Timestamp kuni) {
        this.kuni = kuni;
    }

    @Column(name = "KOMMENTAAR")
    public String getKommentaar() {
        return kommentaar;
    }

    public void setKommentaar(String kommentaar) {
        this.kommentaar = kommentaar;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auaste_id")
    public Auaste getAuaste() {
        return auaste;
    }

    public void setAuaste(Auaste auaste) {
        this.auaste = auaste;
    }

    @Column(name = "PIIRIVALVUR_ID")
    public long getPiirivalvur_id() {
        return piirivalvur_id;
    }

    public void setPiirivalvur_id(long piirivalvur_id) {
        this.piirivalvur_id = piirivalvur_id;
    }

    public void convertAndSetAlates(String alates){

    }

    public void convertAndSetKuni(String kuni){

    }

   /* public String getPiirivalvurNimi() {
        return piirivalvurNimi;
    }

    public void setPiirivalvurNimi(String piirivalvurNimi) {
        this.piirivalvurNimi = piirivalvurNimi;
    }

    public String getAuasteNimi() {
        return auasteNimi;
    }

    public void setAuasteNimi(String auasteNimi) {
        this.auasteNimi = auasteNimi;
    } */


}
