package ee.team14;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


@Controller
public class SimpleController {

    @RequestMapping("/load")
    public String loadView(Model model) {

        try {
            Connection conn = getConnection();
            Statement s = conn.createStatement();
            s.execute("CREATE TABLE border (\n" +
                    "\tid INTEGER NOT NULL IDENTITY,\n" +
                    "\tnimi VARCHAR(99),\n" +
                    "\tvanus INTEGER,\n" +
                    "\taadress VARCHAR(99),\n" +
                    "\thulk INTEGER\n" +
                    ")");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


        return "welcome";
    }

    @RequestMapping("/dropAll")
    public String dropDB(Model model) {

        try {
            Connection conn = getConnection();
            Statement s = conn.createStatement();
            s.execute("DROP TABLE border");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


        return "welcome";
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String loadRead(HttpServletRequest request, Model model) {
        Connection conn = getConnection();
        if(conn != null){
            try {
            	ArrayList<String> nimed = new ArrayList<String>();
                Statement s = conn.createStatement();
                ResultSet rs = s.executeQuery("SELECT nimi, aadress, hulk FROM border");
                while(rs.next()) {
                	nimed.add(rs.getString("nimi"));
                	model.addAttribute("nimed", nimed);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "read";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String loadInsert(HttpServletRequest request, Model model) {

        return "insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String saveInsertPost(HttpServletRequest request, Model model) {
        Connection conn = getConnection();
        if(conn != null){
            try {
                Statement s = conn.createStatement();
                String sql ="INSERT INTO border(nimi, aadress, hulk, vanus) VALUES('"+request.getParameter("nimi")+"', '"+
                        request.getParameter("aadress")+"', "+request.getParameter("hulk")+","+request.getParameter("vanus")+")";
                s.execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "welcome";
    }
    
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String saveInsert(HttpServletRequest request, Model model) {
    	ArrayList<String> gets = new ArrayList<String>();
    	Enumeration paramNames = request.getParameterNames();
    	while(paramNames.hasMoreElements())
        {
    		String elem = (String)paramNames.nextElement();
    		gets.add(elem);
        }
        model.addAttribute("gets", gets);
        return "get";
    }

    @RequestMapping(value = "/generateGuards", method = RequestMethod.GET)
    public String generateGuards(HttpServletRequest request, Model model) {

        String countString = request.getParameter("count");
        if(countString != null){
            GuardService guardService = new GuardService();
            try{
                int count = Integer.parseInt(countString);
                List<String> guardNames = new ArrayList<String>(count);
                for(int i =0; i < count; i++) {
                    String guardName = NameGenerator.generate();
                    guardService.saveGuard(guardName, null, "0", null);
                    guardNames.add(guardName);
                }
                model.addAttribute("guardNames", guardNames);
            } catch (NumberFormatException e){
              model.addAttribute("error", "Error: "+e);
            }
        }

        return "generateGuard";
    }
    
    @RequestMapping(value = "/searchGuard", method = RequestMethod.GET)
    public String searchGuard(HttpServletRequest request, Model model) {
    	String nimi = request.getParameter("nimi");
    	String vanus = request.getParameter("vanus");
    	if(nimi != null || vanus != null){
            GuardService guardService = new GuardService();
            List<String> nimed = guardService.searchGuards(nimi, vanus);

            // TODO: jsp's foreach nimed
            model.addAttribute("nimed", nimed);
        }
    	return "searchGuard";
    }
    
    @RequestMapping(value = "/updateGuard", method = RequestMethod.GET)
    public String updateGuard(HttpServletRequest request, Model model) {
    	String id = request.getParameter("id");
    	String nimi = request.getParameter("name");
    	String vanus = request.getParameter("age");
    	
    	GuardService guardService = new GuardService();
        String message = guardService.updateGuard(id, nimi, vanus);

    	model.addAttribute("nimed", message);
    	return "updateGuard";
    }

    private Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            conn = DriverManager.getConnection("jdbc:hsqldb:/home/taivo/Documents/kool/java/db/BorderDB");
            System.out.println("Using database: " +
                    conn.getMetaData().getDatabaseProductName() + " " +
                    conn.getMetaData().getDatabaseProductVersion() + " at " +
                    conn.getMetaData().getURL());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return conn;
    }
}
