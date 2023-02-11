package controller;

import model.Piece;
import model.PieceQueries;
import model.Warehouse;
import model.WarehouseQueries;

import java.util.ArrayList;

public class CtrlStore {

    public static void pieceTest() {
        PieceQueries queries = new PieceQueries();

        int i = 0;
        queries.createPiece( 10.0f, "Tuerca", "TU01");
        queries.createPiece( 5.0f, "Tornillo", "TO01");

        ArrayList<Piece> nuts = queries.readPieces();



        while (i < nuts.size()) {
            System.out.println(nuts.get(i).getId());
            i++;
        }

        System.out.println(queries.readPiece(nuts.size()-1).getCodPiece());

        queries.deletePiece(1);
        queries.deletePiece(2);
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
