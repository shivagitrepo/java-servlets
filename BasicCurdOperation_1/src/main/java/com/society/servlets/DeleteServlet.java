package com.society.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.society.dao.SocietyDao;
import com.society.entity.Society;

@WebServlet("/deleteurl")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter pw=response.getWriter();
		String sid=request.getParameter("mid");
		int mid=Integer.parseInt(sid);
		int status=SocietyDao.delete(mid);  
		if(status>0){  
			pw.println("selected member deleted......!");
			
			response.sendRedirect("viewurl");  
		}else{  
			pw.println("Sorry! unable to delete record");  
		}  

		pw.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
