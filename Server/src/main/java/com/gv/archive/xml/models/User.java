package com.gv.archive.xml.models;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * specifies properties of user in authentication system
 */
@XStreamAlias("user")
public class User {

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
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                '}';
    }
}
