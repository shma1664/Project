package com.shma.jcip.chapter03;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import com.shma.jcip.annotation.Immutable;

/**
 * ���ɱ���������
 * 	1) ���󴴽��Ժ���״̬�Ͳ����޸�
 * 	2) �������������final����
 * 	3) ��������ȷ�����ģ��ڶ��󴴽������У�this����û�������
 * 	4) �����������ֻ�������У�����������
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
