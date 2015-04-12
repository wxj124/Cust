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
		// 1.��ȡ�û���id
		String id = request.getParameter("id");
		// 2.����service�и���id�����û���Ϣ�ķ���
		Cust cust = custservice.findCustById(id);
		if (cust == null) {
			throw new RuntimeException("�鲻�����û�");
		}
		// 3.�����ҵ�����Ϣ����request���У�����ת����updateCust.jspҳ��
		request.setAttribute("cust", cust);
		request.getRequestDispatcher("/updateCust.jsp").forward(request,
				response);
	}

}
