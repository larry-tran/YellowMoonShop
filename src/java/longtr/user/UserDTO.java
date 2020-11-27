/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longtr.user;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class UserDTO implements Serializable{
    private String userID;
    private String password;
    private String name;
    private String role;
    private String status;

    public UserDTO() {
    }

    public UserDTO(String userID, String password, String name, String role, String status) {
        this.userID = userID;
        this.password = password;
        this.name = name;
        this.role = role;
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
