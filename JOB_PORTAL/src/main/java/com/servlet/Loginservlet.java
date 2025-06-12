package com.servlet;

import java.io.IOException;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

import com.DB.DBConnect;
import com.dao.UserDAO;
import com.entity.User;

import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class Loginservlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws jakarta.servlet.ServletException, IOException {
		 try {
				String em=req.getParameter("email");
				String ps=req.getParameter("password");
				 User u=new User();
				 HttpSession session=req.getSession();
				
				if ("admin@gmail.com".equals(em) && "admin123".equals(ps)) {
					session.setAttribute("Userobj",u);
					u.setRole("admin");
					resp.sendRedirect("admin.jsp");
				}else {
					UserDAO dao=new UserDAO(DBConnect.getConn());
				User user=	dao.login(em, ps);
					if (user!=null) {
						session.setAttribute("Userobj", user);
						resp.sendRedirect("home.jsp");
					}else {
						session.setAttribute("succMsg", "Invalid Email or Password");
						resp.sendRedirect("login.jsp");
					}
				}

				 
			} catch (Exception e) {
					e.printStackTrace();
					}
			}
	}
	
	

