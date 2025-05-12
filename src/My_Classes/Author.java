
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
 * @author tamda
 */
public class Author {
    private int id;
    private String name;
    private String field_Of_Expertise;
    private String about;

    public Author() {
    }

    public Author(int id, String name, String field_Of_Expertise, String about) {
        this.id = id;
        this.name = name;
        this.field_Of_Expertise = field_Of_Expertise;
        this.about = about;
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

    public String getField_Of_Expertise() {
        return field_Of_Expertise;
    }

    public void setField_Of_Expertise(String field_Of_Expertise) {
        this.field_Of_Expertise = field_Of_Expertise;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
    
    //funtions
    
     My_Classes.Func_Class func = new Func_Class();
        
    
    // insert a new author
    public void addAuthor(String name, String expertise, String about) {
        String insertQuery = "INSERT INTO author(name, expertise, about) VALUES (?, ?, ?)";
        
      
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            
            ps.setString(1, name);
            ps.setString(2, expertise);
            ps.setString(3, about);
            
            if(ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Đã Thêm Tác giả", "add author",1);
            } else {
                JOptionPane.showMessageDialog(null, "Không thêm được tác giả", "add author",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    // Chỉnh sưa tác giả bởi id
    public void editAuthor(int id, String name, String expertise, String about) {
        String editQuery = "UPDATE author SET name = ?, expertise = ?, about = ? WHERE id = ?";
        
      
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(editQuery);
            
            ps.setString(1, name);
            ps.setString(2, expertise);
            ps.setString(3, about);
            ps.setInt(4, id);
            
            
            if(ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Tác giả đã được chỉnh sửa", "edit author",1);
            } else {
                JOptionPane.showMessageDialog(null, "Tác giả chưa được chỉnh sửa", "edit author",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    // Xóa tác giả bởi id
    public void removeAuthor(int id) {
        String removeQuery = "DELETE FROM author WHERE id = ?";
 
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
            
            ps.setInt(1, id);
            
            
            if(ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Tác giả đã được xóa", "Xóa",1);
            } else {
                JOptionPane.showMessageDialog(null, "Tác giả chưa được xóa", "Xóa",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //chức năng để điền vào một danh sách mảng với các thể loại
    public ArrayList<Author> authorList() {
        
        ArrayList<Author> aList = new ArrayList<>();
        
       
        try {
            ResultSet rs  = func.getData("SELECT * FROM author");
            Author author;
            
            while(rs.next()) {
                author = new Author(rs.getInt("id"),rs.getString("name"), rs.getString("expertise"), rs.getString("about"));
                aList.add(author);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return aList;
    }
    
    //Tạo phương thức để lấy tác giả qua id
    public Author getAuthorById(Integer id) {
        ResultSet rs  = func.getData("SELECT * FROM author WHERE id = "+id);
        Author author = null;
            
        try {
            while(rs.next()) {
                author = new Author(rs.getInt("id"),rs.getString("name"), rs.getString("expertise"), rs.getString("about"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
        return author;
    }
}
