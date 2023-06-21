package segundoobligatoriop2.interfaz.Registro;

/*
      ---------------------------------------------------------
    |                    Sistema desarrollado por                               |
  |    Joaquin Merida 253076 y Juan Manuel Mera  273527 |
 ---------------------------------------------------------
*/                           

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import segundoobligatoriop2.Sistema;
import segundoobligatoriop2.auxiliar.Item;

public class RegistroMayorista extends javax.swing.JFrame {

    private DefaultListModel<String> seleccionListaItemsAVenderModel = new DefaultListModel<>();

    public RegistroMayorista() {
        initComponents();
        inicializarListaItemsAVender();
    }

    public JButton getBotonRegistro() {
        return botonAltaRegistroMayorista;
    }

    private void inicializarListaItemsAVender() {
        listaSeleccionItemsMayorista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listaSeleccionItemsMayorista.setModel(seleccionListaItemsAVenderModel);
        contenedorListaSeleccionItemsMayorista.setViewportView(listaSeleccionItemsMayorista);
    }

    public void actualizarListaItemsAVender() {
        ArrayList<Item> listaItems = Sistema.getListaItems();
        Collections.sort(listaItems, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return item1.getNombre().compareTo(item2.getNombre());
            }
        });
        if (listaItems.isEmpty()) {
            seleccionListaItemsAVenderModel.clear();
            seleccionListaItemsAVenderModel.addElement("No hay ningun item registrado");
        } else {
            seleccionListaItemsAVenderModel.clear();
            for (Item item : listaItems) {
                String nombreItem = item.getNombre();
                seleccionListaItemsAVenderModel.addElement(nombreItem);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRegistroMayorista = new javax.swing.JPanel();
        textoNombreMayorista = new javax.swing.JLabel();
        nombreMayorista = new javax.swing.JTextField();
        textoRut = new javax.swing.JLabel();
        rutMayorista = new javax.swing.JTextField();
        textoDireccion = new javax.swing.JLabel();
        direccionMayorista = new javax.swing.JTextField();
        productosMayorista = new javax.swing.JLabel();
        botonLimpiarRegistroMayorista = new javax.swing.JButton();
        botonAltaRegistroMayorista = new javax.swing.JButton();
        contenedorListaSeleccionItemsMayorista = new javax.swing.JScrollPane();
        listaSeleccionItemsMayorista = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de mayorista");
        getContentPane().setLayout(null);

        panelRegistroMayorista.setLayout(null);

        textoNombreMayorista.setText("Nombre:");
        panelRegistroMayorista.add(textoNombreMayorista);
        textoNombreMayorista.setBounds(100, 119, 60, 17);

        nombreMayorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreMayoristaActionPerformed(evt);
            }
        });
        panelRegistroMayorista.add(nombreMayorista);
        nombreMayorista.setBounds(260, 119, 120, 23);

        textoRut.setText("Rut:");
        panelRegistroMayorista.add(textoRut);
        textoRut.setBounds(100, 179, 90, 17);

        rutMayorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rutMayoristaActionPerformed(evt);
            }
        });
        panelRegistroMayorista.add(rutMayorista);
        rutMayorista.setBounds(260, 179, 300, 23);

        textoDireccion.setText("Dirección:");
        panelRegistroMayorista.add(textoDireccion);
        textoDireccion.setBounds(100, 230, 70, 17);

        direccionMayorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionMayoristaActionPerformed(evt);
            }
        });
        panelRegistroMayorista.add(direccionMayorista);
        direccionMayorista.setBounds(260, 230, 300, 23);

        productosMayorista.setText("Productos que ofrece:");
        panelRegistroMayorista.add(productosMayorista);
        productosMayorista.setBounds(580, 20, 140, 17);

        botonLimpiarRegistroMayorista.setText("Limpiar");
        botonLimpiarRegistroMayorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarRegistroMayoristaActionPerformed(evt);
            }
        });
        panelRegistroMayorista.add(botonLimpiarRegistroMayorista);
        botonLimpiarRegistroMayorista.setBounds(480, 340, 160, 40);

        botonAltaRegistroMayorista.setText("Registrar mayorista");
        botonAltaRegistroMayorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAltaRegistroMayoristaActionPerformed(evt);
            }
        });
        panelRegistroMayorista.add(botonAltaRegistroMayorista);
        botonAltaRegistroMayorista.setBounds(280, 340, 160, 40);

        listaSeleccionItemsMayorista.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaSeleccionItemsMayorista.setToolTipText("");
        contenedorListaSeleccionItemsMayorista.setViewportView(listaSeleccionItemsMayorista);

        panelRegistroMayorista.add(contenedorListaSeleccionItemsMayorista);
        contenedorListaSeleccionItemsMayorista.setBounds(730, 70, 180, 154);

        getContentPane().add(panelRegistroMayorista);
        panelRegistroMayorista.setBounds(0, -1, 1290, 590);

        setBounds(0, 0, 1364, 603);
    }// </editor-fold>//GEN-END:initComponents

    private void nombreMayoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreMayoristaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreMayoristaActionPerformed

    private void rutMayoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rutMayoristaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rutMayoristaActionPerformed

    private void direccionMayoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionMayoristaActionPerformed

    }//GEN-LAST:event_direccionMayoristaActionPerformed

    private void botonLimpiarRegistroMayoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarRegistroMayoristaActionPerformed
        nombreMayorista.setText("");
        rutMayorista.setText("");
        direccionMayorista.setText("");
    }//GEN-LAST:event_botonLimpiarRegistroMayoristaActionPerformed

    private void botonAltaRegistroMayoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAltaRegistroMayoristaActionPerformed
        String nombre = nombreMayorista.getText();
        String rutTexto = rutMayorista.getText();
        String direccion = direccionMayorista.getText();
        ArrayList<String> elementosSeleccionados = new ArrayList<>(listaSeleccionItemsMayorista.getSelectedValuesList());

        if (nombre.isEmpty() || rutTexto.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Verifique que todos los campos de información estén siendo llenados", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            if (rutTexto.matches("\\d+")) {
                if (Sistema.mayoristaUnico(rutTexto)) {
                    Sistema.agregarMayorista(nombre, rutTexto, direccion, elementosSeleccionados);
                    JOptionPane.showMessageDialog(this, "Has registrado un mayorista con exito", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                    nombreMayorista.setText("");
                    rutMayorista.setText("");
                    direccionMayorista.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Rut ya registrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "El rut solo puede tener valores numericos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Verifique que el campo 'RUT' sea un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonAltaRegistroMayoristaActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroMayorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroMayorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroMayorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroMayorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroMayorista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAltaRegistroMayorista;
    private javax.swing.JButton botonLimpiarRegistroMayorista;
    private javax.swing.JScrollPane contenedorListaSeleccionItemsMayorista;
    private javax.swing.JTextField direccionMayorista;
    public javax.swing.JList<String> listaSeleccionItemsMayorista;
    private javax.swing.JTextField nombreMayorista;
    private javax.swing.JPanel panelRegistroMayorista;
    private javax.swing.JLabel productosMayorista;
    private javax.swing.JTextField rutMayorista;
    private javax.swing.JLabel textoDireccion;
    private javax.swing.JLabel textoNombreMayorista;
    private javax.swing.JLabel textoRut;
    // End of variables declaration//GEN-END:variables
}
