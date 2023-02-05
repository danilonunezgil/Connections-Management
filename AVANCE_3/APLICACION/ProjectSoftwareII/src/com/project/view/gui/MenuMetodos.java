
package com.project.view.gui;

import com.project.controller.*;
import com.project.dto.InfoStudentDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class MenuMetodos extends javax.swing.JPanel {

    /**
     * Creates new form MenuDB
     */
    public MenuMetodos(String conectadoA) {
        initComponents();

        if ("Oracle".equals(conectadoA)) {
            conectado_a.setText(conectadoA);
        } else if ("PostgreSQL".equals(conectadoA)) {
            conectado_a.setText(conectadoA);
        }
        configurarSpinner();

    }

    public void configurarSpinner() {
        SpinnerNumberModel nm = new SpinnerNumberModel();
        SpinnerNumberModel nm1 = new SpinnerNumberModel();
        nm.setMinimum(0);
        nm1.setMinimum(0);
        campo_promEst.setModel(nm);
        campo_promEst.setValue(1);
        campo_promElem.setModel(nm1);
        campo_promElem.setValue(1);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        conectado_a = new javax.swing.JLabel();
        label_nums = new javax.swing.JLabel();
        label_promedioElem = new javax.swing.JLabel();
        campo_promElem = new javax.swing.JSpinner();
        label_codEst = new javax.swing.JLabel();
        label_codEst1 = new javax.swing.JLabel();
        campo_promEst = new javax.swing.JSpinner();
        label_prom = new javax.swing.JLabel();
        label_codElem = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        campo_num1 = new javax.swing.JSpinner();
        campo_num2 = new javax.swing.JSpinner();
        comparacion_nums = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_info = new javax.swing.JTable();
        boton_promEst = new javax.swing.JButton();
        boton_promElem = new javax.swing.JButton();
        boton_compararNums = new javax.swing.JButton();
        cargar_info = new javax.swing.JButton();
        label_infoEst = new javax.swing.JLabel();
        titulo_connect_oracle1 = new javax.swing.JLabel();
        result_promEst = new javax.swing.JLabel();
        result_promElem = new javax.swing.JLabel();
        label_codElem1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        label_infoEst1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(730, 610));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        conectado_a.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        conectado_a.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        conectado_a.setText("DB");
        add(conectado_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 230, 60));

        label_nums.setText("INGRESE LOS NÚMEROS ENTEROS:");
        add(label_nums, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        label_promedioElem.setText("EL PRECIO PROMEDIO ES: ");
        add(label_promedioElem, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, -1, -1));

        campo_promElem.setValue(1);
        add(campo_promElem, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 80, -1));

        label_codEst.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_codEst.setText("ESTUDIANTE");
        add(label_codEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));

        label_codEst1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_codEst1.setText("INGRESE EL CÓDIGO DEL");
        add(label_codEst1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));

        campo_promEst.setValue(1);
        add(campo_promEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 80, -1));

        label_prom.setText("EL PROMEDIO DE CARRERA ES: ");
        add(label_prom, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, -1));

        label_codElem.setText("ELEMENTO DE PROTECCIÓN");
        add(label_codElem, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, -1, -1));

        jLabel6.setText("NUM1");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, -1, -1));

        jLabel7.setText("NUM2");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, -1, -1));
        add(campo_num1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 80, -1));
        add(campo_num2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 80, -1));

        comparacion_nums.setText("RESULTADO COMPARACIÓN");
        add(comparacion_nums, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, -1, -1));

        tabla_info.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "FACULTAD", "PROGRAMA", "ESTUDIANTE", "PROMEDIO", "MATRICULA", "AÑO", "PERIODO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_info);
        if (tabla_info.getColumnModel().getColumnCount() > 0) {
            tabla_info.getColumnModel().getColumn(0).setMaxWidth(90);
            tabla_info.getColumnModel().getColumn(4).setMaxWidth(100);
            tabla_info.getColumnModel().getColumn(5).setMaxWidth(120);
            tabla_info.getColumnModel().getColumn(6).setMaxWidth(90);
            tabla_info.getColumnModel().getColumn(7).setMaxWidth(80);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 680, 230));

        boton_promEst.setText("PROMEDIO ESTUDIANTE");
        boton_promEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_promEstActionPerformed(evt);
            }
        });
        add(boton_promEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        boton_promElem.setText("PROMEDIO ELEMENTO");
        boton_promElem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_promElemActionPerformed(evt);
            }
        });
        add(boton_promElem, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, -1, -1));

        boton_compararNums.setText("COMPARAR NUMS");
        boton_compararNums.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_compararNumsActionPerformed(evt);
            }
        });
        add(boton_compararNums, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, -1, -1));

        cargar_info.setText("CARGAR INFO");
        cargar_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargar_infoActionPerformed(evt);
            }
        });
        add(cargar_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, -1, -1));

        label_infoEst.setText("ESTUDIANTES");
        add(label_infoEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, -1, -1));

        titulo_connect_oracle1.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        titulo_connect_oracle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_connect_oracle1.setText("CONECTADO A  ---> ");
        add(titulo_connect_oracle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 450, 60));

        result_promEst.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        result_promEst.setText("RESULTADO");
        add(result_promEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, -1));

        result_promElem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        result_promElem.setText("RESULTADO");
        add(result_promElem, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, -1, -1));

        label_codElem1.setText("INGRESE EL CÓDIGO DEL");
        add(label_codElem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("PROCEDIMIENTOS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("------>");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        label_infoEst1.setText("INFORMACIÓN");
        add(label_infoEst1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("FUNCIONES");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("------>");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void boton_promElemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_promElemActionPerformed
        // TODO add your handling code here:
        Integer promedioElem = 0;
        if ("Oracle".equals(conectado_a.getText())) {
            promedioElem = OracleService.getInstance().precioPromedio(Integer.valueOf(campo_promElem.getValue().toString()));
            result_promElem.setText(promedioElem.toString());
        } else if ("PostgreSQL".equals(conectado_a.getText())) {
            promedioElem = PostgresqlService.getInstance().precioPromedio(Integer.valueOf(campo_promElem.getValue().toString()));
            result_promElem.setText(promedioElem.toString());
        }
    }//GEN-LAST:event_boton_promElemActionPerformed

    private void boton_promEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_promEstActionPerformed
        // TODO add your handling code here:
        Number promedio = 0;
        if ("Oracle".equals(conectado_a.getText())) {
            promedio = OracleService.getInstance().promedioCarrera(Integer.valueOf(campo_promEst.getValue().toString()));
            result_promEst.setText(promedio.toString());
        } else if ("PostgreSQL".equals(conectado_a.getText())) {
            promedio = PostgresqlService.getInstance().promedioCarrera(Integer.valueOf(campo_promEst.getValue().toString()));
            result_promEst.setText(promedio.toString());
        }
    }//GEN-LAST:event_boton_promEstActionPerformed

    private void boton_compararNumsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_compararNumsActionPerformed
        // TODO add your handling code here:
        String comparacion = "";
        if ("Oracle".equals(conectado_a.getText())) {
            comparacion = OracleService.getInstance().compararNumeros(Integer.valueOf(campo_num1.getValue().toString()), Integer.valueOf(campo_num2.getValue().toString()));
            comparacion_nums.setText(comparacion);
        } else if ("PostgreSQL".equals(conectado_a.getText())) {
            comparacion = PostgresqlService.getInstance().compararNumeros(Integer.valueOf(campo_num1.getValue().toString()), Integer.valueOf(campo_num2.getValue().toString()));
            comparacion_nums.setText(comparacion);
        }
    }//GEN-LAST:event_boton_compararNumsActionPerformed

    private void cargar_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargar_infoActionPerformed
        // TODO add your handling code here:
        List<InfoStudentDTO> informacion_estudiantes = new ArrayList<>();
        if ("Oracle".equals(conectado_a.getText())) {
            informacion_estudiantes = OracleService.getInstance().informacionEstudiantes();
        } else if ("PostgreSQL".equals(conectado_a.getText())) {
            informacion_estudiantes = PostgresqlService.getInstance().informacionEstudiantes();

        }
        Object[][] datos = new Object[informacion_estudiantes.size()][8];
        int i = 0;
        for (InfoStudentDTO estudiante : informacion_estudiantes) {
            datos[i][0] = estudiante.getCodigo();
            datos[i][1] = estudiante.getFacultad();
            datos[i][2] = estudiante.getPrograma();
            datos[i][3] = estudiante.getEstudiante();
            datos[i][4] = estudiante.getPromedio();
            datos[i][5] = estudiante.getMatriculado();
            datos[i][6] = estudiante.getAno();
            datos[i][7] = estudiante.getPeriodo();
            i++;
        }

        String[] nombreColumnas = {"CÓDIGO", "FACULTAD", "PROGRAMAS", "ESTUDIANTE", "PROMEDIO", "MATRICULADO", "AÑO", "PERIODO"};
        tabla_info.setModel(new DefaultTableModel(datos, nombreColumnas));
    }//GEN-LAST:event_cargar_infoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_compararNums;
    private javax.swing.JButton boton_promElem;
    private javax.swing.JButton boton_promEst;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JSpinner campo_num1;
    private javax.swing.JSpinner campo_num2;
    private javax.swing.JSpinner campo_promElem;
    private javax.swing.JSpinner campo_promEst;
    private javax.swing.JButton cargar_info;
    private javax.swing.JLabel comparacion_nums;
    private javax.swing.JLabel conectado_a;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_codElem;
    private javax.swing.JLabel label_codElem1;
    private javax.swing.JLabel label_codEst;
    private javax.swing.JLabel label_codEst1;
    private javax.swing.JLabel label_infoEst;
    private javax.swing.JLabel label_infoEst1;
    private javax.swing.JLabel label_nums;
    private javax.swing.JLabel label_prom;
    private javax.swing.JLabel label_promedioElem;
    private javax.swing.JLabel result_promElem;
    private javax.swing.JLabel result_promEst;
    private javax.swing.JTable tabla_info;
    private javax.swing.JLabel titulo_connect_oracle1;
    // End of variables declaration//GEN-END:variables
}
