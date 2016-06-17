package org.shirdrn.platform.dubbo.service.rpc.server;
import java.io.IOException;
import org.junit.Ignore; 
import org.junit.Test;
import org.junit.Assert;
import org.junit.After;  
import org.junit.AfterClass;  
  
import org.junit.BeforeClass;  
  
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestSolrSearchServer {

	@Test
	@Ignore
	public void  start() throws IOException {
		//String config = SolrSearchServer.class.getPackage().getName().replace('.', '/') + "/search-provider.xml";
		String config =  "search-provider.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        System.in.read();
	}
	@Test
	public void testadd(){
	   int x= new SolrSearchServer().add(2, 2);
	   Assert.assertEquals(x, 4);
	
	}
}
