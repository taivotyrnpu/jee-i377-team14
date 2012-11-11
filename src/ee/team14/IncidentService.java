package ee.team14;

import java.util.List;

/**
 * Date: 11/11/12
 * Time: 12:10 PM
 *
 * @author Taivo Türnpu
 * @author Jarko Kaskmaa
 */
public interface IncidentService {

    List<Incident> getUnresolvedIncidents();

    Incident getUnresolvedIncident(String end, String location, String description, String status, String start);

}
