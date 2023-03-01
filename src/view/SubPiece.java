package view;

import javax.swing.*;

public class SubPiece extends JFrame {
    private JPanel window;
    private JScrollPane ScrollPane;
    private JTable table;

    public SubPiece() {
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
