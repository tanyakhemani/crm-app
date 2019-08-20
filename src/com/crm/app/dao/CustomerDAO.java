package com.crm.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.crm.app.model.Customer;

public class CustomerDAO {

	public boolean createCustomer(int cid, String cfname, String clname, String email) {
		boolean isCustomerCreated = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_db?serverTimezone=UTC",
					"root", "tanya123");

			PreparedStatement pst = con.prepareStatement("insert into customer values(?,?,?,?) ON DUPLICATE KEY UPDATE cfname = ?, clname = ?, email=?");
			pst.setInt(1, cid);
			pst.setString(2, cfname);
			pst.setString(3, clname);
			pst.setString(4, email);
			pst.setString(5, cfname);
			pst.setString(6, clname);
			pst.setString(7, email);

			int count = pst.executeUpdate();

			if (count > 0) {
				isCustomerCreated = true;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isCustomerCreated;
	}

	public Customer getCustomer(int cid) {
		Customer c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_db?serverTimezone=UTC",
					"root", "tanya123");

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("select * from customer where cid = " + cid);

			if (rs.next()) {
				c = new Customer();
				c.setCid(rs.getInt("cid"));
				c.setCfname(rs.getString("cfname"));
				c.setClname(rs.getString("clname"));
				c.setEmail(rs.getString("email"));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}

	public boolean deleteCustomer(int cid) {
		boolean isCustomerDeleted = false;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_db?serverTimezone=UTC",
					"root", "tanya123");

			Statement st = con.createStatement();

			int count = st.executeUpdate("delete from Customer where cid= " + cid);

			if (count > 0) {
				isCustomerDeleted = true;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isCustomerDeleted;

	}

	public boolean updateCustomer(int cid, String cfname, String clname, String email) {
		boolean isCustomerUpdated = false;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_db?serverTimezone=UTC",
					"root", "tanya123");

			PreparedStatement pst = con.prepareStatement("update customer set cfname = ?, clname=?, email=? where cid = ?");
			pst.setString(1, cfname);
			pst.setString(2, clname);
			pst.setString(3, email);
			pst.setInt(4, cid);

			int count = pst.executeUpdate();

			if (count > 0) {
				isCustomerUpdated = true;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isCustomerUpdated;
	}

	public List<Customer> readAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		Customer c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_db?serverTimezone=UTC",
					"root", "tanya123");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from customer");

			while (rs.next()) {
				c = new Customer();
				c.setCid(rs.getInt("cid"));
				c.setCfname(rs.getString("cfname"));
				c.setClname(rs.getString("clname"));
				c.setEmail(rs.getString("email"));
				customers.add(c);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customers;
	}
}
