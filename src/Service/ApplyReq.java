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
 * Servlet implementation class ApplyReq
 */
public class ApplyReq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyReq() {
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
				int uid=Integer.parseInt(request.getParameter("rid"));
				String uname=request.getParameter("uname");
				String ucon=request.getParameter("ucontact");
				String uadd=request.getParameter("uaddress");	
				String ubg=request.getParameter("ubg");
				String ustatus="Requested";
				Connection con=DBconnect.getConnect();
				PreparedStatement ps1=con.prepareStatement("select * from request where rid=?");
				
				ps1.setInt(1,uid);
				ResultSet r= ps1.executeQuery();		
				if(r.next())
				{
					request.getSession().setAttribute("msg", "Duplicate Request ID, Records Already Exist..!!");
	        		response.sendRedirect("applyreq.jsp"); 
				}
				else
				{
					PreparedStatement ps=con.prepareStatement("insert into request values(?,?,?,?,?,?)");
					ps.setInt(1,uid);
					ps.setString(2,uname);
					ps.setString(3,ucon);
					ps.setString(4,uadd);
					ps.setString(5, ubg);
					ps.setString(6,ustatus);
					
					int n= ps.executeUpdate();
					System.out.println("Request Applied");
					
					if(n>=1)
					{
						request.getSession().setAttribute("msg", "Request Applied Successfully..!!");
						response.sendRedirect("viewuserbb.jsp"); 
					}
					else
					{
						request.getSession().setAttribute("msg", "Request Failed To Apply..!!");
						response.sendRedirect("viewuserbb.jsp"); 
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


