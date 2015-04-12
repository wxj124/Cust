package com.wxj.web;

import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxj.factory.BasicDaoFactory;
import com.wxj.service.CustService;

public class DelCustServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DelCustServlet() {
		super();
	}

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
		//1.获取要删除的客户的id
		String id = req.getParameter("id");
		//2.调用service方法中根据id删除客户的方法
		custservice.delCustById(id);
		//3.请求转发会列表页面
		req.getRequestDispatcher("/ListCustServlet").forward(req, resp);
	}

}
