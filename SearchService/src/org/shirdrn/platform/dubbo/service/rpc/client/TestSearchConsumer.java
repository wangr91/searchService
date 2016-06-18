package org.shirdrn.platform.dubbo.service.rpc.client;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Before;
import org.junit.Test;
import org.shirdrn.platform.dubbo.service.rpc.api.SolrSearchService.ResponseType;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.After;  
import org.junit.AfterClass;  
import org.junit.Assert;   
import org.junit.BeforeClass;  
import org.junit.Ignore;  

public class TestSearchConsumer {
	final String collection = "tinycollection";
	final String beanXML = "search-consumer.xml";
	final String config = beanXML;
	SearchConsumer consumer;
	
	@Before
	public void initialize() {
		consumer = new SearchConsumer(collection, new Callable<AbstractXmlApplicationContext>() {
			public AbstractXmlApplicationContext call() throws Exception {
				final AbstractXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
				return context;
			}
		});
	}
	

	
	@Test
	public void syncCall() throws Exception {
		String q = "q=shanghai&fl=*&fq=building_type:1";
		int start = 0;
		int rows = 10;
		ResponseType type  = ResponseType.XML;
		for (int i = 0; i < 3; i++) {
			start = 1 * 10 * i;
			if(i % 2 == 0) {
				type = ResponseType.XML;
			} else {
				type = ResponseType.JSON;
			}
			String result = consumer.toString();
			System.out.println("Result: " + result);
			
		     
		}
	}
	
}
