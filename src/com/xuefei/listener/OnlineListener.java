package com.xuefei.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class OnlineListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		//获取属性名
		String name=arg0.getName();
		ServletContext servletcontext = arg0.getSession().getServletContext();
		if("user".equals(name)){		
				@SuppressWarnings("unchecked")
				Map<String,HttpSession> map = (Map<String,HttpSession>)servletcontext.getAttribute("Map");
				if(map==null){
					map=new HashMap<String,HttpSession>();
				}
				HttpSession session=arg0.getSession();
				map.put(session.getId(), session);
				servletcontext.setAttribute("Map", map);
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		String name=arg0.getName();
		ServletContext servletcontext = arg0.getSession().getServletContext();
		String id = arg0.getSession().getId();
		if("user".equals(name)){
				@SuppressWarnings("unchecked")
				Map<String,HttpSession> map = (Map<String,HttpSession>)servletcontext.getAttribute("Map");
				map.remove(id);
				servletcontext.setAttribute("Map", map);
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
	}

}
