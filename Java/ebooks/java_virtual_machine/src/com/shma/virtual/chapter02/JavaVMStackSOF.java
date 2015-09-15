package com.shma.virtual.chapter02;

/**
 * ÐéÄâ»úÕ»Òç³ö
 * Vm: -Xss128k
 * @author admin
 *
 */
public class JavaVMStackSOF {

	private int stackLength = 1;
	
	private void stackLeak() {
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) {
		JavaVMStackSOF sof = new JavaVMStackSOF();
		try {
			sof.stackLeak();
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("stack length : " + sof.stackLength);
		}
	}

}
