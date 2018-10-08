package M2SChat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SendOnlineFriends extends Thread {

    private Socket clientSocket;
    private String Username;
    private String TEMP;
    public SendOnlineFriends(Socket s, String User) {
        this.clientSocket = s;
        this.Username = User;
    }

    @Override
    public synchronized void run() {
        //this.TEMP = "0";
        //String ON = ""; 
            //!this.TEMP.equals(ON)
        while (true) {
            PrintStream p;
            //ON = CDB.onlineFriendsList(this.Username, ServerInterface.DBIP);
            if (true) {
                try {  
                    p = new PrintStream(this.clientSocket.getOutputStream());
                    p.println("ONLINE" + "\n" + CDB.onlineFriendsList(this.Username, ServerInterface.DBIP));
                    //this.TEMP = ON;
                } catch (IOException ex) {
                    Logger.getLogger(SendOnlineFriends.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SendOnlineFriends.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
