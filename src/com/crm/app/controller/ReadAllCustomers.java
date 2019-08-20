package com.crm.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.app.dao.CustomerDAO;
import com.crm.app.model.Customer;

@WebServlet("/ReadAllCustomers")
public class ReadAllCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDAO dao = new CustomerDAO();
		List<Customer> customers = dao.readAllCustomers();
		
		request.setAttribute("customers", customers);
		RequestDispatcher rd = request.getRequestDispatcher("list-customer.jsp");
		rd.forward(request, response);
	}


}
