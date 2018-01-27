package com.cristhian.apisymfony.Models;

/**
 * Created by Cristhian on 20-12-2017.
 */

public class User {

    private int id;
    private String role;
    private String name;
    private String surname;
    private String email;
    private String password;
    private int iat;
    private int exp;

    private String getHash;

    public User(){}

    public User(int id, String role, String name, String surname, String email, String password) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public User(int id, String email, String name, String surname, int iat, int exp) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.iat = iat;
        this.exp = exp;
    }

    public User(int id) {
        this.id = id;
    }

    public User(String email, String password, String getHash){
        this.email = email;
        this.password = password;
        this.getHash = getHash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIat() {
        return iat;
    }

    public void setIat(int iat) {
        this.iat = iat;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
