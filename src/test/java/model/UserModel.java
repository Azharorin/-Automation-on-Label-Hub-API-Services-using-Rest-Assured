package model;

import groovy.lang.GString;

public class UserModel {
    public String username;
    public String password;
    public UserModel(String username,String password){
        this.password=password;
        this.username=username;

    }

}
