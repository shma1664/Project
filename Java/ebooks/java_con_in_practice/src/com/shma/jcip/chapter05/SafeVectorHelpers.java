package com.shma.jcip.chapter05;

import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import com.shma.jcip.annotation.ThreadSafe;

@ThreadSafe
public class SafeVectorHelpers {

	public static Object getLast(Vector<String> list) {
		synchronized (list) {
			int lastIndex = list.size() - 1;
			return list.get(lastIndex);
		}
	}
	
	public static void deleteLast(Vector<String> list) {
		synchronized (list) {
			int lastIndex = list.size() - 1;
			list.remove(lastIndex);
		}
	}
	
	public static void main(String[] args) {
		ConcurrentHashMap<String,String> map=new ConcurrentHashMap<String,String>();
        String temp=map.putIfAbsent("a", "gaoxing");
        System.out.println(temp);
        System.out.println(map.get("a"));
        temp=map.putIfAbsent("a","nihao");
        System.out.println(temp);
        System.out.println(map.get("a"));
        temp=map.putIfAbsent("a","gaoxing");
        System.out.println(temp);
        System.out.println(map.get("a"));
	}
}
