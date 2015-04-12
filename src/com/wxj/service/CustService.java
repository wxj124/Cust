package com.wxj.service;

import java.util.List;

import com.wxj.domain.Cust;
import com.wxj.domain.Page;

public interface CustService {

	/**
	 * 添加客户
	 * 
	 * @param cust
	 *            封装了客户信息的bean
	 */
	void addCust(Cust cust);

	/**
	 * 查询所有用户信息
	 * 
	 * @return
	 */
	List<Cust> getAllCust();

	/**
	 * 根据id查找用户信息
	 * 
	 * @param id
	 * @return
	 */
	Cust findCustById(String id);
	/**
	 * 修改客户信息
	 * @param cust
	 */
	void updateCust(Cust cust);
	/**
	 * 根据id删除客户信息
	 * @param id
	 */
	void delCustById(String id);
	/**
	 * 批量删除客户信息
	 * @param ids
	 */
	void batchDel(String[] ids);
	/**
	 * 根据条件查询客户信息
	 * @param cust封装了客户信息（姓名，性别，类型）
	 * @return 返回客户信息
	 */
	List<Cust> findCustByCond(Cust cust);
	/**
	 * 分页查询客户信息
	 * @param thispage
	 * @param rowperpage
	 * @return
	 */
	Page pageCust(int thispage, int rowperpage);

}
