/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package segundoobligatoriop2.interfaz.Registro;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import segundoobligatoriop2.Sistema;
import segundoobligatoriop2.interfaz.MenuPrincipal;


public class RegistroPuesto extends javax.swing.JFrame {

    public RegistroPuesto() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRegistroPuesto = new javax.swing.JPanel();
        registroIdentificacion = new javax.swing.JTextField();
        textoIdentificacion = new javax.swing.JLabel();
        textoDueño = new javax.swing.JLabel();
        textoUbicacion = new javax.swing.JLabel();
        textoCantidadEmpleados = new javax.swing.JLabel();
        botonLimpiarRegistro1 = new javax.swing.JButton();
        botonAltaRegistro1 = new javax.swing.JButton();
        registroUbicacion = new javax.swing.JTextField();
        registroNumeroEmpleados = new javax.swing.JTextField();
        registroPuestoCombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de puesto");
        getContentPane().setLayout(null);

        panelRegistroPuesto.setLayout(null);

        registroIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroIdentificacionActionPerformed(evt);
            }
        });
        panelRegistroPuesto.add(registroIdentificacion);
        registroIdentificacion.setBounds(260, 119, 230, 22);

        textoIdentificacion.setText("Identificacion:");
        panelRegistroPuesto.add(textoIdentificacion);
        textoIdentificacion.setBounds(100, 119, 90, 16);

        textoDueño.setText("Dueño:");
        panelRegistroPuesto.add(textoDueño);
        textoDueño.setBounds(100, 179, 90, 16);

        textoUbicacion.setText("Ubicación:");
        panelRegistroPuesto.add(textoUbicacion);
        textoUbicacion.setBounds(100, 239, 100, 16);

        textoCantidadEmpleados.setText("Cantidad empleados:");
        panelRegistroPuesto.add(textoCantidadEmpleados);
        textoCantidadEmpleados.setBounds(100, 290, 120, 16);

        botonLimpiarRegistro1.setText("Limpiar");
        botonLimpiarRegistro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarRegistro1ActionPerformed(evt);
            }
        });
        panelRegistroPuesto.add(botonLimpiarRegistro1);
        botonLimpiarRegistro1.setBounds(260, 339, 100, 40);

        botonAltaRegistro1.setText("Alta");
        botonAltaRegistro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAltaRegistro1ActionPerformed(evt);
            }
        });
        panelRegistroPuesto.add(botonAltaRegistro1);
        botonAltaRegistro1.setBounds(260, 399, 100, 40);

        registroUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroUbicacionActionPerformed(evt);
            }
        });
        panelRegistroPuesto.add(registroUbicacion);
        registroUbicacion.setBounds(260, 240, 230, 22);

        registroNumeroEmpleados.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        registroNumeroEmpleados.setText("0");
        registroNumeroEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroNumeroEmpleadosActionPerformed(evt);
            }
        });
        panelRegistroPuesto.add(registroNumeroEmpleados);
        registroNumeroEmpleados.setBounds(260, 290, 30, 22);

        registroPuestoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        registroPuestoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroPuestoComboActionPerformed(evt);
            }
        });
        panelRegistroPuesto.add(registroPuestoCombo);
        registroPuestoCombo.setBounds(260, 180, 230, 22);

        getContentPane().add(panelRegistroPuesto);
        panelRegistroPuesto.setBounds(-2, -1, 1100, 570);

        getAccessibleContext().setAccessibleName("Registro de puesto");

        setBounds(0, 0, 1156, 578);
    }// </editor-fold>//GEN-END:initComponents

    private void registroIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroIdentificacionActionPerformed

    private void botonLimpiarRegistro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarRegistro1ActionPerformed
        registroIdentificacion.setText("");
        registroUbicacion.setText("");
        registroNumeroEmpleados.setText("0");
    }//GEN-LAST:event_botonLimpiarRegistro1ActionPerformed

    private void botonAltaRegistro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAltaRegistro1ActionPerformed
        String identificacion = registroIdentificacion.getText();
        String dueno = registroPuestoCombo.getSelectedItem().toString();
        String ubicacion = registroUbicacion.getText();
        String cantEmpleados = registroNumeroEmpleados.getText();
        if (identificacion.isEmpty() || ubicacion.isEmpty() || dueno.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Verifique que todos los campos de información estén siendo llenados", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (dueno == "No hay ningun dueno registrado") {
            JOptionPane.showMessageDialog(this, "Error: No hay Duenos registrados actualmente, recuerda registrar un dueno previo a registrar un puesto", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!Sistema.identificacionUnico(identificacion)) {
            if (identificacion.matches("[a-zA-Z]+")) {
                if (cantEmpleados.matches("\\d+") && (Integer.parseInt(cantEmpleados) >= 0)) {
                    int cantidadEmpleados = Integer.parseInt(registroNumeroEmpleados.getText());
                    Sistema.agregarPuesto(identificacion, dueno, ubicacion, cantidadEmpleados);
                    registroIdentificacion.setText("");
                    registroUbicacion.setText("");
                    registroNumeroEmpleados.setText("");
                    
                    //actualizarListaPuestos();
                    //actualizarPuestoQueVende();
                    //actualizarTablaPuestos();
                } else {
                    JOptionPane.showMessageDialog(this, "Error: La cantidad de empleados solo pueden ser valores numericos y no pueden ser negativos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error: La identificación del puesto no puede tener valores numericos", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(this, "Error: La identificación del puesto ya está registrada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonAltaRegistro1ActionPerformed

    private void registroUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroUbicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroUbicacionActionPerformed

    private void registroNumeroEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroNumeroEmpleadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroNumeroEmpleadosActionPerformed

    private void registroPuestoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroPuestoComboActionPerformed

    }//GEN-LAST:event_registroPuestoComboActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroPuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroPuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroPuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroPuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroPuesto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAltaRegistro1;
    private javax.swing.JButton botonLimpiarRegistro1;
    private javax.swing.JPanel panelRegistroPuesto;
    private javax.swing.JTextField registroIdentificacion;
    private javax.swing.JTextField registroNumeroEmpleados;
    private javax.swing.JComboBox<String> registroPuestoCombo;
    private javax.swing.JTextField registroUbicacion;
    private javax.swing.JLabel textoCantidadEmpleados;
    private javax.swing.JLabel textoDueño;
    private javax.swing.JLabel textoIdentificacion;
    private javax.swing.JLabel textoUbicacion;
    // End of variables declaration//GEN-END:variables
}
