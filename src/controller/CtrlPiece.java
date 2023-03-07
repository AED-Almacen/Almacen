package controller;

import model.PieceQueries;
import view.Piece;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class CtrlPiece implements ActionListener, MouseListener {
    private final Piece piece;
    private final PieceQueries queries;

    private void windowConfig() {
        this.piece.setTitle("Piezas");
        this.piece.setLocationRelativeTo(null);
        this.piece.setSize(700, 400);
        this.piece.setVisible(true);
    }

    private void cleanText() {
        this.piece.getPriceTxt().setText("");
        this.piece.getDescTxt().setText("");
        this.piece.getCodTxt().setText("");
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
        this.piece.getTable().addMouseListener(this);
        this.readPieces();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.piece.getAddBtn()) {
            try {
                float price = Float.parseFloat(piece.getPriceTxt().getText());
                String desc = piece.getDescTxt().getText();
                String codPiece = piece.getCodTxt().getText();

                this.queries.createPiece(price, desc, codPiece);
                this.readPieces();

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al añadir pieza. La pieza debe tener código y precio.");
            }
        } else if (e.getSource() == this.piece.getDropBtn()) {
            try {
                int fila = this.piece.getTable().getSelectedRow();
                int id = Integer.parseInt(this.piece.getTable().getValueAt(fila, 0).toString());

                this.queries.deletePiece(id);
                this.readPieces();

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al borrar pieza. Debe seleccionar la pieza a borrar.");
            }
        } else if (e.getSource() == this.piece.getUpdateBtn()) {
            try {
                int fila = this.piece.getTable().getSelectedRow();
                int id = Integer.parseInt(this.piece.getTable().getValueAt(fila, 0).toString());

                float price = Float.parseFloat(piece.getPriceTxt().getText());
                String desc = piece.getDescTxt().getText();
                String codPiece = piece.getCodTxt().getText();

                this.queries.updatePiece(id, price, desc, codPiece);
                this.readPieces();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al actualizar la pieza. Debe seleccionar la pieza a actualizar y .");
            }
        } else if (e.getSource() == this.piece.getSubPieceBtn()) {
            try {
                int fila = this.piece.getTable().getSelectedRow();
                int id = Integer.parseInt(this.piece.getTable().getValueAt(fila, 0).toString());

                new CtrlCompPieces(id);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al encontrar la pieza. Debe seleccionar la pieza para acceder a sus subpiezas.");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = this.piece.getTable().getSelectedRow();

        this.piece.getPriceTxt().setText(this.piece.getTable().getValueAt(fila, 1).toString());
        this.piece.getDescTxt().setText(this.piece.getTable().getValueAt(fila, 2).toString());
        this.piece.getCodTxt().setText(this.piece.getTable().getValueAt(fila, 3).toString());
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
