package com.org.enrolled.deenrolled.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.org.database.manager.DataBaseManager;


@WebServlet(description="Deenrollment" , urlPatterns={"/deEnroll"})
public class DeEnrolledServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2482237929353762301L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//	System.out.println("****"+ip);
		resp.setContentType("application/json");
		PrintWriter writer = resp.getWriter();
		String ip = req.getParameter("ip");
		DataBaseManager.getInstance().deEnrollElement(ip);
		JSONObject obj = new JSONObject();
		try {
			obj.put("Result","Success");
			writer.write(obj.toString());
	    	writer.flush();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
