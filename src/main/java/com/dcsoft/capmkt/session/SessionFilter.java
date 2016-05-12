package com.dcsoft.capmkt.session;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest servletRequest = ((HttpServletRequest)request);
		if(!servletRequest.getSession().isNew()){
		if (servletRequest.getRequestedSessionId() != null
		        && !servletRequest.isRequestedSessionIdValid()) {
		    System.out.println("Session is expired from the filter **********************************, Redirecting to login page");
		    ((HttpServletResponse)response).sendRedirect("/CapitalMkt");
		}
		chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
