package com.shma.jcip.chapter05;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Factorizer extends GenericServlet implements Servlet {

	private final Computable<BigInteger, BigInteger[]> cccc = new Computable<BigInteger, BigInteger[]>() {

		@Override
		public BigInteger[] compute(BigInteger arg) throws InterruptedException {
			// TODO Auto-generated method stub
			return factor(arg);
		}
	};
	
	private final Computable<BigInteger, BigInteger[]> cache
    						= new Memoizer4<BigInteger, BigInteger[]>(cccc);

	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		try {
            BigInteger i = extractFromRequest(req);
            encodeIntoResponse(resp, cache.compute(i));
        } catch (InterruptedException e) {
            encodeError(resp, "factorization interrupted");
        }
	}
	
	void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    void encodeError(ServletResponse resp, String errorString) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

	BigInteger[] factor(BigInteger i) {
		// Doesn't really factor
		return new BigInteger[] { i };
	}

}
