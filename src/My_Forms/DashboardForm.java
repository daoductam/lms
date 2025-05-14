/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package My_Forms;

import My_Classes.Book;
import My_Classes.Func_Class;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author Windows
 */
public class DashboardForm extends javax.swing.JFrame {

    // button border
    Border buttonBorder1 = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE);
    Border buttonBorder0 = BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(36,37,42));
    
    My_Classes.Func_Class func = new Func_Class();
    My_Classes.Book book = new Book();
    
    // Tạo mảng jlabels để hiện 5 ảnh sách mới
    JLabel[] labels_tab = new JLabel[5];
    /**
     * Creates new form DashboardForm
     */
    public DashboardForm() {
        initComponents();
        
        // Căn giữa form
        this.setLocationRelativeTo(null);
        
        // Hiển thị ảnh ở dashboard bên trái
        func.displayImage(jLabel1_Dashboard_Logo.getWidth(), jLabel1_Dashboard_Logo.getHeight(),null
                , "/My_Images/book_dash_logo.png", jLabel1_Dashboard_Logo);
        
        // thêm border cho panel Header
        Border panelHeaderBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
        jPanel_Header.setBorder(panelHeaderBorder);
        
        //Thêm nhiều border
        Border panelHeader_1_Border = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(235,125,22));
        jPanel_1_header.setBorder(panelHeader_1_Border);
        
        Border panelHeader_2_Border = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(26,138,32));
        jPanel_2_header.setBorder(panelHeader_2_Border);
        
        Border panelHeader_3_Border = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(115,40,125));
        jPanel_3_header.setBorder(panelHeader_3_Border);
        
        Border panelHeader_4_Border = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(58,83,155));
        jPanel_4_header.setBorder(panelHeader_4_Border);
        
        //thêm borders cho button
        addBorders();
        
        //Hiệu ứng hover
        buttonsHoverEffect();
        
        
        // Hiển thị số dữ liệu
        displayCount();
        
        //Hiển thị 5 bìa sách mới thêm vào cuối
        // 1 - Thêm jLabels vào labels_tab
        labels_tab[0] = jLabel_Image_1;
        labels_tab[1] = jLabel_Image_2;
        labels_tab[2] = jLabel_Image_3;
        labels_tab[3] = jLabel_Image_4;
        labels_tab[4] = jLabel_Image_5;
        
        //2-Hiển thi các ảnh
        book.displayBooksCover(labels_tab);
    }
    

    
    //Thêm border cho tất cả button trong jpanel menu
    public  void addBorders() {
        // Get các thành phần trong jpanel menu
        Component[] comps =  jPanel_Menu.getComponents();
        
        for(Component comp : comps) {
            // nếu thành phần là button
            if(comp instanceof JButton){
                JButton button = (JButton) comp;
                
                //Thêm border
                button.setBorder(buttonBorder0);
               
            }
        }
    }
    
    // Tạo function thêm hover cho menu button
    public void buttonsHoverEffect() {
        
        // Get các thành phần trong jpanel menu
        Component[] comps =  jPanel_Menu.getComponents();
        
        for(Component comp : comps) {
            // nếu thành phần là button
            if(comp instanceof JButton){
                JButton button = (JButton) comp;
                
                // Thêm hành động nhấn vào button
                button.addMouseListener(new MouseAdapter() {
                    
                    @Override
                    public  void mouseEntered(MouseEvent evt) {
                        button.setBorder(buttonBorder1);
                    }
                    
                    @Override
                    public  void mouseExited(MouseEvent evt) {
                        button.setBorder(buttonBorder0);
                    }
                 
                });
            }
        }
    }
    
    public  void displayCount() {
        jLabel_BooksCount.setText(String.valueOf(func.countData("book")));
        jLabel_AuthorsSount.setText(String.valueOf(func.countData("author")));
        jLabel_MembersCount.setText(String.valueOf(func.countData("member")));
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel_Menu = new javax.swing.JPanel();
        jPanel_Header = new javax.swing.JPanel();
        jLabel1_Dashboard_Logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton_AddMember_ = new javax.swing.JButton();
        jButton_EditMember_ = new javax.swing.JButton();
        jButton_Members_List_ = new javax.swing.JButton();
        jButton_DeleteMember_ = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton_Manage_Genres_ = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton_Manage_Authors_ = new javax.swing.JButton();
        jLabel_CirculationTitle = new javax.swing.JLabel();
        jButton_EditBook_ = new javax.swing.JButton();
        jButton_DeleteBook_ = new javax.swing.JButton();
        jButton_Books_List_ = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton_AddBook_ = new javax.swing.JButton();
        jButton_ManageUsers_ = new javax.swing.JButton();
        jButton_IssueBook_ = new javax.swing.JButton();
        jLabel_tmp = new javax.swing.JLabel();
        jButton_ReturnBook_ = new javax.swing.JButton();
        jPanel_1 = new javax.swing.JPanel();
        jPanel_1_header = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_BooksCount = new javax.swing.JLabel();
        jPanel_2 = new javax.swing.JPanel();
        jPanel_2_header = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel_MembersCount = new javax.swing.JLabel();
        jPanel_3 = new javax.swing.JPanel();
        jPanel_3_header = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel_AuthorsSount = new javax.swing.JLabel();
        jPanel_4 = new javax.swing.JPanel();
        jPanel_4_header = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel_Image_1 = new javax.swing.JLabel();
        jLabel_Image_3 = new javax.swing.JLabel();
        jLabel_Image_4 = new javax.swing.JLabel();
        jLabel_Image_5 = new javax.swing.JLabel();
        jLabel_Image_2 = new javax.swing.JLabel();
        jLabel_WelcomeUsername = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel_Menu.setBackground(new java.awt.Color(36, 37, 42));
        jPanel_Menu.setForeground(new java.awt.Color(255, 255, 255));

        jPanel_Header.setBackground(new java.awt.Color(1, 50, 67));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Library");

        javax.swing.GroupLayout jPanel_HeaderLayout = new javax.swing.GroupLayout(jPanel_Header);
        jPanel_Header.setLayout(jPanel_HeaderLayout);
        jPanel_HeaderLayout.setHorizontalGroup(
            jPanel_HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1_Dashboard_Logo, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel_HeaderLayout.setVerticalGroup(
            jPanel_HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_HeaderLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel_HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1_Dashboard_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_HeaderLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)))
                .addGap(16, 16, 16))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Thành Viên");

        jButton_AddMember_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_AddMember_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_AddMember_.setText("Thêm Thành Viên");
        jButton_AddMember_.setContentAreaFilled(false);
        jButton_AddMember_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_AddMember_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddMember_ActionPerformed(evt);
            }
        });

        jButton_EditMember_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_EditMember_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_EditMember_.setText("Sửa Thành Viên");
        jButton_EditMember_.setContentAreaFilled(false);
        jButton_EditMember_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_EditMember_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EditMember_ActionPerformed(evt);
            }
        });

        jButton_Members_List_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Members_List_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Members_List_.setText("Danh Sách Thành Viên");
        jButton_Members_List_.setContentAreaFilled(false);
        jButton_Members_List_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Members_List_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Members_List_ActionPerformed(evt);
            }
        });

        jButton_DeleteMember_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_DeleteMember_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_DeleteMember_.setText("Xóa Thành Viên");
        jButton_DeleteMember_.setContentAreaFilled(false);
        jButton_DeleteMember_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_DeleteMember_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteMember_ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Thể Loại");

        jButton_Manage_Genres_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Manage_Genres_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Manage_Genres_.setText("Quản Lý Thể Loại");
        jButton_Manage_Genres_.setContentAreaFilled(false);
        jButton_Manage_Genres_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Manage_Genres_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Manage_Genres_ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tác Giả");

        jButton_Manage_Authors_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Manage_Authors_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Manage_Authors_.setText("Quản Lý Tác Giả");
        jButton_Manage_Authors_.setContentAreaFilled(false);
        jButton_Manage_Authors_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Manage_Authors_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Manage_Authors_ActionPerformed(evt);
            }
        });

        jLabel_CirculationTitle.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel_CirculationTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CirculationTitle.setText("Chức năng");

        jButton_EditBook_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_EditBook_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_EditBook_.setText("Sửa Sách");
        jButton_EditBook_.setContentAreaFilled(false);
        jButton_EditBook_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_EditBook_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EditBook_ActionPerformed(evt);
            }
        });

        jButton_DeleteBook_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_DeleteBook_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_DeleteBook_.setText("Xóa Sách");
        jButton_DeleteBook_.setContentAreaFilled(false);
        jButton_DeleteBook_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_DeleteBook_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteBook_ActionPerformed(evt);
            }
        });

        jButton_Books_List_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Books_List_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Books_List_.setText("Danh Sách Sách");
        jButton_Books_List_.setContentAreaFilled(false);
        jButton_Books_List_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Books_List_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Books_List_ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Sách");

        jButton_AddBook_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_AddBook_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_AddBook_.setText("Thêm Sách");
        jButton_AddBook_.setContentAreaFilled(false);
        jButton_AddBook_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_AddBook_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddBook_ActionPerformed(evt);
            }
        });

        jButton_ManageUsers_.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_ManageUsers_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_ManageUsers_.setText("Quản Lý Users");
        jButton_ManageUsers_.setContentAreaFilled(false);
        jButton_ManageUsers_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_ManageUsers_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ManageUsers_ActionPerformed(evt);
            }
        });

        jButton_IssueBook_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_IssueBook_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_IssueBook_.setText("Mượn");
        jButton_IssueBook_.setContentAreaFilled(false);
        jButton_IssueBook_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_IssueBook_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_IssueBook_ActionPerformed(evt);
            }
        });

        jLabel_tmp.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_tmp.setText("|");

        jButton_ReturnBook_.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_ReturnBook_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_ReturnBook_.setText("Trả");
        jButton_ReturnBook_.setContentAreaFilled(false);
        jButton_ReturnBook_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_ReturnBook_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ReturnBook_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_MenuLayout = new javax.swing.GroupLayout(jPanel_Menu);
        jPanel_Menu.setLayout(jPanel_MenuLayout);
        jPanel_MenuLayout.setHorizontalGroup(
            jPanel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_MenuLayout.createSequentialGroup()
                .addGroup(jPanel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_MenuLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_MenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_MenuLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
            .addGroup(jPanel_MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_MenuLayout.createSequentialGroup()
                        .addComponent(jButton_ManageUsers_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel_MenuLayout.createSequentialGroup()
                        .addGroup(jPanel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Manage_Genres_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_Manage_Authors_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_Books_List_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel_MenuLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_MenuLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jButton_IssueBook_)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel_tmp, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton_ReturnBook_, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel_CirculationTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addComponent(jButton_Members_List_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel_MenuLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton_AddMember_, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_EditMember_, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_DeleteMember_, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton_EditBook_, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_AddBook_, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_DeleteBook_, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel_MenuLayout.createSequentialGroup()
                .addGroup(jPanel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_MenuLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel_MenuLayout.setVerticalGroup(
            jPanel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_MenuLayout.createSequentialGroup()
                .addComponent(jPanel_Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Manage_Genres_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Manage_Authors_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_AddMember_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_EditMember_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_DeleteMember_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Members_List_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jButton_AddBook_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_EditBook_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_DeleteBook_, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Books_List_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_CirculationTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_IssueBook_)
                    .addComponent(jLabel_tmp)
                    .addComponent(jButton_ReturnBook_))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_ManageUsers_)
                .addGap(24, 24, 24))
        );

        jPanel_1.setBackground(new java.awt.Color(255, 178, 41));
        jPanel_1.setForeground(new java.awt.Color(255, 102, 255));

        jPanel_1_header.setBackground(new java.awt.Color(246, 145, 16));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Books");

        javax.swing.GroupLayout jPanel_1_headerLayout = new javax.swing.GroupLayout(jPanel_1_header);
        jPanel_1_header.setLayout(jPanel_1_headerLayout);
        jPanel_1_headerLayout.setHorizontalGroup(
            jPanel_1_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_1_headerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel_1_headerLayout.setVerticalGroup(
            jPanel_1_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_1_headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel_BooksCount.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel_BooksCount.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_BooksCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_BooksCount.setText("000532");

        javax.swing.GroupLayout jPanel_1Layout = new javax.swing.GroupLayout(jPanel_1);
        jPanel_1.setLayout(jPanel_1Layout);
        jPanel_1Layout.setHorizontalGroup(
            jPanel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_1_header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel_BooksCount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_1Layout.setVerticalGroup(
            jPanel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_1Layout.createSequentialGroup()
                .addComponent(jPanel_1_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel_BooksCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );

        jPanel_2.setBackground(new java.awt.Color(75, 192, 18));

        jPanel_2_header.setBackground(new java.awt.Color(65, 160, 10));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Members");

        javax.swing.GroupLayout jPanel_2_headerLayout = new javax.swing.GroupLayout(jPanel_2_header);
        jPanel_2_header.setLayout(jPanel_2_headerLayout);
        jPanel_2_headerLayout.setHorizontalGroup(
            jPanel_2_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_2_headerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel_2_headerLayout.setVerticalGroup(
            jPanel_2_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_2_headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel_MembersCount.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel_MembersCount.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MembersCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_MembersCount.setText("11389");

        javax.swing.GroupLayout jPanel_2Layout = new javax.swing.GroupLayout(jPanel_2);
        jPanel_2.setLayout(jPanel_2Layout);
        jPanel_2Layout.setHorizontalGroup(
            jPanel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_2_header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel_MembersCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_2Layout.setVerticalGroup(
            jPanel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_2Layout.createSequentialGroup()
                .addComponent(jPanel_2_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel_MembersCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42))
        );

        jPanel_3.setBackground(new java.awt.Color(155, 89, 182));

        jPanel_3_header.setBackground(new java.awt.Color(125, 60, 155));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Authors");

        javax.swing.GroupLayout jPanel_3_headerLayout = new javax.swing.GroupLayout(jPanel_3_header);
        jPanel_3_header.setLayout(jPanel_3_headerLayout);
        jPanel_3_headerLayout.setHorizontalGroup(
            jPanel_3_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_3_headerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel_3_headerLayout.setVerticalGroup(
            jPanel_3_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_3_headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel_AuthorsSount.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel_AuthorsSount.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_AuthorsSount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_AuthorsSount.setText("18");

        javax.swing.GroupLayout jPanel_3Layout = new javax.swing.GroupLayout(jPanel_3);
        jPanel_3.setLayout(jPanel_3Layout);
        jPanel_3Layout.setHorizontalGroup(
            jPanel_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_3_header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel_3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_AuthorsSount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel_3Layout.setVerticalGroup(
            jPanel_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_3Layout.createSequentialGroup()
                .addComponent(jPanel_3_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel_AuthorsSount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );

        jPanel_4.setBackground(new java.awt.Color(44, 130, 201));
        jPanel_4.setForeground(new java.awt.Color(255, 102, 255));

        jPanel_4_header.setBackground(new java.awt.Color(68, 108, 179));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sách Mới Nhất");

        javax.swing.GroupLayout jPanel_4_headerLayout = new javax.swing.GroupLayout(jPanel_4_header);
        jPanel_4_header.setLayout(jPanel_4_headerLayout);
        jPanel_4_headerLayout.setHorizontalGroup(
            jPanel_4_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_4_headerLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_4_headerLayout.setVerticalGroup(
            jPanel_4_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_4_headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel_Image_1.setBackground(new java.awt.Color(153, 204, 255));
        jLabel_Image_1.setOpaque(true);

        jLabel_Image_3.setBackground(new java.awt.Color(153, 204, 255));
        jLabel_Image_3.setOpaque(true);

        jLabel_Image_4.setBackground(new java.awt.Color(153, 204, 255));
        jLabel_Image_4.setOpaque(true);

        jLabel_Image_5.setBackground(new java.awt.Color(153, 204, 255));
        jLabel_Image_5.setOpaque(true);

        jLabel_Image_2.setBackground(new java.awt.Color(153, 204, 255));
        jLabel_Image_2.setOpaque(true);

        javax.swing.GroupLayout jPanel_4Layout = new javax.swing.GroupLayout(jPanel_4);
        jPanel_4.setLayout(jPanel_4Layout);
        jPanel_4Layout.setHorizontalGroup(
            jPanel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_4_header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_4Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel_Image_1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Image_2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Image_3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Image_4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Image_5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel_4Layout.setVerticalGroup(
            jPanel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_4Layout.createSequentialGroup()
                .addComponent(jPanel_4_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Image_1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Image_3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Image_4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Image_5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Image_2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel_WelcomeUsername.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel_WelcomeUsername.setText("Chào mừng trở lại");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jPanel_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jPanel_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_WelcomeUsername))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_WelcomeUsername)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jPanel_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AddMember_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddMember_ActionPerformed
        // Hiển thị AddMember form
        AddMemberForm addMemberForm = new AddMemberForm();
        addMemberForm.setVisible(true);
    }//GEN-LAST:event_jButton_AddMember_ActionPerformed

    private void jButton_EditMember_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EditMember_ActionPerformed
        // Hiển thị EditMember form
        EditMemberForm editMemberForm = new EditMemberForm();
        editMemberForm.setVisible(true);
    }//GEN-LAST:event_jButton_EditMember_ActionPerformed

    private void jButton_Members_List_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Members_List_ActionPerformed
        // Hiển thị Members List form
        MembersListForm membersListForm = new  MembersListForm();
        membersListForm.setVisible(true);
    }//GEN-LAST:event_jButton_Members_List_ActionPerformed

    private void jButton_DeleteMember_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteMember_ActionPerformed
        // Hiển thị DeleteMember form
        DeleteMemberForm deleteMemberForm = new DeleteMemberForm();
        deleteMemberForm.setVisible(true);
    }//GEN-LAST:event_jButton_DeleteMember_ActionPerformed

    private void jButton_Manage_Genres_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Manage_Genres_ActionPerformed
        // Hiển thị Manage_Genres form
        ManageGenresForm mngGenresF = new ManageGenresForm();
        mngGenresF.setVisible(true);
    }//GEN-LAST:event_jButton_Manage_Genres_ActionPerformed

    private void jButton_Manage_Authors_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Manage_Authors_ActionPerformed
        // Hiển thị Manage_Authors form
        ManageAuthorsForm mngAuthorsF = new ManageAuthorsForm();
        mngAuthorsF.setVisible(true);
    }//GEN-LAST:event_jButton_Manage_Authors_ActionPerformed

    private void jButton_AddBook_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddBook_ActionPerformed
        // Hiển thị add book form
        AddBookForm addBookForm= new AddBookForm();
        addBookForm.setVisible(true);
    }//GEN-LAST:event_jButton_AddBook_ActionPerformed

    private void jButton_EditBook_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EditBook_ActionPerformed
        // Hiển thị edit book form
        EditBookForm editBookForm= new EditBookForm();
        editBookForm.setVisible(true);
    }//GEN-LAST:event_jButton_EditBook_ActionPerformed

    private void jButton_DeleteBook_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteBook_ActionPerformed
        // Hiển thị delete book form
        DeleteBookForm deleteBookForm= new DeleteBookForm();
        deleteBookForm.setVisible(true);
    }//GEN-LAST:event_jButton_DeleteBook_ActionPerformed

    private void jButton_Books_List_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Books_List_ActionPerformed
        // Hiển thị book lists form
        BookListForm bookListForm= new BookListForm();
        bookListForm.setVisible(true);
    }//GEN-LAST:event_jButton_Books_List_ActionPerformed

    private void jButton_ManageUsers_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ManageUsers_ActionPerformed
        // Hiển thị manage users form (Hiện thị loại owner)
        ManageUsersForm manageUsersForm= new ManageUsersForm();
        manageUsersForm.setVisible(true);
    }//GEN-LAST:event_jButton_ManageUsers_ActionPerformed

    private void jButton_IssueBook_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_IssueBook_ActionPerformed
       // Hiển thị issue book form
        IssueBookForm issueBookForm= new IssueBookForm();
        issueBookForm.setVisible(true);
    }//GEN-LAST:event_jButton_IssueBook_ActionPerformed

    private void jButton_ReturnBook_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ReturnBook_ActionPerformed
        // Hiển thị return book form
        ReturnBookForm returnBookForm= new ReturnBookForm();
        returnBookForm.setVisible(true);
    }//GEN-LAST:event_jButton_ReturnBook_ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AddBook_;
    private javax.swing.JButton jButton_AddMember_;
    private javax.swing.JButton jButton_Books_List_;
    private javax.swing.JButton jButton_DeleteBook_;
    private javax.swing.JButton jButton_DeleteMember_;
    private javax.swing.JButton jButton_EditBook_;
    private javax.swing.JButton jButton_EditMember_;
    public javax.swing.JButton jButton_IssueBook_;
    public javax.swing.JButton jButton_ManageUsers_;
    private javax.swing.JButton jButton_Manage_Authors_;
    private javax.swing.JButton jButton_Manage_Genres_;
    private javax.swing.JButton jButton_Members_List_;
    public javax.swing.JButton jButton_ReturnBook_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel1_Dashboard_Logo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_AuthorsSount;
    private javax.swing.JLabel jLabel_BooksCount;
    public javax.swing.JLabel jLabel_CirculationTitle;
    private javax.swing.JLabel jLabel_Image_1;
    private javax.swing.JLabel jLabel_Image_2;
    private javax.swing.JLabel jLabel_Image_3;
    private javax.swing.JLabel jLabel_Image_4;
    private javax.swing.JLabel jLabel_Image_5;
    private javax.swing.JLabel jLabel_MembersCount;
    public javax.swing.JLabel jLabel_WelcomeUsername;
    public javax.swing.JLabel jLabel_tmp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_1;
    private javax.swing.JPanel jPanel_1_header;
    private javax.swing.JPanel jPanel_2;
    private javax.swing.JPanel jPanel_2_header;
    private javax.swing.JPanel jPanel_3;
    private javax.swing.JPanel jPanel_3_header;
    private javax.swing.JPanel jPanel_4;
    private javax.swing.JPanel jPanel_4_header;
    private javax.swing.JPanel jPanel_Header;
    private javax.swing.JPanel jPanel_Menu;
    // End of variables declaration//GEN-END:variables
}
