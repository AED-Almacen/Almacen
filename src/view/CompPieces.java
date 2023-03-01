package view;

import javax.swing.*;

public class CompPieces extends JFrame {
    private JPanel window;
    private JScrollPane ScrollPane;
    private JTable table;

    public CompPieces() {
        super();
        setContentPane(this.window);
    }

    public JScrollPane getScrollPane() {
        return ScrollPane;
    }

    public JTable getTable() {
        return table;
    }
}
