package M2SChat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerListener extends Thread {

    private Socket clientSocket;
    private String Username;
    public static boolean Connected;

    public ServerListener(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public synchronized void run() {
        Connected = true;
        while (true) {

            try {
                Scanner msg = new Scanner(this.clientSocket.getInputStream());
                String Msg = msg.nextLine();
                if (Msg.equals("CONNEXION")) {
                    String USER = msg.nextLine();
                    String PASS = msg.nextLine();
                    this.Username = USER;
                    String Verify = CDB.LogIn(USER, PASS, ServerInterface.DBIP);
                    if (Verify.equals("TRUE")) {
                        PrintStream p = new PrintStream(this.clientSocket.getOutputStream());
                        p.println("CONNEXION" + "\n" + "TRUE");
                        CDB.makeOnline(USER, this.clientSocket.getInetAddress().toString().substring(1), this.clientSocket.getPort(), ServerInterface.DBIP);
                        ServerS.SaveSocket.add(new SavedSockets(this.clientSocket, this.Username));
                        p.println("FRIENDS" + "\n" + CDB.friendsList(this.Username, ServerInterface.DBIP));
                        new SendOnlineFriends(this.clientSocket, this.Username).start();
                        new SendFriendRequest(this.clientSocket, this.Username).start();
                        //set Client online on the server ... 
                        ServerS.connectedClients.addElement(this.Username);
                        ServerMethodes.Interface.connected.setModel(ServerS.connectedClients);
                    } else {
                        PrintStream p = new PrintStream(this.clientSocket.getOutputStream());
                        p.println("CONNEXION" + "\n" + "FALSE");
                    }

                } else if (Msg.equals("MSG")) {
                    String TO = msg.nextLine();
                    String MSG = msg.nextLine();

                    ServerMethodes.saveConvo(MSG, this.Username, TO);
                    System.out.println(ServerS.conversation.get(0).size());
                    try {
                        ServerMethodes.Interface.SBT.startMoving();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ServerListener.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    for (int i = 0; i < ServerS.SaveSocket.size(); ++i) {
                        if (ServerS.SaveSocket.get(i).Username.equals(TO)) {
                            PrintStream p = new PrintStream(ServerS.SaveSocket.get(i).ClientSocket.getOutputStream());
                            p.println("MSG" + "\n" + this.Username + "\n" + MSG);
                        }
                    }
                } else if (Msg.equals("SIGNUP")) {
                    String Username = msg.nextLine();
                    String Password = msg.nextLine();
                    PrintStream p = new PrintStream(this.clientSocket.getOutputStream());
                    p.println("SIGNUP" + "\n" + CDB.signUpClient(Username, Password, ServerInterface.DBIP));

                } else if (Msg.equals("ACCEPT")) {
                    String newFriend = msg.nextLine();
                    CDB.deleteRequest(this.Username, newFriend, ServerInterface.DBIP);
                    CDB.addFriend(this.Username, newFriend, ServerInterface.DBIP);
                    PrintStream p = new PrintStream(this.clientSocket.getOutputStream());
                    p.println("FRIENDS" + "\n" + CDB.friendsList(this.Username, ServerInterface.DBIP));
                } else if (Msg.equals("DECLINE")) {
                    String noFriend = msg.nextLine();
                    CDB.deleteRequest(this.Username, noFriend, ServerInterface.DBIP);
                } else if (Msg.equals("REQUEST")) {
                    String friend = msg.nextLine();
                    PrintStream p = null;
                    if (!CDB.verifyExist(friend, ServerInterface.DBIP) && !friend.equals(this.Username)) {
                        p = new PrintStream(this.clientSocket.getOutputStream());
                        p.println("REQUEST" + "\n" + "Friend request sent !");
                        CDB.addRequest(friend, this.Username, ServerInterface.DBIP);
                    } else {
                        p = new PrintStream(this.clientSocket.getOutputStream());
                        p.println("REQUEST" + "\n" + "This user name doesn't exist, please check the spelling !");
                    }
                } else if (Msg.equals("DECONNEXION")) {
                    CDB.makeOffline(this.Username, ServerInterface.DBIP);
                    for (int j = 0; j < ServerS.SaveSocket.size(); ++j) {
                        if (ServerS.SaveSocket.get(j).Username.equals(this.Username)) {
                            ServerS.SaveSocket.remove(j);
                            break;
                        }
                    }
                    ServerS.connectedClients.removeElement(this.Username);
                    ServerMethodes.Interface.connected.setModel(ServerS.connectedClients);
                    Connected = false;
                }

            } catch (Exception ex) {
                //Logger.getLogger(ServerListener.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
