/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import model.User;


/**
 *
 * @author syst3m
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class DatabaseHandler {
   private String dbms = "mysql";
   private String datasource = "projectiv1201";
   private String username = "root";
   private String password = "root";
   private Connection connection;
   
   public DatabaseHandler() throws Exception {
       try {

           connection = getConnection();
       } catch (SQLException ex) {
           Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   private Connection getConnection()
           throws ClassNotFoundException, SQLException {
       Class.forName("com.mysql.jdbc.Driver");
       return DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/" + datasource, "root", "root");
   }
   
   public List<User> getAllUser() throws SQLException {
       List<User> ret = new ArrayList<User>();
       PreparedStatement getUserByID;
       getUserByID = connection.
               prepareStatement("SELECT * FROM USER");
       ResultSet result = getUserByID.executeQuery();
       while (result.next()) {
           User user = new User();
           user.setId(result.getLong("USERID"));
           user.setName(result.getString("NAME"));
           ret.add(user);

       }
       return ret;
   }
   
}
