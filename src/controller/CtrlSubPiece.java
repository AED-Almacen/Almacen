package controller;

import model.PieceQueries;
import view.SubPiece;

public class CtrlSubPiece {
    private final SubPiece subPiece;
    private final PieceQueries queries;

    private void windowConfig() {
        this.subPiece.setTitle("Piezas");
        this.subPiece.setLocationRelativeTo(null);
        this.subPiece.setSize(700, 400);
        this.subPiece.setVisible(true);
    }

    public CtrlSubPiece() {
        this.subPiece = new SubPiece();
        this.windowConfig();

        this.queries = new PieceQueries();
    }
}
