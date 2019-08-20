package com.crm.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.app.dao.CustomerDAO;

@WebServlet("/CreateCustomer")
public class CreateCustomer extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		String cfname = request.getParameter("cfname");
		String clname = request.getParameter("clname");
		String email = request.getParameter("email");
		
		CustomerDAO dao = new CustomerDAO();
		boolean isCustomerCreated = dao.createCustomer(cid,cfname,clname,email);
		if (isCustomerCreated==true) {
			request.setAttribute("isCustomerCreated", "Customer created success");
		}else {
			request.setAttribute("isCustomerCreated","Customer creation unsuccesfull");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/ReadAllCustomers");
		rd.forward(request, response);
	}

}
