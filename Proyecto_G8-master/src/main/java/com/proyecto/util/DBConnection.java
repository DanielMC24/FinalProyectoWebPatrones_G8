/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 
 */
public class DBConnection {
    
 public static Connection createConnection()
 {
	 Connection con = null;
	 String url = "jdbc:mysql://localhost:3306/proyecto?useTimezone=true&serverTimezone=UTC"; //MySQL URL and followed by the database name
	 String username = "usuario_proyecto"; //MySQL username
	 String password = "la_clave"; //MySQL password	 
	 try 
	 {
		 try 
		 {
			Class.forName("com.mysql.jdbc.Driver"); //loading mysql driver 
		 } 
		 catch (ClassNotFoundException e)
		 {
			e.printStackTrace();
		 } 
		 con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
		 System.out.println("Printing connection object "+con);
	 } 
	 catch (Exception e) 
	 {
		e.printStackTrace();
	 }
	 return con; 
 }
}
    
