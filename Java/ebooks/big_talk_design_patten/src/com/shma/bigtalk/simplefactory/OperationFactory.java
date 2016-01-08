package com.shma.bigtalk.simplefactory;

import com.google.common.base.Strings;

public class OperationFactory {
	
	public static enum OPER {
		ADD, SUB, MULT, DIV
	}

	public static IOperation<Double> getOperation(OPER oper) throws Exception {
		
		if(Strings.isNullOrEmpty(oper.toString())) {
			throw new Exception("操作符不能为空");
		}
		
		IOperation<Double> operation = null;
		
		switch (oper) {
			case ADD:
				operation = new AddOperImpl();
				break;
			case SUB:
				operation = new SubOperImpl();
				break;
			case MULT:
				operation = new MultOpterImpl();
				break;
			case DIV:
				operation = new DivOperImpl();
				break;
			default :
				throw new Exception("操作符不支持");
		}
		
		return operation;
	}
}
