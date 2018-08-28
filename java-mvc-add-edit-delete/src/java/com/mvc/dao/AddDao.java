package com.mvc.dao;

import com.mvc.bean.AddBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddDao 
{
    public String checkInsert(AddBean addBean)
    {
        String name=addBean.getName(); //get name through addBean object and store in temporary variable "name"
        String owner=addBean.getOwner(); //get owner through addBean object and store in temporary variable "owner"
        
        String url="jdbc:mysql://localhost:3306/db_mvcoperation"; //database connection url string
        String username="root"; //database connection username
        String password=""; //database password
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); //load driver
            Connection con=DriverManager.getConnection(url,username,password); //create connection
            
            PreparedStatement pstmt=null; //create statement
            
            pstmt=con.prepareStatement("insert into person(name,owner) values(?,?)"); //sql insert query
            pstmt.setString(1,name);
            pstmt.setString(2,owner);
            pstmt.executeUpdate(); //execute query
            
            pstmt.close(); //close statement
            
            con.close(); //close connection
            
            return "INSERT SUCCESS"; //if valid return "INSERT SUCCESS" string
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return "FAIL INSERT"; //if invalid return "FAIL INSERT" string
    }
    
}
