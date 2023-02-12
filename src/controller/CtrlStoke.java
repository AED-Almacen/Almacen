package controller;

import model.ShelfQueries;
import model.StokeQueries;
import model.Warehouse;
import view.Stoke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CtrlStoke {
    private Stoke stoke;
    private StokeQueries queries;

    private void windowConfig() {
        this.stoke.setTitle("Stoke");
        this.stoke.setLocationRelativeTo(null);
        this.stoke.setSize(600, 600);
        this.stoke.setVisible(true);
    }

    public CtrlStoke() {
        this.stoke = new Stoke();
        windowConfig();

        this.queries = new StokeQueries();
        readStoke();
    }

    private void readStoke() {
        this.stoke.getTextArea1Stoke().setText("");

        ArrayList<model.Stoke> stokes = queries.readStokes();

        if(stokes == null) {
            this.stoke.getTextArea1Stoke().append("No hay Stoke en la base de datos.");
        }else{
            for (model.Stoke stoke : stokes) {
                this.stoke.getTextArea1Stoke().append(stoke.toString()+"\n");
            }
        }

    }

}
