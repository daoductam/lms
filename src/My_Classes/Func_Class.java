
package My_Classes;

import java.sql.Statement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author tamda
 */
public class Func_Class {
    //Tạo 1 hàm để hiện thị ảnh trong jlable
    public void  displayImage(int width, int height,byte[] imagebyte, String imagePath, JLabel jLabel) {
        
        // get ảnh
        ImageIcon imgIco;
        if(imagebyte != null) { // Lấy ảnh sử dụng bytes
            imgIco = new ImageIcon(imagebyte);
        } else { //Lấy ảnh sử dụn đường dẫn
            try {
                // Lấy ảnh từ nguồn project
                imgIco = new ImageIcon(getClass().getResource(imagePath)); 
            }
            catch (Exception e) {
                // Lấy ảnh từ nguồn máy tính
                imgIco = new ImageIcon(imagePath); 
            }
            
        }
        
        
        // chỉnh ảnh vừa với jlabel
        Image image =  imgIco.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
        //để ảnh trong lable
        jLabel.setIcon(new ImageIcon(image));
        
        
    }
    
    //Chức năng tùy chỉnh jtable
    public void customeTable(JTable table) {
        table.setForeground(Color.BLACK);
        table.setSelectionBackground(new Color(249,105,14));
        table.setRowHeight(35);
        table.setShowGrid(false);
        table.setBackground(new Color(248,248,248));
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.ORANGE);
    }
    
    //Chức năng tùy chỉnh jtable Header
    public void customeTableHeader(JTable table, Color back_Color, Integer fontSize) {
        table.getTableHeader().setBackground(back_Color);
        table.getTableHeader().setForeground(Color.white);
        table.getTableHeader().setFont(new Font("Verdana", Font.BOLD,fontSize ));
        table.getTableHeader().setOpaque(false);
    }
    
    
   //Tạo chức năng chọn ảnh
    //Chức năng này sẽ tả về đường dẫn ảnh
    public  String selectImage() {
        // lấy ảnh từ máy tính
        JFileChooser fileChooser= new JFileChooser();
        fileChooser.setDialogTitle("Chọn ảnh hồ sơ");
        
        fileChooser.setCurrentDirectory(new File("C:\\"));
        
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Image",".png","jpg",".jpeg");
        fileChooser.addChoosableFileFilter(extensionFilter);
        
        int fileState = fileChooser.showSaveDialog(null);
        String path = "";
        if(fileState == JFileChooser.APPROVE_OPTION) {
            path = fileChooser.getSelectedFile().getAbsolutePath();
            
        }
        
        return path;
    }
    
    //Phương thức trả về ResultSet
    //Dùng để giảm thiểu code khi điền vào mảng arraylist - bảng jtable
    public ResultSet  getData(String  query) {
        
        PreparedStatement ps;
        ResultSet rs = null;
        
        try {
            ps = DB.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Func_Class.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    // Tao 1 phuoeng thức để đếm số dữ liệu
    public int countData(String tableName) {
        int total = 0;
        ResultSet rs;
        Statement st;
        
        try {
            st = (Statement) DB.getConnection().createStatement();
            rs = st.executeQuery("SELECT COUNT(*) as total from "+tableName+"");
            if(rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Func_Class.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
}
