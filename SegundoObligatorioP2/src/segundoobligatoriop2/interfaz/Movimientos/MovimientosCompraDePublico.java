package segundoobligatoriop2.interfaz.Movimientos;

/*
      ---------------------------------------------------------
    |                    Sistema desarrollado por                               |
  |    Joaquin Merida 253076 y Juan Manuel Mera  273527 |
 ---------------------------------------------------------
 */
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
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

public class MovimientosCompraDePublico extends javax.swing.JFrame {

    public MovimientosCompraDePublico() {
        initComponents();
        inicializarComboPuestos();
    }

    public void inicializarComboPuestos() {
        movimientoComboDePuestosVenta.setModel(new DefaultComboBoxModel<>());
        movimientoComboDePuestosVenta.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedOption = (String) movimientoComboDePuestosVenta.getSelectedItem();
                    if (!selectedOption.equals("Seleccione un puesto")) {
                        actualizarGrilla(selectedOption);
                    }
                }
            }
        });
    }

    public void actualizarPuestoQueVende() {
        ArrayList<Puesto> listaPuestos = Sistema.getListaPuesto();
        DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) movimientoComboDePuestosVenta.getModel();

        comboBoxModel.removeAllElements();
        for (Puesto puesto : listaPuestos) {
            comboBoxModel.addElement(puesto.getIdentificacion());
        }
    }

    public void actualizarGrilla(String idPuesto) {
        ArrayList<Puesto> listaPuestos = Sistema.getListaPuesto();
        for (Puesto puesto : listaPuestos) {
            if (puesto.getIdentificacion().equals(idPuesto)) {
                contenedorProductos.removeAll();
                ArrayList<Item> stock = puesto.getStock();
                puesto.ordenarStock();

                for (Item item : stock) {
                    if (item.getCantidad() > 0) {
                        JButton botonItem = new JButton();
                        int anchoContenedor = contenedorProductos.getWidth();
                        int anchoBoton = anchoContenedor / 2;
                        botonItem.setPreferredSize(new Dimension(anchoBoton, 80));
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
                contenedorProductos.revalidate();
                contenedorProductos.repaint();
                break;
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
        int opcion = JOptionPane.showOptionDialog(this, panel, "Realizar compra",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                new String[]{"Comprar", "Cancelar"}, "Comprar");
        if (opcion == JOptionPane.OK_OPTION) {

            int precio = Integer.parseInt(txtPrecio.getText());
            double cantidad = Double.parseDouble(txtCantidad.getText());
            if (Sistema.realizarCompraDePublico(idVendedor, "Publico", itemVendido, precio, cantidad)) {
                Sistema.realizarCompraDePublico(idVendedor, "Publico", itemVendido, precio, cantidad);
                actualizarGrilla(idVendedor);
                double total = precio * cantidad;
                JOptionPane.showMessageDialog(this, "Total a pagar: $" + total, "Total a pagar", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "el puesto no cuenta con esa cantidad de productos");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Compra cancelada");
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
        tituloCompraPublico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Compra del publico");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
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
        panelVentaPublico.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                panelVentaPublicoComponentShown(evt);
            }
        });
        panelVentaPublico.setLayout(null);

        textoSeleccionPuestoQueVende.setText("Puestos:");
        panelVentaPublico.add(textoSeleccionPuestoQueVende);
        textoSeleccionPuestoQueVende.setBounds(90, 100, 80, 16);

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
        movimientoComboDePuestosVenta.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                movimientoComboDePuestosVentaPropertyChange(evt);
            }
        });
        panelVentaPublico.add(movimientoComboDePuestosVenta);
        movimientoComboDePuestosVenta.setBounds(180, 90, 160, 40);

        contenedorProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contenedorProductos.setLayout(new java.awt.GridLayout(6, 2));
        panelVentaPublico.add(contenedorProductos);
        contenedorProductos.setBounds(480, 80, 440, 510);

        tituloCompraPublico.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        tituloCompraPublico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloCompraPublico.setText("Compra del publico");
        panelVentaPublico.add(tituloCompraPublico);
        tituloCompraPublico.setBounds(190, 10, 610, 70);

        getContentPane().add(panelVentaPublico);
        panelVentaPublico.setBounds(0, 0, 1020, 600);

        setBounds(0, 0, 1030, 607);
    }// </editor-fold>//GEN-END:initComponents

    private void movimientoComboDePuestosVentaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_movimientoComboDePuestosVentaItemStateChanged
        String selectedOption = (String) movimientoComboDePuestosVenta.getSelectedItem();
        actualizarGrilla(selectedOption);
    }//GEN-LAST:event_movimientoComboDePuestosVentaItemStateChanged

    private void movimientoComboDePuestosVentaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movimientoComboDePuestosVentaMouseReleased

    }//GEN-LAST:event_movimientoComboDePuestosVentaMouseReleased

    private void movimientoComboDePuestosVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movimientoComboDePuestosVentaActionPerformed

    }//GEN-LAST:event_movimientoComboDePuestosVentaActionPerformed

    private void panelVentaPublicoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVentaPublicoMouseMoved

    }//GEN-LAST:event_panelVentaPublicoMouseMoved

    private void panelVentaPublicoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVentaPublicoMouseEntered

    }//GEN-LAST:event_panelVentaPublicoMouseEntered

    private void panelVentaPublicoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelVentaPublicoComponentShown
        actualizarPuestoQueVende();

    }//GEN-LAST:event_panelVentaPublicoComponentShown

    private void movimientoComboDePuestosVentaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_movimientoComboDePuestosVentaPropertyChange

    }//GEN-LAST:event_movimientoComboDePuestosVentaPropertyChange

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String selectedOption = (String) movimientoComboDePuestosVenta.getSelectedItem();
        actualizarGrilla(selectedOption);
    }//GEN-LAST:event_formWindowOpened

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
    private javax.swing.JLabel tituloCompraPublico;
    // End of variables declaration//GEN-END:variables
}
