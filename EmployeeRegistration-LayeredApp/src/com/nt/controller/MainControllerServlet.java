package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;
import com.nt.service.EmployeeMgmtServiceImpl;
import com.nt.vo.EmployeeVO;



public class MainControllerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		EmployeeVO vo=null;
		EmployeeDTO dto=null;
		String result=null;
		PrintWriter pw=null;
		
		 String  ename=null,eadd=null,deptNo=null,esalary=null;
	//	ServletOutputStream sos=null;
		
		//read form data
		 ename=req.getParameter("ename");
	     eadd=req.getParameter("eadd");
	     deptNo=req.getParameter("edeptNo");
	     esalary=req.getParameter("esalary");
		
	
		//create VO class object having form data
	        vo=new EmployeeVO();
	        vo.setEname(ename);
	        vo.setEadd(eadd);
	        vo.setDeptno(deptNo);
	        vo.setSalary(esalary);
		//convert VO class object to DTO class object
		dto=new EmployeeDTO();
		    dto=new EmployeeDTO();
	        dto.setEname(vo.getEname());
	        dto.setEadd(vo.getEadd());
	        dto.setDeptno(Integer.parseInt(vo.getDeptno()));
	        dto.setSalary(Float.parseFloat(vo.getSalary()));
		
		
		//use service class
	        EmployeeMgmtService service=new EmployeeMgmtServiceImpl();
				try {
					result=service.registerEmployee(dto);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		//display results
		//sos=res.getOutputStream();
		pw=res.getWriter();
		res.setContentType("text/html");
		
		    pw.println("<h1>Name    :: "+ename+"</h1>");
			pw.println("<h1>Address :: "+eadd+"</h1>");
			pw.println("<h1>DeptNo  :: "+deptNo+"</h1>");
			pw.println("<h1>Salary  :: "+esalary+"</h1>");
			pw.println("<h1>"+result+"</h1>");
		
		//add hyperlink
	    pw.println("<br> <a href='employee_register.html'>home</a>");
		//close streams
		pw.close();
	}//doGet
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		doGet(req,res);
	}//doPost

}//class
