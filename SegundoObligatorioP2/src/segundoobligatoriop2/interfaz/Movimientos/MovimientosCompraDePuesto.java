package segundoobligatoriop2.interfaz.Movimientos;

/*
      ---------------------------------------------------------
    |                    Sistema desarrollado por                               |
  |    Joaquin Merida 253076 y Juan Manuel Mera  273527 |
 ---------------------------------------------------------
 */
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import segundoobligatoriop2.Sistema;
import segundoobligatoriop2.auxiliar.Item;
import segundoobligatoriop2.auxiliar.Mayorista;
import segundoobligatoriop2.auxiliar.Puesto;

public class MovimientosCompraDePuesto extends javax.swing.JFrame {

    public MovimientosCompraDePuesto() {
        initComponents();
        inicializarListaPuestos();
        inicializarListaMayoristas();
        inicializarListaItemsAComprar();
    }

    private DefaultListModel<String> seleccionListaItemsAComprarModel = new DefaultListModel<>();
    private DefaultListModel<String> seleccionListaPuestosModel = new DefaultListModel<>();
    private DefaultListModel<String> seleccionListaMayoristasModel = new DefaultListModel<>();

    public JButton getBotonCompra() {
        return botonCompraDePuesto;
    }

    private void inicializarListaPuestos() {
        seleccionListaPuestos.setModel(seleccionListaPuestosModel);
        contenedorListaPuestos.setViewportView(seleccionListaPuestos);
        actualizarListaPuestos();
    }

    private void inicializarListaMayoristas() {
        seleccionListaMayoristas.setModel(seleccionListaMayoristasModel);
        contenedorListaMayoristas.setViewportView(seleccionListaMayoristas);
    }

    private void inicializarListaItemsAComprar() {
        listaItemsAComprar.setModel(seleccionListaItemsAComprarModel);
        contenedorListaItemsAComprar.setViewportView(listaItemsAComprar);
    }

    public void actualizarListaMayoristas() {
        ArrayList<Mayorista> listaMayoristas = Sistema.getListaMayoristas();
        if (listaMayoristas.isEmpty()) {
            seleccionListaMayoristasModel.clear();
            seleccionListaMayoristasModel.addElement("No hay ningún mayorista registrado");
        } else {
            seleccionListaMayoristasModel.clear();
            for (Mayorista mayorista : listaMayoristas) {
                String nombreMayorista = mayorista.getNombre();
                String rutMayorista = mayorista.getRut();
                seleccionListaMayoristasModel.addElement(nombreMayorista + "/" + rutMayorista);
            }
        }
    }

    public void actualizarListaItemsAComprar(String rutMayorista) {
        Mayorista mayorista = Sistema.getMayorista(rutMayorista);
        ArrayList<Item> listaItems = mayorista.getListaItems();
        if (listaItems.isEmpty()) {
            seleccionListaItemsAComprarModel.clear();
        } else {
            seleccionListaItemsAComprarModel.clear();
            Collections.sort(listaItems, Comparator.comparing(Item::getNombre));
            for (Item item : listaItems) {
                String nombreItem = item.getNombre();
                seleccionListaItemsAComprarModel.addElement(nombreItem);
            }
        }
    }

    public void actualizarListaPuestos() {
        ArrayList<Puesto> listaPuestos = Sistema.getListaPuesto();
        if (listaPuestos.isEmpty()) {
            seleccionListaPuestosModel.clear();
            seleccionListaPuestosModel.addElement("No hay ningún puesto registrado");
        } else {
            seleccionListaPuestosModel.clear();
            for (Puesto puesto : listaPuestos) {
                String idPuesto = puesto.getIdentificacion();
                seleccionListaPuestosModel.addElement(idPuesto);
            }
        }
    }

