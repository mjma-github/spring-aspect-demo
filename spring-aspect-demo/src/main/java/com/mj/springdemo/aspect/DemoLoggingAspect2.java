package com.mj.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect2 {
	@After("com.mj.springdemo.aspect.DemoPointCuts.addMethodsWithAccountParameter()")
	private void afterAddMethodsWithAccount(JoinPoint joinPoint) {
		System.out.println("***Running after advise: " + this.getClass() + "." + "afterAddMethodsWithAccount() ***");
		AspectUtil.displayMethodSignature(joinPoint);
		AspectUtil.displayMethodArguments(joinPoint);
	}
}
