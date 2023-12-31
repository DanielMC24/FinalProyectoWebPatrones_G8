/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.proyecto.bean.LoginBean;
import com.proyecto.util.DBConnection;
/**
 *
 * @author Gloriana
 */
public class LoginDao {
	 public String authenticateUser(LoginBean loginBean)
	 {
		 String userName = loginBean.getUserName(); //Assign user entered values to temporary variables.
		 String password = loginBean.getPassword();

		 Connection con = null;
		 Statement statement = null;
		 ResultSet resultSet = null;

		 String userNameDB = "";
		 String passwordDB = "";

		 try
		 {
			 con = DBConnection.createConnection(); //Fetch database connection object
			 statement = con.createStatement(); //Statement is used to write queries. Read more about it.
			 resultSet = statement.executeQuery("select correo_electronico,contrasena from usuario"); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.

			 while(resultSet.next()) // Until next row is present otherwise it return false
			 {
			  userNameDB = resultSet.getString("correo_electronico"); //fetch the values present in database
			  passwordDB = resultSet.getString("contrasena");

                          
			   if(userName.equals(userNameDB) && password.equals(passwordDB))
			   {
				  return "SUCCESS"; ////If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
			   }
			 }

		 }
                 catch(SQLException e)
                {
                       e.printStackTrace();
                }
                return "Invalid user credentials"; // Return appropriate message in case of failure
	 }
}
