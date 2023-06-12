/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package segundoobligatoriop2.interfaz;

import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import segundoobligatoriop2.Sistema;
import segundoobligatoriop2.auxiliar.*;

public class Interfaz extends javax.swing.JFrame {

    public Interfaz() {
        initComponents();
        inicializarComboDuenos();
        inicializarListaPuestos();
        inicializarListaMayoristas();
        inicializarListaItemsAComprar();
        inicializarComboPuestos();
        generarTablaDuenos();
        generarTablaPuestos();
        inicializarListaItemsAVender();
    }

    private DefaultListModel<String> seleccionListaPuestosModel = new DefaultListModel<>();
    private DefaultListModel<String> seleccionListaMayoristasModel = new DefaultListModel<>();
    private DefaultListModel<String> seleccionListaItemsAComprarModel = new DefaultListModel<>();
    private DefaultListModel<String> seleccionListaItemsAVenderModel = new DefaultListModel<>();

    private void inicializarComboDuenos() {
        registroPuestoCombo.setModel(new DefaultComboBoxModel<>());
        actualizarComboDuenos();
    }

    private void inicializarComboPuestos() {
        movimientoComboDePuestosVenta.setModel(new DefaultComboBoxModel<>());

        movimientoComboDePuestosVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) movimientoComboDePuestosVenta.getSelectedItem();
                actualizarGrilla(selectedOption);
            }
        });
    }

    private void inicializarListaItemsAComprar() {
        listaItemsAComprar.setModel(seleccionListaItemsAComprarModel);
        contenedorListaItemsAComprar.setViewportView(listaItemsAComprar);
    }

    private void inicializarListaItemsAVender() {
        listaSeleccionItemsMayorista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listaSeleccionItemsMayorista.setModel(seleccionListaItemsAVenderModel);
        contenedorListaSeleccionItemsMayorista.setViewportView(listaSeleccionItemsMayorista);
    }

    private void inicializarListaPuestos() {
        seleccionListaPuestos.setModel(seleccionListaPuestosModel);
        contenedorListaPuestos.setViewportView(seleccionListaPuestos);
    }

    private void inicializarListaMayoristas() {
        seleccionListaMayoristas.setModel(seleccionListaMayoristasModel);
        contenedorListaMayoristas.setViewportView(seleccionListaMayoristas);
    }

    private void actualizarListaPuestos() {
        ArrayList<Puesto> listaPuestos = Sistema.getListaPuesto();
        if (listaPuestos.isEmpty()) {
            seleccionListaPuestosModel.addElement("No hay ningún puesto registrado");
        } else {
            seleccionListaPuestosModel.clear();
            for (Puesto puesto : listaPuestos) {
                String idPuesto = puesto.getIdentificacion();
                System.out.println(idPuesto);
                seleccionListaPuestosModel.addElement(idPuesto);
            }
        }
    }

    public void actualizarListaItemsAComprar(int rutMayorista) {
        Mayorista mayorista = Sistema.getMayorista(rutMayorista);

        ArrayList<Item> listaItems = mayorista.getListaItems();
        if (listaItems.isEmpty()) {
            seleccionListaItemsAComprarModel.addElement("No hay ningun item registrado");
            return;
        } else {
            seleccionListaItemsAComprarModel.clear();
            for (Item item : listaItems) {
                String nombreItem = item.getNombre();
                seleccionListaItemsAComprarModel.addElement(nombreItem);
                System.out.println(nombreItem);
            }
        }
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
            seleccionListaItemsAVenderModel.addElement("No hay ningun item registrado");
            return;
        } else {
            seleccionListaItemsAVenderModel.clear();

            for (Item item : listaItems) {
                String nombreItem = item.getNombre();
                seleccionListaItemsAVenderModel.addElement(nombreItem);
                System.out.println(nombreItem);
            }
        }
    }

    private void actualizarListaMayoristas() {
        ArrayList<Mayorista> listaMayoristas = Sistema.getListaMayoristas();
        if (listaMayoristas.isEmpty()) {
            seleccionListaMayoristasModel.addElement("No hay ningún puesto registrado");
            return;
        } else {
            seleccionListaMayoristasModel.clear();
            for (Mayorista mayorista : listaMayoristas) {
                String nombreMayorista = mayorista.getNombre();
                int rutMayorista = mayorista.getRut();
                seleccionListaMayoristasModel.addElement(nombreMayorista + "/" + rutMayorista);
            }
        }
    }

    public void actualizarComboDuenos() {
        ArrayList<Dueno> listaDuenos = Sistema.getListaDuenos();
        DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) registroPuestoCombo.getModel();
        if (listaDuenos.isEmpty()) {
            comboBoxModel.addElement("No hay ningun dueno registrado");
            return;

        }
        comboBoxModel.removeAllElements();
        for (Dueno duenos : listaDuenos) {
            comboBoxModel.addElement(duenos.getNombre());

        }

    }

    public void actualizarPuestoQueVende() {
        ArrayList<Puesto> listaPuestos = Sistema.getListaPuesto();
        DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) movimientoComboDePuestosVenta.getModel();
        if (listaPuestos.isEmpty()) {
            comboBoxModel.addElement("No hay niungun puesto registrado");
            return;
        }
        comboBoxModel.removeAllElements();
        for (Puesto puesto : listaPuestos) {
            comboBoxModel.addElement(puesto.getIdentificacion());
        }
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
            int cantidad = Integer.parseInt(txtCantidad.getText());
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

    public void generarTablaDuenos() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Edad");
        model.addColumn("Años de experiencia");
        tablaConsultaDuenos.setModel(model);
    }

    public void actualizarTablaDuenos() {
        ArrayList<Dueno> listaDuenos = Sistema.getListaDuenos();
        Collections.sort(listaDuenos, new Comparator<Dueno>() {
            @Override
            public int compare(Dueno dueno1, Dueno dueno2) {
                return dueno1.getNombre().compareTo(dueno2.getNombre());
            }
        });
        DefaultTableModel model = (DefaultTableModel) tablaConsultaDuenos.getModel();
        model.setRowCount(0);
        for (Dueno dueno : listaDuenos) {
            model.addRow(new Object[]{dueno.getNombre(), dueno.getEdad(), dueno.getAñosExperiencia()});
        }
        tablaConsultaDuenos.revalidate();
        tablaConsultaDuenos.repaint();
    }

    public void generarTablaPuestos() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Identificación");
        model.addColumn("Dueño");
        model.addColumn("Ubicación");
        model.addColumn("Cantidad de empleados");
        tablaConsultaPuestos.setModel(model);
    }

    public void actualizarTablaPuestos() {
        ArrayList<Puesto> listaPuesto = Sistema.getListaPuesto();
        DefaultTableModel model = (DefaultTableModel) tablaConsultaPuestos.getModel();
        model.setRowCount(0);
        for (Puesto puesto : listaPuesto) {
            model.addRow(new Object[]{puesto.getIdentificacion(), puesto.getDueño(), puesto.getUbicacion(), puesto.getCantidadEmpleados()});
        }
        tablaConsultaPuestos.revalidate();
        tablaConsultaPuestos.repaint();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        panelInicio = new javax.swing.JPanel();
        tituloInicio = new javax.swing.JLabel();
        inicioImagen = new javax.swing.JLabel();
        nombreIntegrante1 = new javax.swing.JLabel();
        nombreIntegrante2 = new javax.swing.JLabel();
        panelGenerarArchivo = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel34 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        panelRegistro = new javax.swing.JPanel();
        menuRegistro = new javax.swing.JTabbedPane();
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
        seleccionarImagen = new javax.swing.JFileChooser();
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
        panelRegistroPuesto1 = new javax.swing.JPanel();
        textoNombre = new javax.swing.JLabel();
        registroNombreDueño = new javax.swing.JTextField();
        textoEdadDueño = new javax.swing.JLabel();
        registroEdadDueño = new javax.swing.JTextField();
        textoExperienciaDueño = new javax.swing.JLabel();
        registroEdadExperiencia = new javax.swing.JTextField();
        botonLimpiarRegistro2 = new javax.swing.JButton();
        botonAltaRegistro2 = new javax.swing.JButton();
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
        panelMovimientos = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
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
        panelVentaPublico = new javax.swing.JPanel();
        textoSeleccionPuestoQueVende = new javax.swing.JLabel();
        movimientoComboDePuestosVenta = new javax.swing.JComboBox<>();
        contenedorProductos = new java.awt.Panel();
        panelConsultas = new javax.swing.JPanel();
        menuConsultas = new javax.swing.JTabbedPane();
        panelConsultaProducto = new javax.swing.JPanel();
        consultasImagen = new javax.swing.JLabel();
        textoNombreConsultaProducto = new javax.swing.JLabel();
        textoDescripcionConsultaProducto = new javax.swing.JLabel();
        textoTipoConsultaProducto = new javax.swing.JLabel();
        textoVenntaPorConsultaProducto = new javax.swing.JLabel();
        consultasNombre = new javax.swing.JTextField();
        consultasDescripcion = new javax.swing.JTextField();
        consultasComboTipo = new javax.swing.JComboBox<>();
        consultasComboVentaPor = new javax.swing.JComboBox<>();
        textoInfoConsultaProducto = new javax.swing.JLabel();
        textoTotalVendidoConsultaProducto = new javax.swing.JLabel();
        textoTotalCompradoConsultaProducto = new javax.swing.JLabel();
        textoCantidadVendidaConsultaProducto = new javax.swing.JLabel();
        textoCantidadTotalCompradaConsultaProducto = new javax.swing.JLabel();
        textoPrecioMinimoConsultaProducto = new javax.swing.JLabel();
        textoPrecioMaximoConsultaProducto = new javax.swing.JLabel();
        textoPrecioVentaMinimoConsultaProducto = new javax.swing.JLabel();
        textoPrecioVentaMaximoConsultaProducto = new javax.swing.JLabel();
        listaPuestosMenorPrecioConsultaProducto = new javax.swing.JScrollPane();
        consultasPrecioMin = new javax.swing.JList<>();
        listaPuestosMayorPrecioConsultaProducto = new javax.swing.JScrollPane();
        consultasVentaMax = new javax.swing.JList<>();
        consultasBotonDerecha = new javax.swing.JButton();
        consultasBotonIzquierda = new javax.swing.JButton();
        panelConsultaDueno = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConsultaDuenos = new javax.swing.JTable();
        tituloConsultaDuenos = new javax.swing.JLabel();
        menuConsultaPuesto = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaConsultaPuestos = new javax.swing.JTable();
        tituloConsultaPuestos = new javax.swing.JLabel();
        menuConsultaMayorista = new javax.swing.JPanel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenuItem1.setText("jMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("jCheckBoxMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        panelInicio.setLayout(null);

        tituloInicio.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        tituloInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloInicio.setText(" Bienvenido a Mercado!");
        panelInicio.add(tituloInicio);
        tituloInicio.setBounds(400, 50, 430, 140);

        inicioImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inicioImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/segundoobligatoriop2/ImagenesOblig/Repollitos.jpg"))); // NOI18N
        inicioImagen.setToolTipText("");
        inicioImagen.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                inicioImagenComponentResized(evt);
            }
        });
        panelInicio.add(inicioImagen);
        inicioImagen.setBounds(250, 130, 780, 460);

        nombreIntegrante1.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        nombreIntegrante1.setText("Juan Manuel Mera");
        panelInicio.add(nombreIntegrante1);
        nombreIntegrante1.setBounds(210, 620, 330, 80);

        nombreIntegrante2.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        nombreIntegrante2.setText("Joaquin Merida");
        panelInicio.add(nombreIntegrante2);
        nombreIntegrante2.setBounds(780, 620, 350, 70);

        jTabbedPane4.addTab("Inicio", panelInicio);

        panelGenerarArchivo.setLayout(null);

        jLabel29.setText("Tipo de movimiento:");
        panelGenerarArchivo.add(jLabel29);
        jLabel29.setBounds(30, 60, 120, 16);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelGenerarArchivo.add(jComboBox1);
        jComboBox1.setBounds(190, 60, 110, 30);

        jLabel30.setText("Rango de movimiento:");
        panelGenerarArchivo.add(jLabel30);
        jLabel30.setBounds(30, 140, 130, 16);

        jLabel31.setText("Desde:");
        panelGenerarArchivo.add(jLabel31);
        jLabel31.setBounds(190, 140, 35, 16);

        jLabel32.setText("Hasta:");
        panelGenerarArchivo.add(jLabel32);
        jLabel32.setBounds(400, 140, 33, 16);

        jTextField1.setText("jTextField1");
        panelGenerarArchivo.add(jTextField1);
        jTextField1.setBounds(250, 130, 90, 40);

        jTextField2.setText("jTextField2");
        panelGenerarArchivo.add(jTextField2);
        jTextField2.setBounds(460, 130, 90, 40);

        jLabel33.setText("Puesto:");
        panelGenerarArchivo.add(jLabel33);
        jLabel33.setBounds(30, 220, 43, 16);

        jCheckBox1.setText("jCheckBox1");
        panelGenerarArchivo.add(jCheckBox1);
        jCheckBox1.setBounds(90, 220, 100, 20);

        jCheckBox2.setText("jCheckBox2");
        panelGenerarArchivo.add(jCheckBox2);
        jCheckBox2.setBounds(90, 250, 85, 20);

        jCheckBox3.setText("jCheckBox3");
        panelGenerarArchivo.add(jCheckBox3);
        jCheckBox3.setBounds(90, 280, 85, 20);

        jCheckBox4.setText("jCheckBox4");
        panelGenerarArchivo.add(jCheckBox4);
        jCheckBox4.setBounds(90, 310, 85, 20);

        jCheckBox5.setText("jCheckBox5");
        panelGenerarArchivo.add(jCheckBox5);
        jCheckBox5.setBounds(90, 340, 85, 20);

        jCheckBox6.setText("jCheckBox6");
        panelGenerarArchivo.add(jCheckBox6);
        jCheckBox6.setBounds(90, 370, 85, 20);

        jLabel34.setText("Nombre del archivo a generar:");
        panelGenerarArchivo.add(jLabel34);
        jLabel34.setBounds(270, 220, 170, 16);

        jTextField3.setText("jTextField3");
        panelGenerarArchivo.add(jTextField3);
        jTextField3.setBounds(450, 220, 240, 22);

        jButton1.setText("Generar Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelGenerarArchivo.add(jButton1);
        jButton1.setBounds(450, 260, 190, 90);

        jTabbedPane4.addTab("Generar archivo", panelGenerarArchivo);

        panelRegistro.setLayout(null);

        panelRegistroItem.setLayout(null);

        textoNombreItem.setText("Nombre:");
        panelRegistroItem.add(textoNombreItem);
        textoNombreItem.setBounds(100, 80, 60, 16);

        registroNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroNombreActionPerformed(evt);
            }
        });
        panelRegistroItem.add(registroNombre);
        registroNombre.setBounds(260, 80, 260, 22);

        textoDescripcion.setText("Descripcion:");
        panelRegistroItem.add(textoDescripcion);
        textoDescripcion.setBounds(100, 140, 90, 16);

        registroDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroDescripcionActionPerformed(evt);
            }
        });
        panelRegistroItem.add(registroDescripcion);
        registroDescripcion.setBounds(260, 140, 260, 22);

        textoTipo.setText("Tipo:");
        panelRegistroItem.add(textoTipo);
        textoTipo.setBounds(100, 200, 26, 16);

        registroTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fruta", "Verdura" }));
        registroTipo.setName("");
        registroTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroTipoActionPerformed(evt);
            }
        });
        panelRegistroItem.add(registroTipo);
        registroTipo.setBounds(260, 190, 110, 20);

        textoVentaPor.setText("Venta por:");
        panelRegistroItem.add(textoVentaPor);
        textoVentaPor.setBounds(100, 240, 110, 16);

        registroVentaPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kilogramo", "Unidad" }));
        panelRegistroItem.add(registroVentaPor);
        registroVentaPor.setBounds(260, 240, 110, 22);

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
        textoImagen.setBounds(590, 40, 60, 16);
        panelRegistroItem.add(AparicionImagenRegistro);
        AparicionImagenRegistro.setBounds(50, 360, 180, 140);

        seleccionarImagen.setAcceptAllFileFilterUsed(false);
        seleccionarImagen.setApproveButtonText("Abrir");
        seleccionarImagen.setApproveButtonToolTipText("Cancelar");
        seleccionarImagen.setDialogTitle("");
        seleccionarImagen.setSelectedFile(new java.io.File("C:\\Users\\joaqu\\OneDrive\\Escritorio\\Obligatorio2P2\\Obligatorio2P2\\SegundoObligatorioP2\\src\\segundoobligatoriop2\\ImagenesOblig"));
        seleccionarImagen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        seleccionarImagen.setDoubleBuffered(true);
        seleccionarImagen.setName("seleccionarImagen");
        seleccionarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarImagenActionPerformed(evt);
            }
        });
        panelRegistroItem.add(seleccionarImagen);
        seleccionarImagen.setBounds(650, 60, 510, 290);

        menuRegistro.addTab("Item", panelRegistroItem);

        panelRegistroMayorista.setLayout(null);

        textoNombreMayorista.setText("Nombre:");
        panelRegistroMayorista.add(textoNombreMayorista);
        textoNombreMayorista.setBounds(100, 119, 60, 16);

        nombreMayorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreMayoristaActionPerformed(evt);
            }
        });
        panelRegistroMayorista.add(nombreMayorista);
        nombreMayorista.setBounds(260, 119, 120, 22);

        textoRut.setText("Rut:");
        panelRegistroMayorista.add(textoRut);
        textoRut.setBounds(100, 179, 90, 16);

        rutMayorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rutMayoristaActionPerformed(evt);
            }
        });
        panelRegistroMayorista.add(rutMayorista);
        rutMayorista.setBounds(260, 179, 300, 22);

        textoDireccion.setText("Dirección:");
        panelRegistroMayorista.add(textoDireccion);
        textoDireccion.setBounds(100, 230, 70, 16);

        direccionMayorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionMayoristaActionPerformed(evt);
            }
        });
        panelRegistroMayorista.add(direccionMayorista);
        direccionMayorista.setBounds(260, 230, 300, 22);

        productosMayorista.setText("Productos que ofrece:");
        panelRegistroMayorista.add(productosMayorista);
        productosMayorista.setBounds(580, 20, 140, 16);

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
        listaSeleccionItemsMayorista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaSeleccionItemsMayorista.setToolTipText("");
        contenedorListaSeleccionItemsMayorista.setViewportView(listaSeleccionItemsMayorista);

        panelRegistroMayorista.add(contenedorListaSeleccionItemsMayorista);
        contenedorListaSeleccionItemsMayorista.setBounds(730, 70, 180, 146);

        menuRegistro.addTab("Mayorista", panelRegistroMayorista);

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

        botonAltaRegistro2.setText("Alta");
        botonAltaRegistro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAltaRegistro2ActionPerformed(evt);
            }
        });
        panelRegistroPuesto1.add(botonAltaRegistro2);
        botonAltaRegistro2.setBounds(260, 340, 150, 40);

        menuRegistro.addTab("Dueño de puesto", panelRegistroPuesto1);

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

        menuRegistro.addTab("Puesto", panelRegistroPuesto);

        panelRegistro.add(menuRegistro);
        menuRegistro.setBounds(50, 10, 1170, 580);

        jTabbedPane4.addTab("Registros", panelRegistro);

        panelMovimientos.setLayout(null);

        panelCompraPuesto.setLayout(null);

        tituloCompraPuesto.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        tituloCompraPuesto.setText("Registrar compra de productos");
        panelCompraPuesto.add(tituloCompraPuesto);
        tituloCompraPuesto.setBounds(350, 10, 500, 25);

        textoSeleccionPuesto.setText("Puesto que realiza la compra:");
        panelCompraPuesto.add(textoSeleccionPuesto);
        textoSeleccionPuesto.setBounds(80, 60, 210, 16);

        textoSeleccionMayoristaVendedor.setText("Mayorista al que le compran:");
        panelCompraPuesto.add(textoSeleccionMayoristaVendedor);
        textoSeleccionMayoristaVendedor.setBounds(80, 250, 210, 16);

        textoPrecioVentaMayorista.setText("Precio individual:");
        panelCompraPuesto.add(textoPrecioVentaMayorista);
        textoPrecioVentaMayorista.setBounds(800, 110, 100, 20);

        textoCantidadVentaMayorista.setText("Cantidad:");
        panelCompraPuesto.add(textoCantidadVentaMayorista);
        textoCantidadVentaMayorista.setBounds(840, 160, 60, 20);
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
        textoSeleccionItemAComprar.setBounds(490, 90, 50, 16);

        botonCompraDePuesto.setText("Realizar compra");
        botonCompraDePuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCompraDePuestoActionPerformed(evt);
            }
        });
        panelCompraPuesto.add(botonCompraDePuesto);
        botonCompraDePuesto.setBounds(530, 270, 380, 130);

        listaItemsAComprar.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaItemsAComprarValueChanged(evt);
            }
        });
        contenedorListaItemsAComprar.setViewportView(listaItemsAComprar);

        panelCompraPuesto.add(contenedorListaItemsAComprar);
        contenedorListaItemsAComprar.setBounds(560, 90, 210, 130);

        jTabbedPane1.addTab("Compra de puesto", panelCompraPuesto);

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

        jTabbedPane1.addTab("Compra de puesto", panelVentaPublico);

        panelMovimientos.add(jTabbedPane1);
        jTabbedPane1.setBounds(20, 20, 1210, 560);

        jTabbedPane4.addTab("Movimientos", panelMovimientos);

        panelConsultas.setLayout(null);

        panelConsultaProducto.setLayout(null);
        panelConsultaProducto.add(consultasImagen);
        consultasImagen.setBounds(0, 10, 160, 170);

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
        textoVenntaPorConsultaProducto.setBounds(190, 200, 60, 16);
        panelConsultaProducto.add(consultasNombre);
        consultasNombre.setBounds(290, 60, 130, 22);
        panelConsultaProducto.add(consultasDescripcion);
        consultasDescripcion.setBounds(290, 110, 230, 22);

        consultasComboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelConsultaProducto.add(consultasComboTipo);
        consultasComboTipo.setBounds(290, 160, 72, 22);

        consultasComboVentaPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelConsultaProducto.add(consultasComboVentaPor);
        consultasComboVentaPor.setBounds(290, 200, 72, 22);

        textoInfoConsultaProducto.setText("Informacion del producto:");
        panelConsultaProducto.add(textoInfoConsultaProducto);
        textoInfoConsultaProducto.setBounds(560, 60, 190, 16);

        textoTotalVendidoConsultaProducto.setText("Total $ vendido entre todos los puestos:");
        panelConsultaProducto.add(textoTotalVendidoConsultaProducto);
        textoTotalVendidoConsultaProducto.setBounds(560, 100, 250, 16);

        textoTotalCompradoConsultaProducto.setText("Total $ comprado por todos los puestos:");
        panelConsultaProducto.add(textoTotalCompradoConsultaProducto);
        textoTotalCompradoConsultaProducto.setBounds(560, 140, 260, 16);

        textoCantidadVendidaConsultaProducto.setText("Cantidad total vendida entre todos los puestos (kilo/unidad):");
        panelConsultaProducto.add(textoCantidadVendidaConsultaProducto);
        textoCantidadVendidaConsultaProducto.setBounds(560, 180, 370, 16);

        textoCantidadTotalCompradaConsultaProducto.setText("Cantidad total comprada entre todos los puestos(kilo/unidad):");
        panelConsultaProducto.add(textoCantidadTotalCompradaConsultaProducto);
        textoCantidadTotalCompradaConsultaProducto.setBounds(560, 220, 370, 16);

        textoPrecioMinimoConsultaProducto.setText("Precio minimo vendido:");
        panelConsultaProducto.add(textoPrecioMinimoConsultaProducto);
        textoPrecioMinimoConsultaProducto.setBounds(560, 260, 170, 16);

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
        listaPuestosMenorPrecioConsultaProducto.setViewportView(consultasPrecioMin);

        panelConsultaProducto.add(listaPuestosMenorPrecioConsultaProducto);
        listaPuestosMenorPrecioConsultaProducto.setBounds(560, 340, 210, 180);

        consultasVentaMax.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaPuestosMayorPrecioConsultaProducto.setViewportView(consultasVentaMax);

        panelConsultaProducto.add(listaPuestosMayorPrecioConsultaProducto);
        listaPuestosMayorPrecioConsultaProducto.setBounds(820, 340, 210, 180);

        consultasBotonDerecha.setText(">");
        panelConsultaProducto.add(consultasBotonDerecha);
        consultasBotonDerecha.setBounds(170, 290, 110, 60);

        consultasBotonIzquierda.setText("<");
        panelConsultaProducto.add(consultasBotonIzquierda);
        consultasBotonIzquierda.setBounds(40, 290, 110, 60);

        menuConsultas.addTab("Consulta por producto", panelConsultaProducto);

        panelConsultaDueno.setLayout(null);

        tablaConsultaDuenos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tablaConsultaDuenos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaConsultaDuenos);

        panelConsultaDueno.add(jScrollPane1);
        jScrollPane1.setBounds(110, 70, 910, 402);

        tituloConsultaDuenos.setFont(new java.awt.Font("Segoe UI Symbol", 0, 36)); // NOI18N
        tituloConsultaDuenos.setText("Dueños de puestos");
        panelConsultaDueno.add(tituloConsultaDuenos);
        tituloConsultaDuenos.setBounds(410, 20, 310, 40);

        menuConsultas.addTab("Consultas de dueños", panelConsultaDueno);

        menuConsultaPuesto.setLayout(null);

        tablaConsultaPuestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaConsultaPuestos);

        menuConsultaPuesto.add(jScrollPane2);
        jScrollPane2.setBounds(150, 70, 880, 402);

        tituloConsultaPuestos.setFont(new java.awt.Font("Segoe UI Symbol", 0, 36)); // NOI18N
        tituloConsultaPuestos.setText("Puestos");
        menuConsultaPuesto.add(tituloConsultaPuestos);
        tituloConsultaPuestos.setBounds(530, 30, 130, 40);

        menuConsultas.addTab("Consulta de puestos", menuConsultaPuesto);

        menuConsultaMayorista.setLayout(null);
        menuConsultas.addTab("Consulta de mayoristas", menuConsultaMayorista);

        panelConsultas.add(menuConsultas);
        menuConsultas.setBounds(10, 30, 1220, 620);

        jTabbedPane4.addTab("Consultas", panelConsultas);

        getContentPane().add(jTabbedPane4);
        jTabbedPane4.setBounds(0, 0, 1240, 1160);

        setBounds(0, 0, 1250, 1168);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void registroNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroNombreActionPerformed

    private void registroDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroDescripcionActionPerformed

    private void registroTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroTipoActionPerformed

    private void botonLimpiarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarRegistroActionPerformed
        LimpiarFormRegistro();
    }//GEN-LAST:event_botonLimpiarRegistroActionPerformed

    private void botonAltaRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAltaRegistroActionPerformed
        String nombre = registroNombre.getText();
        String descripcion = registroDescripcion.getText();
        String tipo = registroTipo.getSelectedItem().toString();
        String formaVenta = registroVentaPor.getSelectedItem().toString();
        String imagen = seleccionarImagen.getSelectedFile().getPath();

        if (nombre.isEmpty() || descripcion.isEmpty() || nombre.contains(" ")) {
            JOptionPane.showMessageDialog(this, "Error: Recuerda llenar todos los campos de texto", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(" no agrega item");
            return;
        } else {
            if (Sistema.itemUnico(nombre, Sistema.getListaItems())) {
                Sistema.agregarItem(new Item(nombre, descripcion, tipo, formaVenta, imagen));
                System.out.println("agrega item");
                registroNombre.setText("");
                registroDescripcion.setText("");
                actualizarListaItemsAVender();
            } else {
                System.out.println("ya existe ese item");
            }
        }


    }//GEN-LAST:event_botonAltaRegistroActionPerformed

    private void seleccionarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarImagenActionPerformed
        String Ruta = "";
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JPG", "JPG");
        seleccionarImagen.setFileFilter(filtrado);
        Ruta = seleccionarImagen.getSelectedFile().getPath();
        Image mImagen = new ImageIcon(Ruta).getImage();
        ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(AparicionImagenRegistro.getWidth(), AparicionImagenRegistro.getHeight(), Image.SCALE_SMOOTH));
        AparicionImagenRegistro.setIcon(mIcono);
    }//GEN-LAST:event_seleccionarImagenActionPerformed

    private void nombreMayoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreMayoristaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreMayoristaActionPerformed

    private void rutMayoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rutMayoristaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rutMayoristaActionPerformed

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
            int rut = Integer.parseInt(rutTexto);
            if (Sistema.mayoristaUnico(rut)) {
                Sistema.agregarMayorista(nombre, rut, direccion, elementosSeleccionados);
                actualizarListaMayoristas();
                nombreMayorista.setText("");
                rutMayorista.setText("");
                direccionMayorista.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Error: Rut ya registrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Verifique que el campo 'RUT' sea un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonAltaRegistroMayoristaActionPerformed

    private void direccionMayoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionMayoristaActionPerformed

    }//GEN-LAST:event_direccionMayoristaActionPerformed

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
        int cantidadEmpleados = Integer.parseInt(registroNumeroEmpleados.getText());
        if (identificacion.isEmpty() || ubicacion.isEmpty() || dueno.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Verifique que todos los campos de información estén siendo llenados", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (dueno == "No hay ningun dueno registrado") {
            JOptionPane.showMessageDialog(this, "Error: No hay Duenos registrados actualmente, recuerda registrar un dueno previo a registrar un puesto", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!Sistema.identificacionUnico(identificacion)) {
            Sistema.agregarPuesto(identificacion, dueno, ubicacion, cantidadEmpleados);
            registroIdentificacion.setText("");
            registroUbicacion.setText("");
            registroNumeroEmpleados.setText("0");
            actualizarListaPuestos();
            actualizarPuestoQueVende();
            actualizarTablaPuestos();
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

    private void registroNombreDueñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroNombreDueñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroNombreDueñoActionPerformed

    private void registroEdadDueñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroEdadDueñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroEdadDueñoActionPerformed

    private void botonLimpiarRegistro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarRegistro2ActionPerformed
        registroNombreDueño.setText("");
        registroEdadDueño.setText("");
        registroEdadExperiencia.setText("");
    }//GEN-LAST:event_botonLimpiarRegistro2ActionPerformed

    private void botonAltaRegistro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAltaRegistro2ActionPerformed
        String nombreDueno = registroNombreDueño.getText();
        String edadTexto = registroEdadDueño.getText();
        String experienciaTexto = registroEdadExperiencia.getText();
        if (nombreDueno.isEmpty() || edadTexto.isEmpty() || experienciaTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Verifica que estas utilizando todos los campos de información", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int edad = Integer.parseInt(edadTexto);
            int experiencia = Integer.parseInt(experienciaTexto);

            if (!Sistema.nombreDueñoUnico(nombreDueno)) {
                Sistema.agregarDueno(nombreDueno, edad, experiencia);
                registroNombreDueño.setText("");
                registroEdadDueño.setText("");
                registroEdadExperiencia.setText("0");
                actualizarComboDuenos();
                actualizarTablaDuenos();
            } else {
                JOptionPane.showMessageDialog(this, "Error: El nombre del dueño ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Verifica que los campos de edad y experiencia sean números válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_botonAltaRegistro2ActionPerformed

    private void registroEdadExperienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroEdadExperienciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroEdadExperienciaActionPerformed

    private void inicioImagenComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_inicioImagenComponentResized
        ImageIcon icono = (ImageIcon) inicioImagen.getIcon();
        Image image = icono.getImage();
        Image resizedImage = image.getScaledInstance(inicioImagen.getWidth(), inicioImagen.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        inicioImagen.setIcon(resizedIcon);
    }//GEN-LAST:event_inicioImagenComponentResized

    private void registroPuestoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroPuestoComboActionPerformed

    }//GEN-LAST:event_registroPuestoComboActionPerformed

    private void movimientoComboDePuestosVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movimientoComboDePuestosVentaActionPerformed
        String selectedOption = (String) movimientoComboDePuestosVenta.getSelectedItem();
        actualizarGrilla(selectedOption);
    }//GEN-LAST:event_movimientoComboDePuestosVentaActionPerformed

    private void botonCompraDePuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCompraDePuestoActionPerformed
        String itemSeleccionado = getSelectedItem("listaItemsAComprar");
        String mayoristaSeleccionado = getSelectedItem("seleccionListaMayoristas");
        String puestoSeleccionado = getSelectedItem("seleccionListaPuestos");
        String corte = "/";
        String[] fragmentos = mayoristaSeleccionado.split(corte);
        int rutMayorista = Integer.parseInt(fragmentos[1]);
        int precio = Integer.parseInt(precioVentaAPuesto.getText());
        int cantidad = Integer.parseInt(cantidadVentaAPuesto.getText());

        Sistema.realizarCompraDePuesto(rutMayorista, puestoSeleccionado, itemSeleccionado, precio, cantidad);
        actualizarGrilla(puestoSeleccionado);
        System.out.println(rutMayorista + " " + puestoSeleccionado + " " + itemSeleccionado + " " + precio + " " + cantidad);
    }//GEN-LAST:event_botonCompraDePuestoActionPerformed

    private void seleccionListaPuestosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_seleccionListaPuestosValueChanged
        if (!evt.getValueIsAdjusting()) {
            String selectedItem = getSelectedItem("seleccionListaPuestos");
            System.out.println("Ítem seleccionado en jList1: " + selectedItem);
        }
    }//GEN-LAST:event_seleccionListaPuestosValueChanged

    private void seleccionListaMayoristasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_seleccionListaMayoristasValueChanged
        if (!evt.getValueIsAdjusting()) {
            String selectedItem = getSelectedItem("seleccionListaMayoristas");
            int rutMayorista;
            String corte = "/";
            String[] fragmentos = selectedItem.split(corte);
            rutMayorista = Integer.parseInt(fragmentos[1]);
            actualizarListaItemsAComprar(rutMayorista);
        }
    }//GEN-LAST:event_seleccionListaMayoristasValueChanged

    private void listaItemsAComprarValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaItemsAComprarValueChanged

    }//GEN-LAST:event_listaItemsAComprarValueChanged

    private void movimientoComboDePuestosVentaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_movimientoComboDePuestosVentaItemStateChanged
        String selectedOption = (String) movimientoComboDePuestosVenta.getSelectedItem();
        actualizarGrilla(selectedOption);
    }//GEN-LAST:event_movimientoComboDePuestosVentaItemStateChanged

    private void movimientoComboDePuestosVentaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movimientoComboDePuestosVentaMouseReleased

    }//GEN-LAST:event_movimientoComboDePuestosVentaMouseReleased

    private void panelVentaPublicoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVentaPublicoMouseEntered

    }//GEN-LAST:event_panelVentaPublicoMouseEntered

    private void panelVentaPublicoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVentaPublicoMouseMoved

    }//GEN-LAST:event_panelVentaPublicoMouseMoved

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AparicionImagenRegistro;
    private javax.swing.JButton botonAltaRegistro;
    private javax.swing.JButton botonAltaRegistro1;
    private javax.swing.JButton botonAltaRegistro2;
    private javax.swing.JButton botonAltaRegistroMayorista;
    private javax.swing.JButton botonCompraDePuesto;
    private javax.swing.JButton botonLimpiarRegistro;
    private javax.swing.JButton botonLimpiarRegistro1;
    private javax.swing.JButton botonLimpiarRegistro2;
    private javax.swing.JButton botonLimpiarRegistroMayorista;
    private javax.swing.JTextField cantidadVentaAPuesto;
    private javax.swing.JButton consultasBotonDerecha;
    private javax.swing.JButton consultasBotonIzquierda;
    private javax.swing.JComboBox<String> consultasComboTipo;
    private javax.swing.JComboBox<String> consultasComboVentaPor;
    private javax.swing.JTextField consultasDescripcion;
    private javax.swing.JLabel consultasImagen;
    private javax.swing.JTextField consultasNombre;
    private javax.swing.JList<String> consultasPrecioMin;
    private javax.swing.JList<String> consultasVentaMax;
    private javax.swing.JScrollPane contenedorListaItemsAComprar;
    private javax.swing.JScrollPane contenedorListaMayoristas;
    private javax.swing.JScrollPane contenedorListaPuestos;
    private javax.swing.JScrollPane contenedorListaSeleccionItemsMayorista;
    private java.awt.Panel contenedorProductos;
    private javax.swing.JTextField direccionMayorista;
    private javax.swing.JLabel inicioImagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JList<String> listaItemsAComprar;
    private javax.swing.JScrollPane listaPuestosMayorPrecioConsultaProducto;
    private javax.swing.JScrollPane listaPuestosMenorPrecioConsultaProducto;
    private javax.swing.JList<String> listaSeleccionItemsMayorista;
    private javax.swing.JPanel menuConsultaMayorista;
    private javax.swing.JPanel menuConsultaPuesto;
    private javax.swing.JTabbedPane menuConsultas;
    private javax.swing.JTabbedPane menuRegistro;
    private javax.swing.JComboBox<String> movimientoComboDePuestosVenta;
    private javax.swing.JLabel nombreIntegrante1;
    private javax.swing.JLabel nombreIntegrante2;
    private javax.swing.JTextField nombreMayorista;
    private javax.swing.JPanel panelCompraPuesto;
    private javax.swing.JPanel panelConsultaDueno;
    private javax.swing.JPanel panelConsultaProducto;
    private javax.swing.JPanel panelConsultas;
    private javax.swing.JPanel panelGenerarArchivo;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelMovimientos;
    private javax.swing.JPanel panelRegistro;
    private javax.swing.JPanel panelRegistroItem;
    private javax.swing.JPanel panelRegistroMayorista;
    private javax.swing.JPanel panelRegistroPuesto;
    private javax.swing.JPanel panelRegistroPuesto1;
    private javax.swing.JPanel panelVentaPublico;
    private javax.swing.JTextField precioVentaAPuesto;
    private javax.swing.JLabel productosMayorista;
    private javax.swing.JTextField registroDescripcion;
    private javax.swing.JTextField registroEdadDueño;
    private javax.swing.JTextField registroEdadExperiencia;
    private javax.swing.JTextField registroIdentificacion;
    private javax.swing.JTextField registroNombre;
    private javax.swing.JTextField registroNombreDueño;
    private javax.swing.JTextField registroNumeroEmpleados;
    private javax.swing.JComboBox<String> registroPuestoCombo;
    private javax.swing.JComboBox<String> registroTipo;
    private javax.swing.JTextField registroUbicacion;
    private javax.swing.JComboBox<String> registroVentaPor;
    private javax.swing.JTextField rutMayorista;
    private javax.swing.JList<String> seleccionListaMayoristas;
    private javax.swing.JList<String> seleccionListaPuestos;
    private javax.swing.JFileChooser seleccionarImagen;
    private javax.swing.JTable tablaConsultaDuenos;
    private javax.swing.JTable tablaConsultaPuestos;
    private javax.swing.JLabel textoCantidadEmpleados;
    private javax.swing.JLabel textoCantidadTotalCompradaConsultaProducto;
    private javax.swing.JLabel textoCantidadVendidaConsultaProducto;
    private javax.swing.JLabel textoCantidadVentaMayorista;
    private javax.swing.JLabel textoDescripcion;
    private javax.swing.JLabel textoDescripcionConsultaProducto;
    private javax.swing.JLabel textoDireccion;
    private javax.swing.JLabel textoDueño;
    private javax.swing.JLabel textoEdadDueño;
    private javax.swing.JLabel textoExperienciaDueño;
    private javax.swing.JLabel textoIdentificacion;
    private javax.swing.JLabel textoImagen;
    private javax.swing.JLabel textoInfoConsultaProducto;
    private javax.swing.JLabel textoNombre;
    private javax.swing.JLabel textoNombreConsultaProducto;
    private javax.swing.JLabel textoNombreItem;
    private javax.swing.JLabel textoNombreMayorista;
    private javax.swing.JLabel textoPrecioMaximoConsultaProducto;
    private javax.swing.JLabel textoPrecioMinimoConsultaProducto;
    private javax.swing.JLabel textoPrecioVentaMaximoConsultaProducto;
    private javax.swing.JLabel textoPrecioVentaMayorista;
    private javax.swing.JLabel textoPrecioVentaMinimoConsultaProducto;
    private javax.swing.JLabel textoRut;
    private javax.swing.JLabel textoSeleccionItemAComprar;
    private javax.swing.JLabel textoSeleccionMayoristaVendedor;
    private javax.swing.JLabel textoSeleccionPuesto;
    private javax.swing.JLabel textoSeleccionPuestoQueVende;
    private javax.swing.JLabel textoTipo;
    private javax.swing.JLabel textoTipoConsultaProducto;
    private javax.swing.JLabel textoTotalCompradoConsultaProducto;
    private javax.swing.JLabel textoTotalVendidoConsultaProducto;
    private javax.swing.JLabel textoUbicacion;
    private javax.swing.JLabel textoVenntaPorConsultaProducto;
    private javax.swing.JLabel textoVentaPor;
    private javax.swing.JLabel tituloCompraPuesto;
    private javax.swing.JLabel tituloConsultaDuenos;
    private javax.swing.JLabel tituloConsultaPuestos;
    private javax.swing.JLabel tituloInicio;
    // End of variables declaration//GEN-END:variables

    private void LimpiarFormRegistro() {
        registroDescripcion.setText("");
        registroNombre.setText("");
    }

}
