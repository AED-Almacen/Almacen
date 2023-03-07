package view;

import javax.swing.*;

public class CompPieces extends JFrame {
    private JPanel window;
    private JScrollPane ScrollPane;
    private JTable table;
    private JComboBox piecesCombo;
    private JButton addBtn;
    private JButton dropBtn;
    private JButton updateBtn;

    public CompPieces() {
        super();
        setContentPane(this.window);
    }

    public JScrollPane getScrollPane() {
        return ScrollPane;
    }

    public JTable getTable() {
        return table;
    }

    public JComboBox getPiecesCombo() {
        return piecesCombo;
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public JButton getDropBtn() {
        return dropBtn;
    }

    public JButton getUpdateBtn() {
        return updateBtn;
    }
}
