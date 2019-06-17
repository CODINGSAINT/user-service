package com.codinsaint.tutorial.spring.userservice.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codinsaint.tutorial.spring.userservice.model.User;
import com.codinsaint.tutorial.spring.userservice.repository.UserRepository;

@Controller
public class UiController {
	UserRepository userRepository;

	@Autowired
	public UiController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping({ "/", "index", "welcome" })
	public ModelAndView index() {
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("users", getAllUsers());
		return new ModelAndView("index", modelMap);

	}

	@PostMapping("user")
	public ModelAndView addUser(@ModelAttribute User user) {
		User savedUser = userRepository.save(user);
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("user", savedUser);
		if (user.getUserId() == null) {
			modelMap.addAttribute("msg", "User added successfully :id " + savedUser.getUserId());

		} else {
			modelMap.addAttribute("msg", "User details modified :id " + savedUser.getUserId());

		}

		modelMap.addAttribute("users", getAllUsers());
		return new ModelAndView("index", modelMap);
	}

	@GetMapping("deleteUser/{id}")
	public ModelAndView deleteUser(@PathVariable("id") String id) {

		userRepository.deleteById(Long.parseLong(id));
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("users", getAllUsers());
		modelMap.addAttribute("msg", "User successfully removed");
		return new ModelAndView("index", modelMap);
	}

	@GetMapping("editUser/{id}")
	public ModelAndView editUser(@PathVariable("id") String id) {

		Optional<User> editUser = userRepository.findById(Long.parseLong(id));
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("user", editUser.get());

		return new ModelAndView("editUser", modelMap);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}
