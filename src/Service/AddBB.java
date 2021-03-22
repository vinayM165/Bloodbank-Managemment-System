package Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectDB.DBconnect;

/**
 * Servlet implementation class Add
 */
public class AddBB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out=response.getWriter();
		{
			try
			{
				String ano=request.getParameter("bdid");
				String aname=request.getParameter("bdname");
				String adate=request.getParameter("bddate");
				String atime=request.getParameter("bdtime");
				String aadd=request.getParameter("bdadd");
				String balance="0";
			
				
				Connection conn=DBconnect.getConnect();
			
				PreparedStatement ps=conn.prepareStatement("select * from camp where campid='"+ano+"'");
				
				ResultSet r= ps.executeQuery();
			
				if(r.next())
				{
					request.getSession().setAttribute("msg", "Duplicatent Blood Donation Camp ID, Records Already Exist..!!");
	        		response.sendRedirect("addbb.jsp"); 
				}
				else
				{
					PreparedStatement ps1=conn.prepareStatement("insert into camp values(?,?,?,?,?)");
					ps1.setString(1,ano);
					ps1.setString(2,aname);
					ps1.setString(3,adate);
					ps1.setString(4,atime);
					ps1.setString(5,aadd);
					
					
					int n= ps1.executeUpdate();
					System.out.println("Recort inserted");
					
					if(n>=1)
					{
						request.getSession().setAttribute("msg", "Record Inserted Successfully..!!");
						response.sendRedirect("addbb.jsp"); 
					}
					else
					{
						request.getSession().setAttribute("msg", "Record Failed To Insert..!!");
						response.sendRedirect("addbb.jsp"); 
					}
				}
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	}

