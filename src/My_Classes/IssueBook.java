/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package My_Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tamda
 */
public class IssueBook {
    private int issueBookId;
    private int memberId;
    private String status; // Mượn - Trả - Mất
    private String issueDate;
    private String returnDate;
    private String note;

    public IssueBook() {
    }

    
    
    public IssueBook(int issueBookId, int memberId, String status, String issueDate, String returnDate, String note) {
        this.issueBookId = issueBookId;
        this.memberId = memberId;
        this.status = status;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.note = note;
    }
    
    

    public int getIssueBookId() {
        return issueBookId;
    }

    public void setIssueBookId(int issueBookId) {
        this.issueBookId = issueBookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
    
    Book book = new Book();
    Func_Class func = new Func_Class();
    
    //thêm 1 lần mượn
    public void addIssue(int bookId, int memberId, String status, 
            String issueDate, String returnDate, String note) {
        String insertQuery = "INSERT INTO issue_book(book_id, member_id, status, issue_date, return_date,note)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        
      
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            
            ps.setInt(1, bookId);
            ps.setInt(2, memberId);
            ps.setString(3, status);
            ps.setString(4, issueDate);
            ps.setString(5, returnDate);
            ps.setString(6, note);

            
            if(ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Đã Mượn", "Mượn",1);
            } else {
                JOptionPane.showMessageDialog(null, "Không Mượn được", "Mượn",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }    
    
    //cập nhật mượn
    public void updateIssue(int bookId, int memberId, String status, 
             String issueDate,String returnDate, String note) {
        String updateQuery = "UPDATE issue_book set  status = ?,  return_date = ?,note = ? "
                + "WHERE book_id = ? AND member_id = ? AND issue_date = ? ";
                
        
      
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(updateQuery);
            
            
            ps.setString(1, status);
            ps.setString(2, returnDate);
            ps.setString(3, note);
            ps.setInt(4, bookId);
            ps.setInt(5, memberId);
            ps.setString(6, issueDate);

            
            if(ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Trạng Thái Đã Cập Nhật", "Mượn Sách",1);
            } else {
                JOptionPane.showMessageDialog(null, "Trạng Thái Không Thay Đổi", "Mượn Sách",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }    
    // kiểm tra xem sách có ko
    // Lây số lượng của bảng sách và so sánh với
    // số sáchđã mượn trong bảng mượn sách
    public boolean checkBookAvailability(int bookId) {
        boolean availability = false;
        try {
            // đầu tiên lấy số lượng sách
            Book selectedBook = book.getBookById(bookId);
            int quantity =  selectedBook.getQuantity();
            
            // Lây số sách đã mượn (Sách giống nhau)
            int issuedBookCount = countData(bookId);
            
            if(quantity > issuedBookCount) {
                availability = true;
            } else {
                availability = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        return availability;
    }
    
     // Tao 1 phuoeng thức để đếm số dữ liệu
    public int countData(int bookId) {
        int total = 0;
        ResultSet rs;
        PreparedStatement ps;
        
        try {
            ps = DB.getConnection().prepareStatement("SELECT COUNT(*) as total  from issue_book WHERE book_id = ? and status = 'issued'");
             
            ps.setInt(1, bookId);
            
            rs = ps.executeQuery();
           
            if(rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    
    //chức năng để điền vào một danh sách mảng với mượn/trả/mất sách
    public ArrayList<IssueBook> issuedBookList(String _status) {
        
        // tạo 1 danh sách
        ArrayList<IssueBook> issBList = new ArrayList<>();
        String query;
        
        if(_status.equals("")) { //nếu status rỗng > hiện các dữ liệu
            query = "SELECT * FROM issue_book";
        } else { // hiện dữ liệu phụ thuộc vào trạng thái dc chọn
            query = "SELECT * FROM issue_book where status = '" + _status + "'";
        }
        
       
        try {
            
            ResultSet rs  = func.getData(query);
            IssueBook issueBook;
            
            while(rs.next()) {
                issueBook = new IssueBook(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4),
                                rs.getString(5),rs.getString(6));
                issBList.add(issueBook);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return issBList;
    }
    
    
    // Xóa sách mượn sử dụng id sách  - id tv và ngày mượn
    // có thể thêm 1 cột id (như  key ) vào bảng và xóa chúng giống như cách làm với sách
    public void removeFromIssuedTable(int bookId,int memberId, String issuedDate) {
        String removeQuery = "DELETE FROM issue_book WHERE book_id = ? AND member_id = ? AND issue_date = ?";
 
        try {
            
            
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
            
            ps.setInt(1, bookId);
            ps.setInt(2, memberId);
            ps.setString(3, issuedDate);
            
            if(ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Xóa thành công", "Xóa",1);
            } else {
                JOptionPane.showMessageDialog(null, "Không xóa được", "Xóa",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
