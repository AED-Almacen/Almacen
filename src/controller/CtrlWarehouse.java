package controller;

import model.WarehouseQueries;
import view.Warehouse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CtrlWarehouse implements ActionListener {
    private Warehouse warehouse;
    private WarehouseQueries queries;

    private void windowConfig() {
        this.warehouse.setTitle("Warehouse");
        this.warehouse.setLocationRelativeTo(null);
        this.warehouse.setSize(600, 600);
        this.warehouse.setVisible(true);
    }

    public CtrlWarehouse() {
        this.warehouse = new Warehouse();
        windowConfig();

        this.queries = new WarehouseQueries();
        this.warehouse.getWareHouseButton().addActionListener(this);


        ArrayList<model.Warehouse> warehouses = queries.readWarehouses();
        for (model.Warehouse warehouse : warehouses) {
            this.warehouse.getTextArea1().append(warehouse.toString()+"\n");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("almacen");
    }
}
