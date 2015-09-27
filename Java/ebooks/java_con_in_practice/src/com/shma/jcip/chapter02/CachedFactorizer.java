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
public class CachedFactorizer extends GenericServlet implements Servlet {

	private static final long serialVersionUID = 7619531648476154591L;
	
	private BigInteger lastNumber;
	private BigInteger[] lastFactors;
	private long hits;
	private long cacheHits;
	
	public synchronized long getHits() {
		return hits;
	}
	
	public synchronized double getCacheHitRatio() {
		return cacheHits * 1.0d / hits;
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		
		BigInteger bigInteger = extractFromRequest(req);
		BigInteger[] factors = null;
		synchronized (this) {
			++hits;
			if(bigInteger.equals(lastNumber)) {
				++cacheHits;
				factors = lastFactors.clone();
			}
		}
		
		if(factors == null) {
			factors = factor(bigInteger);
			synchronized (this) {
				lastNumber = bigInteger;
				lastFactors = factors.clone();
			}
		}
		
		encodeIntoResponse(resp, factors);

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
