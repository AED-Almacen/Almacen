package controller;

import model.PieceQueries;
import view.Piece;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlPiece implements ActionListener {
    private Piece piece;
    private PieceQueries queries;

    private void windowConfig() {
        this.piece.setTitle("Piezas");
        this.piece.setLocationRelativeTo(null);
        this.piece.setSize(400, 400);
        this.piece.setVisible(true);
    }

    public CtrlPiece() {
        this.piece = new Piece();
        windowConfig();

        this.queries = new PieceQueries();
        this.piece.getPieceButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("pieza");
    }
}
