package com.shma;

import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;

public class NumberTokenizerFactory extends TokenizerFactory {

	protected NumberTokenizerFactory(Map<String, String> args) {
		super(args);
		if (!(args.isEmpty()))
			throw new IllegalArgumentException("Unknown parameters: " + args);
	}

	@Override
	public Tokenizer create(AttributeFactory arg0) {
		return null;
	}


}

