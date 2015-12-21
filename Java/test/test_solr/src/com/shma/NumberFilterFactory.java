package com.shma;

import java.util.Map;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.TokenFilterFactory;

public class NumberFilterFactory extends TokenFilterFactory {

	protected NumberFilterFactory(Map<String, String> args) {
		super(args);
	}

	@Override
	public TokenStream create(TokenStream paramTokenStream) {
		return null;
	}

}
