package com.org.data.rtrv.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.org.database.manager.DataBaseManager;


@WebServlet(description="Data Information", urlPatterns={"/datainfo"})
public class DataInfoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5871973317715139464L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		
		String info = req.getParameter("PORT");
		if(null!=info && info.equals("PORT")){
			String  port = getPortForIp(req.getParameter("IP"));
			JSONObject obj = new JSONObject();
			try {
				obj.put("PORT", port);
				writer.write(obj.toString());
		    	writer.flush();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	private String getPortForIp(String ip){
		return DataBaseManager.getInstance().getPortForIp(ip);
	}
	
	
}
