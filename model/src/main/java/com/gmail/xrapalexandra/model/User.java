package com.gmail.xrapalexandra.model;

import java.util.Objects;

public class User {

    private String pass;
    private Role role;
    private String login;

    public User() {
    }

    public User(String login, Role role, String pass) {
        this.pass = pass;
        this.role = role;
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return pass.equals(user.pass) &&
                role == user.role &&
                login.equals(user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pass, role, login);
    }

    @Override
    public String toString() {
        return "User{" +
                "pass='" + pass + '\'' +
                ", role=" + role +
                ", login='" + login + '\'' +
                '}';
    }
}
