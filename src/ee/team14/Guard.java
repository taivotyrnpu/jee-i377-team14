package ee.team14;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Guard {

    @NotNull
    @Size(min = 1, max = 3000)
    String nimi;
	int vanus;
	
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
}