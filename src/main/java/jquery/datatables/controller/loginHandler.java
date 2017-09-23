package jquery.datatables.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginHandler extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7305795731843110072L;
	
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public loginHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String UserName=request.getParameter("UserName");
		String password=request.getParameter("UserName");
	
	}

}
