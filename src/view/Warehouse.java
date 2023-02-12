package view;

import javax.swing.*;

public class Warehouse extends JFrame {
    private JPanel window;
    private JButton wareHouseButton;

    public Warehouse() {
        super();
        setContentPane(window);
    }

    public JPanel getWindow() {
        return this.window;
    }

    public JButton getWareHouseButton() {
        return wareHouseButton;
    }
}
