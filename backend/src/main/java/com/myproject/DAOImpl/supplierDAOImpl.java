package com.myproject.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.DAO.supplierDAO;
import com.myproject.model.supplier;
@Repository
public class supplierDAOImpl implements supplierDAO {
	@Autowired
	SessionFactory sessionfactory;
	
	public boolean insertuser(supplier i) {
	
		try
		{
			Session s=sessionfactory.openSession();
			Transaction t=s.getTransaction();
			t.begin();
			s.save(i);
			t.commit();
			s.close();
			return true;
		}
		catch(Exception e)
		{
		   return false;
		}
	}

	
	public boolean updateuser(supplier u) {

		try
		{
			Session s=sessionfactory.openSession();
			Transaction t=s.getTransaction();
			t.begin();
			s.update(u);
			t.commit();
			s.close();
			return true;
		}
		catch(Exception e)
		{
		   return false;
		}
	}

	
	public boolean deleteuser(int id) {
	
		try
		{
			Session s=sessionfactory.openSession();
			Transaction t=s.getTransaction();
			t.begin();
			supplier x=s.get(supplier.class,id);
			s.delete(x);
			t.commit();
			s.close();
			return true;
		}
		catch(Exception e)
		{
		   return false;
		}
		
	}

	
	public List<supplier> showall() {
	
		try
		{
			Session s=sessionfactory.openSession();
			Transaction t=s.getTransaction();
			t.begin();
			List<supplier> l=s.createQuery("from supplier").list();
			t.commit();
			s.close();
			return l;
		}
		catch(Exception e)
		{
		   return null;
		}
		
	}

	
	public supplier showone(int id) {
	
		try
		{
			Session s=sessionfactory.openSession();
			Transaction t=s.getTransaction();
			t.begin();
			supplier p=s.get(supplier.class,id);
			t.commit();
			s.close();
			return p;
		}
		catch(Exception e)
		{
		   return null;
		}

	
	
	}

}
