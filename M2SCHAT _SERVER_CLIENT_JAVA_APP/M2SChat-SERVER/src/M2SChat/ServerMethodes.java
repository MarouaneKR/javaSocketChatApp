package M2SChat;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class ServerMethodes {
    
    public static ServerInterface Interface;
    public static boolean verify = true;

    public static void verify(String IP) {
        try {
            CDB.Getconnect(IP);

        } catch (Exception ex) {
            verify = false;

        }
    }

    public static void connectServer(String IP) {
        ServerMethodes.verify(IP);
        if (verify == true) {
            
            try { 
                CDB.deleteAll(IP);
                ServerMethodes.Interface = new ServerInterface(IP);
                ServerMethodes.Interface.setLocationRelativeTo(null);
                ServerMethodes.Interface.setVisible(true);
                TCPChat.serverLogin.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(ServerMethodes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ServerMethodes.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            TCPChat.serverLogin.wrongp.setText("Wrong IP !!");

        }
    }
    
    public static  void saveConvo(String MsgFromTo, String fromTo, String toFrom)
    {
        int temp = 0;
        for (int i = 0; i < ServerS.conversation.size(); ++i) {
            if (ServerS.conversation.get(i).get(0).equals(fromTo) &&ServerS.conversation.get(i).get(1).equals(toFrom) || 
                 ServerS.conversation.get(i).get(0).equals(toFrom) && ServerS.conversation.get(i).get(1).equals(fromTo)   ) {
                ServerS.conversation.get(i).add(fromTo+" : "+MsgFromTo);
                temp = 1;
            }
        }
        if(temp == 0)
        {
            ArrayList<String> newConv = new ArrayList<String>();
            newConv.add(fromTo);
            newConv.add(toFrom);
            newConv.add(fromTo+" : "+MsgFromTo);
            ServerS.conversation.add(newConv);

        }
    
    }
    
    public static DefaultListModel connectedClients()
    {
        DefaultListModel model = new DefaultListModel();
        for(int i = 0; i<ServerS.SaveSocket.size();++i)
        {
         model.addElement(ServerS.SaveSocket.get(i).Username);
        }
        return model;
    }
    
     public static Font setFont(Font font) 
    {
     
        try {
            URL fontUrl = new File("src\\M2SChat\\Fonts\\snapitc.ttf").toURI().toURL();
            font = Font.createFont(Font.TRUETYPE_FONT,  fontUrl.openStream());
        } catch (FontFormatException ex) {
            Logger.getLogger(ServerInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
         GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);  
        return font;
    }
     
     
     public static  void pressedKey(int evt) {
        if (evt == 10) {
            if (TCPChat.serverLogin.IP.getText().equals("")) {
                TCPChat.serverLogin.wrongp.setText("All the Field are required !");
            } else {
               TCPChat.serverLogin.Login.doClick();
            }
        }
    }
     public static void reduce() {
        ServerMethodes.Interface.setState(ServerMethodes.Interface.ICONIFIED);
    }

    public static void reduceLogin() {
        TCPChat.serverLogin.setState(TCPChat.serverLogin.ICONIFIED);
    }

    public static void close() {
        java.lang.System.exit(0);
    }
    
}
