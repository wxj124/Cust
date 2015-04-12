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
		// 1.���ͻ���Ϣ�Ƿ����
		if (custdao.findUserByName(cust.getName()) != null) {
			throw new RuntimeException("�û��Ѵ��ڣ�����");
		}
		// 2.����dao�еķ�����ӿͻ���Ϣ
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
//����ɾ��
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
//������ѯ�ͻ���Ϣ
	@Override
	public List<Cust> findCustByCond(Cust cust) {
		// TODO Auto-generated method stub
		return custdao.findCustByCond(cust);
	}
//��ҳ��ѯ
	@Override
	public Page pageCust(int thispage, int rowperpage) {
		// TODO Auto-generated method stub
		Page page = new Page();
		//��ǰҳ
		page.setThispage(thispage);
		//ÿҳ��¼��
		page.setRowperpage(rowperpage);
		//����
		int countrow = custdao.getCountRow();
		page.setCountrow(countrow);
		//ҳ��
		int countpage=countrow/rowperpage+(countrow%rowperpage==0?0:1);
		page.setCountpage(countpage);
		//��ҳ
		page.setFirstpage(1);
		//βҳ
		page.setLastpage(countpage);
		//��һҳ
		page.setPrepage(thispage==1?1:thispage-1);
		//��һҳ
		page.setNextpage(thispage==countpage?countpage:thispage+1);
		//��ǰҳ����
		List<Cust> list = custdao.getCustByPage((thispage-1)*rowperpage,rowperpage);
		page.setList(list);
		
		return page;
	}

}
