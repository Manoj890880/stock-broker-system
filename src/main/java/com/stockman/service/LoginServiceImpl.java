package com.stockman.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockman.exception.LoginException;
import com.stockman.model.CurrentUserSession;
import com.stockman.model.Customer;
import com.stockman.model.LoginDTO;
import com.stockman.repository.CustomerDao;
import com.stockman.repository.SessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CustomerDao cDao;

	@Autowired
	private SessionDao sDao;

	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {

		Customer existingCustomer = cDao.findByMobileNumber(dto.getMobileNo());

		if (existingCustomer == null) {

			throw new LoginException("Please Enter a valid mobile number");

		}

		Optional<CurrentUserSession> validCustomerSessionOpt = sDao.findById(existingCustomer.getCustomerId());

		if (validCustomerSessionOpt.isPresent()) {

			throw new LoginException("User already Logged In with this number");

		}

		if (existingCustomer.getPassword().equals(dto.getPassword())) {

			String key = RandomString.make(6);

			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCustomerId(), key,
					LocalDateTime.now());

			sDao.save(currentUserSession);

			return currentUserSession.toString();
		} else
			throw new LoginException("Please Enter a valid password");

	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {

		CurrentUserSession validCustomerSession = sDao.findByUuid(key);

		if (validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");

		}

		sDao.delete(validCustomerSession);

		return "Logged Out !";

	}

	@Override
	public String logIntoAccountAdmin(LoginDTO dto) throws LoginException {
		if (dto.getMobileNo().equals("admin")&&dto.getPassword().equals("admin")) {

			String key = RandomString.make(6);

			CurrentUserSession currentUserSession = new CurrentUserSession(1, key,
					LocalDateTime.now());

			sDao.save(currentUserSession);

			return currentUserSession.toString();
		} else
			throw new LoginException("Invalid username or password");
	}

	@Override
	public String logOutFromAccountAdmin(String key) throws LoginException {
		CurrentUserSession validCustomerSession = sDao.findByUuid(key);

		if (validCustomerSession == null) {
			throw new LoginException("Admin Not Logged in");

		}

		sDao.delete(validCustomerSession);

		return "Logged Out !";
	}

}
