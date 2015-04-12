package com.wxj.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxj.factory.BasicDaoFactory;
import com.wxj.service.CustService;

public class BatchDelCustServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustService custservice = BasicDaoFactory.getFactory().getInstance(CustService.class);
		//1.获取批量删除的客户的id
		String [] ids = req.getParameterValues("delId");
		//2.调用service中批量删除客户的方法
		custservice.batchDel(ids);
		//3.重定向回到列表页面
		req.getRequestDispatcher("/ListCustServlet").forward(req, resp);
	}

	/**
	 * Constructor of the object.
	 */
	public BatchDelCustServlet() {
		super();
	}

}
