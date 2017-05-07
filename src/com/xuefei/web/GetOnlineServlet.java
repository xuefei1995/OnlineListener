package com.xuefei.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xuefei.entity.UserMessage;

public class GetOnlineServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext servletContext = this.getServletContext();
		@SuppressWarnings("unchecked")
		Map<String,HttpSession> map = (Map<String,HttpSession>)servletContext.getAttribute("Map");
		List<UserMessage> list=new ArrayList<UserMessage>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if(map!=null){//这步要加判断，因为可能发生空指针异常
			for (Entry<String , HttpSession> entry : map.entrySet()) {
				UserMessage us=new UserMessage();
				us.setSessionid(entry.getKey());
				HttpSession session = entry.getValue();
				us.setName((String)session.getAttribute("user"));
				us.setIp((String)session.getAttribute("ip"));
				us.setLogintime(sdf.format(new Date(session.getCreationTime())));
				us.setLasttime(sdf.format(new Date(session.getLastAccessedTime())));
				list.add(us);
			}
		}
		request.setAttribute("userlist", list);
		request.getRequestDispatcher("/online.jsp").forward(request, response);		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
