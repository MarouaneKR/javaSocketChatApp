/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M2SChat;


public class SignUP extends javax.swing.JFrame {
    
    private int xMouse;
    private int yMouse;
    
    public SignUP() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        signUpGo = new javax.swing.JButton();
        wrong = new javax.swing.JLabel();
        IP = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        confirmPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        wrongP = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pWrong = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 530));
        setMinimumSize(new java.awt.Dimension(600, 530));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(600, 530));
        setResizable(false);
        getContentPane().setLayout(null);

        signUpGo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/M2SChat/Photos/SignUpButton.png"))); // NOI18N
        signUpGo.setBorder(null);
        signUpGo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signUpGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpGoActionPerformed(evt);
            }
        });
        getContentPane().add(signUpGo);
        signUpGo.setBounds(230, 475, 150, 30);

        wrong.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        wrong.setForeground(new java.awt.Color(231, 0, 0));
        wrong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(wrong);
        wrong.setBounds(190, 450, 220, 0);

        IP.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        IP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IP.setText("192.168.1.1");
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
        IP.setBounds(180, 190, 240, 30);

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
        username.setBounds(180, 263, 250, 30);

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
        password.setBounds(180, 336, 250, 30);

        confirmPassword.setFont(new java.awt.Font("Arial", 3, 30)); // NOI18N
        confirmPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        confirmPassword.setBorder(null);
        confirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPasswordActionPerformed(evt);
            }
        });
        confirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confirmPasswordKeyPressed(evt);
            }
        });
        getContentPane().add(confirmPassword);
        confirmPassword.setBounds(180, 408, 250, 30);

        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(570, 0, 30, 30);

        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(535, 0, 30, 30);

        wrongP.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        wrongP.setForeground(new java.awt.Color(255, 0, 0));
        wrongP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(wrongP);
        wrongP.setBounds(120, 445, 370, 20);

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

        pWrong.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        pWrong.setForeground(new java.awt.Color(169, 5, 21));
        pWrong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(pWrong);
        pWrong.setBounds(190, 450, 230, 0);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/M2SChat/Photos/SignUP.PNG"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 600, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signUpGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpGoActionPerformed
        ClientMethodes.ConnectClientToServer(this.IP.getText(),this.wrongP);
        char[] p1 = this.password.getPassword();
        char[] p2 = this.confirmPassword.getPassword();
        String Password = "", confirmP = "";
        for (int i = 0; i < p1.length; ++i) {
            Password += p1[i];
        }
        for (int j = 0; j < p2.length; ++j) {
            confirmP += p2[j];
        }
        ClientMethodes.signUpNewClient(this.username.getText(),Password,confirmP);
        
    }//GEN-LAST:event_signUpGoActionPerformed

    private void IPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IPActionPerformed

    }//GEN-LAST:event_IPActionPerformed

    private void IPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IPKeyPressed
        ClientMethodes.pressedKey(evt.getKeyCode(),signUpGo);
    }//GEN-LAST:event_IPKeyPressed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed

    }//GEN-LAST:event_usernameActionPerformed

    private void usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyPressed
        ClientMethodes.pressedKey(evt.getKeyCode(),signUpGo);
    }//GEN-LAST:event_usernameKeyPressed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed

    }//GEN-LAST:event_passwordActionPerformed

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        ClientMethodes.pressedKey(evt.getKeyCode(),signUpGo);
    }//GEN-LAST:event_passwordKeyPressed

    private void confirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPasswordActionPerformed

    }//GEN-LAST:event_confirmPasswordActionPerformed

    private void confirmPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmPasswordKeyPressed
        ClientMethodes.pressedKey(evt.getKeyCode(),signUpGo);
    }//GEN-LAST:event_confirmPasswordKeyPressed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - this.xMouse, y - this.yMouse);
    }//GEN-LAST:event_jLabel2MouseDragged

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        ClientMethodes.close();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabel4MouseClicked

    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    static javax.swing.JTextField IP;
    static javax.swing.JPasswordField confirmPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    static javax.swing.JLabel pWrong;
    static javax.swing.JPasswordField password;
    private javax.swing.JButton signUpGo;
    static javax.swing.JTextField username;
    static javax.swing.JLabel wrong;
    static javax.swing.JLabel wrongP;
    // End of variables declaration//GEN-END:variables
}
