package com.myproject.DAO;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.model.product;


@Service
public interface productDAO {
	boolean insertuser( product i);
	boolean updateuser(product u);
	boolean deleteuser(int id);
	List<product>showall();
	product showone(int id);


}
