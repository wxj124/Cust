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
		//1����ȡ��ǰҪ��ʾ��ҳ��ÿҳ��¼��
		int thispage = Integer.parseInt(req.getParameter("thispage"));
		int rowperpage = 5;
		//2.����service�з�ҳ��ѯ�ͻ��ķ�������ѯ�ͻ���Ϣ
		Page page = custservice.pageCust(thispage,rowperpage);
		//3.����request���У�����pageList.jspҳ�������ʾ
		req.setAttribute("page", page);
		req.getRequestDispatcher("/pageList.jsp").forward(req, resp);
	}

}
