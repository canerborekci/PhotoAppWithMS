package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.delete;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.photoapp.api.account.domain.AccountType;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.update.AccountTypeUpdatedEvent;
import com.appsdeveloperblog.photoapp.api.account.persistence.AccountTypeRepository;

@Component
public class AccountTypeDeletedEventHandler {
	private AccountTypeRepository accountTypeRepository;

	public AccountTypeDeletedEventHandler(AccountTypeRepository accountTypeRepository) {
		this.accountTypeRepository = accountTypeRepository;
	}
	
	@EventHandler
	public void on(AccountTypeDeletedEvent accountTypeDeletedEvent) {
		AccountType accountType = new AccountType();
		BeanUtils.copyProperties(accountTypeDeletedEvent, accountType);
		
		this.accountTypeRepository.deleteById(accountTypeDeletedEvent.getAccountTypeId());
	}
}
