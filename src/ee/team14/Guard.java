package ee.team14;

public class Guard {
	String nimi;
	int vanus;
	String aadress;
	int hulk;
	
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }
    
    public void setVanus(int vanus) {
        this.vanus = vanus;
    }

    public int getVanus() {
        return vanus;
    }
    
    public void setAadress(String aadress) {
        this.aadress = aadress;
    }

    public String getAadress() {
        return aadress;
    }
    
    public void setHulk(int hulk) {
        this.hulk = hulk;
    }

    public int getHulk() {
        return hulk;
    }
}