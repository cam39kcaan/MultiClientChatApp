/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view;

import client.controller.Client;
import client.controller.Command;
import client.model.Message;
import client.listener.MessageListener;
import client.listener.OnGetFileListener;
import client.listener.OnGetHistoryListener;
import client.listener.OnLeaveRoomListener;
import client.listener.OnShowRoomPickerListener;
import client.listener.UserStatusListener;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import client.listener.RoomMemmberListener;
import client.model.FileInfo;
import java.io.IOException;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author hoang
 */
public class MainChatClientScreen extends javax.swing.JFrame implements
        MessageListener, UserStatusListener, RoomMemmberListener, OnLeaveRoomListener, OnGetHistoryListener, OnGetFileListener {

    private Client client;
    private String roomName;
    private DefaultListModel listUserInRoom;
    private List<String> usersInRoom;
    private OnShowRoomPickerListener onShowRoomPickerListener;
    private List<FileInfo> files;

    public MainChatClientScreen(Client client, String roomName) {
        initComponents();
        this.client = client;
        this.roomName = roomName;
        files = new ArrayList<>();
        jLabelRoomName.setText(roomName);
        listUserInRoom = new DefaultListModel();
        usersInRoom = new ArrayList<>();
        jList1.setModel(listUserInRoom);
        jTextPane1.setEditable(false);
        client.addMessageListener(this);
        client.addUserStatusListener(this);
        client.sendMessage(Command.ROOM_MEMMBER, roomName, "");
        client.addRoomMemmberCallback(this);
        client.addOnLeaveRoomListener(this);
        client.addOnGetHistoryListener(this);
        client.addOnGetFileListener(this);
        client.getChatHistory(roomName);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextChat = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelRoomName = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        background = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 110, 30));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("File Box");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/download24px.png"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 30, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/Folder.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 30, 30));

        jTextChat.setOpaque(false);
        jTextChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextChatActionPerformed(evt);
            }
        });
        jTextChat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextChatKeyPressed(evt);
            }
        });
        getContentPane().add(jTextChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 430, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Chat here:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Room:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabelRoomName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelRoomName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRoomName.setText("RoomName");
        getContentPane().add(jLabelRoomName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jList1.setBorder(javax.swing.BorderFactory.createTitledBorder("Members"));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 130, 240));

        jTextPane1.setEditable(false);
        jTextPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jScrollPane3.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 10, 430, 280));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/room_backroudn_dark.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 610, 430));

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));

        jMenu2.setText("Account");

        jMenuItem2.setText("Quit/Logoff");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Room");

        jMenuItem3.setText("Join Room");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Create Room");
        jMenu3.add(jMenuItem4);

        jMenuItem1.setText("Leave Room");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextChatActionPerformed

    }//GEN-LAST:event_jTextChatActionPerformed

    private void jTextChatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextChatKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String msg = jTextChat.getText();
            client.sendMessage(Command.SEND, roomName, msg);
            jTextChat.setText("");
            inputMessage("You: " + msg, Color.BLACK);
        }
    }//GEN-LAST:event_jTextChatKeyPressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        client.sendMessage(Command.QUIT, roomName, "");
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (onShowRoomPickerListener != null) {
            onShowRoomPickerListener.onShowRoomPikcer();
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Choose a directory to save your file: ");
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isFile()) {
                System.out.println("You selected the directory: " + jfc.getSelectedFile());
                client.sendFile(jfc.getSelectedFile().getAbsolutePath(), roomName);
            }
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Choose a directory to save your file: ");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isDirectory()) {
                System.out.println("You selected the directory: " + jfc.getSelectedFile());
                String fileName = (String) jComboBox1.getSelectedItem();
                for (FileInfo file : files) {
                    if (file.getFilename().equals(fileName)) {
                        file.setDestinationDirectory(jfc.getSelectedFile().getAbsolutePath());
                        client.createFile(file);
                    }
                }
            }
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            client.leaveRoom(roomName);
            MainChatClientScreen.this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(MainChatClientScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public void setOnShowRoomPickerListener(OnShowRoomPickerListener onShowRoomPickerListener) {
        this.onShowRoomPickerListener = onShowRoomPickerListener;
    }

    public void showMessageReceive(Message message) throws BadLocationException {
        String receiver = message.getReceiver();
        if (!receiver.equals(roomName)) {
            return;
        }
        String msg = message.getFrom() + " : " + message.getBody();
        SimpleAttributeSet sas = new SimpleAttributeSet(jTextPane1.getCharacterAttributes());

        if (null != message.getCmd()) {
            switch (message.getCmd()) {
                //Checking if your output contains Exception...
                case LOGON:
                    StyleConstants.setForeground(sas, Color.red); //Changing the color of             
                    jTextPane1.getDocument().insertString(
                            jTextPane1.getDocument().getLength(),
                            msg,
                            sas
                    );
                    break;
                case LOGOFF:
                    StyleConstants.setForeground(sas, Color.DARK_GRAY); //Changing the color of             
                    jTextPane1.getDocument().insertString(
                            jTextPane1.getDocument().getLength(),
                            msg + "has offline \n",
                            sas
                    );
                    break;
                case SEND:
                    StyleConstants.setForeground(sas, Color.BLUE); //Changing the color of   
                    jTextPane1.getDocument().insertString(
                            jTextPane1.getDocument().getLength(),
                            msg + "\n",
                            sas
                    );
                    break;
                default:
                    break;
            }
        }

    }

    public void inputMessage(String msg, Color color) {
        SimpleAttributeSet sas = new SimpleAttributeSet(jTextPane1.getCharacterAttributes());
        StyleConstants.setForeground(sas, color); //Changing the color of             
        try {
            jTextPane1.getDocument().insertString(
                    jTextPane1.getDocument().getLength(),
                    msg + "\n",
                    sas
            );
        } catch (BadLocationException ble) {
            System.out.println("Error on append text to text input");
        }

    }

    @Override
    public void onMessageListener(Message message) {
        try {
            showMessageReceive(message);
        } catch (BadLocationException ex) {
            Logger.getLogger(MainChatClientScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onUserLogOn(Message msg) {
        System.out.println("Get logon mess " + this.roomName + " from " + this.getName());
        if (!msg.getReceiver().equals(roomName)) {
            return;
        }
        String logOnUser = msg.getFrom();
        listUserInRoom.addElement(logOnUser);
        usersInRoom.add(logOnUser);
        try {
            showMessageReceive(msg);
        } catch (BadLocationException ex) {
            Logger.getLogger(MainChatClientScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onUserLogOff(Message msg) {
        System.out.println("Geted offlien callback " + msg.getFrom());
        for (String user : usersInRoom) {
            if (user.equals(msg.getFrom())) {
                try {
                    usersInRoom.remove(user);
                    listUserInRoom.removeElement(user);
                    showMessageReceive(msg);
                    break;
                } catch (BadLocationException ex) {
                    Logger.getLogger(MainChatClientScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    @Override
    public void onRoomMemmberOnline(Message message) {
        if (!message.getReceiver().equals(roomName)) {
            return;
        }
        String line = (String) message.getBody();
        System.out.println(line);
        String[] member = line.split(" ");
        System.out.println(member.length + " ");
        for (int i = 0; i < member.length - 1; i++) {
            System.out.println(member[i]);
            if (!member[i].equals(client.getUserName())) {
                listUserInRoom.addElement(member[i]);
                usersInRoom.add(member[i]);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelRoomName;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextChat;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onLeaveRoom(Message message) {
        String receiver = message.getReceiver();
        System.out.println("OnLeaveRoom");
        String user = message.getFrom();
        if (receiver.equals(roomName)) {
            String status = user + " leave the chat room";
            System.out.println(status);
            Iterator<String> iterator = usersInRoom.iterator();
            while (iterator.hasNext()) {
                String userName = iterator.next();
                if (userName.equals(user)) {
                    iterator.remove();
                    listUserInRoom.removeElement(userName);
                    inputMessage(status, Color.DARK_GRAY);
                }
            }
        }
    }

    @Override
    public void onGetMessageHistorys(List<String> historys) {
        inputMessage("Chat history: ", Color.BLUE);
        for (String item : historys) {
            if (item.startsWith(client.getUserName())) {
                String[] chatContent = item.split(" ", 2);
                item = "You " + chatContent[1];
                inputMessage(item, Color.BLUE);
            } else {
                inputMessage(item, Color.BLUE);
            }
        }
        inputMessage("--------------------------------------------", Color.BLUE);
    }

    @Override
    public void onGetFile(FileInfo file,String from) {
        System.out.println("Got a file "+ file.getFilename());
        if(from.equals(client.getUserName())){
            inputMessage("Send file successfully!!!", Color.red);
        }else {
            inputMessage("You got a file : " + file.getFilename() + " from "+ from, Color.red);
        }
        files.add(file);
        jComboBox1.addItem(file.getFilename());
        jComboBox1.setSelectedItem(file.getFilename());
    }

}
