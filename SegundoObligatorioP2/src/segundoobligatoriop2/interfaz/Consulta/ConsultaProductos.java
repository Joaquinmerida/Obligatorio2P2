package segundoobligatoriop2.interfaz.Consulta;

/*
      ---------------------------------------------------------
    |                    Sistema desarrollado por                               |
  |    Joaquin Merida 253076 y Juan Manuel Mera  273527 |
 ---------------------------------------------------------
*/                           

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import segundoobligatoriop2.Sistema;
import segundoobligatoriop2.auxiliar.Item;
import segundoobligatoriop2.auxiliar.Transaccion;

public class ConsultaProductos extends javax.swing.JFrame {

    public ConsultaProductos() {
        initComponents();
        generarListaPuestosBaratos();
        generarListaPuestosCaros();
    }

    private DefaultListModel<String> seleccionListaPuestosMasBaratos = new DefaultListModel<>();
    private DefaultListModel<String> seleccionListaPuestosMasCaros = new DefaultListModel<>();

    public void generarListaPuestosBaratos() {
        consultasPrecioMin.setModel(seleccionListaPuestosMasBaratos);
        contenedorListaPuestosMenorPrecioConsultaProducto.setViewportView(consultasPrecioMin);
    }

    public void generarListaPuestosCaros() {
        consultasPrecioMax.setModel(seleccionListaPuestosMasCaros);
        contenedorListaPuestosMayorPrecioConsultaProducto.setViewportView(consultasPrecioMax);
    }

    public void actualizarListaPuestosBaratos() {
        int minimo = Integer.MAX_VALUE;
        seleccionListaPuestosMasBaratos.clear();
        String item = consultasNombre.getText();
        ArrayList<String> puestoBarato = new ArrayList<>();
        ArrayList<Transaccion> listaTransacciones = Sistema.getListaTransacciones();
        for (Transaccion transaccion : listaTransacciones) {
            if (transaccion.getComprador().equalsIgnoreCase("Publico") && transaccion.getItemVenta().getNombre().equalsIgnoreCase(item)) {
                if (transaccion.getPrecio() < minimo) {
                    minimo=transaccion.getPrecio();
                    puestoBarato.clear();
                    puestoBarato.add(transaccion.getVendedor());
                } else if (transaccion.getPrecio() == minimo && !puestoBarato.contains(transaccion.getVendedor())) {
                    puestoBarato.add(transaccion.getVendedor());
                }
            }
        }
        for (String puesto : puestoBarato) {
            seleccionListaPuestosMasBaratos.addElement(puesto);
        }
    }

    public void actualizarListaPuestosCaros() {
        int maximo = Integer.MIN_VALUE;
        seleccionListaPuestosMasCaros.clear();
        String item = consultasNombre.getText();
        ArrayList<String> puestoCaro = new ArrayList<>();
        ArrayList<Transaccion> listaTransacciones = Sistema.getListaTransacciones();
        for (Transaccion transaccion : listaTransacciones) {
            if (transaccion.getComprador().equalsIgnoreCase("Publico") && transaccion.getItemVenta().getNombre().equalsIgnoreCase(item)) {
                if (transaccion.getPrecio() > maximo) {
                    maximo=transaccion.getPrecio();
                    puestoCaro.clear();
                    puestoCaro.add(transaccion.getVendedor());
                } else if (transaccion.getPrecio() == maximo && !puestoCaro.contains(transaccion.getVendedor())) {
                    puestoCaro.add(transaccion.getVendedor());
                }
            }
        }
        for (String puesto : puestoCaro) {
            seleccionListaPuestosMasCaros.addElement(puesto);
        }
    }

