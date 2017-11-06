//package XRMI;

public class About extends javax.swing.JDialog {
    private static About acerca;
    
    public About(Chat_S padre, boolean modal) {
        super(padre, modal);
        initComponents();
    }//Constructor

    private void initComponents() {//GEN-BEGIN:initComponents
        pImagen = new javax.swing.JPanel();
        lImagen = new javax.swing.JLabel();
        lChatin = new javax.swing.JLabel();
        bOK = new javax.swing.JButton();
        lChat = new javax.swing.JLabel();
        lAutor = new javax.swing.JLabel();
        lParados = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        setTitle("Acerca de...");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        pImagen.setBorder(new javax.swing.border.EtchedBorder());
        lImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.jpg")));
        pImagen.add(lImagen);

        getContentPane().add(pImagen);
        pImagen.setBounds(10, 10, 90, 120);

        lChatin.setFont(new java.awt.Font("Verdana", 1, 12));
        lChatin.setText("Chat\u00edn DUE");
        getContentPane().add(lChatin);
        lChatin.setBounds(110, 20, 80, 16);

        bOK.setText("Ok");
        bOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOKActionPerformed(evt);
            }
        });

        getContentPane().add(bOK);
        bOK.setBounds(160, 110, 50, 20);

        lChat.setFont(new java.awt.Font("Verdana", 0, 12));
        lChat.setText("Chat en Java");
        getContentPane().add(lChat);
        lChat.setBounds(120, 40, 90, 16);

        lAutor.setFont(new java.awt.Font("Verdana", 0, 10));
        lAutor.setText("D.D\u00edaz \u00a9 2003");
        getContentPane().add(lAutor);
        lAutor.setBounds(110, 90, 82, 14);

        lParados.setFont(new java.awt.Font("Verdana", 0, 12));
        lParados.setText("para dos");
        getContentPane().add(lParados);
        lParados.setBounds(120, 60, 60, 17);

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setSize(new java.awt.Dimension(225, 160));
        setLocation((screenSize.width-225)/2,(screenSize.height-160)/2);
    }//GEN-END:initComponents

    private void bOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOKActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_bOKActionPerformed

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lChatin;
    private javax.swing.JLabel lChat;
    private javax.swing.JLabel lImagen;
    private javax.swing.JPanel pImagen;
    private javax.swing.JLabel lParados;
    private javax.swing.JLabel lAutor;
    private javax.swing.JButton bOK;
    // End of variables declaration//GEN-END:variables

}//About