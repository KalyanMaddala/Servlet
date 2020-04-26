package com.nt.initializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.nt.servlet.MarriageServlet;



public class MyWebApplnitializer implements ServletContainerInitializer {
	public void onStartup(java.util.Set<java.lang.Class<?>> set,
			ServletContext sc) throws ServletException{

			//create User-defined Servlet class object
		
             MarriageServlet servlet=new MarriageServlet();
             
			//register with Container

			ServletRegistration.Dynamic dynamic=sc.addServlet("marriage",servlet);

			//enable load on startup

			dynamic.setLoadOnStartup(1);

			//add url pattern

			dynamic.addMapping("/marriageurl");
	}

}
