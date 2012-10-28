package ee.team14;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GuardService {

    private Connection conn;

    public GuardService(){
      conn = DbConnectionRetriever.getConnection();
    }

    public boolean saveGuard(String nimi, String aadress, String hulk, Integer vanus) {
        if(conn != null){
            try {
                Statement s = conn.createStatement();
                //TODO: tee sb lahendus lõpuni
                /*StringBuilder sb = new StringBuilder();
                sb.append("INSERT INTO border(");
                if(nimi != null){
                    sb.append("nimi");
                }
                if(aadress != null){
                    sb.append(",aadress");
                }
                if(hulk != null){
                    sb.append(",hulk");
                }
                if(vanus != null){
                    sb.append(", vanus");
                }
                sb.append(") VALUES(");
                if(nimi != null){
                    sb.append("'"+nimi+"'");
                }
                if(aadress != null){
                    sb.append(",'"+aadress+"'");
                }
                if(hulk != null){
                    sb.append(",'"+hulk+"'");
                }
                if(vanus != null){
                    sb.append(",'"+vanus+"'");
                } */
                String sql ="INSERT INTO border(nimi, aadress, hulk) VALUES(, '"+
                        aadress+"', "+hulk+")";
                s.execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
        System.out.println("Connection is null?");
        return false;
    }

    public List<String> searchGuards(String nimi, String vanus){
        String sql = "SELECT nimi, vanus FROM border";
        boolean addAnd = false;

        if(nimi!=null && !nimi.isEmpty()){
            sql += " WHERE nimi = '"+nimi+"'";
            addAnd = true;
        }

        if(vanus!=null && !vanus.isEmpty()){
            if(addAnd){
                sql += " AND ";
            } else {
                sql += " WHERE ";
            }
            sql += "vanus = '"+vanus+"'";
        }

        ArrayList<String> nimed = new ArrayList<String>();
        if(conn != null){
            try {
                Statement s = conn.createStatement();
                ResultSet rs = s.executeQuery(sql);
                while(rs.next()) {
                    nimed.add(rs.getString("nimi"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return nimed;
    }

    public String updateGuard(String id, String nimi, String vanus){
        String message = "Vigane ID";

        if(id!=null && !id.isEmpty()){
            String sql = "UPDATE guards SET";
            boolean addComma = false;

            if(vanus!=null && !vanus.isEmpty()){
                sql += " vanus = '"+vanus+"'";
                addComma = true;
            }

            if(nimi!=null && !nimi.isEmpty()){
                if(addComma){
                    sql += ",";
                }
                sql += " nimi = '"+nimi+"'";
            }

            sql += " WHERE id = '"+id+"'";
            if(conn != null){
                try {
                    Statement s = conn.createStatement();
                    s.execute(sql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            message = "ID "+id+" uuendatud!";
        }
        return message;
    }

}
