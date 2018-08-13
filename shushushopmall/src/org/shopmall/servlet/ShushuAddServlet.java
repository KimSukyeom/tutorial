package org.shopmall.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopmall.dao.ShuShuDAO;
import org.shopmall.dto.ShushuDTO;

@WebServlet("/shushuAdd")
public class ShushuAddServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		req.getRequestDispatcher("/WEB-INF/views/shushuAddForm.jsp").forward(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String email = req.getParameter("email");
		
		ShushuDTO shudto = new ShushuDTO();
		shudto.setId(id);
		shudto.setName(name);
		shudto.setDob(Date.valueOf(dob));
		shudto.setEmail(email);
		
		ShuShuDAO dao = new ShuShuDAO();
		
		if (dao.insertShushuAdd(shudto))
		{
			res.sendRedirect(req.getContextPath() + "/shushuList");
		}
		else
		{
			req.setAttribute("error", "회원 등록 실패");
			req.getRequestDispatcher("/WEB-INF/views/shushuAddForm.jsp").forward(req, res);
		}
		
	}
}
