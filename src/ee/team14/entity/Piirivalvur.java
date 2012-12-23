package ee.team14.entity;

import javax.persistence.*;

@Entity
@Table(name = "PIIRIVALVUR")
public class Piirivalvur extends VersionableEntity{

    private long id;

    private String aadress;
    private String eesnimi;
    private String email;
    private String isikukood;
    private String kommentaar;
    private String perekonnanimi;
    private String sodurikood;
    private String sugu;
    private String telefon;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAadress() {
        return aadress;
    }

    public void setAadress(String aadress) {
        this.aadress = aadress;
    }

    @Column(name = "EESNIMI")
    public String getEesnimi() {
        return eesnimi;
    }

    public void setEesnimi(String eesnimi) {
        this.eesnimi = eesnimi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIsikukood() {
        return isikukood;
    }

    public void setIsikukood(String isikukood) {
        this.isikukood = isikukood;
    }

    public String getKommentaar() {
        return kommentaar;
    }

    public void setKommentaar(String kommentaar) {
        this.kommentaar = kommentaar;
    }

    public String getPerekonnanimi() {
        return perekonnanimi;
    }

    public void setPerekonnanimi(String perekonnanimi) {
        this.perekonnanimi = perekonnanimi;
    }

    public String getSodurikood() {
        return sodurikood;
    }

    public void setSodurikood(String sodurikood) {
        this.sodurikood = sodurikood;
    }

    public String getSugu() {
        return sugu;
    }

    public void setSugu(String sugu) {
        this.sugu = sugu;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
