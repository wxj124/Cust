package com.wxj.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.wxj.dao.CustDao;
import com.wxj.domain.Cust;
import com.wxj.domain.Page;
import com.wxj.factory.BasicDaoFactory;
import com.wxj.utils.DaoUtils;

public class CustServiceImpl implements CustService {
	CustDao custdao = BasicDaoFactory.getFactory().getInstance(CustDao.class);

	@Override
	public void addCust(Cust cust) {
		// 1.检查客户信息是否存在
		if (custdao.findUserByName(cust.getName()) != null) {
			throw new RuntimeException("用户已存在！！！");
		}
		// 2.调用dao中的方法添加客户信息
		custdao.addCust(cust);
	}

	@Override
	public List<Cust> getAllCust() {
		return custdao.getAllCust();
	}

	@Override
	public Cust findCustById(String id) {
		return custdao.findUserById(id);
	}

	@Override
	public void updateCust(Cust cust) {
		custdao.updateCust(cust);
	}

	@Override
	public void delCustById(String id) {
		custdao.delCustById(id);
	}
//批量删除
	@Override
	public void batchDel(String[] ids) {
		Connection conn=DaoUtils.getConn();
		try {
			conn.setAutoCommit(false);
			for (String id:ids) {
				custdao.delCustByIdWithTrans(conn,id);;
			}
			DbUtils.commitAndCloseQuietly(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
//条件查询客户信息
	@Override
	public List<Cust> findCustByCond(Cust cust) {
		// TODO Auto-generated method stub
		return custdao.findCustByCond(cust);
	}
//分页查询
	@Override
	public Page pageCust(int thispage, int rowperpage) {
		// TODO Auto-generated method stub
		Page page = new Page();
		//当前页
		page.setThispage(thispage);
		//每页记录数
		page.setRowperpage(rowperpage);
		//行数
		int countrow = custdao.getCountRow();
		page.setCountrow(countrow);
		//页数
		int countpage=countrow/rowperpage+(countrow%rowperpage==0?0:1);
		page.setCountpage(countpage);
		//首页
		page.setFirstpage(1);
		//尾页
		page.setLastpage(countpage);
		//上一页
		page.setPrepage(thispage==1?1:thispage-1);
		//下一页
		page.setNextpage(thispage==countpage?countpage:thispage+1);
		//当前页数据
		List<Cust> list = custdao.getCustByPage((thispage-1)*rowperpage,rowperpage);
		page.setList(list);
		
		return page;
	}

}
