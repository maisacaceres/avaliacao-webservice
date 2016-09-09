package br.com.avaliacao.maisa.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import br.com.maisa.avaliacao.entity.User;
import br.com.maisa.avaliacao.exception.UserNotFoundException;
import br.com.maisa.avaliacao.repository.UserRepository;
import br.com.maisa.avaliacao.service.UserService;

public class UserServiceTest {
	@InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;
    
    @Mock
    private User user;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        user = new User("_mojolinny@uol.com.br", 1, 2);
    }
    
    @Test(expected = UserNotFoundException.class)
    public void testGetUserNameNotFound() {
    	String user_name = "test";
    	Mockito.when(userRepository.findByName(user_name)).thenReturn(null);
    	userService.getUserByName(user_name);
    }
    
    @Test
    public void testGetUserByName() {
    	String user_name = "_mojolinny@uol.com.br";
    	Mockito.when(userRepository.findByName(user_name)).thenReturn(user);
    	
    	assertEquals(user_name, userService.getUserByName(user_name).getName());
    }
    
    @Test(expected = UserNotFoundException.class)
    public void testGetAllUsersWhenDoNottExist() {
    	Pageable page = new PageRequest(1, 20);
    	Mockito.when(userRepository.findAll(page)).thenReturn(null);
    	userService.listAllUsers(page);
    }
    
    @Test(expected = UserNotFoundException.class)
    public void testGetBiggerInboxWhenDoNottExist() {
    	Mockito.when(userRepository.findTopByOrderByInboxDesc()).thenReturn(null);
    	userService.getBiggerInbox();
    }
    
    @Test
    public void testGetBiggerInbox() {
    	Mockito.when(userRepository.findTopByOrderByInboxDesc()).thenReturn(user);
    	assertEquals(1, userService.getBiggerInbox().getInbox());
    }
    
    @Test(expected = UserNotFoundException.class)
    public void testGetBiggerSizeWhenDoNottExist() {
    	Mockito.when(userRepository.findTopByOrderBySizeDesc()).thenReturn(null);
    	userService.getBiggerSize();
    }
    
    @Test
    public void testGetBigSize() {
    	Mockito.when(userRepository.findTopByOrderBySizeDesc()).thenReturn(user);
    	assertEquals(2, userService.getBiggerSize().getSize());
    }
}
