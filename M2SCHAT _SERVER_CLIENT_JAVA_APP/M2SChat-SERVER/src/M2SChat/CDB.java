package M2SChat;

import java.net.InetAddress;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CDB {

    public static Connection Getconnect(String ip) throws Exception {
        Connection cn = null;

        Class.forName("com.mysql.jdbc.Driver");
        cn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/serverclient", "root", "");

        return cn;
    }

    public static int update(String sql, String ip) {
        int t = 0;
        try {
            Connection cn = Getconnect(ip);
            Statement st = cn.createStatement();
            t = st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return t;
    }

    public static ResultSet select(String sql, String ip) {
        ResultSet rs = null;
        try {
            Connection cn = Getconnect(ip);
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return rs;
    }

    public static String Friends(String Username, String IP) {
        String F = "";
        ResultSet rs = CDB.select("SELECT `Friends` FROM `user` WHERE `UserName` = '" + Username + "'", IP);
        try {
            while (rs.next()) {

                F = rs.getString("Friends");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return F;
    }

    public static String friendsList(String Username, String IP) {
        String List = "";
        String FF = CDB.Friends(Username, IP);
        String[] IDS = FF.split(";");

        for (int i = 0; i < IDS.length; ++i) {
            ResultSet rs = CDB.select("SELECT `UserName` FROM `user` WHERE `ID` = '" + IDS[i] + "'", IP);
            try {
                while (rs.next()) {
                    List += rs.getString("UserName") + ":::";
                }

            } catch (SQLException ex) {
                Logger.getLogger(CDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return List;
    }

    public static String onlineFriendsList(String Username, String IP) {
        String FF = CDB.Friends(Username, IP);
        String[] IDS = FF.split(";");
        String List = "";
        for (int i = 0; i < IDS.length; ++i) {
            ResultSet rs = CDB.select("SELECT user.`UserName` FROM `user`,`onlineclients` WHERE user.`ID` = '" + IDS[i] + "' AND onlineclients.`UserName` = user.`UserName`", IP);
            try {
                while (rs.next()) {
                    List += rs.getString("UserName") + ":::";
                }

            } catch (SQLException ex) {
                //Logger.getLogger(CDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return List;
    }

    public static String LogIn(String Username, String Password, String DBIP) {
        String TrueFalse = null;
        try {
            ResultSet rs = CDB.select("SELECT * FROM `user` WHERE `UserName` = '" + Username + "' AND `Password` = '" + Password + "'", DBIP);

            if (!rs.next()) {
                TrueFalse = "FALSE";

            } else {
                TrueFalse = "TRUE";
            }

        } catch (SQLException ex) {
            Logger.getLogger(CDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return TrueFalse;
    }

    public static void makeOnline(String Username, String IP, int Port, String DBIP) {
        CDB.update("INSERT INTO `onlineclients` (`UserName`, `IP`, `Port`) VALUES ('" + Username + "','" + IP + "','" + Port + "')", DBIP);
    }

    public static void makeOffline(String Username, String DBIP) {
        CDB.update("DELETE FROM `onlineclients` WHERE `UserName` = '" + Username + "'", DBIP);
    }

    public static void deleteAll(String DBIP) {
        CDB.update("DELETE FROM `onlineclients`", DBIP);
    }

    public static boolean verifyExist(String Username, String DBIP) {
        ResultSet rs = CDB.select("SELECT * FROM `user` WHERE `UserName` = '" + Username + "'", DBIP);
        try {
            if (rs.next()) {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public static boolean verifyExist(String Username, String requestFrom, String DBIP) {
        ResultSet rs = CDB.select("SELECT * FROM `friendrequest` WHERE `UserName` = '" + Username + "' AND `RequestFrom` = '" + requestFrom + "'", DBIP);
        try {
            if (rs.next()) {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public static String signUpClient(String Username, String Password, String DBIP) {
        String valid = "FALSE";

        if (verifyExist(Username, DBIP)) {
            CDB.update("INSERT INTO `user` (`UserName`, `Password`) VALUES ('" + Username + "','" + Password + "')", DBIP);
            valid = "TRUE";
        }

        return valid;
    }

    public static void addRequest(String Username, String requestFrom, String DBIP) {
        if (verifyExist(Username, requestFrom, DBIP)) {
            CDB.update("INSERT INTO `friendrequest` (`UserName`,`RequestFrom`) VALUES ('" + Username + "','" + requestFrom + "')", DBIP);
        }
    }

    public static String getRequests(String Username, String DBIP) {
        ResultSet rs = CDB.select("SELECT `RequestFrom` FROM `friendrequest` WHERE `UserName` = '" + Username + "'", DBIP);
        String requesters = "";
        try {
            while (rs.next()) {
                requesters += rs.getString("RequestFrom") + ":::";
            }
        } catch (SQLException ex) {
            Logger.getLogger(CDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return requesters;
    }

    public static void deleteRequest(String Username, String request, String DBIP) {
        CDB.update("DELETE FROM `friendrequest` WHERE `UserName` = '" + Username + "' AND `RequestFrom` = '" + request + "' OR `UserName` = '" + request + "' AND `RequestFrom` = '" + Username + "'", DBIP);
    }

    public static int returnID(String Username, String DBIP) {
        ResultSet rs = CDB.select("SELECT `ID` FROM `user` WHERE `UserName` = '" + Username + "'", DBIP);
        try {
            while (rs.next()) {
                return rs.getInt("ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static void addFriend(String Username, String Friend, String DBIP) {
        String friends1 = CDB.Friends(Username, DBIP);
        String friends2 = CDB.Friends(Friend, DBIP);
        if (friends1.equals("0")) {
            friends1 =""+CDB.returnID(Friend, DBIP) ;
        } else {
            friends1 += ";" + CDB.returnID(Friend, DBIP);
        }
        if (friends2.equals("0")) {
            friends2 = ""+CDB.returnID(Username, DBIP);
        } else {
            friends2 += ";" + CDB.returnID(Username, DBIP);
        }

        CDB.update("UPDATE `user` SET `Friends` = '" + friends1 + "' WHERE `UserName` = '" + Username + "'", DBIP);
        CDB.update("UPDATE `user` SET `Friends` = '" + friends2 + "' WHERE `UserName` = '" + Friend + "'", DBIP);
    }

}
