package com.dcsoft.capmkt.session;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.sun.istack.internal.logging.Logger;

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
	public void sessionDestroyed(HttpSessionEvent arg0) {
		activeSessions--;
		System.out.println("Session is expired *****************************************");
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
