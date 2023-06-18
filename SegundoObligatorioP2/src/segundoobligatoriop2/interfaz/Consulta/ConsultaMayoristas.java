package segundoobligatoriop2.interfaz.Consulta;

public class ConsultaMayoristas extends javax.swing.JFrame {

    public ConsultaMayoristas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuConsultaMayorista = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
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
        jScrollPane4.setViewportView(tablaConsultaMayoristas);

        menuConsultaMayorista.add(jScrollPane4);
        jScrollPane4.setBounds(150, 70, 880, 402);

        tituloConsultaPuestos1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 36)); // NOI18N
        tituloConsultaPuestos1.setText("Mayoristas");
        menuConsultaMayorista.add(tituloConsultaPuestos1);
        tituloConsultaPuestos1.setBounds(500, 20, 240, 40);

        getContentPane().add(menuConsultaMayorista);
        menuConsultaMayorista.setBounds(0, 0, 1300, 500);

        setBounds(0, 0, 1231, 542);
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel menuConsultaMayorista;
    private javax.swing.JTable tablaConsultaMayoristas;
    private javax.swing.JLabel tituloConsultaPuestos1;
    // End of variables declaration//GEN-END:variables
}
