package com.wxj.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.wxj.domain.Cust;
import com.wxj.factory.BasicDaoFactory;
import com.wxj.service.CustService;

public class FindCustByCondServelt extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FindCustByCondServelt() {
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
		req.setCharacterEncoding("utf-8");
		CustService custservice = BasicDaoFactory.getFactory().getInstance(CustService.class);
		try {
			//1.获取查询的条件,封装到bean中
			Cust cust = new Cust();
			BeanUtils.populate(cust, req.getParameterMap());
			//2.调用service方法中条件查询的方法
			List<Cust> list = custservice.findCustByCond(cust);
			//3.将查询到的信息存到request域中，回到列表页面显示
			req.setAttribute("list", list);
			req.getRequestDispatcher("/listCust.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	

}
