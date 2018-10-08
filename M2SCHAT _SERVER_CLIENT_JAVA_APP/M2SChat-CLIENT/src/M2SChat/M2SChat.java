package M2SChat;

import java.awt.Font;
import java.awt.Toolkit;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultCaret;

public class M2SChat extends javax.swing.JFrame {

    public Font font;
    private int xMouse;
    private int yMouse;    
    public static Socket ClientSocket;
    
    public StartBlockThread SBT;

    public M2SChat() {
  
        initComponents();
        SBT = new StartBlockThread();
        new showConversation(SBT).start();
        ClientMethodes.fReq = new FriendRequest();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Message = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        send = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Conversation = new javax.swing.JTextArea();
        addFriend = new javax.swing.JButton();
        TalkingTo = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Friends = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        online = new javax.swing.JList();
        notify = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LoggedIn = new javax.swing.JLabel();
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

        Message.setFont(new java.awt.Font("Times New Roman", 0, 21)); // NOI18N
        Message.setBorder(null);
        Message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MessageActionPerformed(evt);
            }
        });
        Message.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MessageKeyPressed(evt);
            }
        });
        getContentPane().add(Message);
        Message.setBounds(20, 470, 470, 40);

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

        send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/M2SChat/Photos/sendButton.png"))); // NOI18N
        send.setAlignmentY(0.0F);
        send.setBorder(null);
        send.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });
        getContentPane().add(send);
        send.setBounds(510, 463, 74, 52);

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Conversation.setColumns(20);
        Conversation.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        Conversation.setLineWrap(true);
        Conversation.setRows(5);
        Conversation.setToolTipText("");
        Conversation.setWrapStyleWord(true);
        Conversation.setBorder(null);
        DefaultCaret caret = (DefaultCaret)Conversation.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        Conversation.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        Conversation.setHighlighter(null);
        Conversation.setInheritsPopupMenu(true);
        Conversation.setSelectionColor(new java.awt.Color(139, 163, 189));
        jScrollPane2.setViewportView(Conversation);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(200, 90, 380, 350);

        addFriend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/M2SChat/Photos/AddFriend.png"))); // NOI18N
        addFriend.setBorder(null);
        addFriend.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFriendActionPerformed(evt);
            }
        });
        getContentPane().add(addFriend);
        addFriend.setBounds(135, 255, 30, 30);

        TalkingTo.setFont(new java.awt.Font(ClientMethodes.setFont(this.font).getName(), 0, 24));
        TalkingTo.setForeground(new java.awt.Color(139, 163, 189));
        TalkingTo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(TalkingTo);
        TalkingTo.setBounds(202, 40, 370, 40);

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));

        Friends.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Friends.setForeground(new java.awt.Color(6, 52, 114));
        Friends.setToolTipText("");
        Friends.setSelectionBackground(new java.awt.Color(139, 163, 189));
        jScrollPane3.setViewportView(Friends);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(18, 297, 150, 150);

        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        online.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        online.setForeground(new java.awt.Color(6, 52, 114));
        online.setToolTipText("");
        online.setSelectionBackground(new java.awt.Color(139, 163, 189));
        online.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                onlineValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(online);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(18, 90, 150, 150);

        notify.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/M2SChat/Photos/NotifLogo.png"))); // NOI18N
        notify.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        notify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notifyMouseClicked(evt);
            }
        });
        getContentPane().add(notify);
        notify.setBounds(504, 0, 30, 30);

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

        LoggedIn.setFont(new java.awt.Font(ClientMethodes.setFont(this.font).getName(), 0, 24));
        LoggedIn.setForeground(new java.awt.Color(72, 103, 136));
        LoggedIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoggedIn.setToolTipText("");
        getContentPane().add(LoggedIn);
        LoggedIn.setBounds(230, 0, 180, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/M2SChat/Photos/ConvClient.PNG"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 600, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        if (!this.online.isSelectionEmpty()) {
            ClientMethodes.addMsgRecieved((String) this.online.getSelectedValue(),this.Message.getText(),ClientMethodes.Username);
            ClientMethodes.sendMsg(this.Message.getText(), this.online.getSelectedValue().toString());
        } else {
            JOptionPane.showMessageDialog(null, "Open a conversation first !", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_sendActionPerformed

    private void MessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MessageActionPerformed

    }//GEN-LAST:event_MessageActionPerformed

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
        ClientMethodes.disconnect();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void MessageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MessageKeyPressed
        if (evt.getKeyCode() == 10) {
            this.send.doClick();
        }
    }//GEN-LAST:event_MessageKeyPressed

    private void onlineValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_onlineValueChanged
            ClientMethodes.selectedFriend();      
    }//GEN-LAST:event_onlineValueChanged

    private void addFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFriendActionPerformed
        ClientMethodes.addFriend();
    }//GEN-LAST:event_addFriendActionPerformed

    private void notifyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notifyMouseClicked
        notify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/M2SChat/Photos/NotifLogo.png")));
        ClientMethodes.NotiRequest();
    }//GEN-LAST:event_notifyMouseClicked

    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    static javax.swing.JTextArea Conversation;
    static javax.swing.JList Friends;
    static javax.swing.JLabel LoggedIn;
    static javax.swing.JTextField Message;
    static javax.swing.JLabel TalkingTo;
    private javax.swing.JButton addFriend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    static javax.swing.JLabel notify;
    static javax.swing.JList online;
    private javax.swing.JButton send;
    // End of variables declaration//GEN-END:variables
}
