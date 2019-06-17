package com.codinsaint.tutorial.spring.userservice.contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codinsaint.tutorial.spring.userservice.exception.UserNotFoundException;
import com.codinsaint.tutorial.spring.userservice.model.User;
import com.codinsaint.tutorial.spring.userservice.repository.UserRepository;

@RestController
@RequestMapping("v2")
public class HateoasController {
	
	@Autowired 
	private UserRepository userRepository;
	@RequestMapping(path="user/{id}",method=RequestMethod.GET)
	public Resource<User> get(@PathVariable ("id" )String id) throws UserNotFoundException{
		try {
		Optional<User> user= userRepository.findById(Long.valueOf(id));
		Link selfLink=ControllerLinkBuilder
				.linkTo(HateoasController.class)
				.slash(user.get().getUserId())
				.withSelfRel();
		Link deleteLink=ControllerLinkBuilder.
				linkTo(ControllerLinkBuilder
						.methodOn(UserController.class)
						.delete(user.get().getUserId()+""))
				.withRel("delete");
				
		return new Resource<User>(user.get(),selfLink,deleteLink);
		} catch(Exception e) 
		{
			throw new UserNotFoundException("User Not Found for id :" +id);
		}
	}

}
