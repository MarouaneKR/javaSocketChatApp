package M2SChat;

import java.awt.Toolkit;
import java.awt.Font;
import java.io.IOException;
import java.net.ServerSocket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultCaret;

public class ServerInterface extends javax.swing.JFrame {

    public Font font;
    private int xMouse;
    private int yMouse;
    public static String DBIP;
    private ServerSocket socket;
    static StartBlockThread SBT;
    

    public ServerInterface(String DBIP) throws SQLException, IOException {

        initComponents();
        setIcon();
        this.DBIP = DBIP;
        this.SBT = new StartBlockThread();
        new ServerS().start();
        new OnlineClients().start();
        new showServerConversations().start();
    }
    
    public ServerInterface() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Convos = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ConvBetween = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Conv = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        connected = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("M2SChat!");
        setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        setForeground(java.awt.Color.lightGray);
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(600, 530));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Convos.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Convos.setForeground(new java.awt.Color(6, 52, 114));
        Convos.setToolTipText("");
        Convos.setSelectionBackground(new java.awt.Color(139, 163, 189));
        Convos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ConvosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(Convos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 90, 150, 200);

        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(535, 0, 30, 30);

        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(570, 0, 30, 30);

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel2MouseDragged(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 600, 30);

        ConvBetween.setFont(new java.awt.Font(ServerMethodes.setFont(this.font).getName(), 0, 20));
        ConvBetween.setForeground(new java.awt.Color(139, 163, 189));
        ConvBetween.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(ConvBetween);
        ConvBetween.setBounds(200, 50, 380, 30);

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Conv.setColumns(20);
        Conv.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        Conv.setLineWrap(true);
        Conv.setRows(5);
        Conv.setWrapStyleWord(true);
        Conv.setBorder(null);
        DefaultCaret caret = (DefaultCaret)Conv.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        jScrollPane2.setViewportView(Conv);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(200, 90, 380, 420);

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        connected.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        connected.setForeground(new java.awt.Color(6, 52, 114));
        connected.setSelectionBackground(new java.awt.Color(139, 163, 189));
        jScrollPane3.setViewportView(connected);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(20, 370, 150, 140);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/M2SChat/Photos/ServerConvoNew.PNG"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 600, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - this.xMouse, y - this.yMouse);
    }//GEN-LAST:event_jLabel2MouseDragged

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        this.xMouse = evt.getX();
        this.yMouse = evt.getY();
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        ServerMethodes.close();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void ConvosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ConvosValueChanged
        this.ConvBetween.setText((String) this.Convos.getSelectedValue());
        try {
            ServerInterface.SBT.startMoving();
        } catch (InterruptedException ex) {
            Logger.getLogger(ServerInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ConvosValueChanged

    public static void main(String args[]) {

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    static javax.swing.JTextArea Conv;
    private javax.swing.JLabel ConvBetween;
    static javax.swing.JList Convos;
    public javax.swing.JList connected;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        try{
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Photos/LOGO.png")));
        }
        catch(Exception e)
        {
            
        }
    }
}
