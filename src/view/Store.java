package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Store extends JFrame {
    private JPanel window;
    private JPanel nav;
    private JButton btnStore;
    private JButton btnShelf;
    private JButton btnStoke;
    private JButton btnPiece;

    public Store() {
        super();
        setContentPane(window);
    }

    public JPanel getWindow() {
        return this.window;
    }

    public JPanel getNav() {
        return this.nav;
    }

    public JButton getBtnStore() {
        return this.btnStore;
    }

    public JButton getBtnShelf() {
        return this.btnShelf;
    }

    public JButton getBtnStoke() {
        return this.btnStoke;
    }

    public JButton getBtnPiece() {
        return this.btnPiece;
    }
}
