
package My_Classes;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tamda
 */
public class DB {
    
    //Tạo kết nối giữa project với mysql database
    private static String serverName = "localhost";
    private static String username = "root";
    private static String dbName = "java_library_system";
    private static Integer portNumber = 3306;
    private static String password = "TaM123456789@";
    
    //return connection
    public static Connection getConnection() {
        Connection connection = null;
        
        MysqlDataSource datasource = new MysqlDataSource();
        
        datasource.setServerName(serverName);
        datasource.setUser(username);
        datasource.setDatabaseName(dbName);
        datasource.setPort(portNumber);
        datasource.setPassword(password);
        
        try {
            connection = (Connection) datasource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return connection;
    }
}
