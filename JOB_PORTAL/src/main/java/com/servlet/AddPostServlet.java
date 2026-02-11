//
//package com.servlet;
//
//import java.io.IOException;
//
//import com.DB.DBConnect;
//import com.dao.JobDAO;
//import com.entity.jobs;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//@WebServlet("/add_job")
//public class AddPostServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            String title = req.getParameter("title");
//            String location = req.getParameter("location");
//            String category = req.getParameter("category");
//            String status = req.getParameter("status");
//            String desc = req.getParameter("desc");
//
//            jobs j = new jobs();
//            j.setTitle(title);
//            j.setLocation(location);
//            j.setCategory(category);
//            j.setStatus(status);
//            j.setDescription(desc);
//
//            JobDAO dao = new JobDAO(DBConnect.getConn());
//            HttpSession session = req.getSession();
//
//            boolean f = dao.addJobs(j);
//            if(f) {
//                session.setAttribute("succMsg", "Job Posted Successfully.");
//            } else {
//                session.setAttribute("succMsg", "Something went wrong.");
//            }
//            resp.sendRedirect("add_job.jsp");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
package com.servlet;

import java.io.IOException;

import com.DB.DBConnect;
import com.dao.JobDAO;
import com.entity.jobs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add_job")
public class AddPostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String title = req.getParameter("title");
        String location = req.getParameter("location");
        String category = req.getParameter("category");
        String status = req.getParameter("status");
        String desc = req.getParameter("desc");

        jobs j = new jobs();
        j.setTitle(title);
        j.setLocation(location);
        j.setCategory(category);
        j.setStatus(status);
        j.setDescription(desc);

        JobDAO dao = new JobDAO(DBConnect.getConn());
        HttpSession session = req.getSession();

        if (dao.addJobs(j)) {
            session.setAttribute("succMsg", "Job Posted Successfully.");
        } else {
            session.setAttribute("succMsg", "Something went wrong.");
        }

        resp.sendRedirect("add_job.jsp");
    }
}
