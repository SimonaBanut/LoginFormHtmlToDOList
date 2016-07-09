package LoginFormSimo; /**
 * Created by Simona on 25.06.2016.
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.*;

public class useriDB {

    private static List<user> lista = new ArrayList<>();

    public static List<user> demoSearch() throws ClassNotFoundException, SQLException {
        try {
            // 1. load driver class.forname-incarc driverul

            Class.forName("org.postgresql.Driver");
            // 2. define connection params to db
            final String URL = "jdbc:postgresql://54.93.65.5:5432/4_Simona";
            final String USERNAME = "fasttrackit_dev";
            final String PASSWORD = "fasttrackit_dev";
            // 3. obtain a connection
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // 4. create a query statement
            Statement st = conn.createStatement();

            // 5. execute a query
            ResultSet rs = st.executeQuery("SELECT nume,parola FROM users");

            System.out.println("baza de date este:");
            while (rs.next()) {
                user u1 = new user();
                String usr = rs.getString("nume").trim();
                String pass = rs.getString("parola").trim();
                u1.setU(usr);
                u1.setP(pass);
                lista.add(u1);
                System.out.print(u1.getU() + "****" + u1.getP());

            }
            // 7. close the objects
            rs.close();
            st.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;

    }

    public static boolean isFounds(String n, String p) throws SQLException, ClassNotFoundException {
        boolean k = false;
        demoSearch();

        for (user u : lista) {
            if (u.getU().equals(n) && u.getP().equals(p)) {
                k = true;
                break;
            }
        }

        return k;

    }

    public static boolean demoSave(String username, String password) throws ClassNotFoundException, SQLException {
        boolean ss;
        // 1. load driver class.forname-incarc driverul
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/4_Simona";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("INSERT INTO users (nume, parola) VALUES (?,?)");

        pSt.setString(1, username);
        pSt.setString(2, password);
        ss = true;
        // 5. execute a prepared statement
        int rowsInserted = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();

        return ss;
    }

}


