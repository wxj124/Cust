package com.wxj.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxj.domain.Cust;
import com.wxj.factory.BasicDaoFactory;
import com.wxj.service.CustService;

public class CustInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustService custservice = BasicDaoFactory.getFactory().getInstance(
				CustService.class);
		// 1.获取用户的id
		String id = request.getParameter("id");
		// 2.调用service中根据id查找用户信息的方法
		Cust cust = custservice.findCustById(id);
		if (cust == null) {
			throw new RuntimeException("查不到此用户");
		}
		// 3.将查找到的信息存在request域中，请求转发到updateCust.jsp页面
		request.setAttribute("cust", cust);
		request.getRequestDispatcher("/updateCust.jsp").forward(request,
				response);
	}

}
