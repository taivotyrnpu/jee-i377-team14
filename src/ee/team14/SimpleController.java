package ee.team14;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;


@Controller
public class SimpleController {

    @RequestMapping("/load")
    public String loadView(Model model) {

        try {
            Connection conn = getConnection();
            Statement s = conn.createStatement();
            s.execute("CREATE TABLE border (\n" +
                    "\tid INTEGER NOT NULL IDENTITY,\n" +
                    "\tnimi VARCAR(99),\n" +
                    "\taadress VARCHAR(99),\n" +
                    "\thulk INTEGER\n" +
                    ")");

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
                Statement s = conn.createStatement();
                ResultSet rs = s.executeQuery("SELECT nimi, aadress, hulk FROM border");
                while(rs.next()) {
                  model.addAttribute("nimi", rs.getString("nimi"));
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
    public String saveInsert(HttpServletRequest request, Model model) {
        Connection conn = getConnection();
        if(conn != null){
            try {
                Statement s = conn.createStatement();
                String sql ="INSERT INTO border(nimi, aadress, hulk) VALUES('"+request.getParameter("nimi")+"', '"+
                        request.getParameter("aadress")+"', "+request.getParameter("hulk")+")";
                s.execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        return "welcome";
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