    public void cambiarItemConsulta(int cambio, String itemMostrado) {
        ArrayList<Item> listaItems = Sistema.getListaItems();
        Collections.sort(listaItems, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return item1.getNombre().compareTo(item2.getNombre());
            }
        });
        int j = Sistema.getIndexItem(itemMostrado);

        if (j + cambio >= 0 && j + cambio < listaItems.size()) {
            j = j + cambio;
        } else {
            if (j + cambio > listaItems.size() - 1) {
                j = 0;
            } else {

                j = listaItems.size() - 1;
            }
        }
        for (int i = 0; i < listaItems.size(); i++) {
            if (j == i) {
                consultasNombre.setText(listaItems.get(j).getNombre());
                consultasDescripcion.setText(listaItems.get(j).getDescripcion());
                consultasTipo.setText(listaItems.get(j).getTipo());
                consultasVentaPor.setText(listaItems.get(j).getFormaVenta());
                String Ruta = listaItems.get(j).getImagen();
                Image mImagen = new ImageIcon(Ruta).getImage();
                ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(consultasImagen.getWidth(), consultasImagen.getHeight(), Image.SCALE_SMOOTH));
                consultasImagen.setIcon(mIcono);
                consultaTotalVendidoEntrePuestos.setText(Integer.toString(Sistema.getTotalDineroVentaPuestos(listaItems.get(j))));
                consultaTotalCompradoEntrePuestos.setText(Integer.toString(Sistema.getTotalDineroVentaMayoristas(listaItems.get(j))));
                consultaCantidadKgVendidaPuestos.setText(Double.toString(Sistema.getKgTotalVendidoPuestos(listaItems.get(j))));
                consultaCantidadUnidadesVendidaPuestos.setText(Integer.toString(Sistema.getUnidadesTotalVendidoPuestos(listaItems.get(j))));
                consultaCantidadKilogramosCompradaPuestos.setText(Double.toString(Sistema.getKgTotalCompradoPuestos(listaItems.get(j))));
                consultaCantidadUnidadesCompradaPuestos.setText(Integer.toString(Sistema.getUnidadesTotalCompradoPuestos(listaItems.get(j))));
                consultaPrecioMinimoVendido.setText(Integer.toString(Sistema.getMinimoVendido(listaItems.get(j))));
                consultaPrecioMaximoVendido.setText(Integer.toString(Sistema.getMaximoVendido(listaItems.get(j))));
                actualizarListaPuestosBaratos();
                actualizarListaPuestosCaros();
            }
        }
    }

    public void mostrarItemConsulta() {
        ArrayList<Item> listaItems = Sistema.getListaItems();
        if (!listaItems.isEmpty()) {
            consultasNombre.setText(listaItems.get(0).getNombre());
            consultasDescripcion.setText(listaItems.get(0).getDescripcion());
            consultasTipo.setText(listaItems.get(0).getTipo());
            consultasVentaPor.setText(listaItems.get(0).getFormaVenta());
            String Ruta = listaItems.get(0).getImagen();
            Image mImagen = new ImageIcon(Ruta).getImage();
            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(consultasImagen.getWidth(), consultasImagen.getHeight(), Image.SCALE_SMOOTH));
            consultasImagen.setIcon(mIcono);
            consultaTotalVendidoEntrePuestos.setText(Integer.toString(Sistema.getTotalDineroVentaPuestos(listaItems.get(0))));
            consultaTotalCompradoEntrePuestos.setText(Integer.toString(Sistema.getTotalDineroVentaMayoristas(listaItems.get(0))));
            consultaCantidadKgVendidaPuestos.setText(Double.toString(Sistema.getKgTotalVendidoPuestos(listaItems.get(0))));
            consultaCantidadUnidadesVendidaPuestos.setText(Integer.toString(Sistema.getUnidadesTotalVendidoPuestos(listaItems.get(0))));
            consultaCantidadKilogramosCompradaPuestos.setText(Double.toString(Sistema.getKgTotalCompradoPuestos(listaItems.get(0))));
            consultaCantidadUnidadesCompradaPuestos.setText(Integer.toString(Sistema.getUnidadesTotalCompradoPuestos(listaItems.get(0))));
            consultaPrecioMinimoVendido.setText(Integer.toString(Sistema.getMinimoVendido(listaItems.get(0))));
            consultaPrecioMaximoVendido.setText(Integer.toString(Sistema.getMaximoVendido(listaItems.get(0))));
            actualizarListaPuestosBaratos();
            actualizarListaPuestosCaros();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelConsultaProducto = new javax.swing.JPanel();
        consultasImagen = new javax.swing.JLabel();
        textoNombreConsultaProducto = new javax.swing.JLabel();
        textoDescripcionConsultaProducto = new javax.swing.JLabel();
        textoTipoConsultaProducto = new javax.swing.JLabel();
        textoVenntaPorConsultaProducto = new javax.swing.JLabel();
        consultasNombre = new javax.swing.JTextField();
        consultasDescripcion = new javax.swing.JTextField();
        textoInfoConsultaProducto = new javax.swing.JLabel();
        textoTotalVendidoConsultaProducto = new javax.swing.JLabel();
        textoTotalCompradoConsultaProducto = new javax.swing.JLabel();
        textoCantidadVendidaConsultaProducto = new javax.swing.JLabel();
        textoCantidadTotalCompradaConsultaProducto = new javax.swing.JLabel();
        textoPrecioMinimoConsultaProducto = new javax.swing.JLabel();
        textoPrecioMaximoConsultaProducto = new javax.swing.JLabel();
        textoPrecioVentaMinimoConsultaProducto = new javax.swing.JLabel();
        textoPrecioVentaMaximoConsultaProducto = new javax.swing.JLabel();
        contenedorListaPuestosMenorPrecioConsultaProducto = new javax.swing.JScrollPane();
        consultasPrecioMin = new javax.swing.JList<>();
        contenedorListaPuestosMayorPrecioConsultaProducto = new javax.swing.JScrollPane();
        consultasPrecioMax = new javax.swing.JList<>();
        consultasBotonDerecha = new javax.swing.JButton();
        consultasBotonIzquierda = new javax.swing.JButton();
        consultasVentaPor = new javax.swing.JTextField();
        consultasTipo = new javax.swing.JTextField();
        consultaPrecioMaximoVendido = new javax.swing.JTextField();
        consultaTotalVendidoEntrePuestos = new javax.swing.JTextField();
        consultaTotalCompradoEntrePuestos = new javax.swing.JTextField();
        consultaCantidadKgVendidaPuestos = new javax.swing.JTextField();
        consultaPrecioMinimoVendido = new javax.swing.JTextField();
        consultaCantidadUnidadesVendidaPuestos = new javax.swing.JTextField();
        textoConsultaUnidadesVendidasPuestos = new javax.swing.JLabel();
        textoConsultaKilogramosVendidosPuestos = new javax.swing.JLabel();
        textoConsultaUnidadesCompradasPuestos = new javax.swing.JLabel();
        consultaCantidadUnidadesCompradaPuestos = new javax.swing.JTextField();
        textoConsultaKilogramosCompradosPuestos = new javax.swing.JLabel();
        consultaCantidadKilogramosCompradaPuestos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de productos");
        getContentPane().setLayout(null);

        panelConsultaProducto.setLayout(null);
        panelConsultaProducto.add(consultasImagen);
        consultasImagen.setBounds(10, 20, 160, 170);

        textoNombreConsultaProducto.setText("Nombre:");
        panelConsultaProducto.add(textoNombreConsultaProducto);
        textoNombreConsultaProducto.setBounds(190, 60, 70, 16);

        textoDescripcionConsultaProducto.setText("Descripcion:");
        panelConsultaProducto.add(textoDescripcionConsultaProducto);
        textoDescripcionConsultaProducto.setBounds(190, 110, 80, 16);

        textoTipoConsultaProducto.setText("Tipo:");
        panelConsultaProducto.add(textoTipoConsultaProducto);
        textoTipoConsultaProducto.setBounds(190, 160, 26, 16);

        textoVenntaPorConsultaProducto.setText("Venta por:");
        panelConsultaProducto.add(textoVenntaPorConsultaProducto);
        textoVenntaPorConsultaProducto.setBounds(190, 220, 60, 16);

        consultasNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        consultasNombre.setEnabled(false);
        consultasNombre.setFocusable(false);
        panelConsultaProducto.add(consultasNombre);
        consultasNombre.setBounds(290, 60, 230, 22);

        consultasDescripcion.setEnabled(false);
        panelConsultaProducto.add(consultasDescripcion);
        consultasDescripcion.setBounds(290, 110, 230, 22);

        textoInfoConsultaProducto.setText("Informacion del producto:");
        panelConsultaProducto.add(textoInfoConsultaProducto);
        textoInfoConsultaProducto.setBounds(560, 60, 190, 16);

        textoTotalVendidoConsultaProducto.setText("Total $ vendido entre todos los puestos:");
        panelConsultaProducto.add(textoTotalVendidoConsultaProducto);
        textoTotalVendidoConsultaProducto.setBounds(560, 100, 250, 16);

        textoTotalCompradoConsultaProducto.setText("Total $ comprado por todos los puestos:");
        panelConsultaProducto.add(textoTotalCompradoConsultaProducto);
        textoTotalCompradoConsultaProducto.setBounds(560, 140, 250, 16);

        textoCantidadVendidaConsultaProducto.setText("Cantidad total vendida entre todos los puestos:");
        panelConsultaProducto.add(textoCantidadVendidaConsultaProducto);
        textoCantidadVendidaConsultaProducto.setBounds(560, 180, 420, 16);

        textoCantidadTotalCompradaConsultaProducto.setText("Cantidad total comprada entre todos los puestos:");
        panelConsultaProducto.add(textoCantidadTotalCompradaConsultaProducto);
        textoCantidadTotalCompradaConsultaProducto.setBounds(560, 220, 420, 16);

        textoPrecioMinimoConsultaProducto.setText("Precio minimo vendido:");
        panelConsultaProducto.add(textoPrecioMinimoConsultaProducto);
        textoPrecioMinimoConsultaProducto.setBounds(560, 260, 140, 16);

        textoPrecioMaximoConsultaProducto.setText("Precio maximo vendido:");
        panelConsultaProducto.add(textoPrecioMaximoConsultaProducto);
        textoPrecioMaximoConsultaProducto.setBounds(760, 260, 170, 16);

        textoPrecioVentaMinimoConsultaProducto.setText("Puestos con el precio de venta minimo:");
        panelConsultaProducto.add(textoPrecioVentaMinimoConsultaProducto);
        textoPrecioVentaMinimoConsultaProducto.setBounds(560, 300, 250, 16);

        textoPrecioVentaMaximoConsultaProducto.setText("Puestos con el precio de venta maximo:");
        panelConsultaProducto.add(textoPrecioVentaMaximoConsultaProducto);
        textoPrecioVentaMaximoConsultaProducto.setBounds(820, 300, 270, 16);

        consultasPrecioMin.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        contenedorListaPuestosMenorPrecioConsultaProducto.setViewportView(consultasPrecioMin);

        panelConsultaProducto.add(contenedorListaPuestosMenorPrecioConsultaProducto);
        contenedorListaPuestosMenorPrecioConsultaProducto.setBounds(560, 340, 210, 180);

        consultasPrecioMax.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        contenedorListaPuestosMayorPrecioConsultaProducto.setViewportView(consultasPrecioMax);

        panelConsultaProducto.add(contenedorListaPuestosMayorPrecioConsultaProducto);
        contenedorListaPuestosMayorPrecioConsultaProducto.setBounds(820, 340, 210, 180);

        consultasBotonDerecha.setText(">");
        consultasBotonDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultasBotonDerechaActionPerformed(evt);
            }
        });
        panelConsultaProducto.add(consultasBotonDerecha);
        consultasBotonDerecha.setBounds(170, 290, 110, 60);

        consultasBotonIzquierda.setText("<");
        consultasBotonIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultasBotonIzquierdaActionPerformed(evt);
            }
        });
        panelConsultaProducto.add(consultasBotonIzquierda);
        consultasBotonIzquierda.setBounds(40, 290, 110, 60);

        consultasVentaPor.setEnabled(false);
        consultasVentaPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultasVentaPorActionPerformed(evt);
            }
        });
        panelConsultaProducto.add(consultasVentaPor);
        consultasVentaPor.setBounds(290, 220, 230, 22);

        consultasTipo.setEnabled(false);
        panelConsultaProducto.add(consultasTipo);
        consultasTipo.setBounds(290, 160, 230, 22);

        consultaPrecioMaximoVendido.setEnabled(false);
        consultaPrecioMaximoVendido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaPrecioMaximoVendidoActionPerformed(evt);
            }
        });
        panelConsultaProducto.add(consultaPrecioMaximoVendido);
        consultaPrecioMaximoVendido.setBounds(910, 260, 40, 20);

        consultaTotalVendidoEntrePuestos.setEnabled(false);
        consultaTotalVendidoEntrePuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaTotalVendidoEntrePuestosActionPerformed(evt);
            }
        });
        panelConsultaProducto.add(consultaTotalVendidoEntrePuestos);
        consultaTotalVendidoEntrePuestos.setBounds(820, 100, 130, 20);

        consultaTotalCompradoEntrePuestos.setEnabled(false);
        consultaTotalCompradoEntrePuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaTotalCompradoEntrePuestosActionPerformed(evt);
            }
        });
        panelConsultaProducto.add(consultaTotalCompradoEntrePuestos);
        consultaTotalCompradoEntrePuestos.setBounds(820, 140, 130, 20);

        consultaCantidadKgVendidaPuestos.setEnabled(false);
        consultaCantidadKgVendidaPuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaCantidadKgVendidaPuestosActionPerformed(evt);
            }
        });
        panelConsultaProducto.add(consultaCantidadKgVendidaPuestos);
        consultaCantidadKgVendidaPuestos.setBounds(920, 180, 30, 20);

        consultaPrecioMinimoVendido.setEnabled(false);
        consultaPrecioMinimoVendido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaPrecioMinimoVendidoActionPerformed(evt);
            }
        });
        panelConsultaProducto.add(consultaPrecioMinimoVendido);
        consultaPrecioMinimoVendido.setBounds(700, 260, 40, 20);

        consultaCantidadUnidadesVendidaPuestos.setEnabled(false);
        consultaCantidadUnidadesVendidaPuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaCantidadUnidadesVendidaPuestosActionPerformed(evt);
            }
        });
        panelConsultaProducto.add(consultaCantidadUnidadesVendidaPuestos);
        consultaCantidadUnidadesVendidaPuestos.setBounds(1030, 180, 30, 20);

        textoConsultaUnidadesVendidasPuestos.setText("Unidades");
        panelConsultaProducto.add(textoConsultaUnidadesVendidasPuestos);
        textoConsultaUnidadesVendidasPuestos.setBounds(970, 180, 60, 16);

        textoConsultaKilogramosVendidosPuestos.setText("Kilogramos");
        panelConsultaProducto.add(textoConsultaKilogramosVendidosPuestos);
        textoConsultaKilogramosVendidosPuestos.setBounds(850, 180, 70, 16);

        textoConsultaUnidadesCompradasPuestos.setText("Unidades");
        panelConsultaProducto.add(textoConsultaUnidadesCompradasPuestos);
        textoConsultaUnidadesCompradasPuestos.setBounds(980, 220, 60, 16);

        consultaCantidadUnidadesCompradaPuestos.setEnabled(false);
        consultaCantidadUnidadesCompradaPuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaCantidadUnidadesCompradaPuestosActionPerformed(evt);
            }
        });
        panelConsultaProducto.add(consultaCantidadUnidadesCompradaPuestos);
        consultaCantidadUnidadesCompradaPuestos.setBounds(1040, 220, 30, 20);

        textoConsultaKilogramosCompradosPuestos.setText("Kilogramos");
        panelConsultaProducto.add(textoConsultaKilogramosCompradosPuestos);
        textoConsultaKilogramosCompradosPuestos.setBounds(860, 220, 70, 16);

        consultaCantidadKilogramosCompradaPuestos.setEnabled(false);
        consultaCantidadKilogramosCompradaPuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaCantidadKilogramosCompradaPuestosActionPerformed(evt);
            }
        });
        panelConsultaProducto.add(consultaCantidadKilogramosCompradaPuestos);
        consultaCantidadKilogramosCompradaPuestos.setBounds(930, 220, 30, 20);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consulta de productos");
        panelConsultaProducto.add(jLabel1);
        jLabel1.setBounds(50, -10, 970, 70);

        getContentPane().add(panelConsultaProducto);
        panelConsultaProducto.setBounds(0, 0, 1100, 560);

        setSize(new java.awt.Dimension(1116, 637));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void consultasBotonDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultasBotonDerechaActionPerformed
        String itemMostrado = consultasNombre.getText();
        cambiarItemConsulta(1, itemMostrado);
    }//GEN-LAST:event_consultasBotonDerechaActionPerformed

    private void consultasBotonIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultasBotonIzquierdaActionPerformed
        String itemMostrado = consultasNombre.getText();
        cambiarItemConsulta(-1, itemMostrado);
    }//GEN-LAST:event_consultasBotonIzquierdaActionPerformed

    private void consultasVentaPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultasVentaPorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultasVentaPorActionPerformed

    private void consultaPrecioMaximoVendidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaPrecioMaximoVendidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultaPrecioMaximoVendidoActionPerformed

    private void consultaTotalVendidoEntrePuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaTotalVendidoEntrePuestosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultaTotalVendidoEntrePuestosActionPerformed

    private void consultaTotalCompradoEntrePuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaTotalCompradoEntrePuestosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultaTotalCompradoEntrePuestosActionPerformed

    private void consultaCantidadKgVendidaPuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaCantidadKgVendidaPuestosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultaCantidadKgVendidaPuestosActionPerformed

    private void consultaPrecioMinimoVendidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaPrecioMinimoVendidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultaPrecioMinimoVendidoActionPerformed

    private void consultaCantidadUnidadesVendidaPuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaCantidadUnidadesVendidaPuestosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultaCantidadUnidadesVendidaPuestosActionPerformed

    private void consultaCantidadUnidadesCompradaPuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaCantidadUnidadesCompradaPuestosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultaCantidadUnidadesCompradaPuestosActionPerformed

    private void consultaCantidadKilogramosCompradaPuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaCantidadKilogramosCompradaPuestosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultaCantidadKilogramosCompradaPuestosActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField consultaCantidadKgVendidaPuestos;
    private javax.swing.JTextField consultaCantidadKilogramosCompradaPuestos;
    private javax.swing.JTextField consultaCantidadUnidadesCompradaPuestos;
    private javax.swing.JTextField consultaCantidadUnidadesVendidaPuestos;
    private javax.swing.JTextField consultaPrecioMaximoVendido;
    private javax.swing.JTextField consultaPrecioMinimoVendido;
    private javax.swing.JTextField consultaTotalCompradoEntrePuestos;
    private javax.swing.JTextField consultaTotalVendidoEntrePuestos;
    private javax.swing.JButton consultasBotonDerecha;
    private javax.swing.JButton consultasBotonIzquierda;
    private javax.swing.JTextField consultasDescripcion;
    private javax.swing.JLabel consultasImagen;
    private javax.swing.JTextField consultasNombre;
    private javax.swing.JList<String> consultasPrecioMax;
    private javax.swing.JList<String> consultasPrecioMin;
    private javax.swing.JTextField consultasTipo;
    private javax.swing.JTextField consultasVentaPor;
    private javax.swing.JScrollPane contenedorListaPuestosMayorPrecioConsultaProducto;
    private javax.swing.JScrollPane contenedorListaPuestosMenorPrecioConsultaProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelConsultaProducto;
    private javax.swing.JLabel textoCantidadTotalCompradaConsultaProducto;
    private javax.swing.JLabel textoCantidadVendidaConsultaProducto;
    private javax.swing.JLabel textoConsultaKilogramosCompradosPuestos;
    private javax.swing.JLabel textoConsultaKilogramosVendidosPuestos;
    private javax.swing.JLabel textoConsultaUnidadesCompradasPuestos;
    private javax.swing.JLabel textoConsultaUnidadesVendidasPuestos;
    private javax.swing.JLabel textoDescripcionConsultaProducto;
    private javax.swing.JLabel textoInfoConsultaProducto;
    private javax.swing.JLabel textoNombreConsultaProducto;
    private javax.swing.JLabel textoPrecioMaximoConsultaProducto;
    private javax.swing.JLabel textoPrecioMinimoConsultaProducto;
    private javax.swing.JLabel textoPrecioVentaMaximoConsultaProducto;
    private javax.swing.JLabel textoPrecioVentaMinimoConsultaProducto;
    private javax.swing.JLabel textoTipoConsultaProducto;
    private javax.swing.JLabel textoTotalCompradoConsultaProducto;
    private javax.swing.JLabel textoTotalVendidoConsultaProducto;
    private javax.swing.JLabel textoVenntaPorConsultaProducto;
    // End of variables declaration//GEN-END:variables
}
