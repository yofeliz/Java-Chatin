import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class Servidor extends Thread {
    private static  ServerSocket server  = null;
    private static  Socket       cliente = null;
    private static  Chat_S padre         = null;
    private int     puerto               = 80;
    private int     x                    = 0;
    private String  nick                 = null;
    private boolean flag                 = false;
    
    public Servidor(Chat_S padre, String nick) throws IOException {
        server     = new ServerSocket(puerto);
        this.padre = padre;
        flag       = true;
        this.nick  = nick;
    }//Constructor
    
    public void run() {
        while(flag) {
            try {
                String mensaje = null;
            
                padre.setMessage("Servidor ESCUCHANDO.");
                cliente = server.accept();
                padre.setMessage("CLIENTE conectado.");
                DataInputStream entrada = new DataInputStream(cliente.getInputStream());
                while(true) {
                    mensaje = entrada.readUTF();
                    padre.setMessage(mensaje);
                }//while
            } catch (Exception e) {
                try {
                    padre.setMessage("CLIENTE desconectado.");
                    cliente.close();
                } catch (Exception ex) {
                }//try - catch
            }//try - catch
        }//while
    }//run
    
    public void enviarMensaje(String mensaje) {
        try {
            DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
            salida.writeUTF("<" + nick + "> " + mensaje);
            padre.setMessage("<" + nick + "> " + mensaje);
        } catch (Exception e) {
            padre.setMessage("IMPOSIBLE ENVIAR mensaje.");
        }//try - catch
    }//enviarMensaje
    
    public void close() throws Exception {
        if(cliente != null) cliente.close();
        flag = false;
        server.close();
        padre.setMessage("Servidor CERRADO.");
    }//close
}//Servidor