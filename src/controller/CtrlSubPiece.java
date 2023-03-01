package controller;

import model.PieceQueries;
import view.SubPiece;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class CtrlSubPiece {
    private final SubPiece subPiece;
    private final PieceQueries pieceQueries;

    private void windowConfig() {
        this.subPiece.setTitle("Piezas");
        this.subPiece.setLocationRelativeTo(null);
        this.subPiece.setSize(700, 400);
        this.subPiece.setVisible(true);
    }

    public CtrlSubPiece(int idPiece) {
        this.subPiece = new SubPiece();
        this.windowConfig();

        this.pieceQueries = new PieceQueries();

        String title = "Piezas compuestas - Pieza " + this.pieceQueries.readPiece(idPiece).getCodPiece();
        TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title);
        this.subPiece.getScrollPane().setBorder(border);
    }
}
