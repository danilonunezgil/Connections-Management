/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.project.view.gui;

import com.project.controller.*;
import com.project.dto.AmigoDTO;
import javax.swing.JOptionPane;

public class VentanaEmergente extends javax.swing.JFrame {

    private String conectado_a;

    public VentanaEmergente(AmigoDTO amigo, String db) {
        initComponents();
        conectado_a = db;
        this.setTitle("Menú Actualizar Amigo");
        cargarDatosAmigo(amigo);
        
    }

    public void cargarDatosAmigo(AmigoDTO amigo) {
        campo_id.setText(amigo.getId().toString());
        campo_nombre.setText(amigo.getNombre().toString());
        campo_apellido.setText(amigo.getApellido().toString());
        campo_telefono.setText(amigo.getTelefono().toString());
        campo_direccion.setText(amigo.getDireccion().toString());
        campo_correo.setText(amigo.getCorreo().toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label_id = new javax.swing.JLabel();
        label_nombre = new javax.swing.JLabel();
        label_apellido = new javax.swing.JLabel();
        label_telefono = new javax.swing.JLabel();
        label_direccion = new javax.swing.JLabel();
        label_correo = new javax.swing.JLabel();
        campo_id = new javax.swing.JTextField();
        boton_actualizar = new javax.swing.JToggleButton();
        campo_nombre = new javax.swing.JTextField();
        campo_correo = new javax.swing.JTextField();
        campo_apellido = new javax.swing.JTextField();
        campo_telefono = new javax.swing.JTextField();
        campo_direccion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setText("ACTUALIZACIÓN DATOS AMIGO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        label_id.setText("ID");
        jPanel1.add(label_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        label_nombre.setText("NOMBRE");
        jPanel1.add(label_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        label_apellido.setText("APELLIDO");
        jPanel1.add(label_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        label_telefono.setText("TELEFONO");
        jPanel1.add(label_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        label_direccion.setText("DIRECCION");
        jPanel1.add(label_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        label_correo.setText("CORREO");
        jPanel1.add(label_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        campo_id.setText("jTextField1");
        jPanel1.add(campo_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 250, 30));

        boton_actualizar.setText("ACTUALIZAR");
        boton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_actualizarActionPerformed(evt);
            }
        });
        jPanel1.add(boton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, -1, -1));

        campo_nombre.setText("jTextField1");
        jPanel1.add(campo_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 250, 30));

        campo_correo.setText("jTextField1");
        jPanel1.add(campo_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 250, 30));

        campo_apellido.setText("jTextField1");
        jPanel1.add(campo_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 250, 30));

        campo_telefono.setText("jTextField1");
        jPanel1.add(campo_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 250, 30));

        campo_direccion.setText("jTextField1");
        jPanel1.add(campo_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 250, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_actualizarActionPerformed
        // TODO add your handling code here:
        Number id;
        String nombre, apellido, telefono, direccion, correo;

        id = Integer.parseInt(campo_id.getText());
        nombre = campo_nombre.getText();
        apellido = campo_apellido.getText();
        telefono = campo_telefono.getText();
        direccion = campo_direccion.getText();
        correo = campo_correo.getText();

        if (conectado_a == "Oracle") {
            OracleService.getInstance().actualizarAmigo(new AmigoDTO(id, nombre, apellido, telefono, direccion, correo));
        } else if (conectado_a == "PostgreSQL") {
            PostgresqlService.getInstance().actualizarAmigo(new AmigoDTO(id, nombre, apellido, telefono, direccion, correo));
        }

        JOptionPane.showMessageDialog(null, "Amigo actualizado");
        this.dispose();
    }//GEN-LAST:event_boton_actualizarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaEmergente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaEmergente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaEmergente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaEmergente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaEmergente(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton boton_actualizar;
    private javax.swing.JTextField campo_apellido;
    private javax.swing.JTextField campo_correo;
    private javax.swing.JTextField campo_direccion;
    private javax.swing.JTextField campo_id;
    private javax.swing.JTextField campo_nombre;
    private javax.swing.JTextField campo_telefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_apellido;
    private javax.swing.JLabel label_correo;
    private javax.swing.JLabel label_direccion;
    private javax.swing.JLabel label_id;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_telefono;
    // End of variables declaration//GEN-END:variables
}
