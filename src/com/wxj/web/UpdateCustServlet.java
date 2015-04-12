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

public class UpdateCustServlet extends HttpServlet {

	
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
		//1.封装数据，校验数据
			Cust cust = new Cust();
			BeanUtils.populate(cust, req.getParameterMap());
			//----单独处理爱好
			String [] prefs = req.getParameterValues("preference");
			StringBuffer buffer = new StringBuffer();
			for (String pref : prefs) {
				buffer.append(pref+",");
			}
			String pref = buffer.substring(0,buffer.length()-1);
			cust.setPreference(pref);
		//2.调用service方法修改数据
			custservice.updateCust(cust);
		//3.请求转发到客户列表
			req.getRequestDispatcher("/ListCustServlet").forward(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * Constructor of the object.
	 */
	public UpdateCustServlet() {
		super();
	}

}
