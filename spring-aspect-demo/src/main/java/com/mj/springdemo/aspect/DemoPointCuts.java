package com.mj.springdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//Put reusable pointcuts here to be used by advice classes

@Aspect
public class DemoPointCuts {
	//@Pointcut("within(com.mj.springdemo.dao..*)")		//match any type within the com.mj.springdemo.dao package/sub-package
	@Pointcut("within(com.mj.springdemo.dao..*) && execution(* add*())")	//matches package/subpackage & method name
	public void daoClassMethods() {}
	
	@Pointcut("execution(* add*(com.mj.springdemo.entity.Account))")
	public void addMethodsWithAccountParameter() {}
	
	@Pointcut("execution(* add*(com.mj.springdemo.entity.Account,..))")
	public void addMethodsWithAccountParameterFirstAndAnyParamsNext() {}
	
	@Pointcut("execution(* add*(..))")
	public void addMethodsWithAccountWithAnyParams() {}
}
