package com.xuefei.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KickoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("sessionid");
		@SuppressWarnings("unchecked")
		Map<String,HttpSession> map = (Map<String,HttpSession>)this.getServletContext().getAttribute("Map");
		HttpSession session = map.get(id);
		if(session!=null){
			session.removeAttribute("user");
			session.removeAttribute("ip");
		}
		response.sendRedirect(request.getContextPath()+"/GetOnlineServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
