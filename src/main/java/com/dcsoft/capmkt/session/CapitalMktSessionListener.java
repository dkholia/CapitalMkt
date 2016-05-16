package com.dcsoft.capmkt.session;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CapitalMktSessionListener implements HttpSessionListener {

	private static int activeSessions;
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		activeSessions++;
		System.out.println("Session is created *****************************************");
		log.info("Session created");
		System.out.println("Number of active sessions " + getActiveSessions());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		activeSessions--;
		
		System.out.println("Session is expired *****************************************");
		httpSessionEvent.getSession().removeAttribute("status");
		httpSessionEvent.getSession().invalidate();
		log.info("Session destroyed");
		
		System.out.println("Number of active sessions " + getActiveSessions());
		
	}

	public static int getActiveSessions() {
		return activeSessions;
	}

	public static void setActiveSessions(int activeSessions) {
		CapitalMktSessionListener.activeSessions = activeSessions;
	}
}