    public String getSelectedItem(String nombreLista) {
        try {
            Field field = getClass().getDeclaredField(nombreLista);
            field.setAccessible(true);
            JList<String> listaSeleccionada = (JList<String>) field.get(this);
            if (listaSeleccionada != null) {
                String selectedItem = listaSeleccionada.getSelectedValue();
                return selectedItem;
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return "JList no encontrada";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCompraPuesto = new javax.swing.JPanel();
        tituloCompraPuesto = new javax.swing.JLabel();
        textoSeleccionPuesto = new javax.swing.JLabel();
        textoSeleccionMayoristaVendedor = new javax.swing.JLabel();
        textoPrecioVentaMayorista = new javax.swing.JLabel();
        textoCantidadVentaMayorista = new javax.swing.JLabel();
        precioVentaAPuesto = new javax.swing.JTextField();
        cantidadVentaAPuesto = new javax.swing.JTextField();
        contenedorListaPuestos = new javax.swing.JScrollPane(seleccionListaMayoristas);
        seleccionListaPuestos = new javax.swing.JList<>();
        contenedorListaMayoristas = new javax.swing.JScrollPane(seleccionListaMayoristas);
        seleccionListaMayoristas = new javax.swing.JList<>();
        textoSeleccionItemAComprar = new javax.swing.JLabel();
        botonCompraDePuesto = new javax.swing.JButton();
        contenedorListaItemsAComprar = new javax.swing.JScrollPane();
        listaItemsAComprar = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Compra de puestos");
        getContentPane().setLayout(null);

        panelCompraPuesto.setLayout(null);

        tituloCompraPuesto.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        tituloCompraPuesto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloCompraPuesto.setText("Registrar compra de productos");
        panelCompraPuesto.add(tituloCompraPuesto);
        tituloCompraPuesto.setBounds(220, 10, 630, 60);

        textoSeleccionPuesto.setText("Puesto que realiza la compra:");
        panelCompraPuesto.add(textoSeleccionPuesto);
        textoSeleccionPuesto.setBounds(80, 56, 210, 20);

        textoSeleccionMayoristaVendedor.setText("Mayorista al que le compran:");
        panelCompraPuesto.add(textoSeleccionMayoristaVendedor);
        textoSeleccionMayoristaVendedor.setBounds(80, 250, 210, 16);

        textoPrecioVentaMayorista.setText("Precio individual:");
        panelCompraPuesto.add(textoPrecioVentaMayorista);
        textoPrecioVentaMayorista.setBounds(800, 110, 110, 20);

        textoCantidadVentaMayorista.setText("Cantidad:");
        panelCompraPuesto.add(textoCantidadVentaMayorista);
        textoCantidadVentaMayorista.setBounds(840, 160, 70, 20);
        panelCompraPuesto.add(precioVentaAPuesto);
        precioVentaAPuesto.setBounds(920, 100, 160, 40);
        panelCompraPuesto.add(cantidadVentaAPuesto);
        cantidadVentaAPuesto.setBounds(920, 150, 160, 40);

        seleccionListaPuestos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                seleccionListaPuestosValueChanged(evt);
            }
        });
        contenedorListaPuestos.setViewportView(seleccionListaPuestos);

        panelCompraPuesto.add(contenedorListaPuestos);
        contenedorListaPuestos.setBounds(80, 80, 300, 150);

