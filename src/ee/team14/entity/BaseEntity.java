package ee.team14.entity;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: taivo
 * Date: 12/13/12
 * Time: 11:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class BaseEntity {

    private String avaja;
    private String muutja;
    private String sulgeja;

    private Date avatud;
    private Date suletud;
    private Date muudetud;

    public String getAvaja() {
        return avaja;
    }

    public void setAvaja(String avaja) {
        this.avaja = avaja;
    }

    public String getMuutja() {
        return muutja;
    }

    public void setMuutja(String muutja) {
        this.muutja = muutja;
    }

    public String getSulgeja() {
        return sulgeja;
    }

    public void setSulgeja(String sulgeja) {
        this.sulgeja = sulgeja;
    }

    public Date getAvatud() {
        return avatud;
    }

    public void setAvatud(Date avatud) {
        this.avatud = avatud;
    }

    public Date getSuletud() {
        return suletud;
    }

    public void setSuletud(Date suletud) {
        this.suletud = suletud;
    }

    public Date getMuudetud() {
        return muudetud;
    }

    public void setMuudetud(Date muudetud) {
        this.muudetud = muudetud;
    }
}
