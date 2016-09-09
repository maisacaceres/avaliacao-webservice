package br.com.maisa.avaliacao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import br.com.maisa.avaliacao.entity.User;

public interface UserRepository extends CrudRepository<User, String> {

	Page<User> findAll(Pageable page);
	
	User findByName(String name);
	
	User findTopByOrderByInboxDesc();
	
	User findTopByOrderBySizeDesc();
}
