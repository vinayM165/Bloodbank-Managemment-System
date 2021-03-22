package Service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import connectDB.*;


/**
 * Servlet implementation class Upd
 */
public class Upd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upd() {
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
		int apos=Integer.parseInt(request.getParameter("apos"));
		int aneg=Integer.parseInt(request.getParameter("aneg"));
		int bpos=Integer.parseInt(request.getParameter("bpos"));
		int bneg=Integer.parseInt(request.getParameter("bneg"));
		int opos=Integer.parseInt(request.getParameter("opos"));
		int oneg=Integer.parseInt(request.getParameter("oneg"));
		int abpos=Integer.parseInt(request.getParameter("abpos"));
		int abneg=Integer.parseInt(request.getParameter("abneg"));
		try
		{
			String email =UserInfo.getEmail();
			   Connection con=DBconnect.getConnect();
			   Statement stmt=con.createStatement();
			   ResultSet rs=stmt.executeQuery("Select * from bloodbank WHERE bankemail ='"+email+"'");
			   if(rs.next())
			   {
				   apos=apos+rs.getInt("apos");
				   aneg=aneg+rs.getInt("aneg");
				   bpos=bpos+rs.getInt("bpos");
				   bneg=bneg+rs.getInt("bneg");
				   opos=opos+rs.getInt("opos");
				   oneg=oneg+rs.getInt("oneg");
				   abpos=abpos+rs.getInt("abpos");
				   abneg=abneg+rs.getInt("abneg");
				  
			   }
			   String query="UPDATE bloodbank set apos=?,aneg=?,bpos=?,bneg=?,opos=?,oneg=?,abpos=?,abneg=? where bankemail=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setInt(1,apos);
				ps.setInt(2,aneg);
				ps.setInt(3,bpos);
				ps.setInt(4,bneg);
				ps.setInt(5,opos);
				ps.setInt(6,oneg);
				ps.setInt(7,abpos);
				ps.setInt(8,abneg);
				ps.setString(9,email);
				int n= ps.executeUpdate();
				System.out.println("Blood Groups Updated");
				
				if(n>0)
				{
					request.getSession().setAttribute("msg", "BLood Groups Updated Successfully..!!");
					response.sendRedirect("upd.jsp"); 
				}
				else
				{
					request.getSession().setAttribute("msg", "BLood Groups Failed To Updated");
					response.sendRedirect("upd.jsp"); 
				}
		}
		catch(Exception e){
			e.printStackTrace();
}
	}
}

