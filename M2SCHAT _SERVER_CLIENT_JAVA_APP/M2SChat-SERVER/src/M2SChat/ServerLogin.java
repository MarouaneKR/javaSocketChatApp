package M2SChat;

import java.awt.Toolkit;

public class ServerLogin extends javax.swing.JFrame {

    private int xMouse;
    private int yMouse;
    
    public ServerLogin() {
        initComponents();
        setIcon();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login = new javax.swing.JButton();
        wrong = new javax.swing.JLabel();
        wrongp = new javax.swing.JLabel();
        IP = new javax.swing.JTextField();
        reduce = new javax.swing.JLabel();
        Close = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("M2SChat!");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(600, 520));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        Login.setBackground(new java.awt.Color(204, 204, 204));
        Login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/M2SChat/Photos/button2.png"))); // NOI18N
        Login.setText("Login");
        Login.setToolTipText("");
        Login.setBorder(null);
        Login.setBorderPainted(false);
        Login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Login.setDefaultCapable(false);
        Login.setMaximumSize(new java.awt.Dimension(200, 50));
        Login.setMinimumSize(new java.awt.Dimension(200, 50));
        Login.setPreferredSize(new java.awt.Dimension(200, 45));
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        getContentPane().add(Login);
        Login.setBounds(240, 380, 130, 30);

        wrong.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        wrong.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(wrong);
        wrong.setBounds(190, 350, 230, 0);

        wrongp.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        wrongp.setForeground(new java.awt.Color(255, 0, 0));
        wrongp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(wrongp);
        wrongp.setBounds(190, 350, 230, 20);

        IP.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        IP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IP.setText("127.0.0.1");
        IP.setToolTipText("");
        IP.setBorder(null);
        IP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IPActionPerformed(evt);
            }
        });
        IP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IPKeyPressed(evt);
            }
        });
        getContentPane().add(IP);
        IP.setBounds(180, 313, 240, 30);

        reduce.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reduce.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reduceMouseClicked(evt);
            }
        });
        getContentPane().add(reduce);
        reduce.setBounds(535, 0, 30, 30);

        Close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseMouseClicked(evt);
            }
        });
        getContentPane().add(Close);
        Close.setBounds(570, 0, 30, 30);

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 600, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/M2SChat/Photos/ServerLogin.PNG"))); // NOI18N
        jLabel2.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 600, 530);
        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(440, 20, 2, 2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        ServerMethodes.connectServer(this.IP.getText());
    }//GEN-LAST:event_LoginActionPerformed

    private void IPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IPActionPerformed

    }//GEN-LAST:event_IPActionPerformed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - this.xMouse, y - this.yMouse);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseClicked
        ServerMethodes.close();
    }//GEN-LAST:event_CloseMouseClicked

    private void reduceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reduceMouseClicked
        ServerMethodes.reduceLogin();
    }//GEN-LAST:event_reduceMouseClicked

    private void IPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IPKeyPressed
        ServerMethodes.pressedKey(evt.getKeyCode());
    }//GEN-LAST:event_IPKeyPressed

    public static void main(String args[]) {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Close;
    public javax.swing.JTextField IP;
    public javax.swing.JButton Login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel reduce;
    private javax.swing.JLabel wrong;
    public javax.swing.JLabel wrongp;
    // End of variables declaration//GEN-END:variables

    public void setIcon() {
        try{
        //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("src\\M2SChat\\Photos\\LOGO.png")));
        
        //setIcon(new javax.swing.ImageIcon(getClass().getResource("/M2SChat/Photos/NotifLogo.png")))
        }
        catch(Exception e)
        {
            
        }
    }

}
