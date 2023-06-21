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
import segundoobligatoriop2.auxiliar.Dueno;


public class ConsultaDuenosDePuesto extends javax.swing.JFrame {

  
    public ConsultaDuenosDePuesto() {
        initComponents();
        generarTablaDuenos();

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
            model.addRow(new Object[]{dueno.getNombre(), dueno.getEdad(), dueno.getAExperiencia()});
        }
        tablaConsultaDuenos.revalidate();
        tablaConsultaDuenos.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelConsultaDueno = new javax.swing.JPanel();
        contenedorTablaConsulta = new javax.swing.JScrollPane();
        tablaConsultaDuenos = new javax.swing.JTable();
        tituloConsultaDuenos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de dueños de puesto");

        panelConsultaDueno.setLayout(null);

        tablaConsultaDuenos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
        contenedorTablaConsulta.setViewportView(tablaConsultaDuenos);

        panelConsultaDueno.add(contenedorTablaConsulta);
        contenedorTablaConsulta.setBounds(110, 70, 910, 402);

        tituloConsultaDuenos.setFont(new java.awt.Font("Segoe UI Symbol", 0, 36)); // NOI18N
        tituloConsultaDuenos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloConsultaDuenos.setText("Dueños de puestos");
        panelConsultaDueno.add(tituloConsultaDuenos);
        tituloConsultaDuenos.setBounds(110, 10, 910, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1220, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelConsultaDueno, javax.swing.GroupLayout.PREFERRED_SIZE, 1220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelConsultaDueno, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(1093, 543));
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
            java.util.logging.Logger.getLogger(ConsultaDuenosDePuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaDuenosDePuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaDuenosDePuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaDuenosDePuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaDuenosDePuesto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane contenedorTablaConsulta;
    private javax.swing.JPanel panelConsultaDueno;
    private javax.swing.JTable tablaConsultaDuenos;
    private javax.swing.JLabel tituloConsultaDuenos;
    // End of variables declaration//GEN-END:variables
}
