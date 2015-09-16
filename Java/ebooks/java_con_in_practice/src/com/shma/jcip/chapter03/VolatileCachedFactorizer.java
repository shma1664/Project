package com.shma.jcip.chapter03;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.shma.jcip.annotation.ThreadSafe;

@ThreadSafe
public class VolatileCachedFactorizer extends GenericServlet implements Servlet {

	private static final long serialVersionUID = 2466605161267670532L;
	
	private volatile OneValueCache cache = new OneValueCache(null, null);
	
	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		BigInteger i = extractFromRequest(req);
		
		BigInteger[] factors = cache.getFactors(i);
		if(factors == null) {
			factors = factor(i);
			cache = new OneValueCache(i, factors);
		}
	}
	
	void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }
}
