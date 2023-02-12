package view;

import javax.swing.*;

public class Stoke extends JFrame{
    private JPanel window;
    private JButton stokeButton;

    public Stoke() {
        super();
        setContentPane(window);
    }

    public JPanel getWindow() {
        return window;
    }

    public JButton getStokeButton() {
        return stokeButton;
    }
}