        seleccionListaMayoristas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                seleccionListaMayoristasValueChanged(evt);
            }
        });
        contenedorListaMayoristas.setViewportView(seleccionListaMayoristas);

        panelCompraPuesto.add(contenedorListaMayoristas);
        contenedorListaMayoristas.setBounds(80, 270, 300, 150);

        textoSeleccionItemAComprar.setText("Item:");
        panelCompraPuesto.add(textoSeleccionItemAComprar);
        textoSeleccionItemAComprar.setBounds(490, 90, 60, 16);

        botonCompraDePuesto.setText("Realizar compra");
        botonCompraDePuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCompraDePuestoActionPerformed(evt);
            }
        });
        panelCompraPuesto.add(botonCompraDePuesto);
        botonCompraDePuesto.setBounds(530, 270, 380, 130);

        listaItemsAComprar.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaItemsAComprar.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaItemsAComprarValueChanged(evt);
            }
        });
        contenedorListaItemsAComprar.setViewportView(listaItemsAComprar);

        panelCompraPuesto.add(contenedorListaItemsAComprar);
        contenedorListaItemsAComprar.setBounds(560, 90, 210, 130);

        getContentPane().add(panelCompraPuesto);
        panelCompraPuesto.setBounds(0, 12, 1210, 529);

        setSize(new java.awt.Dimension(1171, 562));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionListaPuestosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_seleccionListaPuestosValueChanged
        if (!evt.getValueIsAdjusting()) {
            String selectedItem = getSelectedItem("seleccionListaPuestos");
        }
    }//GEN-LAST:event_seleccionListaPuestosValueChanged

    private void seleccionListaMayoristasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_seleccionListaMayoristasValueChanged
        if (!evt.getValueIsAdjusting() && getSelectedItem("seleccionListaMayoristas") != null &&  !getSelectedItem("seleccionListaMayoristas").equalsIgnoreCase("No hay ningún mayorista registrado")) {
            String selectedItem = getSelectedItem("seleccionListaMayoristas");
            String rutMayorista;
            String corte = "/";
            String[] fragmentos = selectedItem.split(corte);
            rutMayorista = fragmentos[1];
            actualizarListaItemsAComprar(rutMayorista);
        }
    }//GEN-LAST:event_seleccionListaMayoristasValueChanged

    private void botonCompraDePuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCompraDePuestoActionPerformed
        String itemSeleccionado = getSelectedItem("listaItemsAComprar");
        String mayoristaSeleccionado = getSelectedItem("seleccionListaMayoristas");
        String puestoSeleccionado = getSelectedItem("seleccionListaPuestos");
        String corte = "/";
        String[] fragmentos = null;
        if (mayoristaSeleccionado != null && !mayoristaSeleccionado.equalsIgnoreCase("No hay ningún mayorista registrado") && itemSeleccionado != null && puestoSeleccionado != null && !puestoSeleccionado.equalsIgnoreCase("No hay ningún puesto registrado")) {
            fragmentos = mayoristaSeleccionado.split(corte);
            String rutMayorista = fragmentos[1];
            String precioTexto = precioVentaAPuesto.getText();
            String cantidadTexto = cantidadVentaAPuesto.getText();
            if ((precioTexto.matches("\\d+") && Integer.parseInt(precioTexto) >= 1) && (cantidadTexto.matches("\\d+") && Integer.parseInt(cantidadTexto) >= 1)) {
                int precio = Integer.parseInt(precioVentaAPuesto.getText());
                double cantidad = Double.parseDouble(cantidadVentaAPuesto.getText());
                Sistema.realizarCompraDePuesto(rutMayorista, puestoSeleccionado, itemSeleccionado, precio, cantidad);
                precioVentaAPuesto.setText("");
                cantidadVentaAPuesto.setText("");
                JOptionPane.showMessageDialog(this, "Has realizado una compra con exito", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error: Los campos tienen que ser numericos y solo se aceptan compras mayores a 0 ", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_botonCompraDePuestoActionPerformed

    private void listaItemsAComprarValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaItemsAComprarValueChanged


    }//GEN-LAST:event_listaItemsAComprarValueChanged

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MovimientosCompraDePuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovimientosCompraDePuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovimientosCompraDePuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovimientosCompraDePuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovimientosCompraDePuesto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCompraDePuesto;
    private javax.swing.JTextField cantidadVentaAPuesto;
    private javax.swing.JScrollPane contenedorListaItemsAComprar;
    private javax.swing.JScrollPane contenedorListaMayoristas;
    private javax.swing.JScrollPane contenedorListaPuestos;
    private javax.swing.JList<String> listaItemsAComprar;
    private javax.swing.JPanel panelCompraPuesto;
    private javax.swing.JTextField precioVentaAPuesto;
    private javax.swing.JList<String> seleccionListaMayoristas;
    private javax.swing.JList<String> seleccionListaPuestos;
    private javax.swing.JLabel textoCantidadVentaMayorista;
    private javax.swing.JLabel textoPrecioVentaMayorista;
    private javax.swing.JLabel textoSeleccionItemAComprar;
    private javax.swing.JLabel textoSeleccionMayoristaVendedor;
    private javax.swing.JLabel textoSeleccionPuesto;
    private javax.swing.JLabel tituloCompraPuesto;
    // End of variables declaration//GEN-END:variables
}
