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

import cn.edu.xjtu.manage.business.WhiteIp;
import cn.edu.xjtu.tools.HibernateSessionManager;

public class WhiteIpDao {
	Session session ;
	 
	public WhiteIpDao()
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
	public List<WhiteIp> getWhiteIpList() {
		SQLQuery q = session.createSQLQuery("SELECT t.id,t.ip,t.remark,t.ifrunning FROM t_whiteip t");
		List l = q.list();
		List<WhiteIp> re=new ArrayList<WhiteIp>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);;
			  Integer id = (Integer)row[0];
			  String ip = (String)row[1];  
			  String remark=(String)row[2];
			  int ifrunning=(Integer)row[3];
			  int order=i+1;
			  WhiteIp whiteIp=new WhiteIp(order,id, ip,remark,ifrunning);	 
			  re.add(whiteIp);
		}
		return re;
	}
	
	public int getCountWhiteIp(){

		String sql="select count(*) from t_whiteip t ";
		SQLQuery q = session.createSQLQuery(sql);
		Integer count=((BigInteger)q.uniqueResult()).intValue();
		return count;
	}
	
	public int addWhiteIp(String ip,String remark,int ifrunning){
		HibernateSessionManager.getThreadLocalTransaction();
		Query q = session.createSQLQuery("insert into t_whiteip (ip,remark,ifrunning) values (?,?,?)");
		q.setParameter(0, ip);
		q.setParameter(1, remark);
		q.setParameter(2,ifrunning);
		int result=q.executeUpdate();
		return result;
	}
	
	public int deleteWhiteIp(int id) {
		HibernateSessionManager.getThreadLocalTransaction();
		SQLQuery q = session.createSQLQuery("delete from t_whiteip where ID=?");
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

			  Object[] row = (Object[])l.get(i);
			  Integer id = (Integer)row[0];
			  String name = (String)row[1];  
			  System.out.println(id+" "+name);
		}
	}
	
	
}
