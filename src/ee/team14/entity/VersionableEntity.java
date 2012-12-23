package ee.team14.entity;

/**
 * Created with IntelliJ IDEA.
 * User: taivo
 * Date: 12/13/12
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class VersionableEntity extends BaseEntity{

    private int version;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
