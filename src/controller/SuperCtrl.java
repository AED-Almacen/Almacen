package controller;

import view.Store;
import view.Warehouse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuperCtrl implements ActionListener {
    private Store store;
    private Warehouse warehouse;

    private void windowConfig() {
        this.store.setTitle("Store");
        this.store.setLocationRelativeTo(null);
        this.store.setSize(400, 400);
        this.store.setVisible(true);
    }

    public SuperCtrl() {
        this.store = new Store();
        windowConfig();

        this.store.getBtnStore().addActionListener(this);
        this.store.getBtnShelf().addActionListener(this);
        this.store.getBtnStoke().addActionListener(this);
        this.store.getBtnPiece().addActionListener(this);

        this.warehouse = new Warehouse();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.store.getWindow().add(this.warehouse.getPanel());
    }
}
