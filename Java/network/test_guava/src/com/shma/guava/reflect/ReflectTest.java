package com.shma.guava.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.reflect.Invokable;
import com.google.common.reflect.Reflection;
import com.google.common.reflect.TypeToken;

/**
 * 反射
 * @author admin
 *
 */
public class ReflectTest {

	/**
	 * TypeToken类是用来解决java运行时泛型类型被擦除的问题
	 */
	@Test
	public void testTypeToken() {
		
		//泛型的运行时类型擦除
		ArrayList<Integer> intList = Lists.newArrayList();
		ArrayList<String> stringList = Lists.newArrayList();
		
		System.out.println("intList type is : " + intList.getClass());
		System.out.println("stringList type is : " + stringList.getClass());
		
		System.out.println(intList.getClass().isAssignableFrom(stringList.getClass())); //true
		
		//认为stringList和intList的类型是一样的,这就是所谓的泛型类型擦除。
		//运行时我们不知道泛型类型的类型参数是什么了
		
		TypeToken<ArrayList<String>> typeToken = new TypeToken<ArrayList<String>>() {};
        TypeToken<?> genericTypeToken = typeToken.resolveType(ArrayList.class.getTypeParameters()[0]);
        System.out.println(genericTypeToken.getType()); //class java.lang.String
		
	}
	
	@Test
	public void testInvokable() throws NoSuchMethodException, SecurityException {
		//判断方法是否为public
		Method method = ReflectTest.class.getMethod("testTypeToken", null);
		System.out.println(Modifier.isPublic(method.getModifiers())); //true
		
		System.out.println(Invokable.from(method).isPublic()); //true
		
		System.out.println(Invokable.from(ReflectTest.class.getConstructor(null)).isPackagePrivate());
	}
	
	/**
	 * 动态代理
	 */
	@Test
	public void testProxy() {
		InvocationHandler invocationHandler = new MyInvocationHandler(new MyFoo());

        // Guava Dynamic Proxy implement
        IFoo foo = Reflection.newProxy(IFoo.class, invocationHandler);
        foo.doSomething();
        //jdk Dynamic proxy implement
        IFoo jdkFoo = (IFoo) Proxy.newProxyInstance(
                IFoo.class.getClassLoader(),
                new Class<?>[]{IFoo.class},
                invocationHandler);
        jdkFoo.doSomething();

	    
	}
	
	public class MyInvocationHandler implements InvocationHandler {
	    
		private Object concreteClass;  
	      
	    public MyInvocationHandler(Object concreteClass){  
	        this.concreteClass=concreteClass;  
	    }
		
		public Object invoke(Object proxy, Method method, Object[] args)
	                throws Throwable {
	            System.out.println("proxy println something");
	            Object object = method.invoke(concreteClass, args);//普通的Java反射代码,通过反射执行某个类的某方法  
	            System.out.println("After invoke method...");  
	            return object;
	        }
	}

	public interface IFoo {
		void doSomething();
	}
	
	public class MyFoo implements IFoo {

		@Override
		public void doSomething() {
			System.out.println("MyFoo doSomething...");
			
		}
		
	}

}
