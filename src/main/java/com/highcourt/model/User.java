package com.highcourt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class User {
	private String username;
    private String mobileno;
    private String email;
    private int sectioncode;
    private String password;
    private int statecode ;
   private int districtcode ;
   private int talukacode ;
public User() {
	super();
}
public User(String username, String mobileno, String email, int sectioncode, String password, int statecode,
		int districtcode, int talukacode) {
	super();
	this.username = username;
	this.mobileno = mobileno;
	this.email = email;
	this.sectioncode = sectioncode;
	this.password = password;
	this.statecode = statecode;
	this.districtcode = districtcode;
	this.talukacode = talukacode;
}
public int userRegister() {
	try {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "mahi");
        String query = "INSERT INTO user (username, mobileno, email, sectioncode, password,statecode,districtcode,talukacode) VALUES (?, ?, ?, ?, ?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, username);
        pstmt.setString(2, mobileno);
        pstmt.setString(3, email);
        pstmt.setInt(4, sectioncode);
        pstmt.setString(5, password);
        pstmt.setInt(6, statecode)  ;
        pstmt.setInt(7,districtcode)  ;
        pstmt.setInt(8,talukacode)  ;
        
        int rows=pstmt.executeUpdate();
        return rows;
    } catch (Exception e) {
        e.printStackTrace();
    }
	return 0;
}
public List<User> viewUsers() {
	try 
	{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "mahi");
	ArrayList<User> userList=new ArrayList();
	String s="select * from user";
	Statement stmt=con.createStatement();
	ResultSet res=stmt.executeQuery(s);
	while(res.next())
	{
		
		username=res.getString(2);
		password=res.getString(3);
		mobileno=res.getString(4);
		email=res.getString(5);
		sectioncode=res.getInt(6);
		statecode=res.getInt(7);
		districtcode=res.getInt(8);
		talukacode=res.getInt(9);
		
		User u=new User(username,password,mobileno,sectioncode,email,statecode,districtcode,talukacode);
		userList.add(u);
	}
	return userList;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
	
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getMobileno() {
	return mobileno;
}
public void setMobileno(String mobileno) {
	this.mobileno = mobileno;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getSectioncode() {
	return sectioncode;
}
public void setSectioncode(int sectioncode) {
	this.sectioncode = sectioncode;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getStatecode() {
	return statecode;
}
public void setStatecode(int statecode) {
	this.statecode = statecode;
}
public int getDistrictcode() {
	return districtcode;
}
public void setDistrictcode(int districtcode) {
	this.districtcode = districtcode;
}
public int getTalukacode() {
	return talukacode;
}
public void setTalukacode(int talukacode) {
	this.talukacode = talukacode;
}
@Override
public String toString()
{
	return "User [username="+username+",password="+password+",mobileno="+mobileno+",sectioncode="+sectioncode+",email="+email+",statecode="+statecode+",districtcode"+districtcode+",talukacode"+talukacode+"]";
}



}
