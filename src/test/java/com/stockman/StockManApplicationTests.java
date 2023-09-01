package com.stockman;

import com.stockman.controller.LoginController;
import com.stockman.exception.LoginException;
import com.stockman.model.LoginDTO;
import com.stockman.service.LoginService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class StockManApplicationTests {

	@Test
	void contextLoads() {
	}

	// Add the CustomerLoginControllerTest class here
	@RunWith(MockitoJUnitRunner.class)
	public class CustomerLoginControllerTest {

		@InjectMocks
		private LoginController customerLoginController;

		@Mock
		private LoginService customerLoginService;

		@Test
		public void testLogInCustomer() throws LoginException {
			// Create a sample LoginDTO
			LoginDTO loginDTO = new LoginDTO();
			loginDTO.setMobileNo("john.doe");
			loginDTO.setPassword("password");

			// Mock the behavior of customerLoginService.logIntoAccount
			when(customerLoginService.logIntoAccount(loginDTO)).thenReturn("Login successful");

			// Perform the POST request
			ResponseEntity<String> responseEntity = customerLoginController.logInCustomer(loginDTO);

			// Verify the response
			assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
			assertThat(responseEntity.getBody()).isEqualTo("Login successful");
		}
	}
}
