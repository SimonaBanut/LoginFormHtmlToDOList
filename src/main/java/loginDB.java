import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simona on 01.07.2016.
 */
@WebServlet ("/loginDB")

public class loginDB extends HttpServlet{

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException{

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String uss = req.getParameter("username");
        String pss = req.getParameter("password");
        System.out.println(" ai userul : " + uss);

        try {
            if (useriDB.isFounds(uss,pss)) {
            System.out.println("corect te-ai logat");
        }
        else {
            System.out.println("user sau parola gresit");}
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
