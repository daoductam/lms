/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package My_Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @user tamda
 */
public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String userType; // admin hoặc user thường

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    

    public User() {
    }

    public User(int id, String name, String username, String password, String userType) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    //funtions
    
     My_Classes.Func_Class func = new Func_Class();
        
     
     //Tạo phương thức để check nếu username đã tồn tại
    public boolean checkUsernameExists(int id, String username) {
        ResultSet rs  = func.getData("SELECT * FROM users_table WHERE username = '"+username + "' AND id <> " +id);
        boolean exists = false;
            
        try {
            if(rs.next()) {
                exists = true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exists;
    }
    
    // insert a new user
    public void addUser(String name, String username, String password, String userType) {
        String insertQuery = "INSERT INTO users_table(name, username, password, user_type) VALUES (?, ?, ?, ? )";
        
      
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, userType);
            
            if(ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Đã Thêm User", "add user",1);
            } else {
                JOptionPane.showMessageDialog(null, "Không thêm được User", "add user",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    // Chỉnh sưa user bởi id
    public void editUser(int id, String name, String username, String password, String userType) {
        String editQuery = "UPDATE users_table SET name = ?, username = ?, password = ?, user_type = ?  WHERE id = ?";
        
      
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(editQuery);
            
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, userType);
            ps.setInt(5, id);
            
            
            if(ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "User đã được chỉnh sửa", "edit user",1);
            } else {
                JOptionPane.showMessageDialog(null, "User chưa được chỉnh sửa", "edit user",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    
    // Xóa tác giả bởi id
    public void removeUser(int id) {
        String removeQuery = "DELETE FROM users_table WHERE id = ?";
 
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
            
            ps.setInt(1, id);
            
            
            if(ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "User đã được xóa", "Xóa",1);
            } else {
                JOptionPane.showMessageDialog(null, "User chưa được xóa", "Xóa",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //phương thức lấy ra danh sách user
    public ArrayList<User> usersList() {
        
        ArrayList<User> uList = new ArrayList<>();
        
       
        try {
            ResultSet rs  = func.getData("SELECT * FROM users_table");
            User user;
            
            while(rs.next()) {
                user = new User(rs.getInt("id"),rs.getString("name"), rs.getString("username"), rs.getString("password"),rs.getString("user_type"));
                uList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return uList;
    }
    
    
}
