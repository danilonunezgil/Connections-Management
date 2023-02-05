package com.project.view.gui;

import com.project.controller.OracleService;
import com.project.controller.PostgresqlService;
import com.project.dto.AmigoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class MenuCrud extends javax.swing.JPanel {

    public MenuCrud(String conectadoA) {
        initComponents();
        SpinnerNumberModel nm = new SpinnerNumberModel();
        nm.setMinimum(1);
        campo_idAmigo.setModel(nm);
        campo_idAmigo.setValue(1);
        if ("Oracle".equals(conectadoA)) {
            conectado_a.setText(conectadoA);
        } else if ("PostgreSQL".equals(conectadoA)) {
            conectado_a.setText(conectadoA);
        }
        boton_actualizarAmigo.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo_connect_oracle1 = new javax.swing.JLabel();
        conectado_a = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_amigos = new javax.swing.JTable();
        boton_mostrarAmigos = new javax.swing.JButton();
        boton_amigoAleat = new javax.swing.JButton();
        boton_actualizarAmigo = new javax.swing.JButton();
        boton_eliminarAmigo = new javax.swing.JButton();
        label_IDAmigo = new javax.swing.JLabel();
        campo_idAmigo = new javax.swing.JSpinner();
        boton_savePoint = new javax.swing.JButton();
        boton_cargarPoint = new javax.swing.JButton();
        boton_commit = new javax.swing.JButton();
        boton_rollback = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(693, 610));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo_connect_oracle1.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        titulo_connect_oracle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_connect_oracle1.setText("CONECTADO A  ---> ");
        add(titulo_connect_oracle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 450, 60));

        conectado_a.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        conectado_a.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        conectado_a.setText("DB");
        add(conectado_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 230, 60));

        tabla_amigos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "APELLIDO", "TELEFONO", "DIRECCIÓN", "CORREO"
            }
        ));
        jScrollPane1.setViewportView(tabla_amigos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 520, 290));

        boton_mostrarAmigos.setText("MOSTRAR AMIGOS");
        boton_mostrarAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_mostrarAmigosActionPerformed(evt);
            }
        });
        add(boton_mostrarAmigos, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        boton_amigoAleat.setText("INSERTAR AMIGO ALEATORIO");
        boton_amigoAleat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_amigoAleatActionPerformed(evt);
            }
        });
        add(boton_amigoAleat, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        boton_actualizarAmigo.setText("ACTUALIZAR AMIGO");
        add(boton_actualizarAmigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        boton_eliminarAmigo.setText("ELIMINAR AMIGO");
        boton_eliminarAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_eliminarAmigoActionPerformed(evt);
            }
        });
        add(boton_eliminarAmigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        label_IDAmigo.setText("ID AMIGO");
        add(label_IDAmigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));
        add(campo_idAmigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 90, -1));

        boton_savePoint.setText("SAVE POINT");
        add(boton_savePoint, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, -1, -1));

        boton_cargarPoint.setText("CARGAR SAVE POINT");
        add(boton_cargarPoint, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, -1, -1));

        boton_commit.setText("COMMIT");
        add(boton_commit, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, -1, -1));

        boton_rollback.setText("ROLLBACK");
        add(boton_rollback, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void boton_mostrarAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_mostrarAmigosActionPerformed
        // TODO add your handling code here:
        List<AmigoDTO> amigos = new ArrayList<>();
        if ("Oracle".equals(conectado_a.getText())) {
            amigos = OracleService.getInstance().listarAmigo();
        } else if ("PostgreSQL".equals(conectado_a.getText())) {
            amigos = PostgresqlService.getInstance().listarAmigo();
        }

        Object[][] datos = new Object[amigos.size()][6];
        int i = 0;
        for (AmigoDTO amigo : amigos) {
            datos[i][0] = amigo.getId();
            datos[i][1] = amigo.getNombre();
            datos[i][2] = amigo.getApellido();
            datos[i][3] = amigo.getTelefono();
            datos[i][4] = amigo.getDireccion();
            datos[i][5] = amigo.getCorreo();
            i++;
        }

        String[] nombreColumnas = {"ID", "NOMBRE", "APELLIDO", "TELEFONO", "DIRECCIÓN", "CORREO"};
        tabla_amigos.setModel(new DefaultTableModel(datos, nombreColumnas));

    }//GEN-LAST:event_boton_mostrarAmigosActionPerformed

    private void boton_amigoAleatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_amigoAleatActionPerformed
        // TODO add your handling code here:
        AmigoDTO amigo = null;
        if ("Oracle".equals(conectado_a.getText())) {
            amigo = OracleService.getInstance().ingresarAmigo();
        } else if ("PostgreSQL".equals(conectado_a.getText())) {
            amigo = PostgresqlService.getInstance().ingresarAmigo();
        }
        System.out.println(amigo.getNombre() + " " + amigo.getApellido());
    }//GEN-LAST:event_boton_amigoAleatActionPerformed

    private void boton_eliminarAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_eliminarAmigoActionPerformed
        // TODO add your handling code here:
        if ("Oracle".equals(conectado_a.getText())) {
            OracleService.getInstance().eliminarAmigo(Integer.valueOf(campo_idAmigo.getValue().toString()));
        } else if ("PostgreSQL".equals(conectado_a.getText())) {
            PostgresqlService.getInstance().eliminarAmigo(Integer.valueOf(campo_idAmigo.getValue().toString()));

        }
    }//GEN-LAST:event_boton_eliminarAmigoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_actualizarAmigo;
    private javax.swing.JButton boton_amigoAleat;
    private javax.swing.JButton boton_cargarPoint;
    private javax.swing.JButton boton_commit;
    private javax.swing.JButton boton_eliminarAmigo;
    private javax.swing.JButton boton_mostrarAmigos;
    private javax.swing.JButton boton_rollback;
    private javax.swing.JButton boton_savePoint;
    private javax.swing.JSpinner campo_idAmigo;
    private javax.swing.JLabel conectado_a;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_IDAmigo;
    private javax.swing.JTable tabla_amigos;
    private javax.swing.JLabel titulo_connect_oracle1;
    // End of variables declaration//GEN-END:variables
}
