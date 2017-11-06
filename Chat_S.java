import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class Chat_S extends javax.swing.JFrame {

    private static Chat_S           chat        = null;
    private static InetAddress      local       = null;
    private static Servidor         servidor    = null;
    private static Cliente          cliente     = null;
    private static int              puerto      = 80;

    public Chat_S() {
        initComponents();
    }//Constructor

    private void initComponents() {//GEN-BEGIN:initComponents
        pMensajes = new javax.swing.JPanel();
        spMensajes = new javax.swing.JScrollPane();
        taMensajes = new javax.swing.JTextArea();
        pAcciones = new javax.swing.JPanel();
        lHost = new javax.swing.JLabel();
        tfHost = new javax.swing.JTextField();
        tfIP = new javax.swing.JTextField();
        pServidor = new javax.swing.JPanel();
        bEscuchar = new javax.swing.JButton();
        bCerrar = new javax.swing.JButton();
        tfNickS = new javax.swing.JTextField();
        pCliente = new javax.swing.JPanel();
        bConectar = new javax.swing.JButton();
        bDesconectar = new javax.swing.JButton();
        tfIPC = new javax.swing.JTextField();
        tfNickC = new javax.swing.JTextField();
        lModo = new javax.swing.JLabel();
        cbModo = new javax.swing.JComboBox();
        lIP = new javax.swing.JLabel();
        tfMensaje = new javax.swing.JTextField();
        bEnviar = new javax.swing.JButton();
        bBorrar = new javax.swing.JButton();
        mMenu = new javax.swing.JMenuBar();
        mArchivo = new javax.swing.JMenu();
        miSalir = new javax.swing.JMenuItem();
        mAyuda = new javax.swing.JMenu();
        miAcerca = new javax.swing.JMenuItem();

        getContentPane().setLayout(null);

        setTitle("Chat\u00edn [DUE]");
        setFont(new java.awt.Font("Verdana", 0, 10));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        pMensajes.setLayout(new java.awt.BorderLayout());

        pMensajes.setBorder(new javax.swing.border.EtchedBorder());
        spMensajes.setBorder(null);
        taMensajes.setEditable(false);
        taMensajes.setFont(new java.awt.Font("Verdana", 0, 10));
        taMensajes.setLineWrap(true);
        taMensajes.setWrapStyleWord(true);
        taMensajes.setAutoscrolls(false);
        spMensajes.setViewportView(taMensajes);

        pMensajes.add(spMensajes, java.awt.BorderLayout.CENTER);

        getContentPane().add(pMensajes);
        pMensajes.setBounds(10, 10, 400, 400);

        pAcciones.setLayout(null);

        pAcciones.setBorder(new javax.swing.border.EtchedBorder());
        lHost.setFont(new java.awt.Font("Verdana", 1, 10));
        lHost.setText("Host Local");
        pAcciones.add(lHost);
        lHost.setBounds(10, 10, 60, 14);

        tfHost.setEditable(false);
        tfHost.setFont(new java.awt.Font("Verdana", 0, 10));
        tfHost.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfHost.setText("HOST");
        pAcciones.add(tfHost);
        tfHost.setBounds(10, 30, 150, 18);

        tfIP.setEditable(false);
        tfIP.setFont(new java.awt.Font("Verdana", 0, 10));
        tfIP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfIP.setText("IP");
        pAcciones.add(tfIP);
        tfIP.setBounds(10, 80, 150, 18);

        pServidor.setLayout(null);

        pServidor.setBorder(new javax.swing.border.TitledBorder(null, "Servidor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 10)));
        bEscuchar.setFont(new java.awt.Font("Verdana", 0, 10));
        bEscuchar.setText("Escuchar");
        bEscuchar.setEnabled(false);
        bEscuchar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEscucharActionPerformed(evt);
            }
        });

        pServidor.add(bEscuchar);
        bEscuchar.setBounds(10, 50, 130, 20);

        bCerrar.setFont(new java.awt.Font("Verdana", 0, 10));
        bCerrar.setText("Cerrar");
        bCerrar.setEnabled(false);
        bCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarActionPerformed(evt);
            }
        });

        pServidor.add(bCerrar);
        bCerrar.setBounds(10, 80, 130, 20);

        tfNickS.setEditable(false);
        tfNickS.setFont(new java.awt.Font("Verdana", 0, 10));
        tfNickS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfNickS.setText("NICK");
        tfNickS.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfNickSFocusGained(evt);
            }
        });

        pServidor.add(tfNickS);
        tfNickS.setBounds(10, 20, 130, 20);

        pAcciones.add(pServidor);
        pServidor.setBounds(10, 170, 150, 110);

        pCliente.setLayout(null);

        pCliente.setBorder(new javax.swing.border.TitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 10)));
        bConectar.setFont(new java.awt.Font("Verdana", 0, 10));
        bConectar.setText("Conectar");
        bConectar.setEnabled(false);
        bConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConectarActionPerformed(evt);
            }
        });

        pCliente.add(bConectar);
        bConectar.setBounds(10, 80, 130, 20);

        bDesconectar.setFont(new java.awt.Font("Verdana", 0, 10));
        bDesconectar.setText("Desconectar");
        bDesconectar.setEnabled(false);
        bDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDesconectarActionPerformed(evt);
            }
        });

        pCliente.add(bDesconectar);
        bDesconectar.setBounds(10, 110, 130, 20);

        tfIPC.setEditable(false);
        tfIPC.setFont(new java.awt.Font("Verdana", 0, 10));
        tfIPC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfIPC.setText("000.000.000.000");
        tfIPC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfIPCFocusGained(evt);
            }
        });

        pCliente.add(tfIPC);
        tfIPC.setBounds(10, 50, 130, 20);

        tfNickC.setEditable(false);
        tfNickC.setFont(new java.awt.Font("Verdana", 0, 10));
        tfNickC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfNickC.setText("NICK");
        tfNickC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfNickCFocusGained(evt);
            }
        });

        pCliente.add(tfNickC);
        tfNickC.setBounds(10, 20, 130, 20);

        pAcciones.add(pCliente);
        pCliente.setBounds(10, 280, 150, 140);

        lModo.setFont(new java.awt.Font("Verdana", 1, 10));
        lModo.setText("Modo");
        pAcciones.add(lModo);
        lModo.setBounds(10, 110, 30, 14);

        cbModo.setFont(new java.awt.Font("Verdana", 0, 10));
        cbModo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona el modo...", "Servidor", "Cliente" }));
        cbModo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbModoItemStateChanged(evt);
            }
        });

        pAcciones.add(cbModo);
        cbModo.setBounds(10, 130, 150, 20);

        lIP.setFont(new java.awt.Font("Verdana", 1, 10));
        lIP.setText("IP Local");
        pAcciones.add(lIP);
        lIP.setBounds(10, 60, 50, 14);

        getContentPane().add(pAcciones);
        pAcciones.setBounds(420, 10, 170, 430);

        tfMensaje.setFont(new java.awt.Font("Verdana", 0, 10));
        tfMensaje.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfMensaje.setText("Mensaje...");
        tfMensaje.setEnabled(false);
        tfMensaje.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfMensajeFocusGained(evt);
            }
        });

        tfMensaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfMensajeKeyPressed(evt);
            }
        });

        getContentPane().add(tfMensaje);
        tfMensaje.setBounds(10, 420, 220, 20);

        bEnviar.setFont(new java.awt.Font("Verdana", 0, 10));
        bEnviar.setText("Enviar");
        bEnviar.setEnabled(false);
        bEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEnviarActionPerformed(evt);
            }
        });

        getContentPane().add(bEnviar);
        bEnviar.setBounds(240, 420, 70, 20);

        bBorrar.setFont(new java.awt.Font("Verdana", 0, 10));
        bBorrar.setText("Borrar");
        bBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBorrarActionPerformed(evt);
            }
        });

        getContentPane().add(bBorrar);
        bBorrar.setBounds(320, 420, 90, 20);

        mArchivo.setText("Archivo");
        miSalir.setText("Salir");
        miSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalirActionPerformed(evt);
            }
        });

        mArchivo.add(miSalir);

        mMenu.add(mArchivo);

        mAyuda.setText("Ayuda");
        miAcerca.setText("Acerca de...");
        miAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAcercaActionPerformed(evt);
            }
        });

        mAyuda.add(miAcerca);

        mMenu.add(mAyuda);

        setJMenuBar(mMenu);

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setSize(new java.awt.Dimension(600, 500));
        setLocation((screenSize.width-600)/2,(screenSize.height-500)/2);
    }//GEN-END:initComponents

    private void miAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAcercaActionPerformed
        About acerca = new About(chat, true);
        acerca.setVisible(true);
    }//GEN-LAST:event_miAcercaActionPerformed

    private void tfNickSFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNickSFocusGained
        chat.tfNickS.selectAll();
    }//GEN-LAST:event_tfNickSFocusGained

    private void tfNickCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNickCFocusGained
        chat.tfNickC.selectAll();
    }//GEN-LAST:event_tfNickCFocusGained

    private void tfMensajeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMensajeKeyPressed
        if(evt.getKeyCode() == 10) {
            chat.bEnviarActionPerformed(null);
        }
    }//GEN-LAST:event_tfMensajeKeyPressed

    private void bEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEnviarActionPerformed
        if(chat.cliente == null) {
            chat.servidor.enviarMensaje(chat.tfMensaje.getText());
        }//if
        else if(chat.servidor == null) {
            chat.cliente.enviarMensaje(chat.tfMensaje.getText());
        }//else if
        chat.tfMensaje.setText("");
    }//GEN-LAST:event_bEnviarActionPerformed

    private void tfIPCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfIPCFocusGained
        chat.tfIPC.selectAll();
    }//GEN-LAST:event_tfIPCFocusGained

    private void tfMensajeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfMensajeFocusGained
        chat.tfMensaje.selectAll();
    }//GEN-LAST:event_tfMensajeFocusGained

    private void bBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBorrarActionPerformed
        chat.taMensajes.setText("");
    }//GEN-LAST:event_bBorrarActionPerformed

    private void cbModoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbModoItemStateChanged
        if (cbModo.getSelectedIndex() == 1) {
            chat.bEscuchar.setEnabled(true);
            chat.tfNickS.setEditable(true);
            chat.bCerrar.setEnabled(false);
            chat.bConectar.setEnabled(false);
            chat.bDesconectar.setEnabled(false);
            chat.tfIPC.setEditable(false);
            chat.tfNickC.setEditable(false);
        }//if
        
        else if (cbModo.getSelectedIndex() == 2) {
            chat.bEscuchar.setEnabled(false);
            chat.tfNickS.setEditable(false);
            chat.bCerrar.setEnabled(false);
            chat.bConectar.setEnabled(true);
            chat.bDesconectar.setEnabled(false);
            chat.tfIPC.setEditable(true);
            chat.tfNickC.setEditable(true);
        }//else if
        
        else {
            chat.bEscuchar.setEnabled(false);
            chat.tfNickS.setEditable(false);
            chat.bCerrar.setEnabled(false);
            chat.bConectar.setEnabled(false);
            chat.bDesconectar.setEnabled(false);
            chat.tfIPC.setEditable(false);
        }//else
    }//GEN-LAST:event_cbModoItemStateChanged

    private void bDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDesconectarActionPerformed
        try {
            if(chat.cliente != null) chat.cliente.close();
            chat.cliente = null;
            
            chat.cbModo.setEnabled(true);
            chat.bDesconectar.setEnabled(false);
            chat.bConectar.setEnabled(true);
            chat.tfIPC.setEnabled(true);
            chat.tfNickC.setEnabled(true);
            chat.bEnviar.setEnabled(false);
            chat.tfMensaje.setEnabled(false);
        } catch (Exception e) {
            chat.setMessage("IMPOSIBLE DESCONECTARSE del servidor.");
        }//try - catch
    }//GEN-LAST:event_bDesconectarActionPerformed

    private void bConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConectarActionPerformed
        try {
            chat.cliente = new Cliente(chat, chat.tfIPC.getText(), puerto, chat.tfNickC.getText());
            chat.cliente.start();
            
            chat.cbModo.setEnabled(false);
            chat.bConectar.setEnabled(false);
            chat.bDesconectar.setEnabled(true);
            chat.tfIPC.setEnabled(false);
            chat.tfNickC.setEnabled(false);
            chat.bEnviar.setEnabled(true);
            chat.tfMensaje.setEnabled(true);
        } catch (Exception e) {
            chat.setMessage("IMPOSIBLE CONECTAR a servidor.");
        }//try - catch
    }//GEN-LAST:event_bConectarActionPerformed

    private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed
        try {
            if(chat.servidor != null) chat.servidor.close();
            chat.servidor = null;
            
            chat.cbModo.setEnabled(true);
            chat.bCerrar.setEnabled(false);
            chat.bEscuchar.setEnabled(true);
            chat.tfNickS.setEditable(true);
            chat.bEnviar.setEnabled(false);
            chat.tfMensaje.setEnabled(false);
        } catch (Exception e) {
            chat.setMessage("IMPOSIBLE CERRAR el servidor.");
        }//try - catch
    }//GEN-LAST:event_bCerrarActionPerformed

    private void bEscucharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEscucharActionPerformed
        try {
            chat.servidor = new Servidor(chat, chat.tfNickS.getText());
            chat.servidor.start();
            
            chat.cbModo.setEnabled(false);
            chat.tfNickS.setEditable(false);
            chat.bEscuchar.setEnabled(false);
            chat.bCerrar.setEnabled(true);
            chat.bEnviar.setEnabled(true);
            chat.tfMensaje.setEnabled(true);
        } catch (Exception e) {
            chat.setMessage("IMPOSIBLE CREAR servidor.");
        }//try - catch
    }//GEN-LAST:event_bEscucharActionPerformed

    private void miSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miSalirActionPerformed

    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    public static void main(String args[]) {
        chat = new Chat_S();
        chat.show();
        
        chat.initVariables();
    }//main
    
    private void initVariables() {
        try {
            local = InetAddress.getLocalHost();
            chat.tfHost.setText(local.getHostName().toUpperCase());
        } catch (Exception ex) {
            chat.tfHost.setText("DESCONOCIDO");
        }//try - catch HOST

        try {
            chat.tfIP.setText(local.getHostAddress().toUpperCase());
        } catch (Exception e) {
            chat.tfIP.setText("DESCONOCIDA");
        }//try - catch IP
    }//initVariables
    
    public void setMessage(String message) {
        chat.taMensajes.append(message + "\n");
        chat.taMensajes.setCaretPosition(taMensajes.getText().length());
    }//setMessage

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField tfHost;
    private javax.swing.JComboBox cbModo;
    private javax.swing.JMenuItem miAcerca;
    private javax.swing.JButton bEnviar;
    private javax.swing.JMenuItem miSalir;
    private javax.swing.JTextArea taMensajes;
    private javax.swing.JMenu mAyuda;
    private javax.swing.JPanel pServidor;
    private javax.swing.JTextField tfNickS;
    private javax.swing.JTextField tfIPC;
    private javax.swing.JButton bBorrar;
    private javax.swing.JTextField tfNickC;
    private javax.swing.JLabel lIP;
    private javax.swing.JButton bConectar;
    private javax.swing.JButton bDesconectar;
    private javax.swing.JButton bEscuchar;
    private javax.swing.JButton bCerrar;
    private javax.swing.JPanel pAcciones;
    private javax.swing.JPanel pCliente;
    private javax.swing.JLabel lHost;
    private javax.swing.JTextField tfIP;
    private javax.swing.JTextField tfMensaje;
    private javax.swing.JMenu mArchivo;
    private javax.swing.JLabel lModo;
    private javax.swing.JMenuBar mMenu;
    private javax.swing.JPanel pMensajes;
    private javax.swing.JScrollPane spMensajes;
    // End of variables declaration//GEN-END:variables

}//Chat_S