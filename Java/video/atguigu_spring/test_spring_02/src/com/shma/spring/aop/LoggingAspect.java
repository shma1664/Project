package com.shma.spring.aop;

import java.util.Arrays;

import javax.print.attribute.standard.Media;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * AOP �� helloWorld
 * 1. ���� jar ��
 * com.springsource.net.sf.cglib-2.2.0.jar
 * com.springsource.org.aopalliance-1.0.0.jar
 * com.springsource.org.aspectj.weaver-1.6.8.RELEASE.jar
 * spring-aspects-4.0.0.RELEASE.jar
 * 
 * 2. �� Spring �������ļ��м��� aop �������ռ䡣 
 * 
 * 3. ����ע��ķ�ʽ��ʹ�� AOP
 * 3.1 �������ļ��������Զ�ɨ��İ�: <context:component-scan base-package="com.atguigu.spring.aop"></context:component-scan>
 * 3.2 ����ʹ AspjectJ ע�������õ�����: <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
 * Ϊƥ������Զ����ɶ�̬�������. 
 * 
 * 4. ��д������: 
 * 4.1 һ��һ��� Java ��
 * 4.2 ���������Ҫ����ʵ�ֵĹ���. 
 *
 * 5. ��������
 * 5.1 ��������� IOC �е� bean: ʵ������� @Component ע��
 * 5.2 ������һ������: ��� @Aspect
 * 5.3 ����֪ͨ: ��������빦�ܶ�Ӧ�ķ���. 
 * 5.3.1 ǰ��֪ͨ: @Before("execution(public int com.atguigu.spring.aop.ArithmeticCalculator.*(int, int))")
 * @Before ��ʾ��Ŀ�귽��ִ��֮ǰִ�� @Before ��ǵķ����ķ�����. 
 * @Before ��������������ʽ: 
 * 
 * 6. ��֪ͨ�з�������ϸ��: ������֪ͨ��������� JoinPoint ���͵Ĳ���, ���п��Է��ʵ�������ǩ���ͷ����Ĳ���. 
 * 
 * 7. @After ��ʾ����֪ͨ: �ڷ���ִ��֮��ִ�еĴ���. 
 */
@Aspect
@Order(2)
@Component
public class LoggingAspect {

	@Pointcut("execution(public Integer *(Integer, Integer))")
	public void declareJointPointExpression() {}
	
	@Before("declareJointPointExpression()")
	public void beforeMethod(JoinPoint joinPoint) {
		 String methodName = joinPoint.getSignature().getName();
		 System.out.println("Method execute before : " + methodName + "[" + Arrays.asList(joinPoint.getArgs()) +"]");
	}
	
	@After("declareJointPointExpression()")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("Method execute after : " + methodName + "[" + Arrays.asList(args) + "]");
	}
	
	@AfterReturning(value="declareJointPointExpression()", returning = "result")
	public void afterReturnMethod(JoinPoint jPoint, Object result) {
		String methodName = jPoint.getSignature().getName();
		Object[] args = jPoint.getArgs();
		System.out.println("return result : " + result);
		System.out.println("Method execute return : " + methodName + "[" + Arrays.asList(args) + "]");
	}
	
	@AfterThrowing(value="declareJointPointExpression()", throwing="ex")
	public void afterThrowMethod(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("Method execute throw : " + methodName + ", throw : " + ex.getMessage());
	}
	
//	@Around("execution(public * com.shma.spring.aop.IntegerCalculator.*(Integer, Integer))")
//	public Object round(ProceedingJoinPoint joinPoint) {
//		String methodName = joinPoint.getSignature().getName();
//		Object[] args = joinPoint.getArgs();
//		Object object = null;
//		try {
//			System.out.println("Method Before execute " + methodName + " : [" + args + "]");
//			object = joinPoint.proceed();
//			System.out.println("Method After execute " + methodName + " : [" + args + "]");
//		} catch (Throwable e) {
//			e.printStackTrace();
//			System.out.println("Method execute throw : " + e.getMessage());
//			throw new RuntimeException();
//		}
//		
//		System.out.println("Method end execute " + methodName + " : [" + args + "]");
//		
//		return object;
//	}
}
