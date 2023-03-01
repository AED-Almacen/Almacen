package controller;

import model.CompPiecesQueries;
import model.Piece;
import model.PieceQueries;
import view.CompPieces;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class CtrlCompPieces {
    private final CompPieces compPieces;
    private final PieceQueries pieceQueries;
    private final CompPiecesQueries compPiecesQueries;

    private void windowConfig() {
        this.compPieces.setTitle("Piezas");
        this.compPieces.setLocationRelativeTo(null);
        this.compPieces.setSize(700, 400);
        this.compPieces.setVisible(true);
    }

    private void readCompPieces(int idPiece) {
        ArrayList<Piece> compPieces = this.compPiecesQueries.readCompPieces(idPiece);

        Object[][] data = new Object[compPieces.size()][];

        for (int i = 0; i < compPieces.size(); i++) {
            data[i] = new String[]{
                    String.valueOf(compPieces.get(i).getId()),
                    String.valueOf(compPieces.get(i).getPrice()),
                    String.valueOf(compPieces.get(i).getDesc()),
                    compPieces.get(i).getCodPiece()
            };
        }

        this.compPieces.getTable().setModel(new DefaultTableModel(
                data,
                new String[]{"Id", "Precio", "Descripción", "Código"}
        ));
    }

    public CtrlCompPieces(int idPiece) {
        this.compPieces = new CompPieces();
        this.windowConfig();

        this.pieceQueries = new PieceQueries();
        this.compPiecesQueries = new CompPiecesQueries();

        String title = "Piezas compuestas - Pieza " + this.pieceQueries.readPiece(idPiece).getCodPiece();
        TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title);
        this.compPieces.getScrollPane().setBorder(border);

        this.readCompPieces(idPiece);
    }
}