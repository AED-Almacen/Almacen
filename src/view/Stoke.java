package view;

import javax.swing.*;

public class Stoke extends JFrame{
    private JPanel window;
    private JComboBox pieceCombo;
    private JComboBox shelfCombo;
    private JTextField amountTxt;
    private JButton addBtn;
    private JButton dropBtn;
    private JButton updateBtn;
    private JTable table;

    public Stoke() {
        super();
        setContentPane(window);
    }

    public JComboBox getPieceCombo() {
        return this.pieceCombo;
    }

    public JComboBox getShelfCombo() {
        return this.shelfCombo;
    }

    public JTextField getAmountTxt() {
        return this.amountTxt;
    }

    public JButton getAddBtn() {
        return this.addBtn;
    }

    public JButton getDropBtn() {
        return this.dropBtn;
    }

    public JButton getUpdateBtn() {
        return this.updateBtn;
    }

    public JTable getTable() {
        return this.table;
    }
}
