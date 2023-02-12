package controller;

import model.ShelfQueries;
import view.Shelf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlShelf implements ActionListener {
    private Shelf shelf;
    private ShelfQueries queries;

    private void windowConfig() {
        this.shelf.setTitle("Estanterías");
        this.shelf.setLocationRelativeTo(null);
        this.shelf.setSize(400, 400);
        this.shelf.setVisible(true);
    }

    public CtrlShelf() {
        this.shelf = new Shelf();
        windowConfig();

        this.queries = new ShelfQueries();
        this.shelf.getShelfButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("estantería");
    }
}
