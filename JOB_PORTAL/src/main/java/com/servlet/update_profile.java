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

@WebServlet("/update_profile")
public class update_profile extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String qualification = req.getParameter("qualification");

        HttpSession session = req.getSession();
        User oldUser = (User) session.getAttribute("Userobj");

        User u = new User();
        u.setId(id);
        u.setName(name);
        u.setEmail(email);
        u.setPassword(password);
        u.setQualification(qualification);

        // 🔥 THIS FIXES NAVBAR ISSUE
        u.setRole(oldUser.getRole());

        UserDAO dao = new UserDAO(DBConnect.getConn());

        if (dao.updateUser(u)) {
            session.setAttribute("succMsg", "Profile Updated Successfully");
            session.setAttribute("Userobj", u);
        } else {
            session.setAttribute("errorMsg", "Something went wrong");
        }

        resp.sendRedirect("home.jsp");
    }
}
