package test;

import javax.swing.*;
import java.awt.event.*;
import Beans.*;
import Pojos.*;

public class Lamina extends JPanel implements ActionListener{
    JButton ingresarBtn = new JButton("Ingresar");

    JLabel userLbl = new JLabel("Usuario");
    JLabel passLbl = new JLabel("Password");

    JTextField userTxt = new JTextField(25);
    JTextField passTxt = new JTextField(25);

    public Lamina(){
        add(userLbl);
        add(userTxt);
        add(passLbl);
        add(passTxt);
        add(ingresarBtn);


        ingresarBtn.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Estudiante estudiante = new Estudiante();
        String user = userTxt.getText();
        String pass = passTxt.getText();

        estudiante.setUsername(user);
        estudiante.setPassword(pass);

        Acceso acceso = new Acceso();
        int accesoCorrecto = acceso.acceso(estudiante);

        if(accesoCorrecto == 1){
            JOptionPane.showMessageDialog(null, "Bienvenido");
        }

        else{
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
        }
    }
}