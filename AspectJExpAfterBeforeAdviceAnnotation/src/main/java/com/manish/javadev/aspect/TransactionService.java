package com.manish.javadev.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TransactionService {

	@Pointcut(value = "execution(* com.manish.javadev.services.AccountService.add*(..))")
	public void pc1() {
	}

	@Pointcut(value = "execution(* com.manish.javadev.services.AccountService.find*(..))")
	public void pc2() {
	}

	@Before("pc1() or pc2()")
	public void txnBigin(JoinPoint joinPoint) {

		System.out.println("TXN Bigen() called!");
		System.out.println("Method Name : "
				+ joinPoint.getSignature().getName());
		System.out.println("======================");
	}

	@AfterReturning(pointcut = "pc2() or pc1()", returning = "result")
	public void txnCommite(JoinPoint joinPoint) {

		System.out.println("TXN Commite() called!");
		System.out.println("Method Name : "
				+ joinPoint.getSignature().getName());
		System.out.println("======================");

	}

	@AfterThrowing(pointcut = "pc2()", throwing = "error")
	public void txnAfterThrowing(JoinPoint joinPoint, Throwable error) {

		System.out.println("TXN AfterThrowing() Called!");
		System.out.println("TXN Got Roolback!");
		System.out.println("Method Name : "
				+ joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
		System.out.println("======================");

	}
}