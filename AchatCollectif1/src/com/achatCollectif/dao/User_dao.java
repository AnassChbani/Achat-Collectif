package com.achatCollectif.dao;

import java.util.List;

import com.achatCollectif.model.User;


public interface User_dao {
	public List<User> getAllUsers();
	public User getUserByCin(String cin);
	public User getUserById(String id);
}
