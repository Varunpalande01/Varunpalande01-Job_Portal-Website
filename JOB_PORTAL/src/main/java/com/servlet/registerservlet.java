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

@WebServlet("/add_user")
public class registerservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String ps = req.getParameter("ps");
        String qua = req.getParameter("qua");

        User u = new User(name, email, ps, qua, "User");
        UserDAO dao = new UserDAO(DBConnect.getConn());

        HttpSession session = req.getSession();
        if (dao.addUser(u)) {
            session.setAttribute("succMsg", "Registration Successfully.");
        } else {
            session.setAttribute("succMsg", "Something went wrong.");
        }

        resp.sendRedirect("signup.jsp");
    }
}
