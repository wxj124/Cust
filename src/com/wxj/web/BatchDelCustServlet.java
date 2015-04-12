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
		//1.��ȡ����ɾ���Ŀͻ���id
		String [] ids = req.getParameterValues("delId");
		//2.����service������ɾ���ͻ��ķ���
		custservice.batchDel(ids);
		//3.�ض���ص��б�ҳ��
		req.getRequestDispatcher("/ListCustServlet").forward(req, resp);
	}

	/**
	 * Constructor of the object.
	 */
	public BatchDelCustServlet() {
		super();
	}

}
