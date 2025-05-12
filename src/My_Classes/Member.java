
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
 * @member tamda
 */
public class Member {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String gender;
    private byte[] picture; 
    
    public Member() {
    }

    public Member(int id, String name, String phone, String email, String gender, byte[] picture) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.picture = picture;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    //funtions
    
    // insert a new member
    public void addMember(String name, String phone, String email, String gender, byte[] picture) {
        String insertQuery = "INSERT INTO member(name, phone, email, gender, picture) VALUES (?, ?, ?, ?, ?)";
        
      
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, email);
            ps.setString(4, gender);
            ps.setBytes(5, picture);
            
            if(ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Đã Thêm Thành Viên", "add member",1);
            } else {
                JOptionPane.showMessageDialog(null, "Không thêm được Thành Viên", "add member",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }

    
    // Chỉnh sưa thành viên bởi id
    public void editMember(Integer id, String name, String phone, String email, String gender, byte[] picture) {
        String editQuery = "UPDATE member SET name = ?, phone = ?, email = ?, gender = ?, picture = ? WHERE id = ?";
        
      
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(editQuery);
            
             ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, email);
            ps.setString(4, gender);
            ps.setBytes(5, picture);
            ps.setInt(6, id);
            
            
            if(ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Tác giả đã được chỉnh sửa", "edit member",1);
            } else {
                JOptionPane.showMessageDialog(null, "Tác giả chưa được chỉnh sửa", "edit member",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
    
    // Xóa thành viên bởi id
    public void removeMember(int id) {
        String removeQuery = "DELETE FROM member WHERE id = ?";
 
        try {
            
            
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
            
            ps.setInt(1, id);
            
            
            if(ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Thành viên đã được xóa", "Xóa",1);
            } else {
                JOptionPane.showMessageDialog(null, "Thành viên chưa được xóa", "Xóa",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    // get member by id
    public Member getMemberById(Integer id) throws SQLException {
        Func_Class func = new Func_Class();
        
        String query = "SELECT * FROM member WHERE id = " + id;
        
        ResultSet rs = func.getData(query);
        
        if(rs.next()) {
            return new Member(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                                rs.getString(5),rs.getBytes(6));
        } else {
            
            return null;
        }
    }
    
    
    //chức năng để điền vào một danh sách mảng với thành viên
    public ArrayList<Member> memberList(String query) {
        
        ArrayList<Member> mList = new ArrayList<>();
        
        My_Classes.Func_Class func = new Func_Class();
        
        try {
            
            if(query.equals("")) { // nếu người dùng không nhập gì thì lựa chọn để mặc định
                query = "SELECT * FROM member";
            }
            ResultSet rs  = func.getData(query);
            Member member;
            
            while(rs.next()) {
                member = new Member(rs.getInt("id"),rs.getString("name"), rs.getString("phone"),
                        rs.getString("email"),rs.getString("gender"), rs.getBytes("picture"));
                mList.add(member);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mList;
    }
    
}
