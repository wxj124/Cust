package com.wxj.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxj.domain.Cust;
import com.wxj.domain.Page;
import com.wxj.factory.BasicDaoFactory;
import com.wxj.service.CustService;

public class PageCustServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PageCustServlet() {
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
		//1，获取当前要显示的页和每页记录数
		int thispage = Integer.parseInt(req.getParameter("thispage"));
		int rowperpage = 5;
		//2.调用service中分页查询客户的方法，查询客户信息
		Page page = custservice.pageCust(thispage,rowperpage);
		//3.存入request域中，带到pageList.jsp页面进行显示
		req.setAttribute("page", page);
		req.getRequestDispatcher("/pageList.jsp").forward(req, resp);
	}

}
