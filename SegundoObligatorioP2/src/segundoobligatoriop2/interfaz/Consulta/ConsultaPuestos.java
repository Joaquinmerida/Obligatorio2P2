package segundoobligatoriop2.interfaz.Consulta;

/*
      ---------------------------------------------------------
    |                    Sistema desarrollado por                               |
  |    Joaquin Merida 253076 y Juan Manuel Mera  273527 |
 ---------------------------------------------------------
*/                           

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import segundoobligatoriop2.Sistema;
import segundoobligatoriop2.auxiliar.Puesto;


public class ConsultaPuestos extends javax.swing.JFrame {

  
    public ConsultaPuestos() {
        initComponents();
        generarTablaPuestos();
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
            model.addRow(new Object[]{puesto.getIdentificacion(), puesto.getDueno().getNombre(), puesto.getUbicacion(), puesto.getCantidadEmpleados()});
        }
        tablaConsultaPuestos.revalidate();
        tablaConsultaPuestos.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuConsultaPuesto = new javax.swing.JPanel();
        consultaTablapuestos = new javax.swing.JScrollPane();
        tablaConsultaPuestos = new javax.swing.JTable();
        tituloConsultaPuestos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de puestos");
        getContentPane().setLayout(null);

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
        consultaTablapuestos.setViewportView(tablaConsultaPuestos);

        menuConsultaPuesto.add(consultaTablapuestos);
        consultaTablapuestos.setBounds(150, 70, 880, 402);

        tituloConsultaPuestos.setFont(new java.awt.Font("Segoe UI Symbol", 0, 36)); // NOI18N
        tituloConsultaPuestos.setText("Puestos");
        menuConsultaPuesto.add(tituloConsultaPuestos);
        tituloConsultaPuestos.setBounds(530, 30, 130, 40);

        getContentPane().add(menuConsultaPuesto);
        menuConsultaPuesto.setBounds(0, 0, 1220, 589);

        setSize(new java.awt.Dimension(1205, 584));
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
            java.util.logging.Logger.getLogger(ConsultaPuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaPuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaPuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaPuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaPuestos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane consultaTablapuestos;
    private javax.swing.JPanel menuConsultaPuesto;
    private javax.swing.JTable tablaConsultaPuestos;
    private javax.swing.JLabel tituloConsultaPuestos;
    // End of variables declaration//GEN-END:variables
}
