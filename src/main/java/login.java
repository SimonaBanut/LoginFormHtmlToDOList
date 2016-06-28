import com.sun.org.apache.xpath.internal.SourceTree;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Simona on 25.06.2016.
 */
@WebServlet("/loginjava")
public class login extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {

        useri.listaUseri();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uss = req.getParameter("username");
        String pss = req.getParameter("password");
        System.out.println(" ai userul : " + uss);

    if (useri.isFound(uss,pss)) {
        System.out.println("corect te-ai logat");
    }
        else {
        System.out.println("user sau parola gresit");}

    }
}
