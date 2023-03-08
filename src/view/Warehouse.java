package view;

import javax.swing.*;

public class Warehouse extends JFrame {
    private JPanel window;
    private JTextArea descriptionTxt;
    private JTextField addressTxt;
    private JTable table;
    private JButton addBtn;
    private JButton dropBtn;
    private JButton updateBtn;

    public Warehouse() {
        super();
        this.window.setSize(1000, 1000);
        setContentPane(window);
    }

    public JPanel getWindow() {
        return this.window;
    }

    public JTextArea getDescriptionTxt() {
        return this.descriptionTxt;
    }

    public JTextField getAddressTxt() {
        return this.addressTxt;
    }

    public JButton getAddBtn() {return this.addBtn;}

    public JButton getDropBtn() {return this.dropBtn;}

    public JButton getUpdateBtn() {return this.updateBtn;}

    public JTable getTable() {
        return this.table;
    }
}
