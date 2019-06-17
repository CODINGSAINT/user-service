package com.codinsaint.tutorial.spring.userservice.contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codinsaint.tutorial.spring.userservice.exception.UserNotFoundException;
import com.codinsaint.tutorial.spring.userservice.model.User;
import com.codinsaint.tutorial.spring.userservice.repository.UserRepository;

@RestController
@RequestMapping("v1")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(path= {"greetings","hello"},method= {RequestMethod.GET})
	public String greetings() {
		return "Hello World";
	}
	@RequestMapping(path="user",method=RequestMethod.POST)
	public ResponseEntity<Void> addUser(@RequestBody User user) {
		try {
			User createdUser=userRepository.save(user);
			HttpHeaders headers= new HttpHeaders();
			headers.add("id", createdUser.getUserId().toString());
			return new ResponseEntity<>(headers,HttpStatus.CREATED);
			
		} catch(Exception e) {
			return new ResponseEntity<Void>(HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	@RequestMapping(path="user/{id}",method=RequestMethod.GET)
	public ResponseEntity<User> get(@PathVariable ("id" )String id) throws UserNotFoundException{
		try {
		Optional<User> user= userRepository.findById(Long.valueOf(id));
		return new ResponseEntity<User>(user.get(),HttpStatus.OK);
		} catch(Exception e) 
		{
			throw new UserNotFoundException("User Not Found for id :" +id);
		}
	}
	
	@RequestMapping(path="user",method=RequestMethod.PUT)
	public ResponseEntity<User>update(@RequestBody User user){
		try {
		User updatedUser=userRepository.save(user); 
		return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@RequestMapping(path="user/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") String id){
		try {
		userRepository.deleteById(Long.valueOf(id));
		return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}
