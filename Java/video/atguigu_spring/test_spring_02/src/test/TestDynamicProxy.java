package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;

import com.shma.spring.proxy.Calculator;
import com.shma.spring.proxy.CalculatorDynamicProxy;
import com.shma.spring.proxy.DynamicProxy;
import com.shma.spring.proxy.IntegerCalculator;

public class TestDynamicProxy {

	
	@Test
	public void test() {
		Calculator<Integer> calculator = new IntegerCalculator();
		
		DynamicProxy proxy = new DynamicProxy();
		Calculator<Integer> calculator2 = (Calculator<Integer>) proxy.obj(calculator);
		calculator2.add(1, 2);
		calculator2.sub(4, 2);
		calculator2.mult(5, 2);
		calculator2.div(10, 2);
		
		
		InvocationHandler handler = new CalculatorDynamicProxy(calculator);
		
		Calculator<Integer> calculator3 = (Calculator<Integer>) Proxy.newProxyInstance(calculator.getClass().getClassLoader(), calculator.getClass().getInterfaces(), handler);
		calculator3.add(1, 2);
		calculator3.sub(4, 2);
		calculator3.mult(5, 2);
		calculator3.div(10, 2);
		
	}

}
