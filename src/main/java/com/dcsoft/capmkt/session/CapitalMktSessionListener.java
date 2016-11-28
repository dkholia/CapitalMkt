package com.dcsoft.capmkt.session;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CapitalMktSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		httpSessionEvent.getSession().removeAttribute("status");
		httpSessionEvent.getSession().invalidate();
	}

}
