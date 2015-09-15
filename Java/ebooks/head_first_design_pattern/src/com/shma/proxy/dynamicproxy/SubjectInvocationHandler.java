package com.shma.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SubjectInvocationHandler implements InvocationHandler {

	 private Object obj;

	public SubjectInvocationHandler(Object obj) {
		super();
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before"); 
        method.invoke(obj, args);
        System.out.println("after");
        
        return null;
	}
	
	/**
     * ���ɴ����๤��
     * @author com.tiantian
     * @param realObj
     * @return �������ɵĴ�����
     */
    public static Object getProxyInstanceFactory(Object realObj){
        Class<?> classType = realObj.getClass();
        return Proxy.newProxyInstance(classType.getClassLoader(), 
                classType.getInterfaces(), new SubjectInvocationHandler(realObj));
    }

}
