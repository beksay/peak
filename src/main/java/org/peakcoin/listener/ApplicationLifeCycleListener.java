package org.peakcoin.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.peakcoin.singleton.Configuration;
import org.peakcoin.util.MailSender;

/***
 * 
 * @author Kuttubek Aidaraliev
 *
 */

public class ApplicationLifeCycleListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		MailSender.destroy();
	}

	public void contextInitialized(ServletContextEvent arg0) {
		Configuration.getInstance();
	}

}
