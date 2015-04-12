package com.wxj.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.wxj.domain.Cust;

public interface CustDao {
	/**
	 * 判断用户是否存在
	 * 
	 * @param name
	 * @return
	 */
	Cust findUserByName(String name);

	/**
	 * 添加客户信息
	 * 
	 * @param cust
	 */
	void addCust(Cust cust);

	/**
	 * 查询所有 用户的信息
	 * 
	 * @return
	 */
	List<Cust> getAllCust();

	/**
	 * 查找客户信息根据id
	 * @param id
	 * @return
	 */
	Cust findUserById(String id);
	/**
	 * 修改客户信息
	 * @param cust
	 * @return
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
	 * @throws SQLException 
	 */
	void delCustByIdWithTrans(Connection conn,String id) throws SQLException;
	/**
	 * 根据条件查询客户信息
	 * @param cust 封装了查找的客户的信息的bean
	 * @return 返回查询到的客户信息
	 */
	List<Cust> findCustByCond(Cust cust);
	/**
	 * 查询一共有多少条数据
	 * @return
	 */
	int getCountRow();
	/**
	 * 根据页码查询客户信息
	 * @param from 从那条记录取
	 * @param count 取多少个
	 * @return
	 */
	List<Cust> getCustByPage(int from, int count);


}
