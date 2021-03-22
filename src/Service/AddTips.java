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
 * Servlet implementation class AddTips
 */
public class AddTips extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTips() {
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
				int tipno=Integer.parseInt(request.getParameter("tipno"));
				String bbht=request.getParameter("bbht");
				Connection con=DBconnect.getConnect();
				System.out.println(con);
				PreparedStatement ps1=con.prepareStatement("select * from healthtips where tipno=?");
				
				ps1.setInt(1, tipno);
				ResultSet r= ps1.executeQuery();
			
				if(r.next())
				{
					request.getSession().setAttribute("msg", "Tip No. Already Exist..!!");
	        		response.sendRedirect("addtips.jsp"); 
				}
				else
				{
					PreparedStatement ps=con.prepareStatement("insert into healthtips values(?,?)");
					ps.setInt(1,tipno);
					ps.setString(2,bbht);
					
					int n= ps.executeUpdate();
					System.out.println("Tip Inserted");
					
					if(n>=1)
					{
						request.getSession().setAttribute("msg", "Health Tip Inserted Successfully..!!");
						response.sendRedirect("addtips.jsp"); 
					}
					else
					{
						request.getSession().setAttribute("msg", "Health Tip Failed To Insert..!!");
						response.sendRedirect("addtips.jsp"); 
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




