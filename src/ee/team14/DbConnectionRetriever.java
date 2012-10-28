package ee.team14;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnectionRetriever {

    public static Connection getConnection() {
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
