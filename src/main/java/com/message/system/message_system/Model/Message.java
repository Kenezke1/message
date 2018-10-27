package com.message.system.message_system.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Message extends AbstractDomain {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "conversation_id")
    private Conversation conversation;

    private String content;

    private Long time;

    private Boolean isEdited = false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sender")
    private User sender;


    public Message() {
    }

    public Message(Builder builder){
        this.conversation = builder.converstaion;
        this.content = builder.content;
        this.sender = builder.sender;
        this. time = new Date().getTime();
    }

    public static Builder builder(){
        return new Builder();
    }

    // Getters


    public Conversation getConversation() {
        return conversation;
    }

    public String getContent() {
        return content;
    }

    public Long getTime() {
        return time;
    }

    public Boolean isEdited() {
        return isEdited;
    }

    public User getSender() {
        return sender;
    }

    //Setter


    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public void setEdited(Boolean edited) {
        isEdited = edited;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    //Methods


    @Override
    public String toString() {
        return "Message{" +
                "conversation=" + conversation.toString() +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", sender=" + sender.toString() +
                '}';
    }

    public final static class Builder {
        private Integer id;
        private Conversation converstaion;
        private String content;
        private User sender;

        public Builder(){}

        public Builder id(Integer id){
            this.id = id;
            return this;
        }

        public Builder conversation(Conversation conversation){
            this.converstaion = conversation;
            return this;
        }

        public Builder content(String content){
            this.content = content;
            return this;
        }

        public Builder sender(User sender){
            this.sender = sender;
            return this;
        }

        public Message build(){
            return new Message(this);
        }
    }
}
