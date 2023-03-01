package controller;

import model.WarehouseQueries;
import view.Warehouse;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CtrlWarehouse implements ActionListener {
    private final Warehouse warehouse;
    private final WarehouseQueries queries;

    private void windowConfig() {
        this.warehouse.setTitle("Warehouse");
        this.warehouse.setLocationRelativeTo(null);
        this.warehouse.setSize(600, 600);
        this.warehouse.setVisible(true);
    }

    private void readWarehouse() {
        this.warehouse.getTextArea1().setText("");

        ArrayList<model.Warehouse> warehouses = queries.readWarehouses();

        if(warehouses == null) {
            this.warehouse.getTextArea1().append("No hay almacenes en la base de datos.");
        }else{
            for (model.Warehouse warehouse : warehouses) {
                this.warehouse.getTextArea1().append(warehouse.toString()+"\n");
            }
        }

    }
    public CtrlWarehouse() {
        this.warehouse = new Warehouse();
        windowConfig();

        this.queries = new WarehouseQueries();
        this.warehouse.getAddBtn().addActionListener(this);
        this.warehouse.getDropBtn().addActionListener(this);
        this.warehouse.getUpdateBtn().addActionListener(this);
        readWarehouse();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.warehouse.getAddBtn()) {
            try {
                String desc = warehouse.getDescriptionText().getText();
                String address = warehouse.getAddresText().getText();

                if (desc.equals("") || address.equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "Error al añadir Almacen. Debe rellenar todos los campos.");
                } else {
                    this.queries.createWarehouse( address, desc);
                    readWarehouse();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al añadir almacen. el almacen debe tener descripcion y direccion.");
            }
        } else if (e.getSource() == this.warehouse.getDropBtn()) {
            try {
                if(this.queries.readWarehouse(Integer.parseInt(warehouse.getIdText().getText())) == null) {
                    JOptionPane.showMessageDialog(null,
                            "Error al borrar almacen. El almacen no existe.");
                    return;
                };
                this.queries.deleteWarehouse(Integer.parseInt(warehouse.getIdText().getText()));
                readWarehouse();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al borrar almacen. Debes especificar el id de del almacen a borrar.");
            }
        } else if (e.getSource() == this.warehouse.getUpdateBtn()) {

            try {
                if(this.queries.readWarehouse(Integer.parseInt(warehouse.getIdText().getText())) == null) {
                    JOptionPane.showMessageDialog(null,
                            "Error al actualizar almacen. El almacen no existe.");
                    return;
                };
                int id = Integer.parseInt(warehouse.getIdText().getText());
                String desc = warehouse.getDescriptionText().getText();
                String address = warehouse.getAddresText().getText();

                if (desc.equals("") || address.equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "Error al añadir Almacen. Debe rellenar todos los campos.");
                } else {
                    this.queries.updateWarehouse(id, address, desc);
                    readWarehouse();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al actualizar el almacen. Debes especificar el id del almacen a actualizar.");
            }
        }
    }

}
