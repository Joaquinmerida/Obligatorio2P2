package segundoobligatoriop2.interfaz.Consulta;

/*
      ---------------------------------------------------------
    |                    Sistema desarrollado por                               |
  |    Joaquin Merida 253076 y Juan Manuel Mera  273527 |
 ---------------------------------------------------------
*/                           

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;
import segundoobligatoriop2.Sistema;
import segundoobligatoriop2.auxiliar.Item;
import segundoobligatoriop2.auxiliar.Mayorista;

public class ConsultaMayoristas extends javax.swing.JFrame {

    public ConsultaMayoristas() {
        initComponents();
        generarTablaMayoristas();
    }

    public void generarTablaMayoristas() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("RUT");
        model.addColumn("Dirección");
        model.addColumn("Items");
        tablaConsultaMayoristas.setModel(model);
    }
    
     public void actualizarTablaMayoristas() {
        ArrayList<Mayorista> listaMayorista = Sistema.getListaMayoristas();
        DefaultTableModel model = (DefaultTableModel) tablaConsultaMayoristas.getModel();

        model.setRowCount(0);
        for (Mayorista mayorista : listaMayorista) {
            Object[] rowData = new Object[4];
            rowData[0] = mayorista.getNombre();
            rowData[1] = mayorista.getRut();
            rowData[2] = mayorista.getDireccion();

            ArrayList<Item> items = mayorista.getListaItems();
            StringBuilder itemsString = new StringBuilder();

            Collections.sort(items, new Comparator<Item>() {
                @Override
                public int compare(Item item1, Item item2) {
                    return item1.getNombre().compareTo(item2.getNombre());
                }
            });

            for (Item item : items) {
                itemsString.append(item.getNombre() + " ");
            }
            rowData[3] = itemsString.toString();
            model.addRow(rowData);
        }
        tablaConsultaMayoristas.revalidate();
        tablaConsultaMayoristas.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuConsultaMayorista = new javax.swing.JPanel();
        contenedorTablaMayoristas = new javax.swing.JScrollPane();
        tablaConsultaMayoristas = new javax.swing.JTable();
        tituloConsultaPuestos1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de mayoristas");
        getContentPane().setLayout(null);

        menuConsultaMayorista.setLayout(null);

        tablaConsultaMayoristas.setModel(new javax.swing.table.DefaultTableModel(
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
        contenedorTablaMayoristas.setViewportView(tablaConsultaMayoristas);

        menuConsultaMayorista.add(contenedorTablaMayoristas);
        contenedorTablaMayoristas.setBounds(150, 70, 880, 402);

        tituloConsultaPuestos1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 36)); // NOI18N
        tituloConsultaPuestos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloConsultaPuestos1.setText("Mayoristas");
        menuConsultaMayorista.add(tituloConsultaPuestos1);
        tituloConsultaPuestos1.setBounds(150, 20, 880, 40);

        getContentPane().add(menuConsultaMayorista);
        menuConsultaMayorista.setBounds(0, 0, 1210, 500);

        setSize(new java.awt.Dimension(1231, 542));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultaMayoristas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaMayoristas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaMayoristas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaMayoristas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaMayoristas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane contenedorTablaMayoristas;
    private javax.swing.JPanel menuConsultaMayorista;
    private javax.swing.JTable tablaConsultaMayoristas;
    private javax.swing.JLabel tituloConsultaPuestos1;
    // End of variables declaration//GEN-END:variables
}
