package com.myproject.DAO;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.model.Category;

@Service
public interface CategoryDAO {
	boolean insertuser(Category i);
	boolean updateuser(Category u);
	boolean deleteuser(int id);
	List<Category>showall();
	Category showone(int id);
	
	

}
