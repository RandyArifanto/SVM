package VendingMachine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AO756
 */
public class Admin {

    private String username;
    private String password;
    
    public Admin() {
        this.username = "admin";
        this.password = "amdin";
    }
    
    public boolean cekLogin(String username, String password) {
        return (username.equals(this.username) && password.equals(this.password));
    }    
}
