package M2SChat;

public class FriendRequest extends javax.swing.JFrame {
    
    private int xMouse;
    private int yMouse;
    
    public FriendRequest() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        requestList = new javax.swing.JList();
        Accept = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        decline = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(180, 440));
        setMinimumSize(new java.awt.Dimension(180, 440));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        requestList.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        requestList.setForeground(new java.awt.Color(6, 52, 114));
        requestList.setSelectionBackground(new java.awt.Color(139, 163, 189));
        jScrollPane1.setViewportView(requestList);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(16, 90, 150, 220);

        Accept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/M2SChat/Photos/Accept.png"))); // NOI18N
        Accept.setBorder(null);
        Accept.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Accept.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceptActionPerformed(evt);
            }
        });
        getContentPane().add(Accept);
        Accept.setBounds(22, 331, 140, 40);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 0, 30, 30);

        decline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/M2SChat/Photos/decline.png"))); // NOI18N
        decline.setBorder(null);
        decline.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        decline.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        decline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declineActionPerformed(evt);
            }
        });
        getContentPane().add(decline);
        decline.setBounds(20, 385, 140, 40);

        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });
        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel3MouseDragged(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 180, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/M2SChat/Photos/request.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 180, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        this.xMouse = evt.getX();
        this.yMouse = evt.getY();
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - this.xMouse, y - this.yMouse);
    }//GEN-LAST:event_jLabel3MouseDragged

    private void AcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptActionPerformed
        if(!requestList.isSelectionEmpty())
        ClientMethodes.accept((String) requestList.getSelectedValue());
    }//GEN-LAST:event_AcceptActionPerformed

    private void declineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_declineActionPerformed
        if(!requestList.isSelectionEmpty())
        ClientMethodes.decline((String) requestList.getSelectedValue());
    }//GEN-LAST:event_declineActionPerformed

    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Accept;
    private javax.swing.JButton decline;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    static javax.swing.JList requestList;
    // End of variables declaration//GEN-END:variables
}
