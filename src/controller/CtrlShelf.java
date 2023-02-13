package controller;

import model.ShelfQueries;
import model.Warehouse;
import model.WarehouseQueries;
import view.Shelf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CtrlShelf implements ActionListener {
    private Shelf shelf;
    private ShelfQueries queries;

    private Warehouse warehouse;
    private WarehouseQueries queriesWarehouse;



    private void windowConfig() {
        this.shelf.setTitle("Shelf");
        this.shelf.setLocationRelativeTo(null);
        this.shelf.setSize(1000, 800);
        this.shelf.setVisible(true);
    }

    private void readShelf() {
        this.shelf.getTextArea1().setText("");

        ArrayList<model.Shelf> shelves = queries.readShelves();
        ArrayList<model.Warehouse> warehouses = queriesWarehouse.readWarehouses();

        if(shelves == null) {
            this.shelf.getTextArea1().append("No hay estanterias en la base de datos.");
        }else{
            for (model.Shelf shelf : shelves) {
                this.shelf.getTextArea1().append(shelves.toString()+"\n");
            }
        }

        if(warehouses == null) {
            this.shelf.getTextArea1().append("No hay almacenes en la base de datos.");
        }else{
            for (model.Warehouse warehouse : warehouses) {
                this.shelf.getWarehouseCombo().addItem(warehouse.getId()+"-"+warehouse.getDesc());
            }
        }
    }
    public CtrlShelf() {
        this.shelf = new view.Shelf();
        windowConfig();

        this.queries = new ShelfQueries();
        this.queriesWarehouse = new WarehouseQueries();
        this.shelf.getAddBtn().addActionListener(this);
        this.shelf.getDropBtn().addActionListener(this);
        this.shelf.getUpdateBtn().addActionListener(this);
        readShelf();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.shelf.getAddBtn()) {
            try {
                int idWarehouse = 0;
                String codEstanteria = shelf.getCodShelfText().getText();
                Object comboSelected = shelf.getWarehouseCombo().getSelectedItem();

                if(comboSelected != null){
                    String warehouseCombo = comboSelected.toString().split("-")[0];
                    int idSearch = Integer.parseInt(warehouseCombo);
                    idWarehouse = queriesWarehouse.readWarehouse(idSearch).getId();
                }


                if (codEstanteria.equals("") || idWarehouse == 0) {
                    JOptionPane.showMessageDialog(null,
                            "Error al añadir estanteria. Debe rellenar todos los campos.");
                } else {
                    this.queries.createShelf( codEstanteria, idWarehouse);
                    readShelf();
                }
            } catch (Exception exception) {
                System.out.println(exception);
                JOptionPane.showMessageDialog(null,
                        "Error al añadir estanteria. el almacen debe tener descripcion y direccion.");
            }
        } else if (e.getSource() == this.shelf.getDropBtn()) {
            try {
                if(this.queries.readShelf(Integer.parseInt(shelf.getIdText().getText())) == null) {
                    JOptionPane.showMessageDialog(null,
                            "Error al borrar estanteria. El almacen no existe.");
                    return;
                };
                this.queries.deleteShelf(Integer.parseInt(shelf.getIdText().getText()));
                readShelf();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al borrar estanteria. Debes especificar el id de del estanteria a borrar.");
            }
        } else if (e.getSource() == this.shelf.getUpdateBtn()) {

            try {
                if(this.queries.readShelf(Integer.parseInt(shelf.getIdText().getText())) == null) {
                    JOptionPane.showMessageDialog(null,
                            "Error al actualizar estanteria. El estanteria no existe.");
                    return;
                };
                int id = Integer.parseInt(shelf.getIdText().getText());
                int idWarehouse = 0;
                String codEstanteria = shelf.getCodShelfText().getText();
                Object comboSelected = shelf.getWarehouseCombo().getSelectedItem();

                if(comboSelected != null){
                    String warehouseCombo = comboSelected.toString().split("-")[0];
                    int idSearch = Integer.parseInt(warehouseCombo);
                    idWarehouse = queriesWarehouse.readWarehouse(idSearch).getId();
                }


                if (codEstanteria.equals("") || idWarehouse == 0) {
                    JOptionPane.showMessageDialog(null,
                            "Error al añadir estanteria. Debe rellenar todos los campos.");
                } else {
                    this.queries.updateShelf(id, codEstanteria, idWarehouse);
                    readShelf();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al actualizar. Debes especificar el id de la estanteria  a actualizar.");
            }
        }
    }
}
