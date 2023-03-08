package controller;

import view.Store;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuperCtrl implements ActionListener {
    private final Store store;
    private final CtrlWarehouse ctrlWarehouse;
    private final CtrlShelf ctrlShelf;
    private final CtrlStoke ctrlStoke;
    private final CtrlPiece ctrlPiece;

    private void windowConfig() {
        this.store.setTitle("Acciones de Almacén");
        this.store.setLocationRelativeTo(null);
        this.store.setSize(1000, 400);
        this.store.setVisible(true);
    }

    private void closeWindows() {
        try {
            this.ctrlPiece.getCtrlCompPieces().getCompPieces().setVisible(false);
        } catch (Exception ignored) {}

        this.ctrlWarehouse.getWarehouse().setVisible(false);
        this.ctrlShelf.getShelf().setVisible(false);
        this.ctrlStoke.getStoke().setVisible(false);
        this.ctrlPiece.getPiece().setVisible(false);
    }

    public SuperCtrl() {
        this.store = new Store();
        this.ctrlWarehouse = new CtrlWarehouse();
        this.ctrlShelf = new CtrlShelf();
        this.ctrlStoke = new CtrlStoke();
        this.ctrlPiece = new CtrlPiece();
        windowConfig();

        this.store.getBtnWarehouse().addActionListener(this);
        this.store.getBtnShelf().addActionListener(this);
        this.store.getBtnStoke().addActionListener(this);
        this.store.getBtnPiece().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.closeWindows();

        if (e.getSource() == this.store.getBtnWarehouse()) {
            this.ctrlWarehouse.init();
        } else if (e.getSource() == this.store.getBtnShelf()){
            this.ctrlShelf.init();
        } else if (e.getSource() == this.store.getBtnStoke()){
            this.ctrlStoke.init();
        } else if (e.getSource() == this.store.getBtnPiece()){
            this.ctrlPiece.init();
        }
    }
}
