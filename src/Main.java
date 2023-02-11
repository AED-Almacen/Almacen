import model.ConnectionPool;
import model.Nut;
import model.NutQueries;

import java.sql.Connection;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        NutQueries queries = new NutQueries();

        queries.createNut(2.50f, "test1", "nut1");
        queries.createNut(2.50f, "test2", "nut2");

        int i = 0;

        ArrayList<Nut> nuts = queries.readNuts();

        while (i < nuts.size()) {
            System.out.println(nuts.get(i).getId());
            i++;
        }

        System.out.println(queries.readNut(1).getCodNut());

        queries.deleteNut(1);
        queries.deleteNut(2);
    }
}