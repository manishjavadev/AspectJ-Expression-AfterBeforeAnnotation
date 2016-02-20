package com.manish.javadev.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecurityService {

	@Pointcut(value = "execution(* com.manish.javadev.services.AccountService.add*(..))")
	public void pc1() {
	}

	@Pointcut(value = "execution(* com.manish.javadev.services.AccountService.find*(..))")
	public void pc2() {
	}

	@Before("pc1() or pc2()")
	public void verifyUser() {
		System.out.println("Verify User method called");
	}
}