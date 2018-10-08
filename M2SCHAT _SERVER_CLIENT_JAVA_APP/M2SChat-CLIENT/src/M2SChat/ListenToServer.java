package M2SChat;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class ListenToServer extends Thread {

    public static DefaultListModel modelOnline = new DefaultListModel();
    public static DefaultListModel modelFriends = new DefaultListModel();
    public static DefaultListModel friendRequest = new DefaultListModel();

    @Override
    public synchronized void run() {
        boolean serverOnline = true;
        while (serverOnline) {
            try {
                Scanner msg = new Scanner(ClientMethodes.ClientSocket.getInputStream());
                String Msgs = msg.nextLine();

                if (Msgs.equals("CONNEXION")) {
                    if (msg.nextLine().equals("TRUE")) {
                        ClientMethodes.LoggedIn(ClientMethodes.Username);
                    } else {
                        TCPChat.login.wrongp.setText("The username or password is incorrect !");
                    }
                } else if (Msgs.equals("ONLINE")) {
                    String[] S = msg.nextLine().split(":::");
                    Object selected = ClientMethodes.Interface.online.getSelectedValue();
                    ListenToServer.modelOnline.removeAllElements();
                    for (int i = 0; i < S.length; ++i) {
                        if (!S[i].equals("")) {
                            ListenToServer.modelOnline.addElement(S[i]);
                        }
                    }
                    ClientMethodes.setOnline(selected);
                    ClientMethodes.notification();
                } else if (Msgs.equals("FRIENDS")) {
                    ListenToServer.modelFriends.removeAllElements();
                    String[] S = msg.nextLine().split(":::");
                    for (int i = 0; i < S.length; ++i) {
                        ListenToServer.modelFriends.addElement(S[i]);
                    }
                    ClientMethodes.Interface.Friends.setModel(modelFriends);
                } else if (Msgs.equals("MSG")) {
                    String From = msg.nextLine();
                    String MSG = msg.nextLine();

                    for (int i = 0; i < ClientMethodes.msgNotify.size(); ++i) {
                        if (ClientMethodes.msgNotify.get(i).Name.equals(From) && !ClientMethodes.msgNotify.get(i).Name.equals(ClientMethodes.Interface.online.getSelectedValue())) {
                            ClientMethodes.msgNotify.get(i).notif = true;
                        }
                    }
                    ClientMethodes.notification();
                    ClientMethodes.addMsgRecieved(From, MSG, From);
                    ClientMethodes.Interface.SBT.startMoving();
                    
                } else if (Msgs.equals("NOTIFICATION")) {
                    String Notif = msg.nextLine();
                    String [] requests = Notif.split(":::");
                    for(int i = 0;i<requests.length;++i)
                    {
                        if(!requests[i].equals(""))
                        ListenToServer.friendRequest.addElement(requests[i]);   
                    }
                    ClientMethodes.fReq.requestList.setModel(ListenToServer.friendRequest);
                } else if (Msgs.equals("SIGNUP")) {
                    String REGISTER = msg.nextLine();
                    if (REGISTER.equals("TRUE")) {
                        JOptionPane.showMessageDialog(null, "You accout created successfully, congratulations !", "Gongrats", JOptionPane.INFORMATION_MESSAGE);
                        TCPChat.login.setVisible(true);
                        ClientMethodes.Sign.setVisible(false);
                    } else {
                        ClientMethodes.Sign.wrongP.setText("The username is already exists !");
                    }
                } else if (Msgs.equals("REQUEST")) {
                    String REQUEST = msg.nextLine();
                    JOptionPane.showMessageDialog(null, REQUEST, "Friend request", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception ex) {
                //Logger.getLogger(ListenToServer.class.getName()).log(Level.SEVERE, null, ex);
                try {
                    serverOnline = false;
                    ClientMethodes.ClientSocket.close();
                    JOptionPane.showMessageDialog(null, "The server went offline", "Server", JOptionPane.WARNING_MESSAGE);
                } catch (IOException ex1) {
                    Logger.getLogger(ListenToServer.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
    }

}
