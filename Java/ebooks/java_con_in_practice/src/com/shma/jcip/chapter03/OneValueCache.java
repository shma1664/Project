package com.shma.jcip.chapter03;

import java.math.BigInteger;
import java.util.Arrays;

import com.shma.jcip.annotation.Immutable;

@Immutable
public class OneValueCache {

	private final BigInteger lastNumber;
	private final BigInteger[] lastFactors;
	
	public OneValueCache(BigInteger lastNumber, BigInteger[] lastFactors) {
		super();
		this.lastNumber = lastNumber;
		this.lastFactors = Arrays.copyOf(lastFactors, lastFactors.length);
	}
	
	public BigInteger[] getFactors(BigInteger i) {
		
		if(lastNumber == null || !lastNumber.equals(i)) {
			return null;
		}
		
		return Arrays.copyOf(lastFactors, lastFactors.length);
	}
}
