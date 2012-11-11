package ee.team14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: taivo
 * Date: 11/11/12
 * Time: 12:24 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class IncidentController {

    @Autowired
    private IncidentService incidentService = null;

    public IncidentService getIncidentService() {
        return incidentService;
    }

    public void setIncidentService(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @RequestMapping(value = "/incident/listAll", method = RequestMethod.GET)
    public String listAllIncidents(HttpServletRequest request, Model model) {
    	List<Incident> incidents = new List<Incident>(); // TODO: genereeri!
    	model.addAttribute("incidents", incidents);
    	
        return "listAll";
    }
    
    private Date stringToDate(String input){
    	String[] pieces = input.split(".");
    	int day = Integer.parseInt(pieces[0]);
    	int month = Integer.parseInt(pieces[1]);
    	int year = Integer.parseInt(pieces[2]);
    	
    	GregorianCalendar calendar = new GregorianCalendar(year, month, day);
		return calendar.getTime();
    }
    
    @RequestMapping(value = "/incident/listAll", method = RequestMethod.POST)
    public String listAllIncidents(HttpServletRequest request, Model model) {
    	List<Incident> incidents = new List<Incident>();
    	Incident incident = new Incident();
    	
		incident.setEnd(stringToDate(request.getParameter("end")));
		incident.setLocation(request.getParameter("location"));
		incident.setDescription(request.getParameter("description"));
		incident.setInvolvedGuardCount(guardsRandom);
		incident.setStatus(request.getParameter("status"));
		incident.setStart(stringToDate(request.getParameter("start")));
		
		incidents.add(incident);
		model.addAttribute("incidents", incidents);
		
    	return "listAll";
    }
    
    @RequestMapping(value = "/incident/reportIncident", method = RequestMethod.GET)
    public String reportIncident(HttpServletRequest request, Model model) {

        return "reportIncident";
    }

}
