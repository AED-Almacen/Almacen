package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CRUD_Pieza extends Container {
    private JButton crearButton;
    private JButton eliminarButton;
    private JTextField textFieldDesc;
    private JList listaPiezas;
    private JTextField textFieldPrecio;
public CRUD_Pieza() {
    crearButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Adios");
        }
    });
}
}
