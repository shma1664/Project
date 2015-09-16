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
 * 虽然lastNumber和lastFactors都是原子性的，其本身都是安全的，但是该类中存在竞态条件：
 * 			在lastFactors缓存因子之积应该等于lastNumber中缓存的数值，
 * 当在不变性条件涉及到多个变量，各个变量之间并不是彼此独立的，而是某一个变量的值会对其他变量的值产生约束。
 * 因此，当更新某一个变量时，需要在用一个原子操作中对其他变量同时进行操作
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
