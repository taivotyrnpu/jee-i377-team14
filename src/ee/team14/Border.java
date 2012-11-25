package ee.team14;

import org.hibernate.validator.constraints.NotBlank;

public class Border {

    @NotBlank
    String aadress;
	int hulk;
    
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