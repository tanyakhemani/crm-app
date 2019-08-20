package com.crm.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.app.dao.CustomerDAO;
import com.crm.app.model.Customer;

/**
 * Servlet implementation class ReadCustomer
 */
@WebServlet("/FormPopulateCustomer")
public class FormPopulateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		
		CustomerDAO dao = new CustomerDAO();
		Customer customer = dao.getCustomer(cid);
		request.setAttribute("customer", customer);
		RequestDispatcher rd = request.getRequestDispatcher("form-customer.jsp");
		rd.forward(request, response);
	}

}
