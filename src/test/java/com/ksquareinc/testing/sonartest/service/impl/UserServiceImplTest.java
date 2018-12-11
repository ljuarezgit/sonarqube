package com.ksquareinc.testing.sonartest.service.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import com.ksquareinc.testing.sonartest.dao.UserDao;
import com.ksquareinc.testing.sonartest.model.User;
import com.ksquareinc.testing.sonartest.service.UserService;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class UserServiceImplTest {

	@Mock
	private UserDao userDao;
	
	private UserService userService;
	@Before
	public void setUp() {
		this.userService = new UserServiceImpl(userDao);
	}
	@Test
	public void testFindAll() {
		List<User> users = new ArrayList<>();
		
		when(userDao.findAll()).thenReturn(users);
		
		List<User> result = this.userService.findAll();
		assertThat(result, notNullValue());
		assertThat(result.size(),equalTo(users.size()));
		
	}
	@Test
	public void testCreate() {
		User user = new User();
	    doNothing().when(this.userDao).create(user);
		this.userService.create(user);
	}
}
