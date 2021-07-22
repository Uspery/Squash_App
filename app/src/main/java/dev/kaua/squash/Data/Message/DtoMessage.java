package dev.kaua.squash.Data.Message;

import java.util.List;

public class DtoMessage {


    public static int SEND = 1;
    public static int  RECEIVED = 2;
    private String sender;
    private String id_msg;
    private String receiver;
    private String message;
    private String time;
    private List<String> media;
    private String reply_from;
    private String reply_content;
    private int isSeen;

    public DtoMessage(String sender, String receiver, String message, int isSeen, String time, String reply_from, String reply_content, List<String> media) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.isSeen = isSeen;
        this.time = time;
        this.reply_from = reply_from;
        this.reply_content = reply_content;
        this.media = media;
        this.id_msg = id_msg;
    }

    public DtoMessage(String body, long time, int type) {
    }

    public String getId_msg() {
        return id_msg;
    }

    public void setId_msg(String id_msg) {
        this.id_msg = id_msg;
    }

    public List<String> getMedia() {
        return media;
    }

    public void setMedia(List<String> media) {
        this.media = media;
    }

    public String getReply_from() {
        return reply_from;
    }

    public void setReply_from(String reply_from) {
        this.reply_from = reply_from;
    }

    public String getReply_content() {
        return reply_content;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    public DtoMessage(){}

    public int getIsSeen() {
        return isSeen;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setIsSeen(int isSeen) {
        this.isSeen = isSeen;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}