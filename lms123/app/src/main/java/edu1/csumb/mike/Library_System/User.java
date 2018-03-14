package edu1.csumb.mike.Library_System;

/**
 * Title: AddBook.java
 * Abstract: This is the class for the User class. Users make rentals and are created at the CreateClass.java activity.
 * Author: Michael Royal
 * Date: 12/9/16
 */
public class User {
    private String password;
    private String username;
    private String name;
    private String email;

    private int id;

    public User(){

    }

    public User(User user){
        this.username = user.getUsername();
        this.id = user.getId();
    }

    public User(String name , String username, String email, String password){
        this.name=name;
        this.username=username;
        this.email=email;
        this.password=password;
    }
    public User(String password, String username){
        this.username=username;
        this.password=password;
    }

    public boolean check(){
        //get the credentials from the DB
        return true;
    }

    public String getPassword(){
        return password;
    }

    public String getUsername(){
        return username;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }


    public int getId(){
        return id;
    }

    public String toString(){
        return "user: " + username + "password: " + password;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setEmail(String email){
        this.email = email;
    }

}
