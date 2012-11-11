package ee.team14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author Taivo Türnpu
 * @author Jarko Kaskmaa
 */

@Controller
public class IncidentController {

    @Autowired
    private IncidentService incidentService = null;

    @RequestMapping(value = "/incident/listAll", method = RequestMethod.GET)
    public String listAllIncidents(HttpServletRequest request, Model model) {
    	List<Incident> incidents = incidentService.getUnresolvedIncidents();
    	model.addAttribute("incidents", incidents);
    	
        return "listAll";
    }

    @RequestMapping(value = "/incident/reportIncident", method = RequestMethod.POST)
    public String listAllIncidentsPost(HttpServletRequest request, Model model) {
    	List<Incident> incidents = new ArrayList<Incident>();
        Incident incident = incidentService.getUnresolvedIncident(request.getParameter("end"), request.getParameter("location"),
                request.getParameter("description"), request.getParameter("status"), request.getParameter("start"));
        incidents.add(incident);
		model.addAttribute("incidents", incidents);
		
    	return "listAll";
    }
    
    @RequestMapping(value = "/incident/reportIncident", method = RequestMethod.GET)
    public String reportIncident(HttpServletRequest request, Model model) {

        return "reportIncident";
    }

    public IncidentService getIncidentService() {
        return incidentService;
    }

    public void setIncidentService(IncidentService incidentService) {
        this.incidentService = incidentService;
    }
}
