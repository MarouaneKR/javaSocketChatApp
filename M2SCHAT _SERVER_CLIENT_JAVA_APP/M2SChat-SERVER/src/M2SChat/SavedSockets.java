package M2SChat;

import java.net.Socket;

public class SavedSockets {
    
    Socket ClientSocket;
    String Username;
    
    public SavedSockets(Socket socket, String name)
    {
        this.ClientSocket = socket;
        this.Username = name;
    }

}
