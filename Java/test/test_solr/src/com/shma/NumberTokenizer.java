package com.shma;

import org.apache.lucene.analysis.util.CharTokenizer;

public class NumberTokenizer extends CharTokenizer {

	@Override
	protected boolean isTokenChar(int paramInt) {
		return Character.isLetter(paramInt);
	}

}
