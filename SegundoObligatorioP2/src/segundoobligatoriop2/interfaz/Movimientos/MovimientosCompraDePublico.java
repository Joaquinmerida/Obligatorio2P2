/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package segundoobligatoriop2.interfaz.Movimientos;

import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import segundoobligatoriop2.Sistema;
import segundoobligatoriop2.auxiliar.Item;
import segundoobligatoriop2.auxiliar.Puesto;

/**
 *
 * @author joaqu
 */
public class MovimientosCompraDePublico extends javax.swing.JFrame {

    /**
     * Creates new form MovimientosCompraDePublico
     */
    public MovimientosCompraDePublico() {
        initComponents();
    }

    public void actualizarGrilla(String idPuesto) {
        ArrayList<Puesto> listaPuestos = Sistema.getListaPuesto();
        Iterator<Puesto> iterator = listaPuestos.iterator();
        while (iterator.hasNext()) {
            Puesto puesto = iterator.next();
            if (puesto.getIdentificacion().equals(idPuesto)) {
                ArrayList<Item> stock = new ArrayList<>();
                stock.addAll(puesto.getStock());
                contenedorProductos.removeAll();
                Iterator<Item> stockIterator = stock.iterator();
                while (stockIterator.hasNext()) {
                    Item item = stockIterator.next();
                    if (item.getCantidad() > 0) {
                        puesto.ordenarStock();
                        JButton botonItem = new JButton();
                        botonItem.setSize(80, 80);
                        ImageIcon imageIcon = new ImageIcon(item.getImagen());
                        botonItem.setToolTipText(item.getNombre());
                        Image image = imageIcon.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
                        botonItem.setIcon(new ImageIcon(image));
                        botonItem.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                mostrarPopupCompra(puesto.getIdentificacion(), item);

                            }
                        });
                        contenedorProductos.add(botonItem);
                    }
                }
                stock.clear();
                contenedorProductos.revalidate();
                contenedorProductos.repaint();
            }
        }
    }

    private void mostrarPopupCompra(String idVendedor, Item itemVendido) {
        JPanel panel = new JPanel();
        JLabel lblPrecio = new JLabel("Precio:");
        JTextField txtPrecio = new JTextField(10);
        JLabel lblCantidad = new JLabel("Cantidad:");
        JTextField txtCantidad = new JTextField(10);
        panel.add(lblPrecio);
        panel.add(txtPrecio);
        panel.add(lblCantidad);
        panel.add(txtCantidad);
        int opcion = JOptionPane.showOptionDialog(null, panel, "Realizar compra",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                new String[]{"Comprar", "Cancelar"}, "Comprar");
        if (opcion == JOptionPane.OK_OPTION) {
            int precio = Integer.parseInt(txtPrecio.getText());
            double cantidad = Double.parseDouble(txtCantidad.getText());
            Sistema.realizarCompraDePublico(idVendedor, "Publico", itemVendido, precio, cantidad);
            double total = precio * cantidad;
            JOptionPane.showMessageDialog(null, "Total a pagar: $" + total);
            actualizarGrilla(idVendedor);
        } else {
            JOptionPane.showMessageDialog(null, "Compra cancelada");
        }
        Window dialog = SwingUtilities.windowForComponent(panel);
        if (dialog != null) {
            dialog.setLocationRelativeTo(null);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelVentaPublico = new javax.swing.JPanel();
        textoSeleccionPuestoQueVende = new javax.swing.JLabel();
        movimientoComboDePuestosVenta = new javax.swing.JComboBox<>();
        contenedorProductos = new java.awt.Panel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Compra del publico");
        getContentPane().setLayout(null);

        panelVentaPublico.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelVentaPublicoMouseMoved(evt);
            }
        });
        panelVentaPublico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelVentaPublicoMouseEntered(evt);
            }
        });
        panelVentaPublico.setLayout(null);

        textoSeleccionPuestoQueVende.setText("Puestos:");
        panelVentaPublico.add(textoSeleccionPuestoQueVende);
        textoSeleccionPuestoQueVende.setBounds(90, 100, 60, 16);

        movimientoComboDePuestosVenta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                movimientoComboDePuestosVentaItemStateChanged(evt);
            }
        });
        movimientoComboDePuestosVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                movimientoComboDePuestosVentaMouseReleased(evt);
            }
        });
        movimientoComboDePuestosVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movimientoComboDePuestosVentaActionPerformed(evt);
            }
        });
        panelVentaPublico.add(movimientoComboDePuestosVenta);
        movimientoComboDePuestosVenta.setBounds(140, 90, 160, 40);

        contenedorProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contenedorProductos.setLayout(new java.awt.GridLayout(3, 2));
        panelVentaPublico.add(contenedorProductos);
        contenedorProductos.setBounds(480, 40, 440, 390);

        getContentPane().add(panelVentaPublico);
        panelVentaPublico.setBounds(0, 0, 1020, 510);

        setBounds(0, 0, 1030, 607);
    }// </editor-fold>//GEN-END:initComponents

    private void movimientoComboDePuestosVentaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_movimientoComboDePuestosVentaItemStateChanged
        String selectedOption = (String) movimientoComboDePuestosVenta.getSelectedItem();
        actualizarGrilla(selectedOption);
    }//GEN-LAST:event_movimientoComboDePuestosVentaItemStateChanged

    private void movimientoComboDePuestosVentaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movimientoComboDePuestosVentaMouseReleased

    }//GEN-LAST:event_movimientoComboDePuestosVentaMouseReleased

    private void movimientoComboDePuestosVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movimientoComboDePuestosVentaActionPerformed
        String selectedOption = (String) movimientoComboDePuestosVenta.getSelectedItem();
        actualizarGrilla(selectedOption);
    }//GEN-LAST:event_movimientoComboDePuestosVentaActionPerformed

    private void panelVentaPublicoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVentaPublicoMouseMoved

    }//GEN-LAST:event_panelVentaPublicoMouseMoved

    private void panelVentaPublicoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVentaPublicoMouseEntered

    }//GEN-LAST:event_panelVentaPublicoMouseEntered

   
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MovimientosCompraDePublico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovimientosCompraDePublico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovimientosCompraDePublico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovimientosCompraDePublico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovimientosCompraDePublico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Panel contenedorProductos;
    private javax.swing.JComboBox<String> movimientoComboDePuestosVenta;
    private javax.swing.JPanel panelVentaPublico;
    private javax.swing.JLabel textoSeleccionPuestoQueVende;
    // End of variables declaration//GEN-END:variables
}
