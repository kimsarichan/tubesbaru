/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubestahap1;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author fujitsu
 */
public class Database {
         static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL ="jdbc:mysql://localhost/friendsbook";
    private String dbuser,dbpassword;
    private java.sql.Statement statement;
    private java.sql.Connection connection;
    private java.sql.ResultSet resultSet;

    /**
     *
     */
    public void connect()
    {
        try {
            Class.forName (JDBC_DRIVER);
        } catch (Exception e) {
            JOptionPane.showMessageDialog  (null,e.getMessage (), "JDBC Driver ERROR", JOptionPane.ERROR_MESSAGE);
        }
        try {
            connection = DriverManager.getConnection(DATABASE_URL, "root", "root");
            statement = connection.createStatement ();
        } catch (Exception e) {
            JOptionPane.showMessageDialog (null, e.getMessage (), "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public java.sql.ResultSet getData(String query)
    {
         try {
            resultSet = statement.executeQuery (query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog (null, e.getMessage (), "Querry Error", JOptionPane.ERROR_MESSAGE);
        }
        return resultSet;
    }
    public int execute(String query)
    {
        int i=0;
        try {
            i =statement.executeUpdate (query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog (null, e.getMessage (), "Querry Error", JOptionPane.ERROR_MESSAGE);
        }
        return i;
    }
    public void close()
    {
             try {
                 statement.close();
             } catch (SQLException ex) {
                 Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
}
