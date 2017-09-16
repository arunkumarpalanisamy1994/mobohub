package com.myproject.DAO;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.model.cart;
import com.myproject.model.cartid;



@Service
public interface cartDAO {
	
	boolean checkout(String username,int addressid);
	
	boolean insertProductIntoCart(cart cart);
List<cart> singleUserCart(String username);
	
	boolean updateproducttocart(cart cart);
	
	List<cart> singleprodfromcart(String prodname,String username);
	
	boolean initcartforuser(cartid cartid);
	boolean deletecartproduct(int id);
	
	int totalproductsincartforuser(String username);
	

}
