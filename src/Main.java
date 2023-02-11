import model.*;

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

        System.out.println(queries.readNut(nuts.size()-1).getCodNut());

        queries.deleteNut(1);
        queries.deleteNut(2);

        warehouseTest();
    }

    public static void warehouseTest() {
        WarehouseQueries queries = new WarehouseQueries();

        queries.createWarehouse( "Las Arinaga 1", "Calle falsa 123");
        queries.createWarehouse( "Las Arinaga 2", "Calle falsa 123");

        int i = 0;

        ArrayList<Warehouse> warehouses = queries.readWarehouses();

        while (i < warehouses.size()) {
            System.out.println(warehouses.get(i).getId());
            i++;
        }

        System.out.println(queries.readWarehouse(warehouses.size()-1).getAddress());

        queries.deleteWarehouse(1);
        queries.deleteWarehouse(2);
    }
}