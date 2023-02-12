package controller;

import model.StokeQueries;
import model.WarehouseQueries;
import view.Warehouse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlWarehouse implements ActionListener {
    private Warehouse warehouse;
    private WarehouseQueries queries;

    private void windowConfig() {
        this.warehouse.setTitle("Warehouse");
        this.warehouse.setLocationRelativeTo(null);
        this.warehouse.setSize(400, 400);
        this.warehouse.setVisible(true);
    }

    public CtrlWarehouse() {
        this.warehouse = new Warehouse();
        windowConfig();

        this.queries = new WarehouseQueries();
        this.warehouse.getWareHouseButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("almacen");
    }
}
