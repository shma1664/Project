package com.shma.virtual.chapter02;

import java.util.ArrayList;
import java.util.List;

/**
 * Java¶ÑÄÚ´æÒç³ö²âÊÔ
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author admin
 *
 */
public class HeapOOM {

	public static class HeapObject {
		
	}
	
	public static void main(String[] args) {
		List<HeapObject> heapObjects = new ArrayList<HeapOOM.HeapObject>();
		
		while(true) {
			HeapObject heapObject = new HeapObject();
			heapObjects.add(heapObject);
		}
	}
}
