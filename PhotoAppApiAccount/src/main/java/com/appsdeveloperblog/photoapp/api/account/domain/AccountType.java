package com.appsdeveloperblog.photoapp.api.account.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="accountTypes")
@AllArgsConstructor
@NoArgsConstructor
public class AccountType {
	@Id
	@Column(name="id", unique = true)
	private String accountTypeId;
	@Column(name="account_name")
	private String accountName;
	@Column(name="price")
	private double price;
	@Column(name="description")
	private String description;
}