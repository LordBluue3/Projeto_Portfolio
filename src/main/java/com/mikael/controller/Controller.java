package com.mikael.controller;

import com.mikael.model.DAO;
import com.mikael.model.JavaBeans;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({ "/Controller", "/login", "/addUser" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JavaBeans javaBeans = new JavaBeans();
	DAO dao = new DAO();

    public Controller() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestServlet = request.getServletPath();
		if(requestServlet.equals("/login")){
			javaBeans.setEmail(request.getParameter("email"));
			javaBeans.setPassword(request.getParameter("senha"));
			dao.connection(javaBeans, response);
		}
	}
	public void redirecionarLogin(HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("TELAS/logado.html");
	}
	public void redirecionarErro(HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.html");
	}


}
