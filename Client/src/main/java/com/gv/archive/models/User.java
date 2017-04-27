package com.gv.archive.models;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * specifies properties of user in authentication system
 */
@XStreamAlias("user")
public class User implements Serializable {

    /**
     * property - login of user
     */
    @XStreamAlias("login")
    private String login = "";

    /**
     * property - name of user
     */
    @XStreamAlias("name")
    private String name = "";

    /**
     * property - role of user
     */
    @XStreamAlias("role")
    private Role role;

    /**
     * property - decrypted password of user
     */
    @XStreamAlias("password")
    private String password = "";

    public User() {
    }

    public User(String login, String name, Role role, String password) {
        this.login = login;
        this.name = name;
        this.role = role;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (role != user.role) return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                '}';
    }
}