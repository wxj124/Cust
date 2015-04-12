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
		//1.��ȡҪɾ���Ŀͻ���id
		String id = req.getParameter("id");
		//2.����service�����и���idɾ���ͻ��ķ���
		custservice.delCustById(id);
		//3.����ת�����б�ҳ��
		req.getRequestDispatcher("/ListCustServlet").forward(req, resp);
	}

}
