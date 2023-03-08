package controller;

import model.CompPiecesQueries;
import model.Piece;
import model.PieceQueries;
import view.CompPieces;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class CtrlCompPieces implements ActionListener, MouseListener {
    private final CompPieces compPieces;
    private final CompPiecesQueries queries;
    private final PieceQueries pieceQueries;
    private final int idPiece;

    private void readCompPieces() {
        ArrayList<model.CompPieces> compPieces = this.queries.readCompPieces(this.idPiece);

        Object[][] data = new Object[compPieces.size()][];

        for (int i = 0; i < compPieces.size(); i++) {
            Piece piece = this.pieceQueries.readPiece(compPieces.get(i).getId_pieceComp());

            data[i] = new String[] {
                    String.valueOf(compPieces.get(i).getId()),
                    String.valueOf(piece.getId()),
                    String.valueOf(piece.getPrice()),
                    String.valueOf(piece.getDesc()),
                    piece.getCodPiece()
            };
        }

        this.compPieces.getTable().setModel(new DefaultTableModel(
                data,
                new String[]{"Id", "Id Pieza","Precio", "Descripción", "Código"}
        ));
    }

    public CtrlCompPieces(int idPiece) {
        this.compPieces = new CompPieces();
        this.idPiece = idPiece;

        this.queries = new CompPiecesQueries();
        this.pieceQueries = new PieceQueries();
    }

    public CompPieces getCompPieces() {
        return compPieces;
    }

    public void init() {
        Piece mainPiece = this.pieceQueries.readPiece(this.idPiece);
        this.compPieces.setTitle("Pieza " + mainPiece.getId() + " - " + mainPiece.getCodPiece());
        this.compPieces.setLocationRelativeTo(null);
        this.compPieces.setSize(500, 400);
        this.compPieces.setVisible(true);

        this.compPieces.getAddBtn().addActionListener(this);
        this.compPieces.getUpdateBtn().addActionListener(this);
        this.compPieces.getDropBtn().addActionListener(this);
        this.compPieces.getTable().addMouseListener(this);

        this.readCompPieces();
        ArrayList<Piece> pieces = pieceQueries.readPieces();

        for (Piece piece : pieces) {
            this.compPieces.getPiecesCombo().addItem(piece.getId() + " - " + piece.getCodPiece());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object comboSelected = this.compPieces.getPiecesCombo().getSelectedItem();

        if (e.getSource() == this.compPieces.getAddBtn()) {
            if (comboSelected != null) {
                int idCompPiece = Integer.parseInt(comboSelected.toString().split(" - ")[0]);
                this.queries.createCompPiece(this.idPiece, idCompPiece);

                this.readCompPieces();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Error al añadir pieza. Debe seleccionar una pieza.");
            }

        } else if (e.getSource() == this.compPieces.getUpdateBtn()) {
            try {
                int row = this.compPieces.getTable().getSelectedRow();
                int id = Integer.parseInt(this.compPieces.getTable().getValueAt(row, 0).toString());

                if (comboSelected != null) {
                    int idCompPiece = Integer.parseInt(comboSelected.toString().split(" - ")[0]);
                    this.queries.updateCompPiece(id, this.idPiece, idCompPiece);

                    this.readCompPieces();
                }

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al actualizar pieza. Debe seleccionar la pieza a actualizar.");
            }
        } else if (e.getSource() == this.compPieces.getDropBtn()) {
            try {
                int row = this.compPieces.getTable().getSelectedRow();
                int id = Integer.parseInt(this.compPieces.getTable().getValueAt(row, 0).toString());

                this.queries.deleteCompPiece(id);
                this.readCompPieces();

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al borrar pieza. Debe seleccionar la pieza a borrar.");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = this.compPieces.getTable().getSelectedRow();

        this.compPieces.getPiecesCombo().setSelectedItem(this.compPieces.getTable().getValueAt(row, 1) +
                " - " + this.compPieces.getTable().getValueAt(row, 4));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
