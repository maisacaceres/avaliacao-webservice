package br.com.maisa.avaliacao.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.maisa.avaliacao.entity.User;
import br.com.maisa.avaliacao.exception.UserNotFoundException;
import br.com.maisa.avaliacao.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public User getUserByName(String name) {
		User user = userRepository.findByName(name);
		
		if (user != null) {
			return user; 
		} else {
			throw new UserNotFoundException(name);   
		}
	}

	public Page<User> listAllUsers(Pageable page) {
		Page<User> users = userRepository.findAll(page);
		if (users != null) {
			return users;
		} else {
			throw new UserNotFoundException("any");
		}
	}

	public User getBiggerInbox() {
		User user = userRepository.findTopByOrderByInboxDesc();
		
		if (user != null) {
			return user;
		} else {
			throw new UserNotFoundException("no");
		}
	}

	public User getBiggerSize() {
		User user = userRepository.findTopByOrderBySizeDesc();
		
		if (user != null) {
			return user;
		} else {
			throw new UserNotFoundException("no");
		}
	}

}