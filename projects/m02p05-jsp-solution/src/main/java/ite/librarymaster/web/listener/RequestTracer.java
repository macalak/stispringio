package ite.librarymaster.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class RequestTracer implements ServletRequestListener {
	final Logger logger = LoggerFactory.getLogger(RequestTracer.class);
	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		logger.info("HTTP Request initialized.");
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		StringBuffer message = new StringBuffer("Request trace:\n");
		message.append("	Server Info:").append(sre.getServletContext().getServerInfo()).append("\n");
		message.append("	Character encoding:").append(sre.getServletRequest().getCharacterEncoding());
		logger.info(message.toString());
		logger.info("HTTP Request destroyed.");
	}
}
