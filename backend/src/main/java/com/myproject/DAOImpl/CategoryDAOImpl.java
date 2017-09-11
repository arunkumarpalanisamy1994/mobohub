package com.myproject.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.DAO.CategoryDAO;
import com.myproject.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
    SessionFactory sessionfactory;
	
	public boolean insertuser(Category i) {
	
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

	
	public boolean updateuser(Category u) {

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
			Category x=s.get(Category.class,id);
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

	
	public List<Category> showall() {
		
		try
		{
			Session s=sessionfactory.openSession();
			Transaction t=s.getTransaction();
			t.begin();
			List<Category> l=s.createQuery("from Category").list();
			t.commit();
			s.close();
			return l;
		}
		catch(Exception e)
		{
		   return null;
		}

	}

	
	public Category showone(int id) {
	
		try
		{
			Session s=sessionfactory.openSession();
			Transaction t=s.getTransaction();
			t.begin();
			Category p=s.get(Category.class,id);
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
