/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package My_Classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @genre tamda
 */
public class Genre {
    private int id;
    private String name;

    
    // constuctors
    public Genre() {
    }

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    
    //getter and setter
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
    
    //funtions
    
    My_Classes.Func_Class func = new Func_Class();  
    
    // insert a new genre
    public void addGenre(String name) {
        String insertQuery = "INSERT INTO book_genres(name) VALUES (?)";
        
      
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            
            ps.setString(1, name);
            
            if(ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Genre Added", "add genre",1);
            } else {
                JOptionPane.showMessageDialog(null, "Genre Not Added", "add genre",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    // Chỉnh sưa thể loại bởi id
    public void editGenre(int id, String name) {
        String editQuery = "UPDATE book_genres SET name = ? WHERE id = ?";
        
      
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(editQuery);
            
            ps.setString(1, name);
            ps.setInt(2, id);
            
            
            if(ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Thể loại đã được chỉnh sửa", "edit genre",1);
            } else {
                JOptionPane.showMessageDialog(null, "Thể loại chưa được chỉnh sửa", "edit genre",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    // Xóa thể loại bởi id
    public void removeGenre(int id) {
        String removeQuery = "DELETE FROM book_genres WHERE id = ?";
 
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
            
            ps.setInt(1, id);
            
            
            if(ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Thể loại đã được xóa", "Xóa",1);
            } else {
                JOptionPane.showMessageDialog(null, "Thể loại chưa được xóa", "Xóa",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //chức năng để điền vào một danh sách mảng với các thể loại
    public ArrayList<Genre> genreList() {
        
        ArrayList<Genre> gList = new ArrayList<>();
        
                
        
        try {            
            
            ResultSet rs  = func.getData("SELECT * FROM book_genres");
            Genre genre;
            
            while(rs.next()) {
                genre = new Genre(rs.getInt("id"),rs.getString("name"));
                gList.add(genre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return gList;
    }
    
    
    //Tạo 1 phương thức trả về hashmap
    // key là String
    // value là Integer
    public HashMap<String, Integer> getGenresMap() {
        HashMap<String, Integer> map = new HashMap<>();
        
        try {            
            
            ResultSet rs  = func.getData("SELECT * FROM book_genres");
            Genre genre;
            
            while(rs.next()) {
                genre = new Genre(rs.getInt("id"),rs.getString("name"));
                map.put(genre.getName(), genre.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return map;
    }
    
    //Tạo phương thức để lấy thể loại qua id
    public Genre getGenreById(Integer id) {
        ResultSet rs  = func.getData("SELECT * FROM book_genres WHERE id = "+id);
        Genre genre = null;
            
        try {
            while(rs.next()) {
                genre = new Genre(rs.getInt("id"),rs.getString("name"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return genre;
    }
}
