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

            s.execute("CREATE TABLE piirivalvur (\n" +
                    "\tid BIGINT NOT NULL IDENTITY,\n" +
                    "\teesnimi VARCHAR(99),\n" +
                    "\tperekonnanimi VARCHAR(99),\n" +
                    "\tisikukood VARCHAR(11),\n" +
                    "\temail VARCHAR(50),\n" +
                    "\tkommentaar VARCHAR(150),\n" +
                    "\tsodurikood VARCHAR(20),\n" +
                    "\taadress VARCHAR(99),\n" +
                    "\tsugu VARCHAR(1),\n" +
                    "\ttelefon VARCHAR(30),\n" +
                    "\tavaja VARCHAR(99),\n" +
                    "\tmuutja VARCHAR(99),\n" +
                    "\tsulgeja VARCHAR(99),\n" +
                    "\tavatud DATE,\n" +
                    "\tmuudetud DATE,\n" +
                    "\tsuletud DATE\n" +
                    ")");

            s.execute("CREATE TABLE auaste_tyyp (\n" +
                    "\tid BIGINT NOT NULL IDENTITY,\n" +
                    "\tkood VARCHAR(99),\n" +
                    "\tnimetus VARCHAR(99),\n" +
                    "\tkommentaar VARCHAR(150),\n" +
                    "\tavaja VARCHAR(99),\n" +
                    "\tmuutja VARCHAR(99),\n" +
                    "\tsulgeja VARCHAR(99),\n" +
                    "\tavatud DATE,\n" +
                    "\tmuudetud DATE,\n" +
                    "\tsuletud DATE\n" +
                    ")");

            s.execute("CREATE TABLE auaste (\n" +
                    "\tid BIGINT NOT NULL IDENTITY,\n" +
                    "\tkood VARCHAR(99),\n" +
                    "\tnimetus VARCHAR(99),\n" +
                    "\ttyyp INTEGER,\n" +
                    "\tavaja VARCHAR(99),\n" +
                    "\tmuutja VARCHAR(99),\n" +
                    "\tsulgeja VARCHAR(99),\n" +
                    "\tavatud DATE,\n" +
                    "\tmuudetud DATE,\n" +
                    "\tsuletud DATE\n" +
                    ")");

            s.execute("CREATE TABLE piirivalvur_auaste (\n" +
                    "\tid BIGINT NOT NULL IDENTITY,\n" +
                    "\tauaste_id BIGINT,\n" +
                    "\tpiirivalvur_id BIGINT,\n" +
                    "\tkommentaar VARCHAR(99),\n" +
                    "\talates TIMESTAMP,\n" +
                    "\tkuni TIMESTAMP,\n" +
                    "\tavaja VARCHAR(99),\n" +
                    "\tmuutja VARCHAR(99),\n" +
                    "\tsulgeja VARCHAR(99),\n" +
                    "\tavatud DATE,\n" +
                    "\tmuudetud DATE,\n" +
                    "\tsuletud DATE\n" +
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
            s.execute("DROP TABLE piirivalvur;");
            s.execute("DROP TABLE auaste_tyyp;");
            s.execute("DROP TABLE auaste;");
            s.execute("DROP TABLE piirivalvur_auaste;");


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
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
