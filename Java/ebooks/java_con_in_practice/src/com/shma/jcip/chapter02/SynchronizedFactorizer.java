package com.shma.jcip.chapter02;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.shma.jcip.annotation.ThreadSafe;

@ThreadSafe
public class SynchronizedFactorizer extends GenericServlet implements Servlet {

	private static final long serialVersionUID = 3132009232516672089L;

	private BigInteger lastNumber;
	private BigInteger[] lastFactors;
	
	@Override
	public synchronized void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {

		BigInteger bigInteger = extractFromRequest(req);
		
		if(bigInteger.equals(lastNumber)) {
			encodeIntoResponse(resp, lastFactors);
		} else {
			BigInteger[] factors = factor(bigInteger);
			lastNumber = bigInteger;
			lastFactors = factors;
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
