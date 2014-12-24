package cn.edu.xjtu.manage.dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import cn.edu.xjtu.manage.business.License;
import cn.edu.xjtu.tools.HibernateSessionManager;

public class LicenseDao {
	 Session session ;
	 
	public LicenseDao()
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
		
	public int updateLicense(int id, String license,Date expires,int isvalid) {
		HibernateSessionManager.getThreadLocalTransaction();
		if(id<1){
			Query q = session.createSQLQuery("insert into t_license(license,expires,isvalid) values (?,?,?)");
			q.setParameter(0, license);
			q.setParameter(1, expires);
			q.setParameter(2, isvalid);
			int result=q.executeUpdate();
			return result;
		}else{
			SQLQuery q = session.createSQLQuery("update t_license t set t.license=?,t.expires=?,t.isvalid=? where t.ID=?");
			q.setParameter(0, license);
			q.setParameter(1, expires);
			q.setParameter(2, isvalid);
			q.setParameter(3, id);
			int re=q.executeUpdate();
			return re;
		}
	}
	
	public List<License> getLicense() {
		SQLQuery q = session.createSQLQuery("SELECT t.id,t.license,t.expires,t.isvalid FROM t_license t ");
		q.setFirstResult(0).setMaxResults(1);
		List l = q.list();
		List<License> re=new ArrayList<License>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);;
			  Integer id = (Integer)row[0];
			  String licensestr = (String)row[1];  	
			  Date expires=(Date) row[2];
			  int isvalid=(Integer)row[3];
			  License license=new License(id,licensestr,expires,isvalid);	 
			  re.add(license);
		}
		return re;
	}
	
	
}
