package controller;

import view.Store;
import view.Warehouse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuperCtrl implements ActionListener {
    private Store store;

    private void windowConfig() {
        this.store.setTitle("Store");
        this.store.setLocationRelativeTo(null);
        this.store.setSize(400, 400);
        this.store.setVisible(true);
    }

    public SuperCtrl() {
        this.store = new Store();
        windowConfig();

        this.store.getBtnWarehouse().addActionListener(this);
        this.store.getBtnShelf().addActionListener(this);
        this.store.getBtnStoke().addActionListener(this);
        this.store.getBtnPiece().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.store.getBtnWarehouse()) {
            new CtrlWarehouse();
        } else if (e.getSource() == this.store.getBtnShelf()){
            new CtrlShelf();
        } else if (e.getSource() == this.store.getBtnStoke()){
            new CtrlStoke();
        } else if (e.getSource() == this.store.getBtnPiece()){
            new CtrlPiece();
        }
    }
}
