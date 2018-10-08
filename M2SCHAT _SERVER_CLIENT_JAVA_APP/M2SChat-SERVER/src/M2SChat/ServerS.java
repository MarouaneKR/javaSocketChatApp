package M2SChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class ServerS extends Thread {

    static ServerSocket sSocket;
    Socket client;
    static ArrayList<ArrayList<String>> conversation;
    public static ArrayList<SavedSockets> SaveSocket;
    public static DefaultListModel connectedClients = new DefaultListModel();

    public ServerS() {
        conversation = new ArrayList<ArrayList<String>>();
        SaveSocket = new ArrayList<SavedSockets>();
        try {
            sSocket = new ServerSocket(8080);
            
        } catch (IOException ex) {
            Logger.getLogger(ServerS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized void run() {
        Scanner msg;
        
        while (true) {
            try {
                
                this.client = this.sSocket.accept();
                new ServerListener(this.client).start();

            } catch (IOException ex) {
                Logger.getLogger(ServerS.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    

}
