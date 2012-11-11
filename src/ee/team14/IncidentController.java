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

        return null;
    }
    @RequestMapping(value = "/incident/reportIncident", method = RequestMethod.GET)
    public String reportIncident(HttpServletRequest request, Model model) {

        return null;
    }

}
