package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;

public class UploadServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=null;
		MultipartFormDataRequest nreq =null;
		UploadBean upload=null;
		Hashtable ht=null;
		Enumeration e=null;
		//general Settings
		pw=res.getWriter();
		res.setContentType("text/html");
		try {
			//prepare special request object
			nreq=new MultipartFormDataRequest(req);
			//specify file uploaading settings
			upload=new UploadBean();
			upload.setFolderstore("C:/store");
			upload.setOverwrite(false);
			//complete file upload
			upload.store(nreq);
			//Display the names of uploaded files
			pw.println("<h1>The Uploaded files are </h1>");
			ht=nreq.getFiles();
			e=ht.elements();
			while(e.hasMoreElements()) {
				UploadFile file=(UploadFile)e.nextElement();
				pw.println("<br>"+file.getFileName()+" "+file.getFileSize());
		    }//while 
		}//try
		catch(Exception ea) {
			ea.printStackTrace();
		}
	}//doPost(-,-)
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		doPost(req,res);
		
	}
}//class
