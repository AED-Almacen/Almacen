package controller;

import model.PieceQueries;
import view.Piece;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CtrlPiece implements ActionListener {
    private final Piece piece;
    private final PieceQueries queries;

    private void windowConfig() {
        this.piece.setTitle("Piezas");
        this.piece.setLocationRelativeTo(null);
        this.piece.setSize(700, 400);
        this.piece.setVisible(true);
    }

    private void cleanText() {
        this.piece.getIdText().setText("");
        this.piece.getPriceText().setText("");
        this.piece.getDescText().setText("");
        this.piece.getCodTex().setText("");
    }

    private void readPieces() {
        ArrayList<model.Piece> pieces = this.queries.readPieces();
        this.cleanText();

        Object[][] data = new Object[pieces.size()][];

        for (int i = 0; i < pieces.size(); i++) {
            data[i] = new String[]{
                    String.valueOf(pieces.get(i).getId()),
                    String.valueOf(pieces.get(i).getPrice()),
                    String.valueOf(pieces.get(i).getDesc()),
                    pieces.get(i).getCodPiece()
            };
        }

        this.piece.getTable().setModel(new DefaultTableModel(
                data,
                new String[]{"Id", "Precio", "Descripción", "Código"}
        ));
    }

    public CtrlPiece() {
        this.piece = new Piece();
        windowConfig();

        this.queries = new PieceQueries();
        this.piece.getAddBtn().addActionListener(this);
        this.piece.getDropBtn().addActionListener(this);
        this.piece.getUpdateBtn().addActionListener(this);
        this.piece.getSubPieceBtn().addActionListener(this);
        this.readPieces();
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
                    this.readPieces();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al añadir pieza. La pieza debe tener precio y código.");
            }
        } else if (e.getSource() == this.piece.getDropBtn()) {
            try {
                int id = Integer.parseInt(piece.getIdText().getText());

                if (this.queries.readPiece(id) == null) {
                    JOptionPane.showMessageDialog(null,
                            "Error al borrar pieza. El id no es correcto.");
                } else {
                    this.queries.deletePiece(id);
                    this.readPieces();
                }

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
                } else if (this.queries.readPiece(id) == null)  {
                    JOptionPane.showMessageDialog(null,
                            "Error al actualizar la pieza. El id no es correcto.");
                } else {
                    this.queries.updatePiece(id, price, desc, codPiece);
                    this.readPieces();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al actualizar la pieza. Debes especificar el id de la pieza a actualizar.");
            }
        } else if (e.getSource() == this.piece.getSubPieceBtn()) {
            new CtrlSubPiece();
        }
    }
}
