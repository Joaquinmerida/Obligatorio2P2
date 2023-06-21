package segundoobligatoriop2.interfaz.Registro;

/*
      ---------------------------------------------------------
    |                    Sistema desarrollado por                               |
  |    Joaquin Merida 253076 y Juan Manuel Mera  273527 |
 ---------------------------------------------------------
 */
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import segundoobligatoriop2.Sistema;
import segundoobligatoriop2.auxiliar.Item;

public class RegistroItem extends javax.swing.JFrame {

    private String ruta = "";

    public RegistroItem() {
        initComponents();
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JPG", "JPG");
        seleccionarImagen.setFileFilter(filtrado);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRegistroItem = new javax.swing.JPanel();
        textoNombreItem = new javax.swing.JLabel();
        registroNombre = new javax.swing.JTextField();
        textoDescripcion = new javax.swing.JLabel();
        registroDescripcion = new javax.swing.JTextField();
        textoTipo = new javax.swing.JLabel();
        registroTipo = new javax.swing.JComboBox<>();
        textoVentaPor = new javax.swing.JLabel();
        registroVentaPor = new javax.swing.JComboBox<>();
        botonLimpiarRegistro = new javax.swing.JButton();
        botonAltaRegistro = new javax.swing.JButton();
        textoImagen = new javax.swing.JLabel();
        AparicionImagenRegistro = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        seleccionarImagen = new javax.swing.JFileChooser();
        tituloRegistroItem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro Item");
        getContentPane().setLayout(null);

        panelRegistroItem.setLayout(null);

        textoNombreItem.setText("Nombre:");
        panelRegistroItem.add(textoNombreItem);
        textoNombreItem.setBounds(100, 80, 80, 16);

        registroNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroNombreActionPerformed(evt);
            }
        });
        panelRegistroItem.add(registroNombre);
        registroNombre.setBounds(260, 80, 260, 22);

        textoDescripcion.setText("Descripcion:");
        panelRegistroItem.add(textoDescripcion);
        textoDescripcion.setBounds(100, 140, 100, 16);

        registroDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroDescripcionActionPerformed(evt);
            }
        });
        panelRegistroItem.add(registroDescripcion);
        registroDescripcion.setBounds(260, 140, 260, 22);

        textoTipo.setText("Tipo:");
        panelRegistroItem.add(textoTipo);
        textoTipo.setBounds(100, 200, 50, 16);

        registroTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fruta", "Verdura" }));
        registroTipo.setName("");
        registroTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroTipoActionPerformed(evt);
            }
        });
        panelRegistroItem.add(registroTipo);
        registroTipo.setBounds(260, 190, 200, 20);

        textoVentaPor.setText("Venta por:");
        panelRegistroItem.add(textoVentaPor);
        textoVentaPor.setBounds(100, 240, 110, 16);

        registroVentaPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kilogramo", "Unidad" }));
        panelRegistroItem.add(registroVentaPor);
        registroVentaPor.setBounds(260, 240, 200, 22);

        botonLimpiarRegistro.setText("Limpiar");
        botonLimpiarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarRegistroActionPerformed(evt);
            }
        });
        panelRegistroItem.add(botonLimpiarRegistro);
        botonLimpiarRegistro.setBounds(410, 340, 100, 40);

        botonAltaRegistro.setText("Alta");
        botonAltaRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAltaRegistroActionPerformed(evt);
            }
        });
        panelRegistroItem.add(botonAltaRegistro);
        botonAltaRegistro.setBounds(260, 340, 100, 40);

        textoImagen.setText("Imagen:");
        panelRegistroItem.add(textoImagen);
        textoImagen.setBounds(580, 80, 90, 30);
        panelRegistroItem.add(AparicionImagenRegistro);
        AparicionImagenRegistro.setBounds(50, 360, 180, 140);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelRegistroItem.add(jButton2);
        jButton2.setBounds(1060, 400, 100, 30);

        jButton4.setText("Abrir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panelRegistroItem.add(jButton4);
        jButton4.setBounds(910, 400, 100, 30);

        seleccionarImagen.setAcceptAllFileFilterUsed(false);
        seleccionarImagen.setControlButtonsAreShown(false);
        seleccionarImagen.setDialogTitle("");
        seleccionarImagen.setSelectedFile(new java.io.File("C:\\Users\\joaqu\\OneDrive\\Escritorio\\Obligatorio2P2\\Obligatorio2P2\\SegundoObligatorioP2\\src\\segundoobligatoriop2\\ImagenesOblig"));
        seleccionarImagen.setToolTipText("");
        seleccionarImagen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        seleccionarImagen.setDoubleBuffered(true);
        seleccionarImagen.setName("seleccionarImagen");
        seleccionarImagen.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                seleccionarImagenComponentShown(evt);
            }
        });
        seleccionarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarImagenActionPerformed(evt);
            }
        });
        seleccionarImagen.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                seleccionarImagenPropertyChange(evt);
            }
        });
        panelRegistroItem.add(seleccionarImagen);
        seleccionarImagen.setBounds(640, 70, 530, 310);

        tituloRegistroItem.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        tituloRegistroItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloRegistroItem.setText("Registro de item");
        panelRegistroItem.add(tituloRegistroItem);
        tituloRegistroItem.setBounds(230, 0, 630, 60);

        getContentPane().add(panelRegistroItem);
        panelRegistroItem.setBounds(0, 0, 1190, 550);

        getAccessibleContext().setAccessibleName("Registro de producto");

        setSize(new java.awt.Dimension(1203, 557));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBotonAltaRegistro() {
        return botonAltaRegistro;
    }

    public JFileChooser getFileChooser() {
        return seleccionarImagen;
    }

    private void seleccionarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarImagenActionPerformed
        ruta = seleccionarImagen.getSelectedFile().getPath();
        Image mImagen = new ImageIcon(ruta).getImage();
        ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(AparicionImagenRegistro.getWidth(), AparicionImagenRegistro.getHeight(), Image.SCALE_SMOOTH));
        AparicionImagenRegistro.setIcon(mIcono);
    }//GEN-LAST:event_seleccionarImagenActionPerformed

    private void botonAltaRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAltaRegistroActionPerformed
        String nombre = registroNombre.getText();
        String descripcion = registroDescripcion.getText();
        String tipo = registroTipo.getSelectedItem().toString();
        String formaVenta = registroVentaPor.getSelectedItem().toString();
        String imagen = "";

        if (seleccionarImagen.getSelectedFile() != null) {
            imagen = seleccionarImagen.getSelectedFile().getPath();
        }


        
        if (nombre.isEmpty() || descripcion.isEmpty() || nombre.contains(" ")) {
            JOptionPane.showMessageDialog(this, "Error: Recuerda llenar todos los campos de texto", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (Sistema.itemUnico(nombre, Sistema.getListaItems())) {
                if (nombre.matches("[a-zA-Z]+")) {
                    if (imagen == null || imagen.isEmpty()) {
                        File sinImagenFile = new File("src/segundoobligatoriop2/ImagenesOblig/SinImagen.jpg");
                        if (sinImagenFile.exists()) {
                            imagen = sinImagenFile.getAbsolutePath();
                        } else {
                            // Si no se encuentra la imagen "SinImagen.jpg", mostrar un mensaje de error o utilizar una imagen alternativa
                        }
                    }
                    Sistema.agregarItem(new Item(nombre, descripcion, tipo, formaVenta, imagen));
                    registroNombre.setText("");
                    registroDescripcion.setText("");
                    JOptionPane.showMessageDialog(this, "Has registrado un Item con éxito", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Solo se permiten letras en el nombre", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nombre de item ya registrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_botonAltaRegistroActionPerformed

    private void botonLimpiarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarRegistroActionPerformed
        registroDescripcion.setText("");
        registroNombre.setText("");
    }//GEN-LAST:event_botonLimpiarRegistroActionPerformed

    private void registroTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroTipoActionPerformed

    private void registroDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroDescripcionActionPerformed

    private void registroNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroNombreActionPerformed

    private void seleccionarImagenComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_seleccionarImagenComponentShown
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JPG", "JPG");
        seleccionarImagen.setFileFilter(filtrado);
    }//GEN-LAST:event_seleccionarImagenComponentShown

    private void seleccionarImagenPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_seleccionarImagenPropertyChange

    }//GEN-LAST:event_seleccionarImagenPropertyChange

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ruta = seleccionarImagen.getSelectedFile().getPath();
        Image mImagen = new ImageIcon(ruta).getImage();
        ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(AparicionImagenRegistro.getWidth(), AparicionImagenRegistro.getHeight(), Image.SCALE_SMOOTH));
        AparicionImagenRegistro.setIcon(mIcono);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ruta = "SinImagen.jpg";
        Image mImagen = new ImageIcon(ruta).getImage();
        ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(AparicionImagenRegistro.getWidth(), AparicionImagenRegistro.getHeight(), Image.SCALE_SMOOTH));
        AparicionImagenRegistro.setIcon(mIcono);
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AparicionImagenRegistro;
    private javax.swing.JButton botonAltaRegistro;
    private javax.swing.JButton botonLimpiarRegistro;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel panelRegistroItem;
    private javax.swing.JTextField registroDescripcion;
    private javax.swing.JTextField registroNombre;
    private javax.swing.JComboBox<String> registroTipo;
    private javax.swing.JComboBox<String> registroVentaPor;
    private javax.swing.JFileChooser seleccionarImagen;
    private javax.swing.JLabel textoDescripcion;
    private javax.swing.JLabel textoImagen;
    private javax.swing.JLabel textoNombreItem;
    private javax.swing.JLabel textoTipo;
    private javax.swing.JLabel textoVentaPor;
    private javax.swing.JLabel tituloRegistroItem;
    // End of variables declaration//GEN-END:variables
}
