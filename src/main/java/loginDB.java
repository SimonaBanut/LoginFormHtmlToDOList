import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String uss = request.getParameter("username");
        String pss = request.getParameter("password");
        System.out.println(" ai userul : " + uss);

        try {

            if (useriDB.isFounds(uss,pss)) {
                System.out.println("corect te-ai logat");
//                out.println("<html>");
//                out.println("<head>");
//                out.println("</head>");
//
//                out.println("<body background-image:url(fluturi.jpg)>");
//                out.println("<img src='fluturi.jpg' />");
//
//                out.println("<p style=\"text-align:center;margin-top:5px;font-size: 30px;\"><b>"
//                        + "Logare reusita!" + "</b><br>");
//
//
//                out.println("<a href=\"index-login.html\" " +
//                        "style=\"text-align:center;font-size: 17px;" +
//                        "color:#006dcc;position:relative; top:20px;\">" +
//                        "<b>Log out</b></a>");
//
//                out.close();
//                out.println("</body>");

                HttpSession session = request.getSession(true);
                session.setAttribute("username", uss);
                session.setAttribute("password", pss);


                String success = "/todolist.html";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(success);
                dispatcher.forward(request, response);


            }
        else {
            System.out.println("user sau parola gresit");
              System.out.println("nu exista acest user in db ");
                    String back = "/login.html";
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(back);
                    dispatcher.forward(request, response);

                System.out.println("login service called...");

//                out.println("<html>");
//                out.println("<head>");
//                out.println("</head>");
//
//                out.println("<body>");
//
//
//                out.println("<p style=\"text-align:center;margin-top:30px;font-size: 30px;\"><b>" +
//                        "Parola sau user gresit " + "</b><br>");
//                out.println("<a href=\"index-login.html\" style=\"text-align:center;" +
//                        "font-size: 17px;color:#006dcc;position:relative; top:20px; left:-10px;\">" +
//                        "<b>incearca din nou</b></a>");
//                out.println("<a href=\"createAcc.html\" style=\"text-align:center;" +
//                        "font-size: 17px;color:#006dcc;position:relative; top:20px; right:-10px;\">" +
//                        "<b>Create account</b></a>");
//                out.close();
//
//
//                out.println("</body>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
