package LoginFormSimo;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Simona on 01.07.2016.
 */
@WebServlet("/newloginDB")

public class newloginDB extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String nu = req.getParameter("username");
        String npss = req.getParameter("password");
        String npss1 = req.getParameter("passwordR");
        System.out.println(" userul sa fie : " + nu);

//        if (npss == npss1) {
////            && (nu !="") && (npss != "")
//            try {
        try {
            if (useriDB.demoSave(nu, npss)) {

                System.out.println("user adaugat");

        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body BGCOLOR=#888888>");
        out.println("<p style=\"text-align:center;margin-top:30px;font-size: 30px;\"><b>"
                + "Te-ai inregistrat!" + "</b><br>");
        out.println("<a href=\"index-login.html\" " +
                "style=\"text-align:center;font-size: 17px;" +
                "color:#006dcc;position:relative; top:20px;\">" +
                "<b>Log out</b></a>");

        out.println("</body>");
        out.close();}
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }}
        else{
            System.out.println("parola sau user incorect");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p style=\"text-align:center;margin-top:30px;font-size: 30px;\"><b>" +
                    "Parola gresita " + "</b><br>");
            out.println("<a href=\"index-login.html\" style=\"text-align:center;" +
                    "font-size: 17px;color:#006dcc;position:relative; top:20px; left:-10px;\">" +
                    "<b>incearca cu un user </b></a>");
            out.println("<a href=\"createAcc.html\" style=\"text-align:center;" +
                    "font-size: 17px;color:#006dcc;position:relative; top:20px; right:-10px;\">" +
                    "<b>Creaza cont</b></a>");
            out.println("</body>");
            out.close();
        }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
