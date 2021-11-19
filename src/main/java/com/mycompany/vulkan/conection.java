
package com.mycompany.vulkan;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


 
 

public class conection {
    private String url = "jdbc:mysql://127.0.0.1:3306/prueba";
    private String user = "root";
        
    private String passsword = "JKphG1#L";
    public static Connection getConnection() {
        
        Connection connection = null;
        MysqlDataSource dataSource = new MysqlDataSource();
              
        return connection;
    }
        
    
}
