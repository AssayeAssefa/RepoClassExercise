package com.revature.service;

import java.util.List;

import com.revature.dao.imp.UserDaoImpl;
import com.revature.model.User;

public class UserService implements CrudService<User> {
    UserDaoImpl ud = new UserDaoImpl();
	@Override
	public List<User> getAll() {
		
		return ud.getAllUsers();
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(User obj) {
		ud.createUser(obj);
		return 0;
	}

	@Override
	public int update(User obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public User getByUserName(String username) {
		
		
		return ud.getUserByUsername(username);
	}
	
}