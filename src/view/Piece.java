package view;

import javax.swing.*;

public class Piece extends JFrame {
    private JPanel window;
    private JTextField idText;
    private JTextField priceText;
    private JTextField descText;
    private JTextField codTex;
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

    public JTextField getIdText() {
        return idText;
    }

    public JTextField getPriceText() {
        return priceText;
    }

    public JTextField getDescText() {
        return descText;
    }

    public JTextField getCodTex() {
        return codTex;
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
