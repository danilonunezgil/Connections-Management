package com.project.view.gui;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Start extends javax.swing.JFrame {

    public Start() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("PROYECTO PROFUNDIZACIÓN SOFTWARE II");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/virtual.png")));
        pintarLogo("/com/project/view/gui/images/java-oracle-logo.png", 155, 156, logo_java);
        pintarLogo("/com/project/view/gui/images/unillanos-logo.png", 270, 90, logo_u);
        pintarLogo("/com/project/view/gui/images/software_logo.png", 400, 400, logo_software);
        
    }

    public void pintarLogo(String ruta, int ancho, int altura, JLabel etiqueta) {
        ImageIcon imagen = new ImageIcon(getClass().getResource(ruta));
        Icon fondo = new ImageIcon(imagen.getImage().getScaledInstance(ancho, altura, Image.SCALE_DEFAULT));
        etiqueta.setIcon(fondo);
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        ventana_total = new javax.swing.JPanel();
        panel_opciones = new javax.swing.JPanel();
        logo_java = new javax.swing.JLabel();
        logo_u = new javax.swing.JLabel();
        jLabel_main_menu = new javax.swing.JLabel();
        boton_oracle = new javax.swing.JButton();
        boton_postgres = new javax.swing.JButton();
        boton_cerrar = new javax.swing.JButton();
        opc_crud = new javax.swing.JRadioButton();
        opc_metodos = new javax.swing.JRadioButton();
        label_est = new javax.swing.JLabel();
        estado_conexion = new javax.swing.JLabel();
        opc_estudiantes = new javax.swing.JRadioButton();
        contenido = new javax.swing.JPanel();
        logo_software = new javax.swing.JLabel();
        titulo_admdata2 = new javax.swing.JLabel();
        titulo_admdata3 = new javax.swing.JLabel();
        titulo_admdata = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ventana_total.setBackground(new java.awt.Color(255, 255, 255));
        ventana_total.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_opciones.setBackground(new java.awt.Color(0, 153, 153));

        logo_java.setText("logo_java");

        jLabel_main_menu.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_main_menu.setText("MENÚ PRINCIPAL");

        boton_oracle.setText("ORACLE");
        boton_oracle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_oracleActionPerformed(evt);
            }
        });

        boton_postgres.setText("POSTGRESQL");
        boton_postgres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_postgresActionPerformed(evt);
            }
        });

        boton_cerrar.setText("CERRAR");
        boton_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_cerrarActionPerformed(evt);
            }
        });

        buttonGroup1.add(opc_crud);
        opc_crud.setText("CRUD & TRANSACCIONES");
        opc_crud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opc_crudActionPerformed(evt);
            }
        });

        buttonGroup1.add(opc_metodos);
        opc_metodos.setText("FUNCIONES & PROCEDIMIENTOS");
        opc_metodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opc_metodosActionPerformed(evt);
            }
        });

        label_est.setText("ESTADO DE LA CONEXIÓN:");

        estado_conexion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estado_conexion.setText("NO CONECTADO");

        buttonGroup1.add(opc_estudiantes);
        opc_estudiantes.setText("GESTIÓN DE ESTUDIANTES");
        opc_estudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opc_estudiantesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_opcionesLayout = new javax.swing.GroupLayout(panel_opciones);
        panel_opciones.setLayout(panel_opcionesLayout);
        panel_opcionesLayout.setHorizontalGroup(
            panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_opcionesLayout.createSequentialGroup()
                .addGroup(panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_opcionesLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(opc_crud)
                                .addComponent(opc_metodos)
                                .addComponent(opc_estudiantes))
                            .addComponent(jLabel_main_menu)))
                    .addGroup(panel_opcionesLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(logo_u, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_opcionesLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_opcionesLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(label_est))
                            .addGroup(panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(boton_postgres, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(boton_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(boton_oracle, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(logo_java, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panel_opcionesLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(estado_conexion, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panel_opcionesLayout.setVerticalGroup(
            panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_opcionesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(logo_u, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_main_menu)
                .addGap(18, 18, 18)
                .addComponent(opc_crud)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(opc_metodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(opc_estudiantes)
                .addGap(18, 18, 18)
                .addComponent(boton_oracle)
                .addGap(18, 18, 18)
                .addComponent(boton_postgres)
                .addGap(18, 18, 18)
                .addComponent(boton_cerrar)
                .addGap(22, 22, 22)
                .addComponent(logo_java, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_est)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(estado_conexion)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        ventana_total.add(panel_opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 620));

        contenido.setBackground(new java.awt.Color(255, 255, 255));

        logo_software.setText("jLabel1");

        titulo_admdata2.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        titulo_admdata2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_admdata2.setText("DE");

        titulo_admdata3.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        titulo_admdata3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_admdata3.setText("SISTEMA GESTIÓN");

        titulo_admdata.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        titulo_admdata.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_admdata.setText("DATOS");

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(titulo_admdata, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
            .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contenidoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titulo_admdata3, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(titulo_admdata2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(contenidoLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(logo_software, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(titulo_admdata, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(439, Short.MAX_VALUE))
            .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contenidoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titulo_admdata3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(contenidoLayout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(titulo_admdata2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(50, 50, 50)
                    .addComponent(logo_software, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        ventana_total.add(contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 730, 620));

        getContentPane().add(ventana_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 612));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_postgresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_postgresActionPerformed
        // TODO add your handling code here:
        if (opc_metodos.isSelected()) {
            estado_conexion.setText("FUNCIONANDO");
            MenuMetodos mdb = new MenuMetodos("PostgreSQL");
            mdb.setSize(760, 610);
            mdb.setLocation(0, 0);
            contenido.removeAll();
            contenido.add(mdb, BorderLayout.CENTER);
            contenido.revalidate();
            contenido.repaint();
        } else if (opc_crud.isSelected()) {
            estado_conexion.setText("FUNCIONANDO");
            MenuCrud mdb = new MenuCrud("PostgreSQL");
            mdb.setSize(760, 610);
            mdb.setLocation(0, 0);
            contenido.removeAll();
            contenido.add(mdb, BorderLayout.CENTER);
            contenido.revalidate();
            contenido.repaint();

        } else if (opc_estudiantes.isSelected()) {
            estado_conexion.setText("FUNCIONANDO");
            MenuEstudiantes me = new MenuEstudiantes("PostgreSQL");
            me.setSize(760, 610);
            me.setLocation(0, 0);
            contenido.removeAll();
            contenido.add(me, BorderLayout.CENTER);
            contenido.revalidate();
            contenido.repaint();

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione primero una opción");
        }
    }//GEN-LAST:event_boton_postgresActionPerformed

    private void boton_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_cerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_boton_cerrarActionPerformed

    private void boton_oracleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_oracleActionPerformed
        // TODO add your handling code here:
        if (opc_metodos.isSelected()) {
            estado_conexion.setText("FUNCIONANDO");
            MenuMetodos mdb = new MenuMetodos("Oracle");
            mdb.setSize(760, 610);
            mdb.setLocation(0, 0);
            contenido.removeAll();
            contenido.add(mdb, BorderLayout.CENTER);
            contenido.revalidate();
            contenido.repaint();

        } else if (opc_crud.isSelected()) {
            estado_conexion.setText("FUNCIONANDO");
            MenuCrud mdb = new MenuCrud("Oracle");
            mdb.setSize(760, 610);
            mdb.setLocation(0, 0);
            contenido.removeAll();
            contenido.add(mdb, BorderLayout.CENTER);
            contenido.revalidate();
            contenido.repaint();
        } else if (opc_estudiantes.isSelected()) {
            estado_conexion.setText("FUNCIONANDO");
            MenuEstudiantes me = new MenuEstudiantes("Oracle");
            me.setSize(760, 610);
            me.setLocation(0, 0);
            contenido.removeAll();
            contenido.add(me, BorderLayout.CENTER);
            contenido.revalidate();
            contenido.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione primero una opción");
        }
    }//GEN-LAST:event_boton_oracleActionPerformed

    private void opc_crudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opc_crudActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_opc_crudActionPerformed

    private void opc_metodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opc_metodosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opc_metodosActionPerformed

    private void opc_estudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opc_estudiantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opc_estudiantesActionPerformed

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
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_cerrar;
    private javax.swing.JButton boton_oracle;
    private javax.swing.JButton boton_postgres;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel contenido;
    private javax.swing.JLabel estado_conexion;
    private javax.swing.JLabel jLabel_main_menu;
    private javax.swing.JLabel label_est;
    private javax.swing.JLabel logo_java;
    private javax.swing.JLabel logo_software;
    private javax.swing.JLabel logo_u;
    private javax.swing.JRadioButton opc_crud;
    private javax.swing.JRadioButton opc_estudiantes;
    private javax.swing.JRadioButton opc_metodos;
    private javax.swing.JPanel panel_opciones;
    private javax.swing.JLabel titulo_admdata;
    private javax.swing.JLabel titulo_admdata2;
    private javax.swing.JLabel titulo_admdata3;
    private javax.swing.JPanel ventana_total;
    // End of variables declaration//GEN-END:variables
}
