/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package segundoobligatoriop2.interfaz;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import segundoobligatoriop2.Sistema;
import segundoobligatoriop2.auxiliar.*;

public class Interfaz extends javax.swing.JFrame {

    public Interfaz() {
        initComponents();
        inicializarComboMayoristas();
        inicializarComboDuenos();
        inicializarListaPuestos();
        inicializarListaMayoristas();
        inicializarListaItemsAComprar();
        inicializarComboPuestos();
    }

    private DefaultListModel<String> seleccionListaPuestosModel = new DefaultListModel<>();
    private DefaultListModel<String> seleccionListaMayoristasModel = new DefaultListModel<>();
    private DefaultListModel<String> seleccionListaItemsAComprarModel = new DefaultListModel<>();

    private void inicializarComboMayoristas() {
        seleccionMayorista.setModel(new DefaultComboBoxModel<>());
        actualizarComboMayorista();
    }

    private void inicializarComboDuenos() {
        registroPuestoCombo.setModel(new DefaultComboBoxModel<>());
        actualizarComboDuenos();
    }

    private void inicializarComboPuestos() {
        movimientoComboDePuestosVenta.setModel(new DefaultComboBoxModel<>());
        actualizarPuestoQueVende();
    }

    private void inicializarListaItemsAComprar() {
        listaItemsAComprar.setModel(seleccionListaItemsAComprarModel);
        contenedorListaItemsAComprar.setViewportView(listaItemsAComprar);
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
        ArrayList<Item> listaItems = Sistema.getItemsAVenderMayorista(rutMayorista);
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

    public void actualizarComboMayorista() {
        ArrayList<Mayorista> listaMayoristas = Sistema.getListaMayoristas();

        DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) seleccionMayorista.getModel();
        if (listaMayoristas.isEmpty()) {
            comboBoxModel.addElement("No hay ningun mayorista registrado");
            return;
        }
        comboBoxModel.removeAllElements();
        for (Mayorista mayorista : listaMayoristas) {
            comboBoxModel.addElement(mayorista.getNombre() + "/" + mayorista.getRut());
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
        contenedorProductos.removeAll();
        ArrayList<Puesto> listaPuestos = Sistema.getListaPuesto();
        for (Puesto puesto : listaPuestos) {
            if (puesto.getIdentificacion().equals(idPuesto)) {
                for (Item item : puesto.getStock()) {
                    JButton nuevo = new JButton(item.getNombre());
                    nuevo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Lógica del evento al hacer clic en el botón
                            // Puedes acceder al Item asociado al botón utilizando la variable 'item'
                            // Ejemplo: Item itemSeleccionado = item;
                        }
                    });
                    contenedorProductos.add(nuevo);
                }
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
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inicioImagen = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
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
        jPanel2 = new javax.swing.JPanel();
        consultasImagen = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        consultasNombre = new javax.swing.JTextField();
        consultasDescripcion = new javax.swing.JTextField();
        consultasComboTipo = new javax.swing.JComboBox<>();
        consultasComboVentaPor = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        consultasPrecioMin = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        consultasVentaMax = new javax.swing.JList<>();
        consultasBotonDerecha = new javax.swing.JButton();
        consultasBotonIzquierda = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        consultaTablaMayoristas = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        consultaTablaDuenos = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        consultaTablaPuestos = new javax.swing.JTable();
        Registro = new javax.swing.JPanel();
        menuRegistro = new javax.swing.JTabbedPane();
        panelRegistroItem = new javax.swing.JPanel();
        textoSeleccionMayorista = new javax.swing.JLabel();
        seleccionMayorista = new javax.swing.JComboBox<>();
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
        jButton2 = new javax.swing.JButton();
        panelRegistroMayorista = new javax.swing.JPanel();
        textoNombreMayorista = new javax.swing.JLabel();
        nombreMayorista = new javax.swing.JTextField();
        textoRut = new javax.swing.JLabel();
        rutMayorista = new javax.swing.JTextField();
        textoDireccion = new javax.swing.JLabel();
        direccionMayorista = new javax.swing.JTextField();
        productosMayorista = new javax.swing.JLabel();
        registroVentaPor1 = new javax.swing.JComboBox<>();
        botonLimpiarRegistroMayorista = new javax.swing.JButton();
        botonAltaRegistroMayorista = new javax.swing.JButton();
        panelRegistroPuesto1 = new javax.swing.JPanel();
        textoNombre = new javax.swing.JLabel();
        registroNombreDueño = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        registroEdadDueño = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        registroEdadExperiencia = new javax.swing.JTextField();
        botonLimpiarRegistro2 = new javax.swing.JButton();
        botonAltaRegistro2 = new javax.swing.JButton();
        panelRegistroPuesto = new javax.swing.JPanel();
        registroIdentificacion = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        botonLimpiarRegistro1 = new javax.swing.JButton();
        botonAltaRegistro1 = new javax.swing.JButton();
        registroUbicacion = new javax.swing.JTextField();
        registroNumeroEmpleados = new javax.swing.JTextField();
        registroPuestoCombo = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        precioVentaAPuesto = new javax.swing.JTextField();
        cantidadVentaAPuesto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        contenedorListaPuestos = new javax.swing.JScrollPane(seleccionListaMayoristas);
        seleccionListaPuestos = new javax.swing.JList<>();
        contenedorListaMayoristas = new javax.swing.JScrollPane(seleccionListaMayoristas);
        seleccionListaMayoristas = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        botonCompraDePuesto = new javax.swing.JButton();
        contenedorListaItemsAComprar = new javax.swing.JScrollPane();
        listaItemsAComprar = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        movimientoComboDePuestosVenta = new javax.swing.JComboBox<>();
        contenedorProductos = new java.awt.Panel();

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

        jPanel4.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" Bienvenido a Mercado!");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(400, 50, 430, 140);

        inicioImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inicioImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/segundoobligatoriop2/ImagenesOblig/Repollitos.jpg"))); // NOI18N
        inicioImagen.setToolTipText("");
        inicioImagen.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                inicioImagenComponentResized(evt);
            }
        });
        jPanel4.add(inicioImagen);
        inicioImagen.setBounds(250, 130, 780, 460);

        jLabel3.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel3.setText("Juan Manuel Mera");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(210, 620, 330, 80);

        jLabel4.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel4.setText("Joaquin Merida");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(780, 620, 350, 70);

        jTabbedPane4.addTab("Inicio", jPanel4);

        jPanel3.setLayout(null);

        jLabel29.setText("Tipo de movimiento:");
        jPanel3.add(jLabel29);
        jLabel29.setBounds(30, 60, 120, 16);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(jComboBox1);
        jComboBox1.setBounds(190, 60, 110, 30);

        jLabel30.setText("Rango de movimiento:");
        jPanel3.add(jLabel30);
        jLabel30.setBounds(30, 140, 130, 16);

        jLabel31.setText("Desde:");
        jPanel3.add(jLabel31);
        jLabel31.setBounds(190, 140, 35, 16);

        jLabel32.setText("Hasta:");
        jPanel3.add(jLabel32);
        jLabel32.setBounds(400, 140, 33, 16);

        jTextField1.setText("jTextField1");
        jPanel3.add(jTextField1);
        jTextField1.setBounds(250, 130, 90, 40);

        jTextField2.setText("jTextField2");
        jPanel3.add(jTextField2);
        jTextField2.setBounds(460, 130, 90, 40);

        jLabel33.setText("Puesto:");
        jPanel3.add(jLabel33);
        jLabel33.setBounds(30, 220, 43, 16);

        jCheckBox1.setText("jCheckBox1");
        jPanel3.add(jCheckBox1);
        jCheckBox1.setBounds(90, 220, 100, 20);

        jCheckBox2.setText("jCheckBox2");
        jPanel3.add(jCheckBox2);
        jCheckBox2.setBounds(90, 250, 85, 20);

        jCheckBox3.setText("jCheckBox3");
        jPanel3.add(jCheckBox3);
        jCheckBox3.setBounds(90, 280, 85, 20);

        jCheckBox4.setText("jCheckBox4");
        jPanel3.add(jCheckBox4);
        jCheckBox4.setBounds(90, 310, 85, 20);

        jCheckBox5.setText("jCheckBox5");
        jPanel3.add(jCheckBox5);
        jCheckBox5.setBounds(90, 340, 85, 20);

        jCheckBox6.setText("jCheckBox6");
        jPanel3.add(jCheckBox6);
        jCheckBox6.setBounds(90, 370, 85, 20);

        jLabel34.setText("Nombre del archivo a generar:");
        jPanel3.add(jLabel34);
        jLabel34.setBounds(270, 220, 170, 16);

        jTextField3.setText("jTextField3");
        jPanel3.add(jTextField3);
        jTextField3.setBounds(450, 220, 240, 22);

        jButton1.setText("Generar Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(450, 260, 190, 90);

        jTabbedPane4.addTab("Generar archivo", jPanel3);

        jPanel2.setLayout(null);
        jPanel2.add(consultasImagen);
        consultasImagen.setBounds(0, 10, 160, 170);

        jLabel13.setText("Nombre:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(190, 60, 70, 16);

        jLabel14.setText("Descripcion:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(190, 110, 80, 16);

        jLabel15.setText("Tipo:");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(190, 160, 26, 16);

        jLabel16.setText("Venta por:");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(190, 200, 60, 16);

        consultasNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultasNombreActionPerformed(evt);
            }
        });
        jPanel2.add(consultasNombre);
        consultasNombre.setBounds(290, 60, 130, 22);

        consultasDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultasDescripcionActionPerformed(evt);
            }
        });
        jPanel2.add(consultasDescripcion);
        consultasDescripcion.setBounds(290, 110, 230, 22);

        consultasComboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(consultasComboTipo);
        consultasComboTipo.setBounds(290, 160, 72, 22);

        consultasComboVentaPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(consultasComboVentaPor);
        consultasComboVentaPor.setBounds(290, 200, 72, 22);

        jLabel17.setText("Informacion del producto:");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(560, 60, 190, 16);

        jLabel18.setText("Total $ vendido entre todos los puestos:");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(560, 100, 250, 16);

        jLabel19.setText("Total $ comprado por todos los puestos:");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(560, 140, 220, 16);

        jLabel20.setText("Cantidad total vendida entre todos los puestos (kilo/unidad):");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(560, 180, 330, 16);

        jLabel21.setText("Cantidad total comprade entre todos los puestos(kilo/unidad):");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(560, 220, 330, 16);

        jLabel22.setText("Precio minimo vendido:");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(560, 260, 130, 16);

        jLabel23.setText("Precio maximo vendido:");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(760, 260, 130, 16);

        jLabel24.setText("Puestos con el precio de venta minimo:");
        jPanel2.add(jLabel24);
        jLabel24.setBounds(560, 300, 220, 16);

        jLabel25.setText("Puestos con el precio de venta maximo:");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(820, 300, 230, 16);

        consultasPrecioMin.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(consultasPrecioMin);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(560, 340, 210, 180);

        consultasVentaMax.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(consultasVentaMax);

        jPanel2.add(jScrollPane4);
        jScrollPane4.setBounds(820, 340, 210, 180);

        consultasBotonDerecha.setText(">");
        jPanel2.add(consultasBotonDerecha);
        consultasBotonDerecha.setBounds(170, 290, 110, 60);

        consultasBotonIzquierda.setText("<");
        consultasBotonIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultasBotonIzquierdaActionPerformed(evt);
            }
        });
        jPanel2.add(consultasBotonIzquierda);
        consultasBotonIzquierda.setBounds(40, 290, 110, 60);

        jLabel26.setText("Consulta de duenos:");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(10, 560, 210, 16);

        consultaTablaMayoristas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(consultaTablaMayoristas);

        jPanel2.add(jScrollPane5);
        jScrollPane5.setBounds(10, 820, 570, 270);

        jLabel27.setText("Consulta de puestos:");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(560, 560, 120, 16);

        consultaTablaDuenos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(consultaTablaDuenos);

        jPanel2.add(jScrollPane6);
        jScrollPane6.setBounds(10, 580, 400, 210);

        jLabel28.setText("Consulta de mayoristas:");
        jPanel2.add(jLabel28);
        jLabel28.setBounds(10, 800, 230, 16);

        consultaTablaPuestos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(consultaTablaPuestos);

        jPanel2.add(jScrollPane7);
        jScrollPane7.setBounds(560, 580, 410, 210);

        jTabbedPane4.addTab("Consultas", jPanel2);

        Registro.setLayout(null);

        panelRegistroItem.setLayout(null);

        textoSeleccionMayorista.setText("Mayorista:");
        panelRegistroItem.add(textoSeleccionMayorista);
        textoSeleccionMayorista.setBounds(100, 70, 60, 16);

        seleccionMayorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionMayoristaActionPerformed(evt);
            }
        });
        panelRegistroItem.add(seleccionMayorista);
        seleccionMayorista.setBounds(260, 70, 260, 22);

        textoNombreItem.setText("Nombre:");
        panelRegistroItem.add(textoNombreItem);
        textoNombreItem.setBounds(100, 119, 60, 16);

        registroNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroNombreActionPerformed(evt);
            }
        });
        panelRegistroItem.add(registroNombre);
        registroNombre.setBounds(260, 119, 260, 22);

        textoDescripcion.setText("Descripcion:");
        panelRegistroItem.add(textoDescripcion);
        textoDescripcion.setBounds(100, 179, 90, 16);

        registroDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroDescripcionActionPerformed(evt);
            }
        });
        panelRegistroItem.add(registroDescripcion);
        registroDescripcion.setBounds(260, 179, 260, 22);

        textoTipo.setText("Tipo:");
        panelRegistroItem.add(textoTipo);
        textoTipo.setBounds(100, 239, 26, 16);

        registroTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fruta", "Verdura" }));
        registroTipo.setName("");
        registroTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroTipoActionPerformed(evt);
            }
        });
        panelRegistroItem.add(registroTipo);
        registroTipo.setBounds(260, 229, 110, 20);

        textoVentaPor.setText("Venta por:");
        panelRegistroItem.add(textoVentaPor);
        textoVentaPor.setBounds(100, 279, 110, 16);

        registroVentaPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kilogramo", "Unidad" }));
        panelRegistroItem.add(registroVentaPor);
        registroVentaPor.setBounds(260, 279, 110, 22);

        botonLimpiarRegistro.setText("Limpiar");
        botonLimpiarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarRegistroActionPerformed(evt);
            }
        });
        panelRegistroItem.add(botonLimpiarRegistro);
        botonLimpiarRegistro.setBounds(260, 339, 100, 40);

        botonAltaRegistro.setText("Alta");
        botonAltaRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAltaRegistroActionPerformed(evt);
            }
        });
        panelRegistroItem.add(botonAltaRegistro);
        botonAltaRegistro.setBounds(260, 399, 100, 40);

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

        jButton2.setText("Check de articulos por mayorista");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelRegistroItem.add(jButton2);
        jButton2.setBounds(450, 370, 210, 90);

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
        productosMayorista.setBounds(650, 100, 140, 16);

        registroVentaPor1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "aca", "va" ,"cada","item"}));
        panelRegistroMayorista.add(registroVentaPor1);
        registroVentaPor1.setBounds(640, 130, 330, 110);

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

        jLabel44.setText("Edad:");
        panelRegistroPuesto1.add(jLabel44);
        jLabel44.setBounds(100, 179, 90, 16);

        registroEdadDueño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroEdadDueñoActionPerformed(evt);
            }
        });
        panelRegistroPuesto1.add(registroEdadDueño);
        registroEdadDueño.setBounds(260, 179, 130, 22);

        jLabel45.setText("Años de experiencia:");
        panelRegistroPuesto1.add(jLabel45);
        jLabel45.setBounds(100, 239, 100, 16);

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

        jLabel39.setText("Identificacion:");
        panelRegistroPuesto.add(jLabel39);
        jLabel39.setBounds(100, 119, 90, 16);

        jLabel40.setText("Dueño:");
        panelRegistroPuesto.add(jLabel40);
        jLabel40.setBounds(100, 179, 90, 16);

        jLabel41.setText("Ubicación:");
        panelRegistroPuesto.add(jLabel41);
        jLabel41.setBounds(100, 239, 100, 16);

        jLabel42.setText("Cantidad empleados:");
        panelRegistroPuesto.add(jLabel42);
        jLabel42.setBounds(100, 290, 120, 16);

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

        Registro.add(menuRegistro);
        menuRegistro.setBounds(50, 10, 1170, 580);

        jTabbedPane4.addTab("Registros", Registro);

        jPanel5.setLayout(null);

        jPanel6.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel6.setText("Registrar compra de productos");
        jPanel6.add(jLabel6);
        jLabel6.setBounds(350, 10, 500, 25);

        jLabel7.setText("Puesto que realiza la compra:");
        jPanel6.add(jLabel7);
        jLabel7.setBounds(80, 60, 210, 16);

        jLabel8.setText("Mayorista al que le compran:");
        jPanel6.add(jLabel8);
        jLabel8.setBounds(80, 250, 210, 16);

        jLabel9.setText("Precio individual:");
        jPanel6.add(jLabel9);
        jLabel9.setBounds(800, 110, 100, 20);

        jLabel10.setText("Cantidad:");
        jPanel6.add(jLabel10);
        jLabel10.setBounds(840, 160, 60, 20);
        jPanel6.add(precioVentaAPuesto);
        precioVentaAPuesto.setBounds(920, 100, 160, 40);
        jPanel6.add(cantidadVentaAPuesto);
        cantidadVentaAPuesto.setBounds(920, 150, 160, 40);

        jLabel11.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel11.setText("Registrar venta de productos");
        jPanel6.add(jLabel11);
        jLabel11.setBounds(360, 440, 420, 25);

        seleccionListaPuestos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                seleccionListaPuestosValueChanged(evt);
            }
        });
        contenedorListaPuestos.setViewportView(seleccionListaPuestos);

        jPanel6.add(contenedorListaPuestos);
        contenedorListaPuestos.setBounds(80, 80, 300, 150);

        seleccionListaMayoristas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                seleccionListaMayoristasValueChanged(evt);
            }
        });
        contenedorListaMayoristas.setViewportView(seleccionListaMayoristas);

        jPanel6.add(contenedorListaMayoristas);
        contenedorListaMayoristas.setBounds(80, 270, 300, 150);

        jLabel2.setText("Item:");
        jPanel6.add(jLabel2);
        jLabel2.setBounds(490, 90, 50, 16);

        botonCompraDePuesto.setText("Realizar compra");
        botonCompraDePuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCompraDePuestoActionPerformed(evt);
            }
        });
        jPanel6.add(botonCompraDePuesto);
        botonCompraDePuesto.setBounds(530, 270, 380, 130);

        listaItemsAComprar.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaItemsAComprarValueChanged(evt);
            }
        });
        contenedorListaItemsAComprar.setViewportView(listaItemsAComprar);

        jPanel6.add(contenedorListaItemsAComprar);
        contenedorListaItemsAComprar.setBounds(560, 90, 210, 130);

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3);
        jButton3.setBounds(960, 470, 75, 23);

        jTabbedPane1.addTab("Compra de puesto", jPanel6);

        jPanel7.setLayout(null);

        jLabel12.setText("Puestos:");
        jPanel7.add(jLabel12);
        jLabel12.setBounds(90, 100, 60, 16);

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
        jPanel7.add(movimientoComboDePuestosVenta);
        movimientoComboDePuestosVenta.setBounds(140, 90, 160, 40);

        contenedorProductos.setLayout(new java.awt.GridLayout(1, 2));
        jPanel7.add(contenedorProductos);
        contenedorProductos.setBounds(480, 40, 590, 220);

        jTabbedPane1.addTab("Compra de puesto", jPanel7);

        jPanel5.add(jTabbedPane1);
        jTabbedPane1.setBounds(20, 20, 1210, 560);

        jTabbedPane4.addTab("Movimientos", jPanel5);

        getContentPane().add(jTabbedPane4);
        jTabbedPane4.setBounds(0, 0, 1240, 1160);

        setBounds(0, 0, 1250, 1168);
    }// </editor-fold>//GEN-END:initComponents

    private void consultasNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultasNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultasNombreActionPerformed

    private void consultasDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultasDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultasDescripcionActionPerformed

    private void consultasBotonIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultasBotonIzquierdaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultasBotonIzquierdaActionPerformed

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
        String mayorista = seleccionMayorista.getSelectedItem().toString();
        int rutMayorista = 0;
        String corte = "/";
        String[] fragmentos = mayorista.split(corte);
        if (mayorista != "No hay ningun mayorista registrado") {
            rutMayorista = Integer.parseInt(fragmentos[1]);
        }
        if (nombre.isEmpty() || descripcion.isEmpty() || nombre.contains(" ")) {
            JOptionPane.showMessageDialog(this, "Error: Recuerda llenar todos los campos de texto", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (mayorista == "No hay ningun mayorista registrado") {
            JOptionPane.showMessageDialog(this, "Error: no hay ningun mayorista registrado", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("se agregaitem: " + " nombre " + nombre + " descripcion " + descripcion + " tipo " + tipo + " forma venta : " + formaVenta + " imagenpath: " + imagen + " mayorista : " + mayorista);

            Sistema.agregarItemAMayorista(rutMayorista, nombre, descripcion, tipo, formaVenta, imagen);
            registroNombre.setText("");
            registroDescripcion.setText("");
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

        if (nombre.isEmpty() || rutTexto.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Verifique que todos los campos de información estén siendo llenados", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int rut = Integer.parseInt(rutTexto);
            if (Sistema.mayoristaUnico(rut)) {
                Sistema.agregarMayorista(nombre, rut, direccion);
                actualizarComboMayorista();
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

    private void seleccionMayoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionMayoristaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seleccionMayoristaActionPerformed

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ArrayList<Mayorista> listaMayoristas = Sistema.getListaMayoristas();
        ArrayList<Puesto> listaPuesto = Sistema.getListaPuesto();

        for (Puesto unPuesto : listaPuesto) {
            System.out.println("un puesto:" + unPuesto.getIdentificacion() + "el dueno:" + unPuesto.getDueño());

        }

        for (Mayorista mayorista : listaMayoristas) {
            System.out.println("mayorista:" + mayorista.getNombre());
            ArrayList<Item> listaItems = mayorista.getListaItems();
            for (Item item : listaItems) {
                System.out.println(mayorista.getNombre() + " <dueño producto> " + item.getNombre());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
        Sistema.agregarTransaccion(rutMayorista, puestoSeleccionado, itemSeleccionado, precio, cantidad);

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
        // TODO add your handling code here:
        String selectedOption = (String) movimientoComboDePuestosVenta.getSelectedItem();
        actualizarGrilla(selectedOption);
    }//GEN-LAST:event_listaItemsAComprarValueChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ArrayList<Puesto> listaPuestos = Sistema.getListaPuesto();
        for (Puesto puesto : listaPuestos) {
            ArrayList<Item> listaItems = puesto.getStock();
            System.out.println(puesto.getIdentificacion());
            for (Item item : listaItems) {
                System.out.println("item: " + item.getNombre() + "  cantidad: " + item.getCantidad());
            }
            System.out.println("-----------------------------------------------");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void movimientoComboDePuestosVentaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_movimientoComboDePuestosVentaItemStateChanged
        String selectedOption = (String) movimientoComboDePuestosVenta.getSelectedItem();
        actualizarGrilla(selectedOption);
    }//GEN-LAST:event_movimientoComboDePuestosVentaItemStateChanged

    private void movimientoComboDePuestosVentaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movimientoComboDePuestosVentaMouseReleased
        String selectedOption = (String) movimientoComboDePuestosVenta.getSelectedItem();
        actualizarGrilla(selectedOption);
    }//GEN-LAST:event_movimientoComboDePuestosVentaMouseReleased

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
    private javax.swing.JPanel Registro;
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
    private javax.swing.JTable consultaTablaDuenos;
    private javax.swing.JTable consultaTablaMayoristas;
    private javax.swing.JTable consultaTablaPuestos;
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
    private java.awt.Panel contenedorProductos;
    private javax.swing.JTextField direccionMayorista;
    private javax.swing.JLabel inicioImagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JList<String> listaItemsAComprar;
    private javax.swing.JTabbedPane menuRegistro;
    private javax.swing.JComboBox<String> movimientoComboDePuestosVenta;
    private javax.swing.JTextField nombreMayorista;
    private javax.swing.JPanel panelRegistroItem;
    private javax.swing.JPanel panelRegistroMayorista;
    private javax.swing.JPanel panelRegistroPuesto;
    private javax.swing.JPanel panelRegistroPuesto1;
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
    private javax.swing.JComboBox<String> registroVentaPor1;
    private javax.swing.JTextField rutMayorista;
    private javax.swing.JList<String> seleccionListaMayoristas;
    private javax.swing.JList<String> seleccionListaPuestos;
    private javax.swing.JComboBox<String> seleccionMayorista;
    private javax.swing.JFileChooser seleccionarImagen;
    private javax.swing.JLabel textoDescripcion;
    private javax.swing.JLabel textoDireccion;
    private javax.swing.JLabel textoImagen;
    private javax.swing.JLabel textoNombre;
    private javax.swing.JLabel textoNombreItem;
    private javax.swing.JLabel textoNombreMayorista;
    private javax.swing.JLabel textoRut;
    private javax.swing.JLabel textoSeleccionMayorista;
    private javax.swing.JLabel textoTipo;
    private javax.swing.JLabel textoVentaPor;
    // End of variables declaration//GEN-END:variables

    private void LimpiarFormRegistro() {
        registroDescripcion.setText("");
        registroNombre.setText("");
    }

}
