package com.mj.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

public class AspectUtil {
	
	
	
	//display method signature
	public static void displayMethodSignature(JoinPoint joinPoint) {
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
		System.out.println("   Method: " + methodSig);
	}
	
	//display method arguments
	public static void displayMethodArguments(JoinPoint joinPoint) {
		for(Object arg : joinPoint.getArgs()) {
			System.out.println("   Arg:" + arg);
		}		
	}
}
