package view;

import javax.swing.*;

public class Piece extends JFrame {
    private JPanel window;
    private JButton pieceButton;

    public Piece() {
        super();
        setContentPane(window);
    }

    public JPanel getWindow() {
        return window;
    }

    public JButton getPieceButton() {
        return pieceButton;
    }
}
