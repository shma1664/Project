package com.shma;

import java.io.IOException;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;

public class NumberTokenFilter extends TokenFilter {

	protected NumberTokenFilter(TokenStream input) {
		super(input);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean incrementToken() throws IOException {
		return false;
	}
}
