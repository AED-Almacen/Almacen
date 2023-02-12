package view;

import javax.swing.*;

public class Warehouse extends JFrame {
    private JPanel window;
    private JButton addBtn;
    private JButton dropBtn;
    private JButton updateBtn;
    private JTextArea textArea1;
    private JTextField idText;
    private JTextField descriptionText;
    private JTextField addresText;


    public void setTextArea1(JTextArea textArea1) {
        this.textArea1 = textArea1;
    }

    public Warehouse() {
        super();
        this.window.setSize(1000, 1000);
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

    public JTextField getDescriptionText() {
        return descriptionText;
    }

    public JTextField getAddresText() {
        return addresText;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
