/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model;

import client.controller.Command;
import client.model.FileInfo;
import client.model.Message;
import java.io.IOException;
import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.List;
import server.controller.ServerWorker;

/**
 *
 * @author hoang
 */
public class Room {

    private String name;
    private String password;
    private RoomStatus status;
    private List<String> chatsHistory;
    private ArrayList<ServerWorker> workers;

    public Room(String name, RoomStatus roomStatus) {
        this.name = name;
        this.status = roomStatus;
        workers = new ArrayList<>();
        chatsHistory = new ArrayList<>();
    }

    public void addWorkerMember(ServerWorker member) {
        for (ServerWorker worker : workers) {
            if (worker.getAcount().getUserName().equals(member.getAcount().getUserName())) {
                return;
            }
        }
        workers.add(member);
        System.out.println("Online in room " + name + " " + workers.size());
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<ServerWorker> getWorkers() {
        return workers;
    }

    public List<String> getChatsHistory() {
        return chatsHistory;
    }

    public void setChatsHistory(List<String> chatsHistory) {
        this.chatsHistory = chatsHistory;
    }

    public void sendMessageToRoomate(Command command, String from, String msg) throws IOException {
        String messageContent = from + " :" + msg;
        if (command == Command.SEND) {
            this.chatsHistory.add(messageContent);
        }
        for (ServerWorker worker : workers) {
            if (!worker.getAcount().getUserName().equals(from)) {
                Message<String> message = new Message(command, msg, from, this.getName());
                worker.send(message);
            }
        }
    }

    public void sendFileToRoom(FileInfo file, String from) throws IOException {
        for (ServerWorker worker : workers) {
            Message<FileInfo> message = new Message(Command.FILE, file, from, this.getName());
            worker.send(message);
        }

    }
    
    public void setStatusRinging(String from) throws IOException {
        for (ServerWorker worker: workers) {
            if (!worker.getAcount().getUserName().equals(from)) {
                Message<String> message = new Message(Command.VOICECALL, "", from, this.getName());
                worker.send(message);
            }
        }
    }
    
    public ServerWorker getWorkerByName(String userName){
        for(ServerWorker worker : workers){
            if(worker.getAcount().getUserName().equals(userName)){
                return worker;
            }
        }
        return null;
    }

    public void sendVoiceToRoom(DatagramPacket dp, String from) throws IOException {
        for (ServerWorker worker: workers) {
            if (!worker.getAcount().getUserName().equals(from)) {
                worker.sendDatagram(dp);
            }
        }
    }
}
