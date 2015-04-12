package com.wxj.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.wxj.domain.Cust;
import com.wxj.factory.BasicDaoFactory;
import com.wxj.service.CustService;

public class addCustServlet extends HttpServlet {

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
		resp.setContentType("text/html;charset=utf8");
		CustService custservice = BasicDaoFactory.getFactory().getInstance(CustService.class);
		try { 
			//1.��װ���ݣ�У������
			Cust cust = new Cust();
			BeanUtils.populate(cust, req.getParameterMap());//��jspҳ���õ�������ֲ��cust
			//----����������
			String [] prefs = req.getParameterValues("preference");
			StringBuffer buffer = new StringBuffer();//���л�
			for (String pref : prefs) {
				buffer.append(pref+",");
			}
			String pref = buffer.substring(0,buffer.length()-1);
			cust.setPreference(pref);
			
			//2.����service�еķ�����ӿͻ�
			custservice.addCust(cust);
			
			//3.�ض������ҳ
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * Constructor of the object.
	 */
	public addCustServlet() {
		super();
	}

}
