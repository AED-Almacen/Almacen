package controller;

import model.PieceQueries;
import view.ViewCrud_Pieza;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlPieza_Crear implements ActionListener {

    private ViewCrud_Pieza crudPieza;

    private PieceQueries pieceQueries;

    public CtrlPieza_Crear(ViewCrud_Pieza crudPieza, PieceQueries pieceQueries) {
        this.crudPieza = crudPieza;
        this.pieceQueries = pieceQueries;
    }

    public void iniciar() {
        crudPieza.setVisible(true);
        crudPieza.setSize(500, 300);
        crudPieza.setLocationRelativeTo(null);
        crudPieza.crearButton.addActionListener(this);
        crudPieza.eliminarButton.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e){
        System.out.println(crudPieza.textFieldDesc.getText());
    }



}
