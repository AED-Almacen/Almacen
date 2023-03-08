package view;

import javax.swing.*;

public class Store extends JFrame {
    private JPanel window;
    private JPanel nav;
    private JButton btnWarehouse;
    private JButton btnShelf;
    private JButton btnStoke;
    private JButton btnPiece;

    public Store() {
        super();
        setContentPane(this.window);
    }

    public JPanel getWindow() {
        return this.window;
    }

    public JPanel getNav() {
        return this.nav;
    }

    public JButton getBtnWarehouse() {
        return this.btnWarehouse;
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

    private void createUIComponents() {
        btnWarehouse = new JButton("", new ImageIcon("images/almacen.png"));
        btnShelf = new JButton("", new ImageIcon("images/estanteria.png"));
        btnStoke = new JButton("", new ImageIcon("images/stoke.png"));
        btnPiece = new JButton("", new ImageIcon("images/pieza.png"));
    }
}
