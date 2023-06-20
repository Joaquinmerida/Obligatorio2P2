package segundoobligatoriop2.interfaz.GenerarArchivo;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import segundoobligatoriop2.Sistema;
import segundoobligatoriop2.auxiliar.Puesto;

public class GenerarArchivo extends javax.swing.JFrame {

    public GenerarArchivo() {
        initComponents();
        inicializarListaPuestos();
    }

    private DefaultListModel<String> seleccionListaPuestosModel = new DefaultListModel<>();

    private void inicializarListaPuestos() {
        seleccionPuestoGenerarArchivo.setModel(seleccionListaPuestosModel);
        seleccionPuestoGenerarArchivoModel.setViewportView(seleccionPuestoGenerarArchivo);
    }

    public void actualizarListaPuestos() {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGenerarArchivo = new javax.swing.JPanel();
        textoTipoMovimientos = new javax.swing.JLabel();
        tipoMovimientoGeneracion = new javax.swing.JComboBox<>();
        textoRangoMovimiento = new javax.swing.JLabel();
        textoDesde = new javax.swing.JLabel();
        textoHasta = new javax.swing.JLabel();
        rangoGeneracionDesde = new javax.swing.JTextField();
        rangoGeneracionHasta = new javax.swing.JTextField();
        textoPuesto = new javax.swing.JLabel();
        textoNombreArchivo = new javax.swing.JLabel();
        nombreGeneracionArchivo = new javax.swing.JTextField();
        botonGenerarArchivo = new javax.swing.JButton();
        seleccionPuestoGenerarArchivoModel = new javax.swing.JScrollPane();
        seleccionPuestoGenerarArchivo = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGenerarArchivo.setLayout(null);

        textoTipoMovimientos.setText("Tipo de movimiento:");
        panelGenerarArchivo.add(textoTipoMovimientos);
        textoTipoMovimientos.setBounds(30, 60, 120, 16);

        tipoMovimientoGeneracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Compras", "Ventas", "Todo" }));
        panelGenerarArchivo.add(tipoMovimientoGeneracion);
        tipoMovimientoGeneracion.setBounds(190, 60, 110, 30);

        textoRangoMovimiento.setText("Rango de movimiento:");
        panelGenerarArchivo.add(textoRangoMovimiento);
        textoRangoMovimiento.setBounds(30, 140, 130, 16);

        textoDesde.setText("Desde:");
        panelGenerarArchivo.add(textoDesde);
        textoDesde.setBounds(190, 140, 60, 16);

        textoHasta.setText("Hasta:");
        panelGenerarArchivo.add(textoHasta);
        textoHasta.setBounds(400, 140, 60, 16);
        panelGenerarArchivo.add(rangoGeneracionDesde);
        rangoGeneracionDesde.setBounds(250, 130, 90, 40);
        panelGenerarArchivo.add(rangoGeneracionHasta);
        rangoGeneracionHasta.setBounds(460, 130, 90, 40);

        textoPuesto.setText("Puesto:");
        panelGenerarArchivo.add(textoPuesto);
        textoPuesto.setBounds(30, 220, 43, 16);

        textoNombreArchivo.setText("Nombre del archivo a generar:");
        panelGenerarArchivo.add(textoNombreArchivo);
        textoNombreArchivo.setBounds(270, 220, 170, 16);
        panelGenerarArchivo.add(nombreGeneracionArchivo);
        nombreGeneracionArchivo.setBounds(450, 220, 240, 22);

        botonGenerarArchivo.setText("Generar Archivo");
        botonGenerarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarArchivoActionPerformed(evt);
            }
        });
        panelGenerarArchivo.add(botonGenerarArchivo);
        botonGenerarArchivo.setBounds(450, 260, 190, 90);

        seleccionPuestoGenerarArchivoModel.setViewportView(seleccionPuestoGenerarArchivo);

        panelGenerarArchivo.add(seleccionPuestoGenerarArchivoModel);
        seleccionPuestoGenerarArchivoModel.setBounds(90, 220, 120, 210);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1240, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelGenerarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 1240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1129, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelGenerarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 1129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setBounds(0, 0, 1256, 1137);
    }// </editor-fold>//GEN-END:initComponents

    private void botonGenerarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarArchivoActionPerformed
        int desde = Integer.parseInt(rangoGeneracionDesde.getText());
        int hasta = Integer.parseInt(rangoGeneracionHasta.getText());
        String nombreArchivo = nombreGeneracionArchivo.getText();
        String tipoMovimiento = tipoMovimientoGeneracion.getSelectedItem().toString();
        ArrayList<String> elementosSeleccionados = new ArrayList<>(seleccionPuestoGenerarArchivo.getSelectedValuesList());
        Sistema.generarArchivo(desde, hasta, nombreArchivo, tipoMovimiento, elementosSeleccionados);
    }//GEN-LAST:event_botonGenerarArchivoActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GenerarArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerarArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerarArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerarArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerarArchivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGenerarArchivo;
    private javax.swing.JTextField nombreGeneracionArchivo;
    private javax.swing.JPanel panelGenerarArchivo;
    private javax.swing.JTextField rangoGeneracionDesde;
    private javax.swing.JTextField rangoGeneracionHasta;
    private javax.swing.JList<String> seleccionPuestoGenerarArchivo;
    private javax.swing.JScrollPane seleccionPuestoGenerarArchivoModel;
    private javax.swing.JLabel textoDesde;
    private javax.swing.JLabel textoHasta;
    private javax.swing.JLabel textoNombreArchivo;
    private javax.swing.JLabel textoPuesto;
    private javax.swing.JLabel textoRangoMovimiento;
    private javax.swing.JLabel textoTipoMovimientos;
    private javax.swing.JComboBox<String> tipoMovimientoGeneracion;
    // End of variables declaration//GEN-END:variables
}
