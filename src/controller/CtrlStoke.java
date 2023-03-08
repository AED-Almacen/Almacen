package controller;

import model.*;
import view.Stoke;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class CtrlStoke implements ActionListener, MouseListener {
    private final Stoke stoke;
    private final StokeQueries queries;
    private  final PieceQueries pieceQueries;
    private final ShelfQueries shelfQueries;

    private void cleanText() {
        this.stoke.getAmountTxt().setText("");
    }

    private void readStokes() {
        ArrayList<model.Stoke> stokes = this.queries.readStokes();
        this.cleanText();

        Object[][] data = new Object[stokes.size()][];

        for (int i = 0; i < stokes.size(); i++) {
            Piece piece = this.pieceQueries.readPiece(stokes.get(i).getIdPiece());
            Shelf shelf = this.shelfQueries.readShelf(stokes.get(i).getIdShelf());

            data[i] = new String[] {
                    String.valueOf(stokes.get(i).getId()),
                    String.valueOf(stokes.get(i).getAmount()),
                    String.valueOf(piece.getId()),
                    String.valueOf(piece.getCodPiece()),
                    String.valueOf(shelf.getId()),
                    shelf.getCodShelf()
            };
        }

        this.stoke.getTable().setModel(new DefaultTableModel(
                data,
                new String[]{"Id", "Cantidad", "Id Pieza","Código Pieza", "Id Estantería", "Código Estantería"}
        ));
    }

    public CtrlStoke() {
        this.stoke = new Stoke();

        this.queries = new StokeQueries();
        this.pieceQueries = new PieceQueries();
        this.shelfQueries = new ShelfQueries();
    }

    public Stoke getStoke() {
        return stoke;
    }

    public void init() {
        this.stoke.setTitle("Stoke");
        this.stoke.setLocationRelativeTo(null);
        this.stoke.setSize(650, 400);
        this.stoke.setVisible(true);

        this.stoke.getAddBtn().addActionListener(this);
        this.stoke.getUpdateBtn().addActionListener(this);
        this.stoke.getDropBtn().addActionListener(this);
        this.stoke.getTable().addMouseListener(this);

        this.readStokes();

        ArrayList<Piece> pieces = this.pieceQueries.readPieces();
        ArrayList<Shelf> shelves = this.shelfQueries.readShelves();

        for (Piece piece : pieces) {
            this.stoke.getPieceCombo().addItem(piece.getId() + " - " + piece.getCodPiece());
        }

        for (Shelf shelf : shelves) {
            this.stoke.getShelfCombo().addItem(shelf.getId() + " - " + shelf.getCodShelf());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object pieceComboSelected = this.stoke.getPieceCombo().getSelectedItem();
        Object shelfComboSelected = this.stoke.getShelfCombo().getSelectedItem();

        if (e.getSource() == this.stoke.getAddBtn()) {
            try {
                if (pieceComboSelected != null && shelfComboSelected != null) {
                    int idPiece = Integer.parseInt(pieceComboSelected.toString().split(" - ")[0]);
                    int idShelf = Integer.parseInt(shelfComboSelected.toString().split(" - ")[0]);

                    this.queries.createStoke(Integer.parseInt(this.stoke.getAmountTxt().getText()), idPiece, idShelf);

                    this.readStokes();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error al añadir elemento stoke. Debe seleccionar una pieza y una estantería.");
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al añadir elemento stoke. Debe seleccionar una cantidad.");
            }

        } else if (e.getSource() == this.stoke.getUpdateBtn()) {
            try {
                int row = this.stoke.getTable().getSelectedRow();
                int id = Integer.parseInt(this.stoke.getTable().getValueAt(row, 0).toString());

                if (pieceComboSelected != null && shelfComboSelected != null) {
                    int idPiece = Integer.parseInt(pieceComboSelected.toString().split(" - ")[0]);
                    int idShelf = Integer.parseInt(shelfComboSelected.toString().split(" - ")[0]);

                    this.queries.updateStoke(id, Integer.parseInt(this.stoke.getAmountTxt().getText()), idPiece, idShelf);
                    this.readStokes();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error al actualizar elemento stoke. Debe seleccionar una pieza y una estantería.");
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al actualizar elemento stoke. Debe seleccionar el elemento stoke a actualizar.");
            }
        } else if (e.getSource() == this.stoke.getDropBtn()) {
            try {
                int row = this.stoke.getTable().getSelectedRow();
                int id = Integer.parseInt(this.stoke.getTable().getValueAt(row, 0).toString());

                this.queries.deleteStoke(id);
                this.readStokes();

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        "Error al borrar elemento stoke. Debe seleccionar el elemento stoke a borrar.");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = this.stoke.getTable().getSelectedRow();

        this.stoke.getPieceCombo().setSelectedItem(this.stoke.getTable().getValueAt(row, 2) +
                " - " + this.stoke.getTable().getValueAt(row, 2));
        this.stoke.getShelfCombo().setSelectedItem(this.stoke.getTable().getValueAt(row, 4) +
                " - " + this.stoke.getTable().getValueAt(row, 4));
        this.stoke.getAmountTxt().setText(this.stoke.getTable().getValueAt(row, 1).toString());
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
