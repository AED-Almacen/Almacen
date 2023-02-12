package view;

import javax.swing.*;

public class Shelf extends JFrame{
    private JPanel window;
    private JButton shelfButton;

    public Shelf() {
        super();
        setContentPane(window);
    }

    public JPanel getWindow() {
        return window;
    }

    public JButton getShelfButton() {
        return shelfButton;
    }
}
