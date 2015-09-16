package com.shma.jcip.chapter02;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.shma.jcip.annotation.NotThreadSafe;
import com.shma.jcip.annotation.ThreadSafe;

/**
 * 统计请求servlet总次数
 * @author admin
 *
 */
@NotThreadSafe
public class UnsafeCountingFactorizer extends GenericServlet implements Servlet {

	private static final long serialVersionUID = -1716494625601923917L;

	private long count = 0;
	
	public long getCount() {
		return count;
	}

	@Override
	public void service(ServletRequest request, ServletResponse resp)
			throws ServletException, IOException {
		BigInteger bigInteger = extractFromRequest(request);
		BigInteger[] factors = factor(bigInteger);
		count++;
		encodeIntoResponse(resp, factors);
	}
	
	public void encodeIntoResponse(ServletResponse resp, 
											BigInteger[] factors) {
    
	}

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[] { i };
    }

}
