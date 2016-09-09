package br.com.maisa.avaliacao.resource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.maisa.avaliacao.entity.User;
import br.com.maisa.avaliacao.service.UserService;

@RestController
public class UserResource {
	
	@Autowired
	UserService userService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
	public User userByName(@RequestParam(value = "name") String name) {
		logger.info("User seach by name: " + name);
		return userService.getUserByName(name);
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	public Page<User> allUsers(Pageable page) {
		logger.info("Users from page: " + page);
		return userService.listAllUsers(page);
	}
	
	@RequestMapping(value = "/user_inbox", method = RequestMethod.GET, produces = "application/json")
	public User userWithBiggerInbox() {
		logger.info("Request for the bigger inbox");
		return userService.getBiggerInbox();
	}
	
	@RequestMapping(value = "/user_size", method = RequestMethod.GET, produces = "application/json")
	public User userWithBiggerSize() {
		logger.info("Request for the bigger size");
		return userService.getBiggerSize();
	}
}