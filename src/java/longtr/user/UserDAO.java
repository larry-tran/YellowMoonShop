/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longtr.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import longtr.utils.DBHelper;

/**
 *
 * @author Admin
 */
public class UserDAO {
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    
    public UserDTO checkLogin(String userID, String password) throws SQLException, NamingException{
        UserDTO dto = null;
        try {
            con = DBHelper.getConnection();
            if(con!=null){
                String sql = "SELECT userID, password, name, status, role FROM User WHERE userID = ? AND password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if(rs.next()){
                    userID = rs.getString("userID");
                    password = rs.getString("password");
                    String name = rs.getString("name");
                    String status = rs.getString("status");
                    String role = rs.getString("role");
                    dto = new UserDTO(userID, password, name, role, status);
                    return dto;
                }
            }
        } finally {
            if(rs!=null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return dto;
    }
    
    public boolean checkExist(String userID) throws NamingException, SQLException{
        boolean check = false;
        try {
            con = DBHelper.getConnection();
            if(con!=null){
                String sql = "SELECT userID FROM User WHERE userID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, userID);
                rs = stm.executeQuery();
                if(rs.next()){
                    check = true;
                }
            }
        } finally{
            if(rs!=null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return check;
    }
}
