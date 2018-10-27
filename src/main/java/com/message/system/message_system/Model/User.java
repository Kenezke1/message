package com.message.system.message_system.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User extends AbstractDomain{
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String image;

    @Enumerated(EnumType.STRING)
    private Status status;

    public User() {
    }

    public User(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.status = builder.status;
        this.image = builder.image;
    }

    public static Builder builder(){
        return new Builder();
    }

    //Getters


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getImage() {
        return image;
    }

    public Status getStatus() {
        return status;
    }

    //Setters


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    //Methods

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", image='" + image + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(image, user.image) &&
                status == user.status;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), firstName, lastName, email, image, status);
    }

    public final static class Builder {
        private Integer id;
        private String firstName;
        private String lastName;
        private String email;
        private String image;
        private Status status;

        public Builder() {
        }

        public Builder id(Integer id){
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder image(String image){
            this.image = image;
            return this;
        }

        public Builder status(String status){
            this.status = Status.valueOf(status);
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
