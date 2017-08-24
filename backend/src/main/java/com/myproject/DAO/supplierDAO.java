package com.myproject.DAO;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.model.supplier;

@Service
public interface supplierDAO {
	boolean insertuser(supplier i);
	boolean updateuser(supplier u);
	boolean deleteuser(int id);
	List<supplier>showall();
	supplier showone(int id);


}
