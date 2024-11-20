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
import java.sql.ResultSet;

/**
 * Servlet implementation class A7
 */
public class A7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A7() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private static final String chec="select * from wipro where uid=? and pwd=?";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db","root","Mysql@123");  
			String s1=request.getParameter("uid");
			String s2=request.getParameter("pwd");
		//	out.println("Your username is "+s1);
		 //	out.println("<br> your password is "+s2);
			PreparedStatement ps=con.prepareStatement(chec);
			ps.setString(1, s1);
			ps.setString(2,s2);
			ResultSet rs=ps.executeQuery();
			int j=0;
			while(rs.next()) {
				if(rs.getString(1).equals(s1) && rs.getString(2).equals(s2))
					j=1;
			}
		
			if (j==1) {
				// out.println("Login Sucessfull");
				response.sendRedirect("1.jsp");
			}
			else
				out.println("Invalid User");
			
			}
		catch(Exception e){
			System.out.println(e);
			} 
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

