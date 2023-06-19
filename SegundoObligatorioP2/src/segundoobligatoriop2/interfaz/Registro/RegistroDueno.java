/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package segundoobligatoriop2.interfaz.Registro;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import segundoobligatoriop2.Sistema;

/**
 *
 * @author joaqu
 */
public class RegistroDueno extends javax.swing.JFrame {

    /**
     * Creates new form RegistroDueño
     */
    public RegistroDueno() {
        initComponents();
    }

    public JButton getBotonAlta(){
    return botonAltaRegistro;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRegistroPuesto1 = new javax.swing.JPanel();
        textoNombre = new javax.swing.JLabel();
        registroNombreDueño = new javax.swing.JTextField();
        textoEdadDueño = new javax.swing.JLabel();
        registroEdadDueño = new javax.swing.JTextField();
        textoExperienciaDueño = new javax.swing.JLabel();
        registroEdadExperiencia = new javax.swing.JTextField();
        botonLimpiarRegistro2 = new javax.swing.JButton();
        botonAltaRegistro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de dueño");
        getContentPane().setLayout(null);

        panelRegistroPuesto1.setLayout(null);

        textoNombre.setText("Nombre");
        panelRegistroPuesto1.add(textoNombre);
        textoNombre.setBounds(100, 119, 90, 17);

        registroNombreDueño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroNombreDueñoActionPerformed(evt);
            }
        });
        panelRegistroPuesto1.add(registroNombreDueño);
        registroNombreDueño.setBounds(260, 119, 120, 23);

        textoEdadDueño.setText("Edad:");
        panelRegistroPuesto1.add(textoEdadDueño);
        textoEdadDueño.setBounds(100, 179, 90, 17);

        registroEdadDueño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroEdadDueñoActionPerformed(evt);
            }
        });
        panelRegistroPuesto1.add(registroEdadDueño);
        registroEdadDueño.setBounds(260, 179, 130, 23);

        textoExperienciaDueño.setText("Años de experiencia:");
        panelRegistroPuesto1.add(textoExperienciaDueño);
        textoExperienciaDueño.setBounds(100, 239, 150, 17);

        registroEdadExperiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroEdadExperienciaActionPerformed(evt);
            }
        });
        panelRegistroPuesto1.add(registroEdadExperiencia);
        registroEdadExperiencia.setBounds(260, 240, 40, 23);

        botonLimpiarRegistro2.setText("Limpiar");
        botonLimpiarRegistro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarRegistro2ActionPerformed(evt);
            }
        });
        panelRegistroPuesto1.add(botonLimpiarRegistro2);
        botonLimpiarRegistro2.setBounds(450, 340, 150, 40);

        botonAltaRegistro.setText("Alta");
        botonAltaRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAltaRegistroActionPerformed(evt);
            }
        });
        panelRegistroPuesto1.add(botonAltaRegistro);
        botonAltaRegistro.setBounds(260, 340, 150, 40);

        getContentPane().add(panelRegistroPuesto1);
        panelRegistroPuesto1.setBounds(0, 12, 1170, 549);

        setBounds(0, 0, 928, 581);
    }// </editor-fold>//GEN-END:initComponents

    private void registroNombreDueñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroNombreDueñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroNombreDueñoActionPerformed

    private void registroEdadDueñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroEdadDueñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroEdadDueñoActionPerformed

    private void registroEdadExperienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroEdadExperienciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroEdadExperienciaActionPerformed

    private void botonLimpiarRegistro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarRegistro2ActionPerformed
        registroNombreDueño.setText("");
        registroEdadDueño.setText("");
        registroEdadExperiencia.setText("");
    }//GEN-LAST:event_botonLimpiarRegistro2ActionPerformed

    private void botonAltaRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAltaRegistroActionPerformed
        String nombreDueno = registroNombreDueño.getText();
        String edadTexto = registroEdadDueño.getText();
        String experienciaTexto = registroEdadExperiencia.getText();
        if (nombreDueno.isEmpty() || edadTexto.isEmpty() || experienciaTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Verifica que estas utilizando todos los campos de información", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            if ((edadTexto.matches("\\d+") && experienciaTexto.matches("\\d+")) && ((Integer.parseInt(edadTexto) >= 0)) && (Integer.parseInt(experienciaTexto) >= 0)) {
                int edad = Integer.parseInt(edadTexto);
                int experiencia = Integer.parseInt(experienciaTexto);

                if (!Sistema.nombreDueñoUnico(nombreDueno)) {
                    if (nombreDueno.matches("[a-zA-Z]+")) {
                        if (edad > experiencia) {
                            Sistema.agregarDueno(nombreDueno, edad, experiencia);
                            registroNombreDueño.setText("");
                            registroEdadDueño.setText("");
                            registroEdadExperiencia.setText("0");
                            //actualizarComboDuenos();
                            //actualizarTablaDuenos();
                        } else {
                            JOptionPane.showMessageDialog(this, "Error: La experiencia no puede ser mayor a la edad", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Solo se permiten letras en el nombre", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Error: El nombre del dueño ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error: Verifica que todos los campos estan introducidos correctamente(no numeros negativos y numeros en los campos correctos) ", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Verifica que los campos de edad y experiencia sean números válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonAltaRegistroActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroDueno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroDueno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroDueno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroDueno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroDueno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAltaRegistro;
    private javax.swing.JButton botonLimpiarRegistro2;
    private javax.swing.JPanel panelRegistroPuesto1;
    private javax.swing.JTextField registroEdadDueño;
    private javax.swing.JTextField registroEdadExperiencia;
    private javax.swing.JTextField registroNombreDueño;
    private javax.swing.JLabel textoEdadDueño;
    private javax.swing.JLabel textoExperienciaDueño;
    private javax.swing.JLabel textoNombre;
    // End of variables declaration//GEN-END:variables
}
