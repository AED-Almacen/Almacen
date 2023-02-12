package controller;

import model.PieceQueries;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlPiece implements ActionListener {
    private PieceQueries query;

    public CtrlPiece() {
        this.query = new PieceQueries();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
