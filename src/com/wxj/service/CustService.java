package com.wxj.service;

import java.util.List;

import com.wxj.domain.Cust;
import com.wxj.domain.Page;

public interface CustService {

	/**
	 * ��ӿͻ�
	 * 
	 * @param cust
	 *            ��װ�˿ͻ���Ϣ��bean
	 */
	void addCust(Cust cust);

	/**
	 * ��ѯ�����û���Ϣ
	 * 
	 * @return
	 */
	List<Cust> getAllCust();

	/**
	 * ����id�����û���Ϣ
	 * 
	 * @param id
	 * @return
	 */
	Cust findCustById(String id);
	/**
	 * �޸Ŀͻ���Ϣ
	 * @param cust
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
	 */
	void batchDel(String[] ids);
	/**
	 * ����������ѯ�ͻ���Ϣ
	 * @param cust��װ�˿ͻ���Ϣ���������Ա����ͣ�
	 * @return ���ؿͻ���Ϣ
	 */
	List<Cust> findCustByCond(Cust cust);
	/**
	 * ��ҳ��ѯ�ͻ���Ϣ
	 * @param thispage
	 * @param rowperpage
	 * @return
	 */
	Page pageCust(int thispage, int rowperpage);

}
