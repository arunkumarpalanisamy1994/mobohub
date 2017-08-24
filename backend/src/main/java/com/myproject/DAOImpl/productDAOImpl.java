package com.myproject.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.DAO.productDAO;
import com.myproject.model.product;
@Repository
public class productDAOImpl implements productDAO {
    @Autowired
    SessionFactory sessionfactory;
    @Override
	public boolean insertuser(product i) {
	
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

	@Override
	public boolean updateuser(product u) {

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

	@Override
	public boolean deleteuser(int id) {
		
		try
		{
			Session s=sessionfactory.openSession();
			Transaction t=s.getTransaction();
			t.begin();
			product x=s.get(product.class,id);
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

	@Override
	public List<product> showall() {
		try
		{
			Session s=sessionfactory.openSession();
			Transaction t=s.getTransaction();
			t.begin();
			List<product> l=s.createQuery("from product").list();
			t.commit();
			s.close();
			return l;
		}
		catch(Exception e)
		{
		   return null;
		}
		
	}
	@Override
	public product showone(int id) {
		try
		{
			Session s=sessionfactory.openSession();
			Transaction t=s.getTransaction();
			t.begin();
			product p=s.get(product.class,id);
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