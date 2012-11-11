package ee.team14;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: taivo
 * Date: 11/11/12
 * Time: 12:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Incident {
    private Date start;
    private Date end;
    private String location;
    private String description;
    private Integer involvedGuardCount;
    private String status;

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getInvolvedGuardCount() {
        return involvedGuardCount;
    }

    public void setInvolvedGuardCount(Integer involvedGuardCount) {
        this.involvedGuardCount = involvedGuardCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }
}
