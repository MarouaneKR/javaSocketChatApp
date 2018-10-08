package M2SChat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SendFriendRequest extends Thread{
    private Socket clientSocket;
    private String Username;
    public SendFriendRequest(Socket s,String user)
    {
        this.Username = user;
        this.clientSocket = s;
    }
    
    @Override
    public synchronized void run()
    {
        PrintStream p = null;
        while (ServerListener.Connected) {            
            try {
                p = new PrintStream(this.clientSocket.getOutputStream());
                p.println("NOTIFICATION" + "\n" + CDB.getRequests(this.Username,ServerInterface.DBIP));
            } catch (IOException ex) {
                Logger.getLogger(SendFriendRequest.class.getName()).log(Level.SEVERE, null, ex);
            }  
            try {
                sleep(60000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SendFriendRequest.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
