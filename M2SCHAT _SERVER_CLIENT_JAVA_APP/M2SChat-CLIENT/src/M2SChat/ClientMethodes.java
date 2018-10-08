package M2SChat;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ClientMethodes {

    public static M2SChat Interface;
    public static SignUP Sign;
    public static FriendRequest fReq;
    public static Socket ClientSocket;
    public static String Username;
    public static ArrayList<ArrayList<String>> Conversations;
    public static boolean isOnline = true;
    static DefaultListModel<Notification> msgNotify = new DefaultListModel<Notification>();

    public static void ConnectClientToServer(String IP, JLabel wrong) {
        try {
            if (IP.equals("")) {
                wrong.setText("Enter the server IP !");
                isOnline = false;
            } else {
                isOnline = true;
                ClientSocket = new Socket(IP, 8080);
                new ListenToServer().start();
            }
        } catch (IOException ex) {
            wrong.setText("The server is offline");
            isOnline = false;
        }

    }

    public static void connectClient(String Username, String Password) {

        try {
            if (Username.equals("") || Password.equals("")) {
                TCPChat.login.wrongp.setText("All the Field are required !");
            } else if (isOnline) {
                ClientMethodes.Username = Username;
                PrintStream p = new PrintStream(ClientSocket.getOutputStream());
                String Msg;
                Msg = "CONNEXION" + "\n" + Username + "\n" + Password;
                p.println(Msg);
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientMethodes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void LoggedIn(String Username) {
        ClientMethodes.Conversations = new ArrayList<ArrayList<String>>();
        ClientMethodes.Interface = new M2SChat();
        Interface.LoggedIn.setText(Username);
        Interface.setLocationRelativeTo(null);
        Interface.setVisible(true);
        TCPChat.login.setVisible(false);
    }

    public static void addMsgRecieved(String Username, String Msg, String From) {
        int temp = 0;
        for (int i = 0; i < ClientMethodes.Conversations.size(); ++i) {
            if (ClientMethodes.Conversations.get(i).get(0).equals(Username)) {
                ClientMethodes.Conversations.get(i).add(From + " : " + Msg);
                temp = 1;
            }
        }
        if (temp == 0) {
            ArrayList<String> newConversation = new ArrayList<String>();
            newConversation.add(Username);
            newConversation.add(From + " : " + Msg);
            ClientMethodes.Conversations.add(newConversation);
        }
    }

    public static void sendMsg(String Msg, String To) {
        PrintStream p = null;
        if (!Msg.equals("")) {
            try {
                p = new PrintStream(ClientSocket.getOutputStream());
                p.println("MSG" + "\n" + To + "\n" + Msg);
                ClientMethodes.Interface.Message.setText("");
            } catch (IOException ex) {
                Logger.getLogger(ClientMethodes.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ClientMethodes.Interface.SBT.startMoving();
            } catch (InterruptedException ex) {
                Logger.getLogger(ClientMethodes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void disconnect() {
        PrintStream p = null;
        try {
            p = new PrintStream(ClientSocket.getOutputStream());
            p.println("DECONNEXION" + "\n");
            java.lang.System.exit(0);
        } catch (IOException ex) {
             java.lang.System.exit(0);
        }
    }

    public static void close() {
        java.lang.System.exit(0);
    }

    public static void setFriends() {
        ClientMethodes.Interface.Friends.setModel(ListenToServer.modelFriends);
    }

    public static void setOnline(Object Selected) {
        DefaultListModel<Notification> temp = new DefaultListModel<Notification>();

        for (int l = 0; l < ClientMethodes.msgNotify.size(); ++l) {
            temp.addElement(new Notification(ClientMethodes.msgNotify.get(l).Name, ClientMethodes.msgNotify.get(l).notif));
        }

        ClientMethodes.msgNotify.removeAllElements();
        for (int k = 0; k < ListenToServer.modelOnline.size(); ++k) {
            ClientMethodes.msgNotify.addElement(new Notification((String) ListenToServer.modelOnline.get(k), false));
        }

        for (int kk = 0; kk < temp.size(); ++kk) {
            for (int ll = 0; ll < ClientMethodes.msgNotify.size(); ++ll) {
                if (temp.get(kk).Name.equals(ClientMethodes.msgNotify.get(ll).Name)) {
                    ClientMethodes.msgNotify.get(ll).notif = temp.get(kk).notif;
                }
            }
        }
        ClientMethodes.Interface.online.setModel(ListenToServer.modelOnline);
        if(ListenToServer.modelOnline.size()!=0)
        ClientMethodes.Interface.online.setSelectedValue(Selected, true);

    }

    public static void selectedFriend() {
        ClientMethodes.Interface.TalkingTo.setText((String) ClientMethodes.Interface.online.getSelectedValue());
        for (int i = 0; i < ClientMethodes.msgNotify.size(); ++i) {
            if (ClientMethodes.msgNotify.get(i).Name.equals(ClientMethodes.Interface.online.getSelectedValue())) {
                ClientMethodes.msgNotify.get(i).notif = false;
            }
        }
        try {
            ClientMethodes.Interface.SBT.startMoving();
            ClientMethodes.notification();
        } catch (InterruptedException ex) {
            Logger.getLogger(ClientMethodes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Font setFont(Font font) {

        try {
            URL fontUrl = new File("src\\M2SChat\\Fonts\\snapitc.ttf").toURI().toURL();
            font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
        } catch (FontFormatException ex) {
            Logger.getLogger(ClientMethodes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientMethodes.class.getName()).log(Level.SEVERE, null, ex);
        }
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        return font;
    }

    public static void notification() {

        ClientMethodes.Interface.online.setCellRenderer(new DefaultListCellRenderer() {

            ImageIcon icon = new ImageIcon(getClass().getResource("Photos/msg.png"));
            ImageIcon selectIcon = new ImageIcon(getClass().getResource("Photos/msg1.png"));

            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                setIcon(icon);
                String nextUser = value.toString();
                for (int i = 0; i < ClientMethodes.msgNotify.size(); ++i) {
                    if (ClientMethodes.msgNotify.get(i).Name.equals(value) && ClientMethodes.msgNotify.get(i).notif == true && isSelected == false) {
                        setBackground(new Color(170, 139, 189));
                        setIcon(selectIcon);
                    }
                }

                return c;
            }

        });
    }

    public static void pressedKey(int evt, JButton B) {
        if (evt == 10) {
            B.doClick();
        }
    }

    public static void signUp() {
        Sign = new SignUP();
        Sign.setLocationRelativeTo(null);
        Sign.setVisible(true);
        TCPChat.login.setVisible(false);
    }

    public static void signUpNewClient(String Username, String Password, String confirmPassword) {
        if (Username.equals("") || Password.equals("") || confirmPassword.equals("")) {
            Sign.wrongP.setText("All the Field are required !");
        } else if (!Password.equals(confirmPassword)) {
            Sign.wrongP.setText("These passwords don't match. Try again?");
        } else if (isOnline) {
            PrintStream p = null;
            try {
                p = new PrintStream(ClientSocket.getOutputStream());
                String Msg;
                Msg = "SIGNUP" + "\n" + Username + "\n" + Password;
                p.println(Msg);
            } catch (IOException ex) {
                Logger.getLogger(ClientMethodes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void underline(Font font, JLabel label) {
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        label.setFont(font.deriveFont(attributes));
    }

    public static void addFriend() {
        String friend = JOptionPane.showInputDialog(null, "Enter the username of your friend.", "Add new friend", JOptionPane.QUESTION_MESSAGE);
        boolean temp = true;
        for (int i = 0; i < ListenToServer.modelFriends.size(); ++i) {
            if (friend.equals(ListenToServer.modelFriends.get(i))) {
                JOptionPane.showMessageDialog(null, "you're already friend with " + friend + " !!", "Add friend", JOptionPane.ERROR_MESSAGE);
                temp = false;
                break;
            }
        }
        if (temp) {
            PrintStream p = null;
            try {
                p = new PrintStream(ClientSocket.getOutputStream());
                String Msg;
                Msg = "REQUEST" + "\n" + friend;
                p.println(Msg);
            } catch (IOException ex) {
                Logger.getLogger(ClientMethodes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public static void accept(String newFriend)
    {
        ListenToServer.friendRequest.removeElement(newFriend);
        PrintStream p = null;
            try {
                p = new PrintStream(ClientSocket.getOutputStream());
                String Msg;
                Msg = "ACCEPT" + "\n" + newFriend;
                p.println(Msg);
                ClientMethodes.fReq.requestList.setModel(ListenToServer.friendRequest);
            } catch (IOException ex) {
                Logger.getLogger(ClientMethodes.class.getName()).log(Level.SEVERE, null, ex);
            }   
    }
    
    public static void decline(String noFriend)
    {
        ListenToServer.friendRequest.removeElement(noFriend);
         PrintStream p = null;
            try {
                p = new PrintStream(ClientSocket.getOutputStream());
                String Msg;
                Msg = "DECLINE" + "\n" + noFriend;
                p.println(Msg);
                ClientMethodes.fReq.requestList.setModel(ListenToServer.friendRequest);
            } catch (IOException ex) {
                Logger.getLogger(ClientMethodes.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static void NotiRequest()
    {
        ClientMethodes.fReq.setLocation(ClientMethodes.Interface.getX()+420,ClientMethodes.Interface.getY());
        ClientMethodes.fReq.setVisible(true);
    }

}
