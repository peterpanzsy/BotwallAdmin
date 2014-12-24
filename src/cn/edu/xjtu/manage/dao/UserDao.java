package cn.edu.xjtu.manage.dao;

// default package

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;  
import javax.persistence.TableGenerator;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import cn.edu.xjtu.manage.business.User;
import cn.edu.xjtu.tools.HibernateSessionManager;


public class UserDao  {
    
	//property constants
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
//	public static final String USERGROUPID = "usergroupid";
//	public static final String EMAIL = "email";
//	public static final String STATE = "state";
//	public static final String INFO = "info";

    public static final String ADDTIME="addTime";
    public static final String LASTLOGINTIME="lastLoginTime";
    public static final String LOGINTIMES="loginTimes";
    Session session ;
	 
	public UserDao()
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
	
	//遍历
	public  void all()
	{
		Query q = session.createSQLQuery("select id,name from Test");
		
		List l = q.list();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);;
			  Integer id = (Integer)row[0];
			  String name = (String)row[1];  
			  System.out.println(id+" "+name);
		}
	}
	
	
	public int addUser(String username,String password){
		HibernateSessionManager.getThreadLocalTransaction();
		Query q = session.createSQLQuery("insert into t_user (username,password) values (?,?)");
		q.setParameter(0, username);
		q.setParameter(1, password);
		int result=q.executeUpdate();

		return result;
	}
	
	public int updateUser(String username,String password){
		HibernateSessionManager.getThreadLocalTransaction();
		Query q = session.createSQLQuery("update t_user set username=?,password=?");
		q.setParameter(0, username);
		q.setParameter(1, password);
		int result=q.executeUpdate();
		return result;
	}
	
	
	public int deleteUser(int id) {
		HibernateSessionManager.getThreadLocalTransaction();
		SQLQuery q = session.createSQLQuery("delete from t_user where ID=?");
		q.setParameter(0, id);
		int re=q.executeUpdate();
		return re;
		
	}

	public User searchUser(String name,String pass,String type){
		
		
		
		User userR=null;
		try {
				
				
		        Query query = session.createSQLQuery("select * from t_user s where s.username=? and s.password=?");
		        query.setParameter(0, name);
		        query.setParameter(1, pass);
		        
		        List users=new ArrayList<User>();
				List l = query.list();
				for(int i=0;i<l.size();i++)
				{
					//TestDb user = (TestDb)l.get(i);
					//System.out.println(user.getUsername());

					  Object[] row = (Object[])l.get(i);;
					  int id = (Integer) row[0];
					  String username = (String)row[1];  
					  String password = (String)row[2];
					  User user=new User();
					  user.setUserid(id);
					  user.setUsername(username);
					  user.setPassword(password);
					  users.add(user);
				}
				if(!users.isEmpty()){
					userR=new User();
					userR=(User)users.get(0);
				}
				
				} catch (Exception e) {
			e.printStackTrace();
		}		
		return userR;
	}
	
	public List<User> getUserList() {
		SQLQuery q = session.createSQLQuery("select t.ID,t.username from t_user t");
		List l = q.list();
		List<User> re=new ArrayList<User>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);;
			  Integer uid = (Integer)row[0];
			  String uName = (String)row[1];  
			  if(!uName.equals("_imiss_botnet")){
				  User user=new User(uid, uName,null);	 
				  re.add(user);
			  }
			 
		}
		return re;
	}
	
	public Boolean findByUsername(String name){
		SQLQuery q=session.createSQLQuery("select count(*) from t_user t where t.username=?");
		q.setParameter(0, name);
		int count=((BigInteger)q.uniqueResult()).intValue();
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	public static String getUSERNAME() {
		return USERNAME;
	}

	public static String getPASSWORD() {
		return PASSWORD;
	}

	public static String getADDTIME() {
		return ADDTIME;
	}


	public static String getLASTLOGINTIME() {
		return LASTLOGINTIME;
	}


	public static String getLOGINTIMES() {
		return LOGINTIMES;
	}


}