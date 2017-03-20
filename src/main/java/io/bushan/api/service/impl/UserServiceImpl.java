package io.bushan.api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.bushan.api.entity.User;
import io.bushan.api.exception.BadRequestException;
import io.bushan.api.exception.NotFoundException;
import io.bushan.api.repository.UserRepository;
import io.bushan.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository repository;

	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findOne(String id) {
		User existing = repository.findOne(id);
		if(existing ==null){
			throw new NotFoundException("User with id "+id+" is not found");
		}
		return existing;
	}

	@Override
	public User create(User user) {
		User existing = repository.findByEmail(user.getEmail());
		if(existing !=null){
			throw new BadRequestException("User with email "+user.getEmail()+" is  found");
		}
		return repository.create(user);
	}

	@Override
	public User update(String id, User user) {
		User existing = repository.findOne(id);
		if(existing ==null){
			throw new BadRequestException("User with id "+id+" is not found");
		}
		return repository.update(id, user);
	}

	@Override
	public void delete(String id) {
		User existing = repository.findOne(id);
		if(existing ==null){
			throw new NotFoundException("User with id "+id+" is not found");
		}
		 repository.delete(id);
	}

}
