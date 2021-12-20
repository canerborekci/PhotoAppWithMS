package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.create;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.photoapp.api.account.domain.AccountType;
import com.appsdeveloperblog.photoapp.api.account.persistence.AccountTypeRepository;
//bellekte yer tutacağı için component ekliyoruz, bellekte instance oluşuyor tekrar tekrar new leyerek bellekte yer açmıyoruz.
@Component
public class AccountTypeEventsHandler {
	private AccountTypeRepository accountTypeRepository;

	public AccountTypeEventsHandler(AccountTypeRepository accountTypeRepository) {
		this.accountTypeRepository = accountTypeRepository;
	}
	
	//parametresinde istenilen parametre verildiğinde burası çalışır
	@EventHandler
	public void on(AccountTypeCreatedEvent accountTypeCreatedEvent) {
		AccountType accountType = new AccountType();
		BeanUtils.copyProperties(accountTypeCreatedEvent, accountType);
		
		this.accountTypeRepository.save(accountType);
	}
}
