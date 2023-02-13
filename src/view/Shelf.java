package view;

import javax.swing.*;

public class Shelf extends JFrame{
    private JPanel window;
    private JButton addBtn;
    private JButton dropBtn;
    private JButton updateBtn;
    private JTextArea textArea1;
    private JComboBox warehouseCombo;
    private JTextField codShelfText;



    private JTextField idText;


    public void setTextArea1(JTextArea textArea1) {
        this.textArea1 = textArea1;
    }



    public Shelf() {
        super();
        this.window.setSize(1500, 1000);
        setContentPane(window);
    }

    public JPanel getWindow() {
        return this.window;
    }

    public JButton getAddBtn() {return addBtn;}
    public JButton getDropBtn() {return dropBtn;}
    public JButton getUpdateBtn() {return updateBtn;}

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public JTextField getIdText() {
        return idText;
    }

    public JComboBox getWarehouseCombo() {return warehouseCombo;}

    public JTextField getCodShelfText() {return codShelfText;}
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
