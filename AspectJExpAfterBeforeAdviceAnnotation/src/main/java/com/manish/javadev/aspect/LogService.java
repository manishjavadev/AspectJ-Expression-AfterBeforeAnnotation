package com.manish.javadev.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogService {

	@Pointcut(value = "execution(* com.manish.javadev.services.AccountService.add*(..))")
	public void pc1() {
	}

	@Pointcut(value = "execution(* com.manish.javadev.services.AccountService.find*(..))")
	public void pc2() {
	}

	@Before("pc1() or pc2()")
	public void logBefore(JoinPoint joinPoint) {

		System.out.println("LogBefore() called!");
		System.out.println("Method Name : "
				+ joinPoint.getSignature().getName() +" Start here");
		System.out.println("======================");
	}

	@After("pc1()")
	public void logAfter(JoinPoint joinPoint) {

		System.out.println("LogAfter() called!");
		System.out.println("Method Name : "
				+ joinPoint.getSignature().getName() +" Ended here");
		System.out.println("======================");
	}

	@AfterReturning(pointcut = "pc2()", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {

		System.out.println("LogAfterReturning() called!");
		System.out.println("Method Name : "
				+ joinPoint.getSignature().getName()  +" Processing Done");
		System.out.println("Method returned value is : " + result);
		System.out.println("======================");

	}

	@AfterThrowing(pointcut = "pc2() or pc1()", throwing = "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

		System.out.println("LogAfterThrowing() called!");
		System.out.println("Method Name : "
				+ joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
		System.out.println("======================");

	}

}