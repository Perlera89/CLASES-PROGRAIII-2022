package com.william.clasesgenerales;

import service.*;
import Entidades.*;
import com.william.BD.Conexion;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmMain extends javax.swing.JFrame {

    int idEstudiantes[];
    int idMaterias[];

    public FrmMain() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTabla();
        cargarComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnConexion = new javax.swing.JButton();
        btnModelo = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstudiantes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        cbbEstudiantes = new javax.swing.JComboBox<>();
        cbbMaterias = new javax.swing.JComboBox<>();
        btnNota = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNota = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblInscritos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnConexion.setText("Conexion BD");
        btnConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConexionActionPerformed(evt);
            }
        });

        btnModelo.setText("Modelaje de Tabla");
        btnModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModeloActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellido");

        jLabel3.setText("Fecha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                .addGap(344, 344, 344))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnConexion, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(44, 44, 44))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btnConexion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar))
                .addContainerGap(162, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registro estudiante", jPanel1);

        tblEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblEstudiantes);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Notas registradas", jPanel4);

        cbbEstudiantes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbMaterias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnNota.setText("Insertar");
        btnNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotaActionPerformed(evt);
            }
        });

        jLabel4.setText("Estudiantes");

        jLabel5.setText("Materias");

        jLabel6.setText("Nota");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNota)
                            .addComponent(cbbEstudiantes, 0, 347, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel5))
                            .addComponent(txtNota)
                            .addComponent(cbbMaterias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel6)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(btnNota)
                .addGap(46, 46, 46))
        );

        jTabbedPane1.addTab("Registro de nota", jPanel2);

        tblInscritos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblInscritos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Estudiantes registrados", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Estudiante estudiante = new Estudiante();
        EstudianteDao estudiantes = new EstudianteDao();

        estudiante.setNombre(txtNombre.getText());
        estudiante.setApellido(txtApellido.getText());
        estudiante.setFechaNacimiento(txtFecha.getDate());
        estudiantes.agregarEstudiante(estudiante);
        
        JOptionPane.showMessageDialog(null, "Exito", "El estudiante se ha registrado con exito", JOptionPane.INFORMATION_MESSAGE);
        cargarTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModeloActionPerformed
        cargarTabla();

    }//GEN-LAST:event_btnModeloActionPerformed

    private void btnConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConexionActionPerformed

        Conexion ClaseDeConexion = new Conexion();

        ClaseDeConexion.getConecction();
    }//GEN-LAST:event_btnConexionActionPerformed

    private void btnNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotaActionPerformed
        NotaDao notas = new NotaDao();
        Nota nota = new Nota();
        nota.setIdEstudiante(idEstudiantes[cbbEstudiantes.getSelectedIndex()]);
        nota.setIdMateria(idMaterias[cbbMaterias.getSelectedIndex()]);
//        int valueMember = idEstudiantes[cbbEstudiantes.getSelectedIndex()];
//        int valueMember2 = idMaterias[cbbMaterias.getSelectedIndex()];
//        
//        System.out.println(valueMember);
//        System.out.println(valueMember2);
        
        nota.setNota(txtNota.getText());
        notas.agregarNota(nota);
        cargarTabla();
        JOptionPane.showMessageDialog(null, "La nota se ha registrado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnNotaActionPerformed

    public void cargarTabla() {
        EstudianteDao estudiantes = new EstudianteDao();
        String titulosEstudiantes[] = {"Nombre", "Apellido", "Fecha nacimiento"};
        DefaultTableModel modeloEstudiantes = new DefaultTableModel(null, titulosEstudiantes);
        Object filaEstudiante[] = new Object[3];
        for (var iteracion : estudiantes.listarEstudiantes()) {
            ///  Estudiante estBucle = (Estudiante) iterador.next();
            filaEstudiante[0] = iteracion.getNombre();
            filaEstudiante[1] = iteracion.getApellido();
            filaEstudiante[2] = iteracion.getFechaNacimiento();

            modeloEstudiantes.addRow(filaEstudiante);
        }
        tblInscritos.setModel(modeloEstudiantes);

        NotaDao notas = new NotaDao();
        String titulosNotas[] = {"Nombre", "Materia", "Nota"};
        DefaultTableModel modeloNotas = new DefaultTableModel(null, titulosNotas);
        String filaNoa[] = new String[3];
        for (var iteracion : notas.listarNotasEstudiantes()) {
            filaNoa[0] = iteracion.getNombre();
            filaNoa[1] = iteracion.getNombremateria();
            filaNoa[2] = iteracion.getNota();

            modeloNotas.addRow(filaNoa);
        }
        tblEstudiantes.setModel(modeloNotas);
    }

    public void cargarComboBox() {
        EstudianteDao estudiantes = new EstudianteDao();
        ArrayList<Estudiante> listadoEstudiantes = estudiantes.listarEstudiantes();
        Iterator iteratorEstudiantes = listadoEstudiantes.iterator();
        DefaultComboBoxModel modeloEstudiantes = new DefaultComboBoxModel();
        modeloEstudiantes.removeAllElements();
        cbbEstudiantes.removeAll();
        idEstudiantes = new int[listadoEstudiantes.size()];

        int contadorEstudiantes = 0;
        Estudiante estudiante;

        while (iteratorEstudiantes.hasNext()) {
            estudiante = (Estudiante) iteratorEstudiantes.next();
            idEstudiantes[contadorEstudiantes] = estudiante.getIdEstudiante();

            modeloEstudiantes.addElement(estudiante.getNombre());
            contadorEstudiantes++;

        }
        cbbEstudiantes.setModel(modeloEstudiantes);
        
        MateriaDao materias = new MateriaDao();
        ArrayList<Materia> listadoMaterias = materias.listarMaterias();
        Iterator iteratorMaterias = listadoMaterias.iterator();
        DefaultComboBoxModel modeloMaterias = new DefaultComboBoxModel();
        modeloMaterias.removeAllElements();
        cbbMaterias.removeAll();
        idMaterias = new int[listadoMaterias.size()];

        int contadorMaterias = 0;
        Materia materia;

        while (iteratorMaterias.hasNext()) {
            materia = (Materia) iteratorMaterias.next();
            idMaterias[contadorMaterias] = materia.getIdMateria();

            modeloMaterias.addElement(materia.getNombreMateria());
            contadorMaterias++;

        }
        cbbMaterias.setModel(modeloMaterias);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnConexion;
    private javax.swing.JButton btnModelo;
    private javax.swing.JButton btnNota;
    private javax.swing.JComboBox<String> cbbEstudiantes;
    private javax.swing.JComboBox<String> cbbMaterias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblEstudiantes;
    private javax.swing.JTable tblInscritos;
    private javax.swing.JTextField txtApellido;
    private com.toedter.calendar.JDateChooser txtFecha;
    public static javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNota;
    // End of variables declaration//GEN-END:variables
}
