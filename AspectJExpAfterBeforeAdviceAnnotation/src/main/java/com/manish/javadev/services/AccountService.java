package com.manish.javadev.services;

import com.manish.javadev.exception.AccountNotFoundException;

public interface AccountService {

	void addAccount();

	String findAccountById(int accNumber) throws AccountNotFoundException;
}