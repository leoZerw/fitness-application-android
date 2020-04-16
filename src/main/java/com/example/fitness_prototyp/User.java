package com.example.fitness_prototyp;

import org.parceler.Parcel;

@Parcel
public class User {

    String name;
    String email;
    String password;
    String teamCode;
    //TODO: Zusätzliche Attribute für google firebase connection


    public User() {}

    public User(String name, String email, String password, String teamCode) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.teamCode = teamCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTeamCode() {
        return teamCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", teamCode='" + teamCode + '\'' +
                '}';
    }
}
