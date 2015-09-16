package com.shma.jcip.chapter03;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import com.shma.jcip.annotation.Immutable;

/**
 * 不可变类条件：
 * 	1) 对象创建以后其状态就不能修改
 * 	2) 对象的所有域都用final定义
 * 	3) 对象是正确创建的（在对象创建过程中，this引用没有溢出）
 * 	4) 对象的作用域只是在类中，不会出这个类
 * @author admin
 *
 */
@Immutable
public class ThreeStooges {

	private final Set<String> stooges = new HashSet<String>();
	
	public ThreeStooges() {
		stooges.add("Moe");
		stooges.add("Larry");
		stooges.add("Curly");
	}
	
	public boolean isStooge(String name) {
		return stooges.contains(name);
	}
	
	public String getStoogeNames() {
        List<String> stooges = new Vector<String>();
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
        return stooges.toString();
    }
}
