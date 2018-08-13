package org.shopmall.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shopmall.dao.ShuShuDAO;
import org.shopmall.dto.ShushuDTO;

@WebServlet("/shushuList")
public class ShuShuListServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		ShuShuDAO shudao = new ShuShuDAO();
		
		ShushuDTO[] lists = shudao.selectShushuList();
		
		req.setAttribute("list", lists);
		req.getRequestDispatcher("/WEB-INF/views/shushuListForm.jsp").forward(req, res);
	}
}
