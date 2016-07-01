/**
 * Created by Simona on 25.06.2016.
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

//            if (!rs.isBeforeFirst()) {
//                System.out.println("Numele nu este in agenda");
//            }
            // 6. iterate the result set and print the values

            System.out.println("users cu datele");
            while (rs.next()) {
                user u1=new user();
                String usr=rs.getString("nume").trim();
                String pass=rs.getString("parola").trim();
                u1.setU(usr);
                u1.setP(pass);
                lista.add(u1);
                System.out.print(u1.getU()+ "****" + u1.getP());

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

        for (int i = 0; i < lista.size(); i++)
      {

            if (lista.get(i).getU().equals(n)) {
                if (lista.get(i).getP().equals(p)) {
                    k = true;
                }
            }

        }

        return k;

    }
}


