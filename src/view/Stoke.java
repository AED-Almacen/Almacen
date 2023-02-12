package view;

import javax.swing.*;

public class Stoke extends JFrame{
    private JPanel window;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTextArea textArea1;
    private JButton stokeButton;

    public Stoke() {
        super();
        setContentPane(window);
    }

    public JPanel getWindow() {
        return window;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public JTextField getTextField3() {
        return textField3;
    }

    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public JButton getButton3() {
        return button3;
    }

    public JTextArea getTextArea1Stoke() {
        return textArea1;
    }

    public JButton getStokeButton() {
        return stokeButton;
    }
}
