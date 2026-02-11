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

@WebServlet("/update")
public class Updatejobservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String location = req.getParameter("location");
        String category = req.getParameter("category");
        String status = req.getParameter("status");
        String desc = req.getParameter("desc");

        jobs j = new jobs();
        j.setId(id);
        j.setTitle(title);
        j.setLocation(location);
        j.setCategory(category);
        j.setStatus(status);
        j.setDescription(desc);

        JobDAO dao = new JobDAO(DBConnect.getConn());
        HttpSession session = req.getSession();

        if (dao.updatejob(j)) {
            session.setAttribute("succMsg", "Job Updated Successfully.");
        } else {
            session.setAttribute("succMsg", "Something went wrong.");
        }

        resp.sendRedirect("viewjob.jsp");
    }
}
