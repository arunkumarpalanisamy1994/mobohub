package com.myproject.DAO;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.model.UserRegistration;
import com.myproject.model.product;
@Service
public interface UserRegistrationDAO {
	boolean insertuser(UserRegistration i);
	List<UserRegistration>showall();

}
