import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class Cliente extends Thread {

    private Chat_S padre  = null;
    private Socket socket = null;
    private String ip     = null;
    private int    puerto = 0;
    private String nick   = null;
    
    public Cliente(Chat_S padre, String ip, int puerto, String nick) throws Exception {
        this.padre  = padre;
        this.ip     = ip;
        this.puerto = puerto;
        this.nick   = nick;
        socket = new Socket(ip, puerto);
    }//Contructor
    
    public void run() {
        try {
            String mensaje;
            padre.setMessage("CONECTADO al servidor.");
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            while(true) {
                mensaje = entrada.readUTF();
                padre.setMessage(mensaje);
            }//while
        } catch (Exception e) {
            padre.setMessage("SERVIDOR cerrado.");
        }//try - catch
    }//arrancar
    
    public void close() throws Exception {
        socket.close();
        padre.setMessage("DESCONECTADO del servidor");
    }//close
    
    public void enviarMensaje(String mensaje) {
        try {
            DataOutputStream salida = new DataOutputStream(this.socket.getOutputStream());
            salida.writeUTF("<" + nick + "> " + mensaje);
            padre.setMessage("<" + nick + "> " + mensaje);
        } catch (Exception e) {
            padre.setMessage("IMPOSIBLE enviar mensaje.");
        }//try - catch
    }//enviarMensaje
}//Socket_C