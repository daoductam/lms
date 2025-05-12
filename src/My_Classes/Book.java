/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package My_Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author tamda
 */
public class Book {
    private Integer id;
    private String isbn;
    private String name;
    private Integer authorId;
    private Integer genreId;
    private Integer quantity;
    private String publisher;
    private double price;
    private String dateRecieved;
    private String description;
    private byte[] cover;

    public Book() {
    }

    public Book(Integer id,String isbn, String name, Integer authorId, Integer genreId, Integer 
            quantity, String publisher, double price, String dateRecieved, String description, byte[] cover) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.authorId = authorId;
        this.genreId = genreId;
        this.quantity = quantity;
        this.publisher = publisher;
        this.price = price;
        this.dateRecieved = dateRecieved;
        this.description = description;
        this.cover = cover;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDateRecieved() {
        return dateRecieved;
    }

    public void setDateRecieved(String dateRecieved) {
        this.dateRecieved = dateRecieved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }
    
    Func_Class func = new Func_Class();
    
    //funtions
    
    // insert a new book
    public void addBook(String isbn, String name, Integer authorId, Integer genreId, Integer 
            quantity, String publisher, double price, String dateRecieved, String description, byte[] cover) {
        String insertQuery = "INSERT INTO book(isbn, name, author_id, genre_id, quantity, publisher, price, date_received, description, cover_image)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
      
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            
            ps.setString(1, isbn);
            ps.setString(2, name);
            ps.setInt(3, authorId);
            ps.setInt(4, genreId);
            ps.setInt(5, quantity);
            ps.setString(6, publisher);
            ps.setDouble(7, price);
            ps.setString(8, dateRecieved);
            ps.setString(9, description);
            ps.setBytes(10, cover);
            
            if(ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Đã Thêm Sách", "add book",1);
            } else {
                JOptionPane.showMessageDialog(null, "Không thêm được Sách", "add book",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
    //Tạo 1 phương thức để check nếu isbn đã tồn tại
    public boolean isISBNexists(String isbn) {
        String query = "SELECT * FROM book WHERE isbn ='"+isbn+"'";
        
        ResultSet rs = func.getData(query);
        try {
            if(rs.next()) {
                return true; // nếu isbn tồn tại thì trả về true
            }
            else {
                return false; // nếu ko trả về false
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  true;
    }

    public Book searchBookById_Isbn(int id, String isbn) {
        
        String query = "SELECT * FROM book WHERE id ="+id+" or isbn ='"+isbn+"'";
       
        ResultSet rs = func.getData(query);
        Book book = null;
        try {
            if(rs.next()) {
                book = new Book(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4),
                                rs.getInt(5), rs.getInt(6), rs.getString(7),rs.getDouble(8),rs.getString(9),
                                rs.getString(10), rs.getBytes(11));
            }
            else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  book;
    }
    
    // chỉnh sửa thông tin sách
    public void editBook(int id, String name, Integer authorId, Integer genreId, Integer 
            quantity, String publisher, double price, String dateRecieved, String description, byte[] cover) {
        String updateQuery ;
        PreparedStatement ps;
        
        try {
            
        if(cover != null) { // nếu muốn cập nhật ảnh
            updateQuery = "UPDATE book SET name = ?, author_id = ?, genre_id = ?, quantity = ? , publisher = ? , price = ? , date_received= ?"
                + ", description = ?, cover_image= ? WHERE id = ?";
            
            ps = DB.getConnection().prepareStatement(updateQuery);
            
//            ps.setString(1, isbn);
            ps.setString(1, name);
            ps.setInt(2, authorId);
            ps.setInt(3, genreId);
            ps.setInt(4, quantity);
            ps.setString(5, publisher);
            ps.setDouble(6, price);
            ps.setString(7, dateRecieved);
            ps.setString(8, description);
            ps.setBytes(9, cover);
            ps.setInt(10, id);
        } else {
            updateQuery = "UPDATE book SET name = ?, author_id = ?, genre_id = ?, quantity = ? , publisher = ? , price = ? , date_received= ?"
                + ", description = ? WHERE id = ?";
            
            ps = DB.getConnection().prepareStatement(updateQuery);
            
//            ps.setString(1, isbn);
            ps.setString(1, name);
            ps.setInt(2, authorId);
            ps.setInt(3, genreId);
            ps.setInt(4, quantity);
            ps.setString(5, publisher);
            ps.setDouble(6, price);
            ps.setString(7, dateRecieved);
            ps.setString(8, description);
//            ps.setBytes(9, cover);
            ps.setInt(9, id);
        }
        
            if(ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Đã Chỉnh Sưae Sách", "Chỉnh Sửa Sách",1);
            } else {
                JOptionPane.showMessageDialog(null, "Không thêm được Sách", "Chỉnh Sửa Sách",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
    
    // Xóa sách 1ua id
    public void removeBook(int id) {
        String removeQuery = "DELETE FROM book WHERE id = ?";
 
        try {
            
            
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
            
            ps.setInt(1, id);
            
            
            if(ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Thành viên đã được xóa", "Xóa",1);
            } else {
                JOptionPane.showMessageDialog(null, "Thành viên chưa được xóa", "Xóa",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    //chức năng để điền vào một danh sách mảng với thành viên
    public ArrayList<Book> bookList(String query) {
        
        ArrayList<Book> bList = new ArrayList<>();
        
       
        try {
            
            if(query.equals("")) { // nếu người dùng không nhập gì thì lựa chọn để mặc định
                query = "SELECT * FROM book";
            }
            ResultSet rs  = func.getData(query);
            Book book;
            
            while(rs.next()) {
                book = new Book(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4),
                                rs.getInt(5), rs.getInt(6), rs.getString(7),rs.getDouble(8),rs.getString(9),
                                rs.getString(10), rs.getBytes(11));
                bList.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bList;
    }
    
     
    // get book by id
    public Book getBookById(Integer id) throws SQLException {
        
        // query để lấy sách qua id
        String query = "SELECT * FROM book WHERE id = " + id;
        
        ResultSet rs = func.getData(query);
        
        if(rs.next()) {
            // trả về sách
            return new Book(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4),
                                rs.getInt(5), rs.getInt(6), rs.getString(7),rs.getDouble(8),rs.getString(9),
                                rs.getString(10), rs.getBytes(11));
        } else {
            
            return null;
        }
    }
    
    // tạo phương thức để hiện 5 sách mới nhất
    public void displayBooksCover(JLabel[] labels_tab) {
        ResultSet rs;
        Statement st;
        
        try {
            st =  DB.getConnection().createStatement();
            rs = st.executeQuery("SELECT cover_image from book order by id desc LIMIT 5");
            byte[] image;
            int i =0;//phủ hết các label_tab với ảnh
               
            while(rs.next()) { //đi qua hết các dữ liệu
                image = rs.getBytes("cover_image");
                
                func.displayImage(labels_tab[i].getWidth(), labels_tab[i].getHeight(), image, name, labels_tab[i]);
                i++;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void setQuantity_Minus_One(int bookId,int quantity) {
        String updateQuantityQuery ;
        PreparedStatement ps;
        
        try {
            updateQuantityQuery = "UPDATE book SET quantity = ? WHERE id = ?";
            
            ps = DB.getConnection().prepareStatement(updateQuantityQuery);
         
            ps.setInt(1, quantity);
            ps.setInt(2, bookId);

            if(ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Sách này đã bị mất -> Số lượng - 1", "Chỉnh Sửa Số Lượng Sách",1);
            } else {
                JOptionPane.showMessageDialog(null, "Số lượng Sách khổng thể chỉnh", "Chỉnh Sửa Số Lượng Sách",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
    
}
