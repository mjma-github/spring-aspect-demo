package com.mj.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)		//Specifies execution order of aspect, lower gets executed first
public class DemoLoggingAspect {
	/*
	 * Advise annotations
	 * 	Before:
	 *	After:
	 *	AfterReturning:
	 *	AfterThrowing:
	 *	Around:
	 */
	
	/*
	 * Pointcut designators
	 * 	execution: matches a method, this is the primary spring pointcut designator
	 *  within: matches a type
	 *  	ex.
	 *  		@Pointcut("within(org.baeldung.dao.FooDao)")	//match all FooDao methods
	 *  		@Pointcut("within(org.baeldung..*)")			//match any type within the org.baeldung package or a sub-package
	 *  
	 *  this/target:
	 *  	target: limits matching to join points where the target object is an instance of the given type
	 *  	ex.
	 *  		public class FooDao implements BarDao { ... }
	 *  
	 *  		@Pointcut("target(org.baeldung.dao.BarDao)")	//will match FooDao class
	 *  
	 *  args: used for matching particular method arguments
	 *  	ex.
	 *  		@Pointcut("execution(* *..find*(Long))")		//matches any method that starts with find and has only one parameter of type Long
	 *  		@@Pointcut("execution(* *..find*(Long,..))")	//matches any method that starts with find and has first parameter of type Long
	 *  
	 *  @target: limits matching to join points where the class of the executing object has an annotation of the given type
	 *  	ex.
	 *  		@Pointcut("@target(org.springframework.stereotype.Repository)")	//limits matching to join points where the class of the executing object has an annotation of @Repository
	 *  
	 *  @args: limits matching to join points where the runtime type of the actual arguments passed have annotations of the given type(s)
	 *  	ex.
	 *  		@Pointcut("@args(org.baeldung.aop.annotations.Entity)")		//all the methods accepting beans annotated with @Entity
	 *  
	 *  @within: limits matching to join points within types that have the given annotation
	 *  	ex.
	 *  		@Pointcut("@within(org.springframework.stereotype.Repository)")
	 *  
	 *  @annotation: limits matching to join points where the subject of the join point has the given annotation
	 *  	ex.
	 *  		@Pointcut("@annotation(org.baeldung.aop.annotations.Loggable)")
	 *  		public void loggableMethods() {}
	 *  
	 *  		@Before("loggableMethods()")
	 *  		public void logMethod(JoinPoint jp) {
	 *  		String methodName = jp.getSignature().getName();
	 *  		logger.info("Executing method: " + methodName);
}
	 *  		
	 */
	
	/*
	 * execution pointcut expression syntax:
	 * execution(<modifier> <return type> <method name>(<parameters>))
	 * Note:
	 *  <modifier> is optional/may be omitted
	 * 	wildcard * can be used on <modifier>, <return type>, and <method name> 
	 */
	
	/*
	 * wilcard expressions
	 * *:any value
	 * ..:any number of parameters(>= 0)
	 * 
	 * 
	 * parameter patter wildcards
	 * (): method with no params
	 * (*): method with 1 param of any type
	 * (..): method with >=0 of any type
	 */
	
	/*---------- Start: Advise ----------*/
	
	//@Before("execution(public void add*())")									//run advise before executing public void method starting with add having no parameters
	//@Before("execution(* add*())")											//run advise before executing any return type method starting with add having no parameters
	//@Before("execution(* addAccount())")										//run advise before executing any method named addAccount having no parameters
	//@Before("execution(* com.mj.springdemo.dao.AccountDao.addAccount())")		//run advise before executing any method named addAccount from specified class having no parameters
	//@Before("execution(* com.mj.springdemo.dao.AccountDao.add*())")			//run advise before executing any method starting with add* from specified class having no parameters
	//@Before("execution(* com.mj.springdemo.dao.*.*())")						//run advise before executing any method from specified package having no parameters
	//@Before("execution(* com.mj.springdemo.dao.*.add*())")					//run advise before executing any method starting with add* from specified package having no parameters
	//@Before("execution(* com.mj.springdemo.dao.*.ADD*())")					//does not work: case sensitive naming
	//@Before("execution(* com..*.add*())")										//run advise before executing any method starting with add* having no parameters from package com.*
	//@Before("execution(void add*())")											//run advise before executing any method starting with add* having no parameters with return type void
	@Before("com.mj.springdemo.aspect.DemoPointCuts.daoClassMethods()")												//run advise before executing method specified in pointcut daoClassMethods
	private void beforeAdviseDemo(JoinPoint joinPoint) {
		System.out.println("***Running before advise: " + this.getClass() + "." + "beforeAdviseDemo() ***");
		AspectUtil.displayMethodSignature(joinPoint);
		AspectUtil.displayMethodArguments(joinPoint);
	}
	
	@Before("com.mj.springdemo.aspect.DemoPointCuts.addMethodsWithAccountParameterFirstAndAnyParamsNext()")											
	private void beforeAdviseAddMethodsWithAccountParameterFirstAndAnyParamsNex(JoinPoint joinPoint) {
		System.out.println("***Running before advise: " + this.getClass() + "." + "beforeAdviseAddMethodsWithAccountParameterFirstAndAnyParamsNext() ***");
		AspectUtil.displayMethodSignature(joinPoint);
		AspectUtil.displayMethodArguments(joinPoint);
	}
	@Before("com.mj.springdemo.aspect.DemoPointCuts.addMethodsWithAccountWithAnyParams()")											
	private void beforeAdviseAddMethodsWithAndAnyParams(JoinPoint joinPoint) {
		System.out.println("***Running before advise: " + this.getClass() + "." + "beforeAdviseAddMethodsWithAnyParams() ***");
		AspectUtil.displayMethodSignature(joinPoint);
		AspectUtil.displayMethodArguments(joinPoint);
		
	}
	
	/*---------- End: Advise ----------*/
}
