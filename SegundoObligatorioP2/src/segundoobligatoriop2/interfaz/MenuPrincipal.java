package segundoobligatoriop2.interfaz;

/*
      ---------------------------------------------------------
    |                    Sistema desarrollado por                               |
  |    Joaquin Merida 253076 y Juan Manuel Mera  273527 |
 ---------------------------------------------------------
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import segundoobligatoriop2.Sistema;
import segundoobligatoriop2.interfaz.Registro.*;
import segundoobligatoriop2.interfaz.Movimientos.*;
import segundoobligatoriop2.interfaz.GenerarArchivo.*;
import segundoobligatoriop2.interfaz.Consulta.*;

public class MenuPrincipal extends javax.swing.JFrame {

    public RegistroMayorista registroMayorista = new RegistroMayorista();
    public RegistroPuesto registroPuesto = new RegistroPuesto();
    public RegistroItem registroItem = new RegistroItem();
    public RegistroDueno registroDueno = new RegistroDueno();

    public ConsultaProductos consultaProductos = new ConsultaProductos();
    public ConsultaPuestos consultaPuestos = new ConsultaPuestos();
    public ConsultaMayoristas consultaMayoristas = new ConsultaMayoristas();
    public ConsultaDuenosDePuesto consultaDuenos = new ConsultaDuenosDePuesto();

    public MovimientosCompraDePublico compraPublico = new MovimientosCompraDePublico();
    public MovimientosCompraDePuesto compraPuestos = new MovimientosCompraDePuesto();

    public GenerarArchivo generarArchivo = new GenerarArchivo();

    public MenuPrincipal() {
        initComponents();
        SeleccionInicio dialog = new SeleccionInicio(null, true);
        dialog.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInicio = new javax.swing.JPanel();
        tituloInicio1 = new javax.swing.JLabel();
        textoRegistro = new javax.swing.JLabel();
        textoMovimientos = new javax.swing.JLabel();
        textoConsultas = new javax.swing.JLabel();
        textoGenerarArchivos = new javax.swing.JLabel();
        nombreIntegrante1 = new javax.swing.JLabel();
        nombreIntegrante2 = new javax.swing.JLabel();
        botonItem = new javax.swing.JToggleButton();
        botonMayoristas = new javax.swing.JToggleButton();
        botonPuesto = new javax.swing.JToggleButton();
        botonDueno = new javax.swing.JToggleButton();
        botonCompraPuesto = new javax.swing.JToggleButton();
        botonCompraPublico = new javax.swing.JToggleButton();
        botonConsultaMayoristas = new javax.swing.JToggleButton();
        botonConsultaPuestos = new javax.swing.JToggleButton();
        botonConsultaDuenos = new javax.swing.JToggleButton();
        botonConsultaProductos = new javax.swing.JToggleButton();
        botonGenerarArchivos = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mercado");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        panelInicio.setLayout(null);

        tituloInicio1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        tituloInicio1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloInicio1.setText(" Bienvenido a Mercado!");
        panelInicio.add(tituloInicio1);
        tituloInicio1.setBounds(240, -20, 640, 140);

        textoRegistro.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        textoRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoRegistro.setText("Registro");
        panelInicio.add(textoRegistro);
        textoRegistro.setBounds(130, 140, 130, 40);

        textoMovimientos.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        textoMovimientos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoMovimientos.setText("Movimientos");
        panelInicio.add(textoMovimientos);
        textoMovimientos.setBounds(100, 260, 180, 50);

        textoConsultas.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        textoConsultas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoConsultas.setText("Consultas");
        panelInicio.add(textoConsultas);
        textoConsultas.setBounds(20, 390, 330, 80);

        textoGenerarArchivos.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        textoGenerarArchivos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoGenerarArchivos.setText("Generar archivo");
        panelInicio.add(textoGenerarArchivos);
        textoGenerarArchivos.setBounds(30, 530, 330, 80);

        nombreIntegrante1.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        nombreIntegrante1.setText("Juan Manuel Mera");
        panelInicio.add(nombreIntegrante1);
        nombreIntegrante1.setBounds(170, 640, 330, 80);

        nombreIntegrante2.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        nombreIntegrante2.setText("Joaquin Merida");
        panelInicio.add(nombreIntegrante2);
        nombreIntegrante2.setBounds(740, 640, 350, 70);

        botonItem.setText("Item");
        botonItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonItemActionPerformed(evt);
            }
        });
        panelInicio.add(botonItem);
        botonItem.setBounds(380, 120, 150, 40);

        botonMayoristas.setText("Mayorista");
        botonMayoristas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMayoristasActionPerformed(evt);
            }
        });
        panelInicio.add(botonMayoristas);
        botonMayoristas.setBounds(590, 120, 150, 40);

        botonPuesto.setText("Puesto");
        botonPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPuestoActionPerformed(evt);
            }
        });
        panelInicio.add(botonPuesto);
        botonPuesto.setBounds(380, 170, 150, 40);

        botonDueno.setText("Dueño de puesto");
        botonDueno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDuenoActionPerformed(evt);
            }
        });
        panelInicio.add(botonDueno);
        botonDueno.setBounds(590, 170, 150, 40);

        botonCompraPuesto.setText("Compra de puesto");
        botonCompraPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCompraPuestoActionPerformed(evt);
            }
        });
        panelInicio.add(botonCompraPuesto);
        botonCompraPuesto.setBounds(380, 260, 150, 40);

        botonCompraPublico.setText("Compra del publico");
        botonCompraPublico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCompraPublicoActionPerformed(evt);
            }
        });
        panelInicio.add(botonCompraPublico);
        botonCompraPublico.setBounds(590, 260, 150, 40);

        botonConsultaMayoristas.setText("Consulta Mayoristas");
        botonConsultaMayoristas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultaMayoristasActionPerformed(evt);
            }
        });
        panelInicio.add(botonConsultaMayoristas);
        botonConsultaMayoristas.setBounds(380, 360, 150, 40);

        botonConsultaPuestos.setText("Consulta Puestos");
        botonConsultaPuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultaPuestosActionPerformed(evt);
            }
        });
        panelInicio.add(botonConsultaPuestos);
        botonConsultaPuestos.setBounds(590, 360, 150, 40);

        botonConsultaDuenos.setText("Consulta Dueños");
        botonConsultaDuenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultaDuenosActionPerformed(evt);
            }
        });
        panelInicio.add(botonConsultaDuenos);
        botonConsultaDuenos.setBounds(380, 430, 150, 40);

        botonConsultaProductos.setText("Consulta Productos");
        botonConsultaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultaProductosActionPerformed(evt);
            }
        });
        panelInicio.add(botonConsultaProductos);
        botonConsultaProductos.setBounds(590, 430, 150, 40);

        botonGenerarArchivos.setText("Generar archivo");
        botonGenerarArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarArchivosActionPerformed(evt);
            }
        });
        panelInicio.add(botonGenerarArchivos);
        botonGenerarArchivos.setBounds(470, 550, 210, 40);

        getContentPane().add(panelInicio);
        panelInicio.setBounds(0, 0, 1120, 770);

        setSize(new java.awt.Dimension(1130, 781));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonConsultaMayoristasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultaMayoristasActionPerformed
        consultaMayoristas.actualizarTablaMayoristas();
        consultaMayoristas.setVisible(true);
    }//GEN-LAST:event_botonConsultaMayoristasActionPerformed

    private void botonDuenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDuenoActionPerformed
        registroDueno.getBotonAlta().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                registroPuesto.actualizarComboDuenos();
                consultaDuenos.actualizarTablaDuenos();
            }
        });
        registroDueno.setVisible(true);
    }//GEN-LAST:event_botonDuenoActionPerformed

    private void botonCompraPublicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCompraPublicoActionPerformed
        compraPublico.setVisible(true);
        
        compraPublico.actualizarPuestoQueVende();
    }//GEN-LAST:event_botonCompraPublicoActionPerformed

    private void botonItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonItemActionPerformed
        registroItem.getBotonAltaRegistro().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                consultaProductos.mostrarItemConsulta();
                registroMayorista.actualizarListaItemsAVender();
            }
        });
        registroItem.setVisible(true);
    }//GEN-LAST:event_botonItemActionPerformed

    private void botonMayoristasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMayoristasActionPerformed
        registroMayorista.getBotonRegistro().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                compraPuestos.actualizarListaMayoristas();
                consultaMayoristas.actualizarTablaMayoristas();
            }
        });
        registroMayorista.actualizarListaItemsAVender();
        registroMayorista.setVisible(true);
    }//GEN-LAST:event_botonMayoristasActionPerformed

    private void botonPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPuestoActionPerformed
        registroPuesto.getBotonRegistroPuesto().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                compraPuestos.actualizarListaPuestos();
                compraPublico.actualizarPuestoQueVende();
                consultaPuestos.actualizarTablaPuestos();
                generarArchivo.actualizarListaPuestos();
            }
        });
        registroPuesto.actualizarComboDuenos();
        registroPuesto.setVisible(true);
    }//GEN-LAST:event_botonPuestoActionPerformed

    private void botonGenerarArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarArchivosActionPerformed
        generarArchivo.actualizarListaPuestos();
        generarArchivo.setVisible(true);
    }//GEN-LAST:event_botonGenerarArchivosActionPerformed

    private void botonConsultaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultaProductosActionPerformed
        consultaProductos.mostrarItemConsulta();
        consultaProductos.setVisible(true);
    }//GEN-LAST:event_botonConsultaProductosActionPerformed

    private void botonConsultaPuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultaPuestosActionPerformed
        consultaPuestos.actualizarTablaPuestos();
        consultaPuestos.setVisible(true);
    }//GEN-LAST:event_botonConsultaPuestosActionPerformed

    private void botonConsultaDuenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultaDuenosActionPerformed
        consultaDuenos.actualizarTablaDuenos();
        consultaDuenos.setVisible(true);
    }//GEN-LAST:event_botonConsultaDuenosActionPerformed

    private void botonCompraPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCompraPuestoActionPerformed
        compraPuestos.actualizarListaMayoristas();
        compraPuestos.actualizarListaPuestos();
        compraPuestos.getBotonCompra().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                consultaProductos.mostrarItemConsulta();
            }
        });
        compraPuestos.setVisible(true);
    }//GEN-LAST:event_botonCompraPuestoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Sistema.guardarProceso();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botonCompraPublico;
    private javax.swing.JToggleButton botonCompraPuesto;
    private javax.swing.JToggleButton botonConsultaDuenos;
    private javax.swing.JToggleButton botonConsultaMayoristas;
    private javax.swing.JToggleButton botonConsultaProductos;
    private javax.swing.JToggleButton botonConsultaPuestos;
    private javax.swing.JToggleButton botonDueno;
    private javax.swing.JToggleButton botonGenerarArchivos;
    private javax.swing.JToggleButton botonItem;
    private javax.swing.JToggleButton botonMayoristas;
    private javax.swing.JToggleButton botonPuesto;
    private javax.swing.JLabel nombreIntegrante1;
    private javax.swing.JLabel nombreIntegrante2;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JLabel textoConsultas;
    private javax.swing.JLabel textoGenerarArchivos;
    private javax.swing.JLabel textoMovimientos;
    private javax.swing.JLabel textoRegistro;
    private javax.swing.JLabel tituloInicio1;
    // End of variables declaration//GEN-END:variables
}
