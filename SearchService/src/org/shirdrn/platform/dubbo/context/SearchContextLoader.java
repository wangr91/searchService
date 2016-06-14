package org.shirdrn.platform.dubbo.context;
import javax.servlet.ServletContextEvent; 
import javax.servlet.ServletContextListener;  
import org.shirdrn.platform.dubbo.service.rpc.server.SolrSearchServer;
import org.springframework.context.support.ClassPathXmlApplicationContext; 
import org.springframework.web.context.ContextLoader;
public class SearchContextLoader extends ContextLoader implements ServletContextListener{
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub  } 
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		String config = arg0.getServletContext().getInitParameter("contextConfigLocation");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config); 
		context.start();
	}
}
