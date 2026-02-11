//
//
//package com.servlet;
//
//import java.io.IOException;
//
//import com.DB.DBConnect;
//import com.dao.UserDAO;
//import com.entity.User;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//@WebServlet("/login")
//public class Loginservlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        try {
//            String em = req.getParameter("email");
//            String ps = req.getParameter("password");
//            HttpSession session = req.getSession();
//
//            if("admin@gmail.com".equals(em) && "admin123".equals(ps)) {
//                User u = new User();
//                u.setRole("admin");
//                session.setAttribute("Userobj", u);
//                resp.sendRedirect("admin.jsp");
//            } else {
//                UserDAO dao = new UserDAO(DBConnect.getConn());
//                User user = dao.login(em, ps);
//                if(user != null) {
//                    session.setAttribute("Userobj", user);
//                    resp.sendRedirect("home.jsp");
//                } else {
//                    session.setAttribute("succMsg", "Invalid Email or Password");
//                    resp.sendRedirect("login.jsp");
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
package com.servlet;

import java.io.IOException;

import com.DB.DBConnect;
import com.dao.UserDAO;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Loginservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String em = req.getParameter("email");
        String ps = req.getParameter("password");
        HttpSession session = req.getSession();

        if ("admin@gmail.com".equals(em) && "admin123".equals(ps)) {
            User u = new User();
            u.setRole("admin");
            session.setAttribute("Userobj", u);
            resp.sendRedirect("admin.jsp");
        } else {
            UserDAO dao = new UserDAO(DBConnect.getConn());
            User user = dao.login(em, ps);

            if (user != null) {
                session.setAttribute("Userobj", user);
                resp.sendRedirect("home.jsp");
            } else {
                session.setAttribute("succMsg", "Invalid Email or Password");
                resp.sendRedirect("login.jsp");
            }
        }
    }
}

