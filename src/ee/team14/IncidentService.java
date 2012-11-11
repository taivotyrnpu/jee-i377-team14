package ee.team14;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: taivo
 * Date: 11/11/12
 * Time: 12:10 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IncidentService {
    List<Incident> getUnresolvedIncidents();
}
