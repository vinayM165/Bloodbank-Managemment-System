package Service;

import java.io.IOException;
import java.io.PrintWriter;
import connectDB.DBconnect;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class AddAdmin
 */
public class AddAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdmin() {
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
				int apos=0,aneg=0,bpos=0,bneg=0,opos=0,oneg=0,abpos=0,abneg=0;
				int bbid=Integer.parseInt(request.getParameter("bbid"));
				String bbname=request.getParameter("bbname");
				String bbcon=request.getParameter("bbcontact");
				String bbadd=request.getParameter("bbaddress");	
				String bbemail=request.getParameter("bbemail");	
				String bbpwd=request.getParameter("bbpassword");	
				Connection con=DBconnect.getConnect();
				PreparedStatement ps1=con.prepareStatement("select * from bloodbank where bankid=? and bankemail=?");
				
				ps1.setInt(1, bbid);
				ps1.setString(2, bbemail);
				ResultSet r= ps1.executeQuery();		
				if(r.next())
				{
					request.getSession().setAttribute("msg", "Duplicate Blood Bank ID, Records Already Exist..!!");
	        		response.sendRedirect("addadminuser.jsp"); 
				}
				else
				{
					PreparedStatement ps=con.prepareStatement("insert into bloodbank values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					ps.setInt(1,bbid);
					ps.setString(2,bbname);
					ps.setString(3,bbcon);
					ps.setString(4,bbadd);
					ps.setString(5,bbemail);
					ps.setString(6,bbpwd);
					ps.setInt(7,apos);
					ps.setInt(8,aneg);
					ps.setInt(9,bpos);
					ps.setInt(10,bneg);
					ps.setInt(11,opos);
					ps.setInt(12,oneg);
					ps.setInt(13,abpos);
					ps.setInt(14,abneg);
					
					int n= ps.executeUpdate();
					System.out.println("Recort Inserted");
					
					if(n>=1)
					{
						request.getSession().setAttribute("msg", "Record Inserted Successfully..!!");
						response.sendRedirect("addadminuser.jsp"); 
					}
					else
					{
						request.getSession().setAttribute("msg", "Record Failed To Insert..!!");
						response.sendRedirect("addadminuser.jsp"); 
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


