package io.bushan.api.controller;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import io.bushan.api.entity.User;
import io.bushan.api.service.UserService;

@Controller
public class UserController {
	private UserService service;
	
	// constructor based dependency injection
	public UserController(UserService service){
		this.service= service;
	}
	
	@ResponseBody 
	@RequestMapping(method = RequestMethod.GET, value = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll() {
		return service.findAll();
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findOne(@PathVariable("id") String userId) {
		return service.findOne(userId);
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User Create(@RequestBody User user) {
		return service.create(user);
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update(@PathVariable("id") String id, @RequestBody User user) {
		return service.update(id, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}

}
