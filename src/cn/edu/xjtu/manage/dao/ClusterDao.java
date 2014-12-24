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

import cn.edu.xjtu.manage.business.Cluster;
import cn.edu.xjtu.manage.business.DB;
import cn.edu.xjtu.manage.business.HoneyPot;
import cn.edu.xjtu.tools.HibernateSessionManager;

public class ClusterDao {
	 Session session ;
	 
	public ClusterDao()
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
	
	public int updateParameter(int id, String interval) {
		HibernateSessionManager.getThreadLocalTransaction();
		// TODO Auto-generated method stub
		if(id<1){
			Query q = session.createSQLQuery("insert into t_cluster(cluster_interval) values (?)");
			q.setParameter(0, interval);
			int result=q.executeUpdate();
			return result;
		}else{
			SQLQuery q = session.createSQLQuery("update t_cluster t set t.cluster_interval=? where t.ID=?");
			q.setParameter(0, interval);
			q.setParameter(1, id);
			int re=q.executeUpdate();
			return re;
		}
	}
	
	public List<Cluster> getParameter() {
		SQLQuery q = session.createSQLQuery("SELECT t.id,t.cluster_interval FROM t_cluster t ");
		q.setFirstResult(0).setMaxResults(1);
		List l = q.list();
		List<Cluster> re=new ArrayList<Cluster>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);;
			  Integer id = (Integer)row[0];
			  String interval = (String)row[1];  					
			  Cluster cluster=new Cluster(id, interval);	 
			  re.add(cluster);
		}
		return re;
	}
	
}
