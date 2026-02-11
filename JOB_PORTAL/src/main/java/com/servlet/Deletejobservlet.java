//
//package com.servlet;
//
//import java.io.IOException;
//
//import com.DB.DBConnect;
//import com.dao.JobDAO;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//@WebServlet("/delete")
//public class Deletejobservlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            int id = Integer.parseInt(req.getParameter("id"));
//            JobDAO dao = new JobDAO(DBConnect.getConn());
//            boolean f = dao.deletejob(id);
//
//            HttpSession session = req.getSession();
//            if(f) {
//                session.setAttribute("succMsg", "Job deleted Successfully.");
//            } else {
//                session.setAttribute("succMsg", "Something went wrong.");
//            }
//            resp.sendRedirect("viewjob.jsp");
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
import com.dao.JobDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/delete")
public class Deletejobservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        JobDAO dao = new JobDAO(DBConnect.getConn());

        HttpSession session = req.getSession();
        if (dao.deletejob(id)) {
            session.setAttribute("succMsg", "Job deleted Successfully.");
        } else {
            session.setAttribute("succMsg", "Something went wrong.");
        }

        resp.sendRedirect("viewjob.jsp");
    }
}
