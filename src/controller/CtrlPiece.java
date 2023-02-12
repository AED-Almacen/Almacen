package controller;

import model.PieceQueries;
import view.Piece;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CtrlPiece implements ActionListener {
    private Piece piece;
    private PieceQueries queries;

    private void windowConfig() {
        this.piece.setTitle("Piezas");
        this.piece.setLocationRelativeTo(null);
        this.piece.setSize(700, 400);
        this.piece.setVisible(true);
    }

    private void readPieces() {
        this.piece.getTextArea().setText("");

        ArrayList<model.Piece> pieces = this.queries.readPieces();

        if(pieces == null) {
            this.piece.getTextArea().append("No hay piezas en la base de datos.");
        }else{
            int i = 0;
            while(i < pieces.size()) {
                model.Piece piece = pieces.get(i);
                this.piece.getTextArea().append(
                        piece.getId() + ". \t" + piece.getPrice() + "\t" +
                                piece.getDesc() + "\t" + piece.getCodPiece() + "\n");
                i++;
            }
        }
    }

    public CtrlPiece() {
        this.piece = new Piece();
        windowConfig();

        this.queries = new PieceQueries();
        this.piece.getAddBtn().addActionListener(this);
        this.piece.getDropBtn().addActionListener(this);
        this.piece.getUpdateBtn().addActionListener(this);
        readPieces();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.piece.getAddBtn()) {
            try {
                float price = Float.parseFloat(piece.getPriceText().getText());
                String desc = piece.getDescText().getText();
                String codPiece = piece.getCodTex().getText();

                if (codPiece.equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "Error al añadir pieza. La pieza debe tener precio y código.");
                } else {
                    this.queries.createPiece(price, desc, codPiece);
                    readPieces();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al añadir pieza. La pieza debe tener precio y código.");
            }
        } else if (e.getSource() == this.piece.getDropBtn()) {
            try {
                this.queries.deletePiece(Integer.parseInt(piece.getIdText().getText()));
                readPieces();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al borrar pieza. Debes especificar el id de la pieza a borrar.");
            }
        } else if (e.getSource() == this.piece.getUpdateBtn()) {

            try {
                int id = Integer.parseInt(piece.getIdText().getText());
                float price = Float.parseFloat(piece.getPriceText().getText());
                String desc = piece.getDescText().getText();
                String codPiece = piece.getCodTex().getText();

                if (codPiece.equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "Error al añadir pieza. La pieza debe tener precio y código.");
                } else {
                    this.queries.updatePiece(id, price, desc, codPiece);
                    readPieces();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al actualizar la pieza. Debes especificar el id de la pieza a actualizar.");
            }
        }
    }
}
