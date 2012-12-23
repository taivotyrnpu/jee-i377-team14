package ee.team14.controller;

import ee.team14.service.BorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

@Controller
public class BorderController {

    @Autowired
    private BorderService borderService;

    @RequestMapping(value = "/piirivalvur", method = RequestMethod.GET)
    public String showAllPiirivalvur(HttpServletRequest request, Model model) {
        model.addAttribute("piirivalvurid", borderService.getAllPiirivalvur());
        return "listAllPiirivalvur";
    }

    @RequestMapping(value = "/piirivalvur", method = RequestMethod.POST)
    public String addOrUpdatePiirivalvur(HttpServletRequest request, Model model) {
        borderService.addOrUpdatePiirivalvur(request);
        model.addAttribute("piirivalvurid", borderService.getAllPiirivalvur());
        return "listAllPiirivalvur";
    }


    @RequestMapping(value = "/auasteTyyp", method = RequestMethod.GET)
    public String showAllAuasteTyyp(HttpServletRequest request, Model model) {
        model.addAttribute("tyybid", borderService.getAllAuasteTyyp());
        return "listAllAuasteTyyp";
    }

    @RequestMapping(value = "/auasteTyyp", method = RequestMethod.POST)
    public String addOrUpdateAuasteTyyp(HttpServletRequest request, Model model) {
        borderService.addOrUpdateAuasteTyyp(request);
        model.addAttribute("tyybid", borderService.getAllAuasteTyyp());
        return "listAllAuasteTyyp";
    }

    @RequestMapping(value = "/auaste", method = RequestMethod.GET)
    public String showAllAuaste(HttpServletRequest request, Model model) {
        model.addAttribute("auastmed", borderService.getAllAuaste());
        return "listAllAuaste";
    }

    @RequestMapping(value = "/auaste", method = RequestMethod.POST)
    public String addOrUpdateAuaste(HttpServletRequest request, Model model) {
        borderService.addOrUpdateAuaste(request);
        model.addAttribute("auastmed", borderService.getAllAuaste());
        return "listAllAuaste";
    }

    @RequestMapping(value = "/piirivalvurAuaste", method = RequestMethod.GET)
    public String showPiirivalvurAuaste(HttpServletRequest request, Model model) {
        model.addAttribute("piirivalvuridAuastmes", borderService.getAllPiirivalvurAuaste());
        model.addAttribute("auastmed", borderService.getAllAuaste());
        model.addAttribute("piirivalvurid", borderService.getAllPiirivalvur());
        return "listAllPiirivalvurAuaste";
    }

    @RequestMapping(value = "/piirivalvurAuaste", method = RequestMethod.POST)
    public String addOrUpdatePiirivalvurAuaste(HttpServletRequest request, Model model) {
        borderService.addOrUpdatePiirivalvurAuaste(request);
        model.addAttribute("piirivalvuridAuastmes", borderService.getAllPiirivalvurAuaste());
        return "listAllPiirivalvurAuaste";
    }

    public BorderService getBorderService() {
        return borderService;
    }

    public void setBorderService(BorderService borderService) {
        this.borderService = borderService;
    }

}
