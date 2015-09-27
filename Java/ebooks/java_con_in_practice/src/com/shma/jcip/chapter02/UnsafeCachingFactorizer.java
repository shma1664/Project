package com.shma.jcip.chapter02;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.shma.jcip.annotation.NotThreadSafe;

/**
 * ��ȻlastNumber��lastFactors����ԭ���Եģ��䱾���ǰ�ȫ�ģ����Ǹ����д��ھ�̬������
 * 			��lastFactors��������֮��Ӧ�õ���lastNumber�л������ֵ��
 * ���ڲ����������漰�������������������֮�䲢���Ǳ˴˶����ģ�����ĳһ��������ֵ�������������ֵ����Լ����
 * ��ˣ�������ĳһ������ʱ����Ҫ����һ��ԭ�Ӳ����ж���������ͬʱ���в���
 * @author admin
 *
 */
@NotThreadSafe
public class UnsafeCachingFactorizer extends GenericServlet implements Servlet {

	private static final long serialVersionUID = 3132009232516672089L;

	private static final AtomicReference<BigInteger> lastNumber 
										= new AtomicReference<BigInteger>();
	
	private static final AtomicReference<BigInteger[]> lastFactors
										= new AtomicReference<BigInteger[]>();
	
	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {

		BigInteger bigInteger = extractFromRequest(req);
		if(bigInteger.equals(lastNumber.get())) {
			encodeIntoResponse(resp, lastFactors.get());
		} else {
			BigInteger[] factors = factor(bigInteger);
			lastNumber.set(bigInteger);
			lastFactors.set(factors);
			encodeIntoResponse(resp, factors);
		}
	}
	
	public void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

	public BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

	public BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }

}
