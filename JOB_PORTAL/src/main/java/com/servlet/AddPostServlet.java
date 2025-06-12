package com.servlet;

import java.io.IOException;

import javax.print.attribute.standard.JobSheets;

import com.DB.DBConnect;
import com.dao.JobDAO;
import com.entity.jobs;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/add_job")
public class AddPostServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String title = req.getParameter("title");
			String location = req.getParameter("location");
			String category = req.getParameter("category");
			String status = req.getParameter("status");
			String desc = req.getParameter("desc");
				 
			
			jobs j=new jobs();
			j.setTitle(title);
			j.setLocation(location);
			j.setCategory(category);
			j.setStatus(status);
			j.setDescription(desc);
			
			
			HttpSession session=req.getSession()
;			JobDAO dao=new JobDAO(DBConnect.getConn());
			 boolean f= dao.addJobs(j);
			 if(f)
			 {
				 session.setAttribute("succMsg", "Job Post Successfully..");
				 resp.sendRedirect("add_job.jsp");
			 }
			else {
				session.setAttribute("succMsg", "Something went wrong");
				 resp.sendRedirect("add_job.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
