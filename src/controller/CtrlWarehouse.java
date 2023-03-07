package controller;

import model.WarehouseQueries;
import view.Warehouse;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class CtrlWarehouse implements ActionListener, MouseListener {
    private final Warehouse warehouse;
    private final WarehouseQueries queries;

    private void windowConfig() {
        this.warehouse.setTitle("Warehouse");
        this.warehouse.setLocationRelativeTo(null);
        this.warehouse.setSize(600, 600);
        this.warehouse.setVisible(true);
    }

    private void cleanText() {
        this.warehouse.getDescriptionTxt().setText("");
        this.warehouse.getAddressTxt().setText("");
    }

    private void readWarehouses() {
        ArrayList<model.Warehouse> warehouses = this.queries.readWarehouses();
        this.cleanText();

        Object[][] data = new Object[warehouses.size()][];

        for (int i = 0; i < warehouses.size(); i++) {
            data[i] = new String[]{
                    String.valueOf(warehouses.get(i).getId()),
                    warehouses.get(i).getDesc(),
                    warehouses.get(i).getAddress()
            };
        }

        this.warehouse.getTable().setModel(new DefaultTableModel(
                data,
                new String[]{"Id", "Descripción", "Dirección"}
        ));

    }
    public CtrlWarehouse() {
        this.warehouse = new Warehouse();
        windowConfig();

        this.queries = new WarehouseQueries();
        this.warehouse.getAddBtn().addActionListener(this);
        this.warehouse.getDropBtn().addActionListener(this);
        this.warehouse.getUpdateBtn().addActionListener(this);
        this.warehouse.getTable().addMouseListener(this);
        this.readWarehouses();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.warehouse.getAddBtn()) {
            try {
                String desc = warehouse.getDescriptionTxt().getText();
                String address = warehouse.getAddressTxt().getText();

                this.queries.createWarehouse(desc, address);
                this.readWarehouses();

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al añadir pieza.");
            }
        } else if (e.getSource() == this.warehouse.getDropBtn()) {
            try {
                int fila = this.warehouse.getTable().getSelectedRow();
                int id = Integer.parseInt(this.warehouse.getTable().getValueAt(fila, 0).toString());

                this.queries.deleteWarehouse(id);
                this.readWarehouses();

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al borrar pieza. Debe seleccionar la pieza a borrar.");
            }
        } else if (e.getSource() == this.warehouse.getUpdateBtn()) {
            try {
                int fila = this.warehouse.getTable().getSelectedRow();
                int id = Integer.parseInt(this.warehouse.getTable().getValueAt(fila, 0).toString());

                String desc = warehouse.getDescriptionTxt().getText();
                String address = warehouse.getAddressTxt().getText();

                this.queries.updateWarehouse(id, desc, address);
                this.readWarehouses();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al actualizar la pieza. Debe seleccionar la pieza a actualizar y mantener un código.");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = this.warehouse.getTable().getSelectedRow();

        this.warehouse.getDescriptionTxt().setText(this.warehouse.getTable().getValueAt(fila, 1).toString());
        this.warehouse.getAddressTxt().setText(this.warehouse.getTable().getValueAt(fila, 2).toString());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
