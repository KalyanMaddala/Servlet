package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.vo.StudentVO;

public class StudentControllerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		StudentVO vo=null;
		String sno=null,sname=null,m1=null,m2=null,m3=null;
		StudentDTO dto=null;
		StudentService service=null;
		String result=null;
		PrintWriter pw=null;
	//	ServletOutputStream sos=null;
		
		//read form data
		sno=req.getParameter("no");
		sname=req.getParameter("name");
		m1=req.getParameter("m1");
		m2=req.getParameter("m2");
		m3=req.getParameter("m3");
		
		//create VO class object having form data
		vo=new StudentVO();
		vo.setSno(sno);
		vo.setSname(sname);
		vo.setM1(m1);
		vo.setM2(m2);
		vo.setM3(m3);
		//convert VO class object to DTO class object
		dto=new StudentDTO();
		dto.setSno(Integer.parseInt(vo.getSno()));
		dto.setSname(vo.getSname());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
		
		//use service class
		service=new StudentService();
		result=service.generateResult(dto);
		//display results
		//sos=res.getOutputStream();
		pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<h1>Result"+result+"</h1>");
		//add hyperlink
		pw.println("<a href='form.html'>Home</a>");
		//close streams
		pw.close();
	}//doGet
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		doGet(req,res);
		
	}//doPost

}//class
