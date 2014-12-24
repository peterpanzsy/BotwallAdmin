package cn.edu.xjtu.manage.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import cn.edu.xjtu.manage.business.HoneyPot;
import cn.edu.xjtu.tools.HibernateSessionManager;

public class HoneyPotDao {
	Session session ;
	 
	public HoneyPotDao()
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
	public List<HoneyPot> getHoneyPotList() {
		SQLQuery q = session.createSQLQuery("SELECT t.id,t.ip FROM t_pot t");
		List l = q.list();
		List<HoneyPot> re=new ArrayList<HoneyPot>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);;
			  Integer id = (Integer)row[0];
			  String ip = (String)row[1];  
			  int order=i+1;
			  HoneyPot pot=new HoneyPot(order,id, ip);	 
			  re.add(pot);
		}
		return re;
	}
	
	public int getCountPot(){

		String sql="select count(*) from t_pot t ";
		SQLQuery q = session.createSQLQuery(sql);
		Integer count=((BigInteger)q.uniqueResult()).intValue();
		return count;
	}
	
	public int addPot(String ip){
		HibernateSessionManager.getThreadLocalTransaction();
		Query q = session.createSQLQuery("insert into t_pot (ip) values (?)");
		q.setParameter(0, ip);
		int result=q.executeUpdate();
		return result;
	}
	
	public int deletePot(int id) {
		HibernateSessionManager.getThreadLocalTransaction();
		SQLQuery q = session.createSQLQuery("delete from t_pot where ID=?");
		q.setParameter(0, id);
		int re=q.executeUpdate();
		return re;
		
	}
	//遍历
	public  void all()
	{
		Query q = session.createSQLQuery("select id,name from Test");
		
		List l = q.list();
		for(int i=0;i<l.size();i++)
		{
			//TestDb user = (TestDb)l.get(i);
			//System.out.println(user.getUsername());

			  Object[] row = (Object[])l.get(i);;
			  Integer id = (Integer)row[0];
			  String name = (String)row[1];  
			  System.out.println(id+" "+name);
		}
	}
	
}
