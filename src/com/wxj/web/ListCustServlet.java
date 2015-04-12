package com.wxj.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxj.domain.Cust;
import com.wxj.factory.BasicDaoFactory;
import com.wxj.service.CustService;

public class ListCustServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustService custservice = BasicDaoFactory.getFactory().getInstance(CustService.class);
		//1.����service�еķ�����ѯ���пͻ�
		List<Cust> list = custservice.getAllCust();
		//2.����ѯ�������ݴ浽request���У�����ת����listCust.jspҳ��
		request.setAttribute("list", list);
		request.getRequestDispatcher("/listCust.jsp").forward(request, response);
	}

}
