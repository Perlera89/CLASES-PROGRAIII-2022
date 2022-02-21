package test;

import javax.swing.*;
import java.awt.event.*;

class Formulario extends JFrame{
    public Formulario(){
        setTitle("Login");
        setBounds(0, 0, 400, 300);
        setResizable(false);
        setLocationRelativeTo(null);

        Lamina lamina = new Lamina();
        add(lamina);
    }
}

