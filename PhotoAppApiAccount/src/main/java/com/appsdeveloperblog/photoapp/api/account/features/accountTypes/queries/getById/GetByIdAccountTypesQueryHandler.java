package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.queries.getById;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.photoapp.api.account.domain.AccountType;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.restModels.AccountTypeListRestModelById;
import com.appsdeveloperblog.photoapp.api.account.persistence.AccountTypeRepository;

@Component
public class GetByIdAccountTypesQueryHandler {
	private AccountTypeRepository accountTypeRepository;
	@Autowired
	public GetByIdAccountTypesQueryHandler(AccountTypeRepository accountTypeRepository) {
		this.accountTypeRepository = accountTypeRepository;
	}
	@QueryHandler
	public AccountTypeListRestModelById getAccountTypeById(GetByIdAccountTypesQuery getByIdAccountTypesQuery) {
		AccountTypeListRestModelById result = new AccountTypeListRestModelById();
		
		AccountType accountType = this.accountTypeRepository.getById(getByIdAccountTypesQuery.getId());
		BeanUtils.copyProperties(accountType, result);
		
		return result;
	}
}
