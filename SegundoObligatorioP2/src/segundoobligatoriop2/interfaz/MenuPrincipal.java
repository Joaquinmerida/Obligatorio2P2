/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package segundoobligatoriop2.interfaz;

import segundoobligatoriop2.Sistema;
import segundoobligatoriop2.interfaz.Registro.*;
import segundoobligatoriop2.interfaz.Movimientos.*;
import segundoobligatoriop2.interfaz.GenerarArchivo.*;
import segundoobligatoriop2.interfaz.Consulta.*;

public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
    }
    
    
    

    public static void asd(){
        System.out.println("123");
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInicio = new javax.swing.JPanel();
        tituloInicio = new javax.swing.JLabel();
        nombreIntegrante1 = new javax.swing.JLabel();
        nombreIntegrante2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        tituloInicio1 = new javax.swing.JLabel();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        tituloInicio2 = new javax.swing.JLabel();
        jToggleButton7 = new javax.swing.JToggleButton();
        tituloInicio3 = new javax.swing.JLabel();
        jToggleButton8 = new javax.swing.JToggleButton();
        jToggleButton9 = new javax.swing.JToggleButton();
        jToggleButton10 = new javax.swing.JToggleButton();
        tituloInicio4 = new javax.swing.JLabel();
        jToggleButton11 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        panelInicio.setLayout(null);

        tituloInicio.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        tituloInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloInicio.setText("Generar archivo");
        panelInicio.add(tituloInicio);
        tituloInicio.setBounds(10, 520, 330, 80);

        nombreIntegrante1.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        nombreIntegrante1.setText("Juan Manuel Mera");
        panelInicio.add(nombreIntegrante1);
        nombreIntegrante1.setBounds(210, 620, 330, 80);

        nombreIntegrante2.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        nombreIntegrante2.setText("Joaquin Merida");
        panelInicio.add(nombreIntegrante2);
        nombreIntegrante2.setBounds(780, 620, 350, 70);

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelInicio.add(jButton2);
        jButton2.setBounds(1200, 230, 75, 23);

        jToggleButton1.setText("Consulta Mayoristas");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        panelInicio.add(jToggleButton1);
        jToggleButton1.setBounds(380, 360, 150, 40);

        jToggleButton2.setText("Dueño de puesto");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        panelInicio.add(jToggleButton2);
        jToggleButton2.setBounds(590, 170, 150, 40);

        jToggleButton3.setText("Compra del publico");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        panelInicio.add(jToggleButton3);
        jToggleButton3.setBounds(590, 260, 150, 40);

        tituloInicio1.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        tituloInicio1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloInicio1.setText(" Bienvenido a Mercado!");
        panelInicio.add(tituloInicio1);
        tituloInicio1.setBounds(470, -10, 430, 140);

        jToggleButton4.setText("Item");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });
        panelInicio.add(jToggleButton4);
        jToggleButton4.setBounds(380, 120, 150, 40);

        jToggleButton5.setText("Mayorista");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });
        panelInicio.add(jToggleButton5);
        jToggleButton5.setBounds(590, 120, 150, 40);

        jToggleButton6.setText("Puesto");
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });
        panelInicio.add(jToggleButton6);
        jToggleButton6.setBounds(380, 170, 150, 40);

        tituloInicio2.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        tituloInicio2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloInicio2.setText("Registro");
        panelInicio.add(tituloInicio2);
        tituloInicio2.setBounds(0, 90, 360, 80);

        jToggleButton7.setText("Generar archivo");
        jToggleButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton7ActionPerformed(evt);
            }
        });
        panelInicio.add(jToggleButton7);
        jToggleButton7.setBounds(460, 540, 210, 40);

        tituloInicio3.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        tituloInicio3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloInicio3.setText("Movimientos");
        panelInicio.add(tituloInicio3);
        tituloInicio3.setBounds(10, 250, 330, 80);

        jToggleButton8.setText("Consulta Productos");
        jToggleButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton8ActionPerformed(evt);
            }
        });
        panelInicio.add(jToggleButton8);
        jToggleButton8.setBounds(590, 430, 150, 40);

        jToggleButton9.setText("Consulta Puestos");
        jToggleButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton9ActionPerformed(evt);
            }
        });
        panelInicio.add(jToggleButton9);
        jToggleButton9.setBounds(590, 360, 150, 40);

        jToggleButton10.setText("Consulta Dueños");
        jToggleButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton10ActionPerformed(evt);
            }
        });
        panelInicio.add(jToggleButton10);
        jToggleButton10.setBounds(380, 430, 150, 40);

        tituloInicio4.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        tituloInicio4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloInicio4.setText("Consultas");
        panelInicio.add(tituloInicio4);
        tituloInicio4.setBounds(10, 370, 330, 80);

        jToggleButton11.setText("Compra de puesto");
        jToggleButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton11ActionPerformed(evt);
            }
        });
        panelInicio.add(jToggleButton11);
        jToggleButton11.setBounds(380, 260, 150, 40);

        getContentPane().add(panelInicio);
        panelInicio.setBounds(0, 0, 1290, 770);

        setBounds(0, 0, 1314, 781);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Sistema.guardarProceso();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        ConsultaMayoristas cm = new ConsultaMayoristas();
        cm.setVisible(true);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        RegistroDueno rd = new RegistroDueno();
        rd.setVisible(true);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        MovimientosCompraDePublico cp = new MovimientosCompraDePublico();
        cp.setVisible(true);
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        RegistroItem r = new RegistroItem();
        r.setVisible(true);
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        RegistroMayorista rm = new RegistroMayorista();
        rm.setVisible(true);
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
        RegistroPuesto rp = new RegistroPuesto();
        rp.setVisible(true);
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jToggleButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton7ActionPerformed
        GenerarArchivo ga = new GenerarArchivo();
        ga.setVisible(true);
    }//GEN-LAST:event_jToggleButton7ActionPerformed

    private void jToggleButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton8ActionPerformed
        ConsultaProductos cp = new ConsultaProductos();
        cp.setVisible(true);
    }//GEN-LAST:event_jToggleButton8ActionPerformed

    private void jToggleButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton9ActionPerformed
       ConsultaPuestos cp = new ConsultaPuestos();
        cp.setVisible(true);
    }//GEN-LAST:event_jToggleButton9ActionPerformed

    private void jToggleButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton10ActionPerformed
        ConsultaDuenosDePuesto cd = new ConsultaDuenosDePuesto();
        cd.setVisible(true);
    }//GEN-LAST:event_jToggleButton10ActionPerformed

    private void jToggleButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton11ActionPerformed
        MovimientosCompraDePuesto cp = new MovimientosCompraDePuesto();
        cp.setVisible(true);
    }//GEN-LAST:event_jToggleButton11ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton10;
    private javax.swing.JToggleButton jToggleButton11;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JToggleButton jToggleButton8;
    private javax.swing.JToggleButton jToggleButton9;
    private javax.swing.JLabel nombreIntegrante1;
    private javax.swing.JLabel nombreIntegrante2;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JLabel tituloInicio;
    private javax.swing.JLabel tituloInicio1;
    private javax.swing.JLabel tituloInicio2;
    private javax.swing.JLabel tituloInicio3;
    private javax.swing.JLabel tituloInicio4;
    // End of variables declaration//GEN-END:variables
}
