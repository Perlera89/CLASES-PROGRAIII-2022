package test;

import data.*;
import domain.Estudiante;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Registro extends JFrame{
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }
    
    public Registro(){
        setTitle("Registro Estudiantes");
        setSize(500, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        initComponents();
    }
    
    private void initComponents(){
        initPanels();
        initLabels();
        initTextFields();
        initButtons();
        initTables();
        cargar();
    }
    
    private void initPanels(){
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
    }
    
    private void initLabels(){
        lblNombre = new JLabel();
        lblNombre.setText("Nombre:");
        lblNombre.setBounds(50, 50, 100, 30);
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 15));
        
        lblApellido = new JLabel();
        lblApellido.setText("Apellido:");
        lblApellido.setBounds(50, 130, 100, 30);
        lblApellido.setFont(new Font("Arial", Font.PLAIN, 15));
        
        panel.add(lblNombre);
        panel.add(lblApellido);
    }
    
    private void initTextFields(){
        txtNombre = new JTextField();
        txtNombre.setBounds(50, 80, 400, 30);
        txtNombre.setFont(new Font("Arial", Font.PLAIN, 15));
        
        txtApellido = new JTextField();
        txtApellido.setBounds(50, 160, 400, 30);
        txtApellido.setFont(new Font("Arial", Font.PLAIN, 15));
        
        panel.add(txtNombre);
        panel.add(txtApellido);
    }
    
    private void initButtons(){
        btnActualizar = new JButton();
        btnActualizar.setText("Actualizar");
        btnActualizar.setBounds(200, 575, 100, 30);
        btnActualizar.setFont(new Font("Arial", Font.PLAIN, 15));

        btnSeleccionar = new JButton();
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setBounds(50, 575, 120, 30);
        btnSeleccionar.setFont(new Font("Arial", Font.PLAIN, 15));

        btnEliminar = new JButton();
        btnEliminar.setText("Eliminar");
        btnEliminar.setBounds(300, 575, 100, 30);
        btnEliminar.setFont(new Font("Arial", Font.PLAIN, 15));

        btnInsertar = new JButton();
        btnInsertar.setText("Insertar");
        btnInsertar.setBounds(50, 210, 100, 30);
        btnInsertar.setFont(new Font("Arial", Font.PLAIN, 15));
        
        panel.add(btnInsertar);
        panel.add(btnSeleccionar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);

        btnInsertarActionPerformed();
        btnSeleccionarActionPerformed();
        btnActualizarActionPerformed();
        btnEliminarActionPerformed();
    }
    
    private void initTables(){
        String titulos[] = {"Nombre", "Materia","Nota"};
        modeloTabla = new DefaultTableModel(null, titulos);
        
        tblEstudiantes = new JTable(modeloTabla);
        tblEstudiantes.setBounds(50, 260, 350, 300);
        
        panel.add(tblEstudiantes);
        
        JScrollPane scroll = new JScrollPane(tblEstudiantes, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(50, 260, 350, 300);
        
        panel.add(scroll);
    } 
    
    private void btnInsertarActionPerformed(){
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Estudiante estudiante = new Estudiante();
                    EstudianteDao estudiantes = new EstudianteDao();
                    
                    estudiante.setNombre(txtNombre.getText());
                    estudiante.setApellido(txtApellido.getText());
                    
                    estudiantes.insertar(estudiante);
                    isSeleccionado = false;
                    
                    cargar();
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        
        btnInsertar.addActionListener(actionListener);
    }
    
    private void btnSeleccionarActionPerformed(){
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isSeleccionado = true;

                try{
                    id = Integer.parseInt(tblEstudiantes.getValueAt(tblEstudiantes.getSelectedRow(), 0).toString());
                    txtNombre.setText(tblEstudiantes.getValueAt(tblEstudiantes.getSelectedRow(), 1).toString());
                    txtApellido.setText(tblEstudiantes.getValueAt(tblEstudiantes.getSelectedRow(), 2).toString());

                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        
        btnSeleccionar.addActionListener(actionListener);
    }

    private void btnActualizarActionPerformed(){
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(isSeleccionado == true){
                        EstudianteDao estudiantes = new EstudianteDao();
                        int idEstudiante = id;
                        String nombre = txtNombre.getText();
                        String apellido = txtApellido.getText();
                        
                        int row = tblEstudiantes.getSelectedRow();

                        tblEstudiantes.setValueAt(nombre, row, 1);
                        tblEstudiantes.setValueAt(apellido, row, 2);

                        Estudiante estudiante = new Estudiante(idEstudiante, nombre, apellido);
                        estudiantes.actualizar(estudiante);

                        isSeleccionado = false;

                        cargar();
                    }

                    else{
                        JOptionPane.showMessageDialog(null, "Seleccione una fila", "Aviso", 3);
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error" + ex.getMessage());
                }
            }
        };
        
        btnActualizar.addActionListener(actionListener);
    }

    private void btnEliminarActionPerformed(){
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(isSeleccionado == true){
                        EstudianteDao estudiantes = new EstudianteDao();
                        
                        int idEstudiante = id;
                        Estudiante estudiante = new Estudiante(idEstudiante);
                        estudiantes.eliminar(estudiante);

                        isSeleccionado = false;
                        cargar();
                    }

                    else{
                        JOptionPane.showMessageDialog(null, "Seleccione una fila", "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
                }
            }
        };
        
        btnEliminar.addActionListener(actionListener);
    }
    
    private void cargar(){
        limpiar();
        
        NotaDao notas = new NotaDao();

        Object fila[] = new Object[3];
        
        for(var listado : notas.seleccionar()){
            fila[0] = listado.getNombre();
            fila[1] = listado.getMateria();
            fila[2] = listado.getNota();
            
            modeloTabla.addRow(fila);
        }
        

    }

    private void limpiar(){
        for(int i = 0; i < tblEstudiantes.getRowCount(); i++){
            modeloTabla.removeRow(i);
            i -= 1;
        }

        txtNombre.setText("");
        txtApellido.setText("");
    }
    
    DefaultTableModel  modeloTabla;
    public boolean isSeleccionado = false;
    public int id = 0;

    //Componentes
    private JPanel panel;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JButton btnInsertar;
    private JButton btnSeleccionar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JTable tblEstudiantes;
}
