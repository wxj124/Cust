package com.wxj.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.wxj.domain.Cust;

public interface CustDao {
	/**
	 * �ж��û��Ƿ����
	 * 
	 * @param name
	 * @return
	 */
	Cust findUserByName(String name);

	/**
	 * ��ӿͻ���Ϣ
	 * 
	 * @param cust
	 */
	void addCust(Cust cust);

	/**
	 * ��ѯ���� �û�����Ϣ
	 * 
	 * @return
	 */
	List<Cust> getAllCust();

	/**
	 * ���ҿͻ���Ϣ����id
	 * @param id
	 * @return
	 */
	Cust findUserById(String id);
	/**
	 * �޸Ŀͻ���Ϣ
	 * @param cust
	 * @return
	 */
	void updateCust(Cust cust);
	/**
	 * ����idɾ���ͻ���Ϣ
	 * @param id
	 */
	void delCustById(String id);
	/**
	 * ����ɾ���ͻ���Ϣ
	 * @param ids
	 * @throws SQLException 
	 */
	void delCustByIdWithTrans(Connection conn,String id) throws SQLException;
	/**
	 * ����������ѯ�ͻ���Ϣ
	 * @param cust ��װ�˲��ҵĿͻ�����Ϣ��bean
	 * @return ���ز�ѯ���Ŀͻ���Ϣ
	 */
	List<Cust> findCustByCond(Cust cust);
	/**
	 * ��ѯһ���ж���������
	 * @return
	 */
	int getCountRow();
	/**
	 * ����ҳ���ѯ�ͻ���Ϣ
	 * @param from ��������¼ȡ
	 * @param count ȡ���ٸ�
	 * @return
	 */
	List<Cust> getCustByPage(int from, int count);


}
