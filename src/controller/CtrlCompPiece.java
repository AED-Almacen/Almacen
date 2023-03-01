package controller;

import model.PieceQueries;
import view.CompPiece;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class CtrlCompPiece {
    private final CompPiece compPiece;
    private final PieceQueries pieceQueries;

    private void windowConfig() {
        this.compPiece.setTitle("Piezas");
        this.compPiece.setLocationRelativeTo(null);
        this.compPiece.setSize(700, 400);
        this.compPiece.setVisible(true);
    }

    public CtrlCompPiece(int idPiece) {
        this.compPiece = new CompPiece();
        this.windowConfig();

        this.pieceQueries = new PieceQueries();

        String title = "Piezas compuestas - Pieza " + this.pieceQueries.readPiece(idPiece).getCodPiece();
        TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title);
        this.compPiece.getScrollPane().setBorder(border);
    }
}
