/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view;

import client.controller.Client;
import client.controller.Command;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author hoang
 */
public class LoginUI extends javax.swing.JFrame {

    /**
     * Creates new form LoginUI
     */
    public LoginUI() {
        initComponents();
        client = Client.getClient(this, "localhost", 8188);
        if (client.connection()) {
            Client.connectionStatus = true;
        } else {
            JOptionPane.showConfirmDialog(this, "Connection fail");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        jButtonRegister = new javax.swing.JButton();
        jTextUserName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelWarning = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextPassword.setBackground(new java.awt.Color(51, 51, 51));
        jTextPassword.setForeground(new java.awt.Color(255, 255, 255));
        jTextPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextPassword.setBorder(null);
        jTextPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextPasswordKeyPressed(evt);
            }
        });
        getContentPane().add(jTextPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 190, 30));

        jLabel6.setFont(new java.awt.Font("DialogInput", 2, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("If you don't hava account, click register ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 310, -1));

        jButtonLogin.setBackground(new java.awt.Color(0, 153, 153));
        jButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogin.setText("Login");
        jButtonLogin.setBorder(null);
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 90, 30));

        jButtonRegister.setBackground(new java.awt.Color(0, 153, 153));
        jButtonRegister.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegister.setText("Register");
        jButtonRegister.setBorder(null);
        jButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 80, 30));

        jTextUserName.setBackground(new java.awt.Color(51, 51, 51));
        jTextUserName.setForeground(new java.awt.Color(255, 255, 255));
        jTextUserName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextUserName.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jTextUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextUserNameActionPerformed(evt);
            }
        });
        getContentPane().add(jTextUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 190, 30));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("UserName");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CHAT ROOM");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, -1, 22));

        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Login to join our chat room");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 330, 50));
        getContentPane().add(jLabelWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/rocket-2680282_1280.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        login();
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jTextUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextUserNameActionPerformed

    private void jTextPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_jTextPasswordKeyPressed

    private void jButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegisterActionPerformed
        try {
            register();
        } catch (IOException ex) {
            Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonRegisterActionPerformed

    private void login() {
        if (Client.connectionStatus == false) {
            return;
        }
        if (jTextUserName.getText() != null && jTextPassword.getPassword() != null) {
            try {
                String user = jTextUserName.getText();
                String pass = new String(jTextPassword.getPassword());
                if (client.login(user, pass)) {
//                    main = new MainChatClientScreen(client, "General");
//                    main.setVisible(true);
//                    main.setTitle("Chat Room: " + client.getUserName());
                    RoomPicker roomPicker = new RoomPicker(client);
                    roomPicker.setVisible(true);
                    roomPicker.setTitle("RoomPicker");
                    roomPicker.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            JFrame frame = (JFrame) e.getSource();
                            int result = JOptionPane.showConfirmDialog(
                                    frame,
                                    "Are you sure you want to exit the application?",
                                    "Exit Application",
                                    JOptionPane.YES_NO_OPTION);
                            if (result == JOptionPane.YES_OPTION) {
                                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                client.sendMessage(Command.QUIT, "SYSTEM", "");
                                LoginUI.this.setVisible(true);
                            }
                        }

                    });
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Username or password incorect");
                }
            } catch (IOException ex) {
                Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUI().setVisible(true);
            }
        });
    }

    public MainChatClientScreen getMain() {
        return main;
    }

    private Client client;
    private MainChatClientScreen main;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelWarning;
    private javax.swing.JPasswordField jTextPassword;
    private javax.swing.JTextField jTextUserName;
    // End of variables declaration//GEN-END:variables

    private void register() throws IOException, ClassNotFoundException {
        if (Client.connectionStatus == false) {
            return;
        }
        System.out.println("Start register");
        String user = jTextUserName.getText();
        String pass = new String(jTextPassword.getPassword());
        if (!user.isEmpty() && !pass.isEmpty()) {
            System.out.println("register");
            client.register(user, pass);
        }
    }
}
