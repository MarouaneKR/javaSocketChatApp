package M2SChat;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    private int xMouse;
    private int yMouse;

    public Login() {
    
        initComponents();
        ClientMethodes.underline(this.signUp.getFont(),this.signUp);
        ClientMethodes.underline(this.forgotPassword.getFont(),this.forgotPassword);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        password = new javax.swing.JPasswordField();
        username = new javax.swing.JTextField();
        Login = new javax.swing.JButton();
        wrong = new javax.swing.JLabel();
        wrongp = new javax.swing.JLabel();
        IP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        forgotPassword = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        signUp = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("M2SChat!");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(600, 520));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        password.setFont(new java.awt.Font("Arial", 3, 30)); // NOI18N
        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password.setBorder(null);
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });
        getContentPane().add(password);
        password.setBounds(180, 330, 130, 30);

        username.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.setBorder(null);
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameKeyPressed(evt);
            }
        });
        getContentPane().add(username);
        username.setBounds(180, 255, 240, 30);

        Login.setBackground(new java.awt.Color(204, 204, 204));
        Login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/M2SChat/Photos/button2.png"))); // NOI18N
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
        Login.setBounds(240, 420, 130, 30);

        wrong.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        wrong.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(wrong);
        wrong.setBounds(190, 350, 230, 0);

        wrongp.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        wrongp.setForeground(new java.awt.Color(255, 0, 0));
        wrongp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(wrongp);
        wrongp.setBounds(190, 370, 230, 20);

        IP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        IP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IP.setText("192.168.1.1");
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
        IP.setBounds(335, 330, 97, 30);

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

        forgotPassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        forgotPassword.setForeground(new java.awt.Color(139, 163, 189));
        forgotPassword.setText("Forgot password?");
        forgotPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        forgotPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotPasswordMouseClicked(evt);
            }
        });
        getContentPane().add(forgotPassword);
        forgotPassword.setBounds(200, 388, 110, 20);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(139, 163, 189));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("|");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(320, 380, 10, 30);

        signUp.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        signUp.setForeground(new java.awt.Color(80, 100, 238));
        signUp.setText("SING UP");
        signUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signUpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signUpMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                signUpMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                signUpMouseReleased(evt);
            }
        });
        signUp.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                signUpMouseDragged(evt);
            }
        });
        signUp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                signUpFocusGained(evt);
            }
        });
        getContentPane().add(signUp);
        signUp.setBounds(340, 388, 60, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/M2SChat/Photos/backgroundd.PNG"))); // NOI18N
        jLabel2.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 600, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed

    }//GEN-LAST:event_passwordActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        
        ClientMethodes.ConnectClientToServer(this.IP.getText(),this.wrongp);
        char[] p = this.password.getPassword();
        String Password = "";
        for (int i = 0; i < p.length; ++i) {
            Password += p[i];
        }
        ClientMethodes.connectClient(this.username.getText(), Password);

    }//GEN-LAST:event_LoginActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed

    }//GEN-LAST:event_usernameActionPerformed

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

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

        ClientMethodes.close();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyPressed
        ClientMethodes.pressedKey(evt.getKeyCode(),Login);
    }//GEN-LAST:event_usernameKeyPressed

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        ClientMethodes.pressedKey(evt.getKeyCode(),Login);
    }//GEN-LAST:event_passwordKeyPressed

    private void IPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IPKeyPressed
        ClientMethodes.pressedKey(evt.getKeyCode(),Login);
    }//GEN-LAST:event_IPKeyPressed

    private void signUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpMouseClicked
        ClientMethodes.signUp();
    }//GEN-LAST:event_signUpMouseClicked

    private void signUpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpMousePressed
                this.signUp.setForeground(new Color(190,138,239));
    }//GEN-LAST:event_signUpMousePressed

    private void signUpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpMouseEntered

    }//GEN-LAST:event_signUpMouseEntered

    private void signUpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_signUpFocusGained

    }//GEN-LAST:event_signUpFocusGained

    private void signUpMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpMouseDragged

    }//GEN-LAST:event_signUpMouseDragged

    private void signUpMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpMouseReleased
        this.signUp.setForeground(new Color(80,100,238));
    }//GEN-LAST:event_signUpMouseReleased

    private void forgotPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPasswordMouseClicked
        JOptionPane.showMessageDialog(null, "You forget your password , We forget you ! ", "Forgot Password",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_forgotPasswordMouseClicked

    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    static javax.swing.JTextField IP;
    public javax.swing.JButton Login;
    private javax.swing.JLabel forgotPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    static javax.swing.JPasswordField password;
    private javax.swing.JLabel signUp;
    static javax.swing.JTextField username;
    private javax.swing.JLabel wrong;
    public javax.swing.JLabel wrongp;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Photos/LOGO.png")));
    }

}
