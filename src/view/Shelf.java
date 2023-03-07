package view;

import javax.swing.*;

public class Shelf extends JFrame {
    private JPanel window;
    private JButton addBtn;
    private JButton dropBtn;
    private JButton updateBtn;
    private JComboBox warehouseCombo;
    private JTextField codTxt;
    private JTable table;

    public Shelf() {
        super();
        setContentPane(window);
    }

    public JTextField getCodTxt() {
        return this.codTxt;
    }

    public JComboBox getWarehouseCombo() {
        return this.warehouseCombo;
    }

    public JTable getTable() {
        return this.table;
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

}
