package com.myproject.DAOImpl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.DAO.UserRegistrationDAO;
import com.myproject.model.UserRegistration;
import com.myproject.model.product;
@Repository
public class UserRegistrationDAOImpl implements UserRegistrationDAO {
	@Autowired
	SessionFactory sessionfactory;
	@Override
	public boolean insertuser(UserRegistration i) {

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
	public List<UserRegistration> showall() {
		try
		{
			Session s=sessionfactory.openSession();
			Transaction t=s.getTransaction();
			t.begin();
			List<UserRegistration> l=s.createQuery("from UserRegistration").list();
			t.commit();
			s.close();
			return l;
		}
		catch(Exception e)
		{
		   return null;
		}
	
	}
}
