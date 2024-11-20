package com.DemoApp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class A8
 */
@WebServlet("/A8")
public class A8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String insertq="insert into wipro(uid,pwd) values(?,?)";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A8() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String s1=request.getParameter("uid");
		String s2=request.getParameter("pwd");
		System.out.println("name "+s1);
		System.out.println("pwd "+s2);
		

		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db","root","Mysql@123");
			PreparedStatement ps=con.prepareStatement(insertq);
			ps.setString(1, s1);
			ps.setString(2,s2);
			ps.executeUpdate();
			pw.println("Registration Sucessfull");
			
		}catch(Exception e){
			System.out.println(e);
			} 
		
	pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}









