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
public class UserErrorDTO implements Serializable{
    private String errID;
    private String errPassword;
    private String errName;
    private String errCode;
    private String errConfirm;

    public UserErrorDTO() {
    }

    public String getErrID() {
        return errID;
    }

    public void setErrID(String errID) {
        this.errID = errID;
    }

    public String getErrPassword() {
        return errPassword;
    }

    public void setErrPassword(String errPassword) {
        this.errPassword = errPassword;
    }

    public String getErrName() {
        return errName;
    }

    public void setErrName(String errName) {
        this.errName = errName;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrConfirm() {
        return errConfirm;
    }

    public void setErrConfirm(String errConfirm) {
        this.errConfirm = errConfirm;
    }
    
    
}
