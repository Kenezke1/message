package com.message.system.message_system.Model;

import javax.persistence.*;

@Entity
@Table(name = "conversations")
public class Conversation extends AbstractDomain {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "participant_1")
    private User participant1;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "participant_2")
    private User participant2;

    public Conversation() {
    }

    public Conversation(Builder builder){
        this.participant1 = builder.participant1;
        this.participant2 = builder.participant2;
    }

    public static Builder builder(){
        return new Builder();
    }

    //Getters


    public User getParticipant1() {
        return participant1;
    }

    public User getParticipant2() {
        return participant2;
    }

    //Setters


    public void setParticipant1(User participant1) {
        this.participant1 = participant1;
    }

    public void setParticipant2(User participant2) {
        this.participant2 = participant2;
    }

    //Methods

    @Override
    public String toString() {
        return "Conversation{" +
                "participant1=" + participant1.toString() +
                ", participant2=" + participant2.toString() +
                '}';
    }

    public final static class Builder {
        private Integer id;
        private User participant1;
        private User participant2;

        public Builder() {
        }

        public Builder id(Integer id){
            this.id = id;
            return this;
        }

        public Builder participant1(User participant1){
            this.participant1 = participant1;
            return this;
        }

        public Builder participant2(User participant2){
            this.participant2 = participant2;
            return this;
        }

        public Conversation build(){
            return new Conversation(this);
        }
    }
}
