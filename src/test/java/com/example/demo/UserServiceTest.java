/**
 * 
 */
package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import com.example.demo.service.GreetingService;
import com.example.demo.service.UserService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.BeforeEach;

/**
 * @author Rahil_Khan
 *
 */
//@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

	private UserService userService;

	@Mock
	private GreetingService greetingService;

	@BeforeEach
	void init() {
		userService = new UserService(greetingService);

	}

	@Test
	public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
		Mockito.when(greetingService.getUserName(anyString())).thenReturn("Mock user name");
		String testName = userService.getUserName("SomeId");
		assertEquals("Mock user name", testName);

	}

}
