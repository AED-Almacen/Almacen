package controller;

import model.ShelfQueries;
import model.StokeQueries;
import view.Stoke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlStoke implements ActionListener {
    private Stoke stoke;
    private StokeQueries queries;

    private void windowConfig() {
        this.stoke.setTitle("Stoke");
        this.stoke.setLocationRelativeTo(null);
        this.stoke.setSize(400, 400);
        this.stoke.setVisible(true);
    }

    public CtrlStoke() {
        this.stoke = new Stoke();
        windowConfig();

        this.queries = new StokeQueries();
        this.stoke.getStokeButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Stoke");
    }
}
