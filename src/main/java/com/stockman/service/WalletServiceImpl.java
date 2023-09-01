package com.stockman.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockman.exception.ResourceNotFoundException;
import com.stockman.model.Wallet;
import com.stockman.repository.WalletRepository;


@Service
public class WalletServiceImpl implements WalletService{
	@Autowired
	private WalletRepository walletRepository;
	@Override
	public void delete(Wallet wallet) throws ResourceNotFoundException {
	 	walletRepository.deleteById(wallet.getWalletId());
	}

}
