package Service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connectDB.DBconnect;
import connectDB.UserInfo;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
			PreparedStatement ps = conn.prepareStatement("select * from user where uemail=? and upwd=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				UserInfo.setEmail(email);
				response.sendRedirect("viewuserbb.jsp");
			}
			else
			{
				request.getSession().setAttribute("msg", "Enter Valid Email Or Password..!!!");
				response.sendRedirect("userlogin.jsp");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}


