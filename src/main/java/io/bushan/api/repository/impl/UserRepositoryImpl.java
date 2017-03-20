package io.bushan.api.repository.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import io.bushan.api.entity.User;
import io.bushan.api.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@Override
	public List<User> findAll() {
		List<User> users= new ArrayList<User>();
		
		User user1 = new User();
		user1.setEmail("bushan@gamil.com");
		User user2 = new User();
		user1.setEmail("bushan@gamil.com");
		User user3 = new User();
		user1.setEmail("bushan@gamil.com");
		
		
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
		return users;
	}

	@Override
	public User findOne(String id) {
		User user1 = new User();
		user1.setEmail("bushan@gamil.com");
		return user1;
	}

	@Override 
	public User create(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(String id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
