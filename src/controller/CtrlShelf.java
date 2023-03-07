package controller;

import model.ShelfQueries;
import model.Warehouse;
import model.WarehouseQueries;
import view.Shelf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;

public class CtrlShelf implements ActionListener, MouseListener {
    private final Shelf shelf;
    private final ShelfQueries queries;
    private final WarehouseQueries warehouseQueries;

    private void windowConfig() {
        this.shelf.setTitle("Estantería");
        this.shelf.setLocationRelativeTo(null);
        this.shelf.setSize(700, 400);
        this.shelf.setVisible(true);
    }

    private void cleanText() {
        this.shelf.getCodTxt().setText("");
    }

    private void readShelves() {
        ArrayList<model.Shelf> shelves = this.queries.readShelves();
        this.cleanText();

        Object[][] data = new Object[shelves.size()][];

        for (int i = 0; i < shelves.size(); i++) {
            Warehouse warehouse = this.warehouseQueries.readWarehouse(shelves.get(i).getIdWarehouse());

            if (warehouse != null) {
                data[i] = new String[]{
                        String.valueOf(shelves.get(i).getId()),
                        shelves.get(i).getCodShelf(),
                        String.valueOf(warehouse.getId()),
                        warehouse.getDesc(),
                        warehouse.getAddress()
                };
            }
        }

        this.shelf.getTable().setModel(new DefaultTableModel(
                data,
                new String[]{"Id", "Código", "Id Almacén", "Descripción", "Dirección"}
        ));
    }
    public CtrlShelf() {
        this.shelf = new view.Shelf();
        windowConfig();

        this.queries = new ShelfQueries();
        this.warehouseQueries = new WarehouseQueries();

        this.readShelves();
        ArrayList<Warehouse> warehouses = warehouseQueries.readWarehouses();
        for (Warehouse warehouse : warehouses) {
            this.shelf.getWarehouseCombo().addItem(warehouse.getId() + " - " + warehouse.getDesc());
        }

        this.shelf.getAddBtn().addActionListener(this);
        this.shelf.getDropBtn().addActionListener(this);
        this.shelf.getUpdateBtn().addActionListener(this);
        this.shelf.getTable().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object comboSelected = this.shelf.getWarehouseCombo().getSelectedItem();

        if (e.getSource() == this.shelf.getAddBtn()) {
            if (comboSelected != null) {
                int idWarehouse = Integer.parseInt(comboSelected.toString().split(" - ")[0]);
                this.queries.createShelf(this.shelf.getCodTxt().getText(), idWarehouse);

                this.readShelves();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Error al añadir pieza. Debe seleccionar una pieza.");
            }

        } else if (e.getSource() == this.shelf.getUpdateBtn()) {
            try {
                int row = this.shelf.getTable().getSelectedRow();
                int id = Integer.parseInt(this.shelf.getTable().getValueAt(row, 0).toString());

                if (comboSelected != null) {
                    int idWarehouse = Integer.parseInt(comboSelected.toString().split(" - ")[0]);

                    this.queries.updateShelf(id, this.shelf.getCodTxt().getText(), idWarehouse);
                    this.readShelves();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error al actualizar elemento stoke. Debe seleccionar una pieza y una estantería.");
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al actualizar pieza. Debe seleccionar la pieza a actualizar.");
            }
        } else if (e.getSource() == this.shelf.getDropBtn()) {
            try {
                int row = this.shelf.getTable().getSelectedRow();
                int id = Integer.parseInt(this.shelf.getTable().getValueAt(row, 0).toString());

                this.queries.deleteShelf(id);
                this.readShelves();

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al borrar pieza. Debe seleccionar la pieza a borrar.");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = this.shelf.getTable().getSelectedRow();

        this.shelf.getCodTxt().setText(this.shelf.getTable().getValueAt(row, 1).toString());
        this.shelf.getWarehouseCombo().setSelectedItem(this.shelf.getTable().getValueAt(row, 2) +
                " - " + this.shelf.getTable().getValueAt(row, 3));
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
