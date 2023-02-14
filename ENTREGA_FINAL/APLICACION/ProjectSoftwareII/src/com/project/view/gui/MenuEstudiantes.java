package com.project.view.gui;

import libreria.controller.OracleService;
import libreria.controller.PostgresqlService;
import libreria.dto.EstudianteDTO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javax.swing.SpinnerNumberModel;

public final class MenuEstudiantes extends javax.swing.JPanel {

    private EstudianteDTO est = new EstudianteDTO();

    ;

    /**
     * Creates new form MenuEstudiantes
     *
     * @param conectadoA
     */
    public MenuEstudiantes(String conectadoA) {
        initComponents();
        conectado_a.setText(conectadoA);
        configurarSpinner();
        limpiarLabels();

    }

    public void configurarSpinner() {
        SpinnerNumberModel nm = new SpinnerNumberModel();
        nm.setMinimum(1);
        campo_codigo.setModel(nm);
        campo_codigo.setValue(1);
    }

    public void limpiarLabels() {
        codigo.setText(null);
        nombres.setText(null);
        primerApellido.setText(null);
        segundoApellido.setText(null);
        telefono.setText(null);
        facultad.setText(null);
        programa.setText(null);
        fecha_inicio.setText(null);
        foto_estudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/project/view/gui/images/user.jpeg")));
    }

    public void mostrarFoto(byte[] foto) {
        if (foto != null) {
            BufferedImage img = null;
            try {
                img = ImageIO.read(new ByteArrayInputStream(foto));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
            }
            ImageIcon icono = new ImageIcon(img);
            foto_estudiante.setIcon(icono);
        } else {
            foto_estudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/project/view/gui/images/user.jpeg")));
        }
    }

    public void mostrarDatos() {
        if ("Oracle".equals(conectado_a.getText())) {
            est = OracleService.getInstance().buscarIdEstudianteOracle((Number) campo_codigo.getValue());
            Number codigo_estudiante = (Number) campo_codigo.getValue();
            if (codigo_estudiante.equals(est.getCodigo())) {
                codigo.setText(est.getCodigo().toString());
                nombres.setText(est.getNombres());
                primerApellido.setText(est.getApellido1());
                segundoApellido.setText(est.getApellido2());
                telefono.setText(est.getTelefono());
                facultad.setText(est.getFacultad());
                programa.setText(est.getPrograma());
                fecha_inicio.setText(est.getFecha_inicio().toString());
                mostrarFoto(est.getFoto());
            } else {
                limpiarLabels();
                JOptionPane.showMessageDialog(null, "NO EXISTE UN ESTUDIANTE CON ESE CODIGO", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
                est = null;
            }
        } else if ("PostgreSQL".equals(conectado_a.getText())) {
            est = PostgresqlService.getInstance().buscarIdEstudiantePostgres((Number) campo_codigo.getValue());
            Number codigo_estudiante = (Number) campo_codigo.getValue();
            if (codigo_estudiante.equals(est.getCodigo())) {
                codigo.setText(est.getCodigo().toString());
                nombres.setText(est.getNombres());
                primerApellido.setText(est.getApellido1());
                segundoApellido.setText(est.getApellido2());
                telefono.setText(est.getTelefono());
                facultad.setText(est.getFacultad());
                programa.setText(est.getPrograma());
                fecha_inicio.setText(est.getFecha_inicio().toString());
                mostrarFoto(est.getFoto());
            } else {
                limpiarLabels();
                est = null;
                JOptionPane.showMessageDialog(null, "NO EXISTE UN ESTUDIANTE CON ESE CODIGO", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void guardarFoto() {
        String ruta = null;
        JFileChooser j = new JFileChooser();
        int ap = j.showOpenDialog(j);
        if (ap == JFileChooser.APPROVE_OPTION) {
            ruta = j.getSelectedFile().getAbsolutePath();
            File archivo = new File(ruta);
            est.setFoto(new byte[(int) archivo.length()]);
            try {
                InputStream inte = new FileInputStream(archivo);
                inte.read(est.getFoto());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            if ("Oracle".equals(conectado_a.getText())) {
                est.setFoto(OracleService.getInstance().guardarFotoCarpetaOracle(est));
                est.setFoto(OracleService.getInstance().guardarFotoBaseOracle(est));
                mostrarDatos();
            } else if ("PostgreSQL".equals(conectado_a.getText())) {
                est.setFoto(PostgresqlService.getInstance().guardarFotoCarpetaPostgres(est));
                est.setFoto(PostgresqlService.getInstance().guardarFotoBasePostgres(est));
                mostrarDatos();
            }
        } else {
            System.out.println("OPERACION CANCELADA");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo_connect_oracle1 = new javax.swing.JLabel();
        conectado_a = new javax.swing.JLabel();
        label_instruccion = new javax.swing.JLabel();
        boton_cargar = new javax.swing.JButton();
        foto_estudiante = new javax.swing.JLabel();
        segundoApellido = new javax.swing.JLabel();
        primerApellido = new javax.swing.JLabel();
        label_telefono = new javax.swing.JLabel();
        label_inicio = new javax.swing.JLabel();
        label_facultad = new javax.swing.JLabel();
        label_programa = new javax.swing.JLabel();
        nombres = new javax.swing.JLabel();
        codigo = new javax.swing.JLabel();
        programa = new javax.swing.JLabel();
        telefono = new javax.swing.JLabel();
        fecha_inicio = new javax.swing.JLabel();
        facultad = new javax.swing.JLabel();
        campo_codigo = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        label_codigo1 = new javax.swing.JLabel();
        label_codigo2 = new javax.swing.JLabel();
        label_codigo3 = new javax.swing.JLabel();
        label_codigo4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(730, 610));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo_connect_oracle1.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        titulo_connect_oracle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_connect_oracle1.setText("CONECTADO A  ---> ");
        add(titulo_connect_oracle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 16, 393, -1));

        conectado_a.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        conectado_a.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        conectado_a.setText("DB");
        add(conectado_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 230, -1));

        label_instruccion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_instruccion.setText("Ingrese el  código del Estudiante para visualizar los datos");
        add(label_instruccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        boton_cargar.setText("CARGAR");
        boton_cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_cargarActionPerformed(evt);
            }
        });
        add(boton_cargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));

        foto_estudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/project/view/gui/images/user.jpeg"))); // NOI18N
        add(foto_estudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 210, 190));

        segundoApellido.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        segundoApellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        segundoApellido.setText("APELLIDO2");
        add(segundoApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 230, -1));

