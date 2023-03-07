package view;

import javax.swing.*;

public class Piece extends JFrame {
    private JPanel window;
    private JTextField priceTxt;
    private JTextArea descTxt;
    private JTextField codTxt;
    private JButton addBtn;
    private JButton dropBtn;
    private JButton updateBtn;
    private JTable table;
    private JButton subPieceBtn;
    private JScrollPane ScrollPane;

    public Piece() {
        super();
        setContentPane(this.window);
    }

    public JTextField getPriceTxt() {
        return this.priceTxt;
    }

    public JTextArea getDescTxt() {
        return this.descTxt;
    }

    public JTextField getCodTxt() {
        return this.codTxt;
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

    public JButton getSubPieceBtn() {
        return subPieceBtn;
    }

    public JTable getTable() {
        return table;
    }

}
