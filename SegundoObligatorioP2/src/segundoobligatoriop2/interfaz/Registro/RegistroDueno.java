package segundoobligatoriop2.interfaz.Registro;

/*
      ---------------------------------------------------------
    |                    Sistema desarrollado por                               |
  |    Joaquin Merida 253076 y Juan Manuel Mera  273527 |
 ---------------------------------------------------------
 */
import javax.swing.JButton;
import javax.swing.JOptionPane;
import segundoobligatoriop2.Sistema;

public class RegistroDueno extends javax.swing.JFrame {

    public RegistroDueno() {
        initComponents();
    }

    public JButton getBotonAlta() {
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
        tituloRegistroDueno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de dueño");
        getContentPane().setLayout(null);

        panelRegistroPuesto1.setLayout(null);

        textoNombre.setText("Nombre");
        panelRegistroPuesto1.add(textoNombre);
        textoNombre.setBounds(100, 119, 90, 16);

        registroNombreDueño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroNombreDueñoActionPerformed(evt);
            }
        });
        panelRegistroPuesto1.add(registroNombreDueño);
        registroNombreDueño.setBounds(260, 119, 120, 22);

        textoEdadDueño.setText("Edad:");
        panelRegistroPuesto1.add(textoEdadDueño);
        textoEdadDueño.setBounds(100, 179, 90, 16);

        registroEdadDueño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroEdadDueñoActionPerformed(evt);
            }
        });
        panelRegistroPuesto1.add(registroEdadDueño);
        registroEdadDueño.setBounds(260, 179, 130, 22);

        textoExperienciaDueño.setText("Años de experiencia:");
        panelRegistroPuesto1.add(textoExperienciaDueño);
        textoExperienciaDueño.setBounds(100, 239, 150, 16);

        registroEdadExperiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroEdadExperienciaActionPerformed(evt);
            }
        });
        panelRegistroPuesto1.add(registroEdadExperiencia);
        registroEdadExperiencia.setBounds(260, 240, 40, 22);

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

        tituloRegistroDueno.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        tituloRegistroDueno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloRegistroDueno.setText("Registro de dueño");
        panelRegistroPuesto1.add(tituloRegistroDueno);
        tituloRegistroDueno.setBounds(190, -10, 480, 110);

        getContentPane().add(panelRegistroPuesto1);
        panelRegistroPuesto1.setBounds(0, 12, 900, 549);

        setSize(new java.awt.Dimension(928, 581));
        setLocationRelativeTo(null);
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
                if (!Sistema.nombreDuenoUnico(nombreDueno)) {
                    if (nombreDueno.matches("[a-zA-Z]+")) {
                        if (edad > experiencia) {
                            Sistema.agregarDueno(nombreDueno, edad, experiencia);
                            registroNombreDueño.setText("");
                            registroEdadDueño.setText("");
                            registroEdadExperiencia.setText("0");
                            JOptionPane.showMessageDialog(this, "Has registrado un dueño con exito", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
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

    public static void main(String args[]) {

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
    private javax.swing.JLabel tituloRegistroDueno;
    // End of variables declaration//GEN-END:variables
}
