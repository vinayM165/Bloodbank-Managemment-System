package Service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectDB.DBconnect;
import connectDB.UserInfo;

/**
 * Servlet implementation class BBLogin
 */
public class BBLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBLogin() {
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
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		try
		{
			Connection conn=DBconnect.getConnect();
			PreparedStatement ps = conn.prepareStatement("select * from bloodbank where bankemail=? and bankpwd=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				UserInfo.setEmail(email);
				response.sendRedirect("addbb.jsp");
			}
			else
			{
				request.getSession().setAttribute("msg", "Enter Valid Email Or Password..!!!");
				response.sendRedirect("bblogin.jsp");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	}

