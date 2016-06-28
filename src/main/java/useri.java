/**
 * Created by Simona on 25.06.2016.
 */
import java.awt.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class useri {

    private static  List<user> lista = new ArrayList<>();

    public static void listaUseri ()
    {
        user u1= new user ();
                u1.setU("simo");
                u1.setP("123456");
            lista.add(u1);

        user u2= new user ();
                u2.setU("banu");
                u2.setP ("987654");
            lista.add(u2);
    }

    public static boolean isFound (String n, String p ){
        boolean k=false;
        for (int i=0; i<lista.size();i++){

            if (lista.get(i).getU().equals(n)) {
                if (lista.get(i).getP().equals(p)){
                 k= true;
                }
            }

        }

        return k;

    }
}


