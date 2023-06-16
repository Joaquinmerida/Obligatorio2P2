package segundoobligatoriop2.interfaz;

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

        jLabel1 = new javax.swing.JLabel();
        botonInicioSistemaVacio = new javax.swing.JButton();
        botonInicioSesionAnterior = new javax.swing.JButton();
        botonInicioDatosPrecargados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(null);

        jLabel1.setText("Selecciona el tipo de inicio");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(450, 60, 150, 16);

        botonInicioSistemaVacio.setText("Partir de sistema vacio");
        botonInicioSistemaVacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInicioSistemaVacioActionPerformed(evt);
            }
        });
        getContentPane().add(botonInicioSistemaVacio);
        botonInicioSistemaVacio.setBounds(90, 220, 270, 90);

        botonInicioSesionAnterior.setText("Datos de la sesion anterior");
        botonInicioSesionAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInicioSesionAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(botonInicioSesionAnterior);
        botonInicioSesionAnterior.setBounds(400, 220, 290, 90);

        botonInicioDatosPrecargados.setText("Datos Precargados");
        botonInicioDatosPrecargados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInicioDatosPrecargadosActionPerformed(evt);
            }
        });
        getContentPane().add(botonInicioDatosPrecargados);
        botonInicioDatosPrecargados.setBounds(750, 220, 250, 80);

        pack();
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
            java.util.logging.Logger.getLogger(SeleccionInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
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
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
