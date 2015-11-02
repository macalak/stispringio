package ite.librarymaster.web.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class SessionAuditor implements HttpSessionListener{
	final Logger logger = LoggerFactory.getLogger(SessionAuditor.class);
	final static private String AUDIT_LEVEL = "AUDIT_LEVEL";

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		logger.info("HTTP Session created.");
		HttpSession session = se.getSession();
		ServletContext servletContext = session.getServletContext();
		String auditLevel = servletContext.getInitParameter(AUDIT_LEVEL);
		if(auditLevel != null && "FINE".equals(auditLevel)){
			StringBuffer message = new StringBuffer("Session Audit:\n");
			message.append("Creation time:").append(new Date(session.getCreationTime())).append("\n");
			message.append("ID:").append(session.getId()).append("\n");
			logger.info(message.toString());
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		logger.info("HTTP Session destroyed.");
		
	}

}
