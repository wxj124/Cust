package com.wxj.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.wxj.domain.Cust;
import com.wxj.utils.DaoUtils;

public class CustDaoImpl implements CustDao {

	@Override
	public Cust findUserByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from t_customer where name=?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSource());
			return runner.query(sql, new BeanHandler<Cust>(Cust.class), name);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void addCust(Cust cust) {
		// TODO Auto-generated method stub
		String sql = "insert into t_customer values(null,?,?,?,?,?,?,?,?)";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSource());
			runner.update(sql, cust.getName(), cust.getGender(),
					cust.getBirthday(), cust.getCellphone(), cust.getEmail(),
					cust.getPreference(), cust.getType(), cust.getDescription());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Cust> getAllCust() {
		// TODO Auto-generated method stub
		String sql = "select * from t_customer";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSource());
			return runner.query(sql, new BeanListHandler<Cust>(Cust.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public Cust findUserById(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from t_customer where id=?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSource());
			return runner.query(sql, new BeanHandler<Cust>(Cust.class), id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateCust(Cust cust) {
		// TODO Auto-generated method stub
		String sql = "update t_customer set name=?,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id=?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSource());
			runner.update(sql, cust.getName(), cust.getGender(),
					cust.getBirthday(), cust.getCellphone(), cust.getEmail(),
					cust.getPreference(), cust.getType(),
					cust.getDescription(), cust.getId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delCustById(String id) {
		String sql = "delete from t_customer where id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSource());
			runner.update(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	// 批量删除
	@Override
	public void delCustByIdWithTrans(Connection conn, String id)
			throws SQLException {
		String sql = "delete from t_customer where id = ?";
		QueryRunner runner = new QueryRunner();
		runner.update(conn, sql, id);

	}
	//条件查询
	@Override
	public List<Cust> findCustByCond(Cust cust) {
		// TODO Auto-generated method stub
		String sql = "select * from t_customer where 1=1";
		List<Object> list = new ArrayList<Object>();
		if (cust.getName() != null && !"".equals(cust.getName())) {
			sql += " and name like ? ";
			list.add("%" + cust.getName() + "%");
		}
		if (cust.getGender() != null && !"".equals(cust.getGender())) {
			sql += " and gender=? "; 
			list.add(cust.getGender());
		}
		if (cust.getType() != null && !"".equals(cust.getType())) {
			sql += " and type=? ";
			list.add(cust.getType());
		}
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSource());
			if (list.size() <= 0) {
				return runner.query(sql, new BeanListHandler<Cust>(Cust.class));
			} else {
				return runner.query(sql, new BeanListHandler<Cust>(Cust.class),
						list.toArray());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	//查询数据总数
	@Override
	public int getCountRow() {
		// TODO Auto-generated method stub
		try {
			String sql="select count(*) from t_customer";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSource());
			return ((Long)runner.query(sql, new ScalarHandler())).intValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	//查询当前页信息

	@Override
	public List<Cust> getCustByPage(int from, int count) {
		// TODO Auto-generated method stub
		String sql="select * from t_customer limit ?,?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSource());
			return runner.query(sql, new BeanListHandler<Cust>(Cust.class),from,count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

}