        primerApellido.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        primerApellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        primerApellido.setText("APELLIDO1");
        add(primerApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 240, -1));

        label_telefono.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        label_telefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_telefono.setText("TELÉFONO:");
        add(label_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 130, -1));

        label_inicio.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        label_inicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_inicio.setText("FECHA INICIO");
        add(label_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 530, 160, -1));

        label_facultad.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        label_facultad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_facultad.setText("FACULTAD");
        add(label_facultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, 130, -1));

        label_programa.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        label_programa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_programa.setText("PROGRAMA");
        add(label_programa, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, 130, -1));

        nombres.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        nombres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombres.setText("NOMBRES");
        add(nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 270, 20));

        codigo.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        codigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        codigo.setText("CODIGO");
        add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 130, 20));

        programa.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        programa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        programa.setText("INGENIERIA DE SISTEMAS");
        add(programa, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, 350, 30));

        telefono.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        telefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        telefono.setText("TELEFONO");
        add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 160, 20));

        fecha_inicio.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        fecha_inicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(fecha_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 560, 230, 30));

        facultad.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        facultad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        facultad.setText("CIENCIAS BASICAS E INGENIERA");
        add(facultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 350, 30));
        add(campo_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 120, -1));

        jButton1.setText("CAMBIAR FOTO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, -1, -1));

        label_codigo1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        label_codigo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_codigo1.setText("CÓDIGO:");
        add(label_codigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 130, 20));

        label_codigo2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        label_codigo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_codigo2.setText("NOMBRES:");
        add(label_codigo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 130, 20));

        label_codigo3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        label_codigo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_codigo3.setText("PRIMER APELLIDO:");
        add(label_codigo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 200, 20));

        label_codigo4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        label_codigo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_codigo4.setText("SEGUNDO APELLIDO:");
        add(label_codigo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 200, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (est != null) {
            guardarFoto();
        }else{
            JOptionPane.showMessageDialog(null, "NO EXISTE UN ESTUDIANTE CON ESE CODIGO", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void boton_cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_cargarActionPerformed
        mostrarDatos();
    }//GEN-LAST:event_boton_cargarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_cargar;
    private javax.swing.JSpinner campo_codigo;
    private javax.swing.JLabel codigo;
    private javax.swing.JLabel conectado_a;
    private javax.swing.JLabel facultad;
    private javax.swing.JLabel fecha_inicio;
    private javax.swing.JLabel foto_estudiante;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel label_codigo1;
    private javax.swing.JLabel label_codigo2;
    private javax.swing.JLabel label_codigo3;
    private javax.swing.JLabel label_codigo4;
    private javax.swing.JLabel label_facultad;
    private javax.swing.JLabel label_inicio;
    private javax.swing.JLabel label_instruccion;
    private javax.swing.JLabel label_programa;
    private javax.swing.JLabel label_telefono;
    private javax.swing.JLabel nombres;
    private javax.swing.JLabel primerApellido;
    private javax.swing.JLabel programa;
    private javax.swing.JLabel segundoApellido;
    private javax.swing.JLabel telefono;
    private javax.swing.JLabel titulo_connect_oracle1;
    // End of variables declaration//GEN-END:variables
}
