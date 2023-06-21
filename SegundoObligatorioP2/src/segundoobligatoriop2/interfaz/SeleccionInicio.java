package segundoobligatoriop2.interfaz;

/*
      ---------------------------------------------------------
    |                    Sistema desarrollado por                               |
  |    Joaquin Merida 253076 y Juan Manuel Mera  273527 |
 ---------------------------------------------------------
*/                           

import java.awt.Dimension;
import java.awt.Toolkit;
import segundoobligatoriop2.Sistema;

public class SeleccionInicio extends javax.swing.JDialog {

    public SeleccionInicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.width * 0.8);
        int height = (int) (screenSize.height * 0.8);
        setSize(width, height);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloInicio = new javax.swing.JLabel();
        botonInicioSistemaVacio = new javax.swing.JButton();
        botonInicioSesionAnterior = new javax.swing.JButton();
        botonInicioDatosPrecargados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Seleccion de datos guardados");
        setAlwaysOnTop(true);
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        tituloInicio.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        tituloInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloInicio.setText("Selecciona el tipo de inicio");
        getContentPane().add(tituloInicio);
        tituloInicio.setBounds(160, 70, 690, 70);

        botonInicioSistemaVacio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonInicioSistemaVacio.setText("Partir de sistema vacio");
        botonInicioSistemaVacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInicioSistemaVacioActionPerformed(evt);
            }
        });
        getContentPane().add(botonInicioSistemaVacio);
        botonInicioSistemaVacio.setBounds(60, 220, 270, 90);

        botonInicioSesionAnterior.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonInicioSesionAnterior.setText("Datos de la sesion anterior");
        botonInicioSesionAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInicioSesionAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(botonInicioSesionAnterior);
        botonInicioSesionAnterior.setBounds(390, 220, 290, 90);

        botonInicioDatosPrecargados.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonInicioDatosPrecargados.setText("Datos Precargados");
        botonInicioDatosPrecargados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInicioDatosPrecargadosActionPerformed(evt);
            }
        });
        getContentPane().add(botonInicioDatosPrecargados);
        botonInicioDatosPrecargados.setBounds(740, 220, 290, 90);

        setSize(new java.awt.Dimension(1096, 434));
    }// </editor-fold>//GEN-END:initComponents

    private void botonInicioSistemaVacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInicioSistemaVacioActionPerformed
        dispose();
    }//GEN-LAST:event_botonInicioSistemaVacioActionPerformed

    private void botonInicioSesionAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInicioSesionAnteriorActionPerformed
        Sistema.leerArchivo(1);
        dispose();
    }//GEN-LAST:event_botonInicioSesionAnteriorActionPerformed

    private void botonInicioDatosPrecargadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInicioDatosPrecargadosActionPerformed
        Sistema.leerArchivo(2);
        dispose();
    }//GEN-LAST:event_botonInicioDatosPrecargadosActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Sistema.guardarProceso();
    }//GEN-LAST:event_formWindowClosed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SeleccionInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SeleccionInicio dialog = new SeleccionInicio(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonInicioDatosPrecargados;
    private javax.swing.JButton botonInicioSesionAnterior;
    private javax.swing.JButton botonInicioSistemaVacio;
    private javax.swing.JLabel tituloInicio;
    // End of variables declaration//GEN-END:variables
}
