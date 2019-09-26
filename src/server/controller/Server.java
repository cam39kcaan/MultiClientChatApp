/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.controller;

import server.view.ServerMain;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoang
 */
public class Server extends Thread {

    public static final String SYSTEM = "SYSTEM";
    private final int serverPort;
    private AccountManager accountManager;
    private RoomAndAccountManager roomAndAccountManager;
    private RoomManager roomManager;

    public Server(int port) {
        this.serverPort = port;
        accountManager = AccountManager.getInstance();
        roomAndAccountManager = RoomAndAccountManager.getInstance();
        roomManager = RoomManager.getInstance();
    }

    public ArrayList<ServerWorker> getWorkers(String roomName) {
        if (roomName.equals("General")) {
            return roomManager.getRooms().get(0).getWorkers();
        }
        return roomManager.getRoomByName(roomName).getWorkers();
    }

    public void addWorker(ServerWorker worker, String roomName) {
        if (roomName.equals("General")) {
            roomManager.getRooms().get(0).addWorkerMember(worker);
        }
        else roomManager.getRoomByName(roomName).addWorkerMember(worker);
    }

    public void removeWorker(ServerWorker worker,String roomName) {
        ArrayList<ServerWorker> workers = getWorkers(roomName);
        for (ServerWorker w : workers) {
            if (w.getAcount().getUserName().equals(worker.getAcount().getUserName())) {
                workers.remove(w);
                break;
            }
        }
        System.out.println("remove after: " + workers.size());
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

    public RoomAndAccountManager getRoomAndAccountManager() {
        return roomAndAccountManager;
    }

    public RoomManager getRoomManager() {
        return roomManager;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            while (true) {
                System.out.println("About to accept client connection...");
                Socket clientsocket = serverSocket.accept();
                System.out.println("Accepted connection from" + clientsocket);
                ServerWorker serverWorker = new ServerWorker(this, clientsocket);
                serverWorker.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}