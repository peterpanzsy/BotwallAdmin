package cn.edu.xjtu.manage.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import cn.edu.xjtu.manage.business.ControlIp;
import cn.edu.xjtu.tools.HibernateSessionManager;

public class ControlIpDao {
	Session session ;
	 
	public ControlIpDao()
	{		
		session = HibernateSessionManager.getThreadLocalSession();
	}
	public void close() {
		// TODO Auto-generated method stub
		HibernateSessionManager.commitThreadLocalTransaction();
		HibernateSessionManager.closeThreadLocalSession();
	}

	public void roll() {
		// TODO Auto-generated method stub
		HibernateSessionManager.rollbackThreadLocalTransaction();
		HibernateSessionManager.closeThreadLocalSession();
	}


	public void initDao()
	{	
		session = HibernateSessionManager.getThreadLocalSession();
	
	}	
	public List<ControlIp> getControlIpList() {
		SQLQuery q = session.createSQLQuery("SELECT t.id,t.ip,t.remark FROM t_adminip t");
		List l = q.list();
		List<ControlIp> re=new ArrayList<ControlIp>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);;
			  Integer id = (Integer)row[0];
			  String ip = (String)row[1];  
			  String remark=(String)row[2];
			  int order=i+1;
			  ControlIp controlIp=new ControlIp(order,id, ip,remark);	 
			  re.add(controlIp);
		}
		return re;
	}
	
	public int getCountControlIp(){

		String sql="select count(*) from t_adminip t ";
		SQLQuery q = session.createSQLQuery(sql);
		Integer count=((BigInteger)q.uniqueResult()).intValue();
		return count;
	}
	
	public int addControlIp(String ip,String remark){
		HibernateSessionManager.getThreadLocalTransaction();
		Query q = session.createSQLQuery("insert into t_adminip (ip,remark) values (?,?)");
		q.setParameter(0, ip);
		q.setParameter(1, remark);
		int result=q.executeUpdate();
		return result;
	}
	
	public int deleteControlIp(int id) {
		HibernateSessionManager.getThreadLocalTransaction();
		SQLQuery q = session.createSQLQuery("delete from t_adminip where ID=?");
		q.setParameter(0, id);
		int re=q.executeUpdate();
		return re;
		
	}

}
