package com.shma.chapter03.classloader;

/**
 * 	curr loader:sun.misc.Launcher$AppClassLoader@1ff0dde
	parent loader:sun.misc.Launcher$ExtClassLoader@1e78fc6
	gparent loader:null
 * @author admin
 *
 */
public class ClassLoaderTest {

	public static void main(String[] args) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		System.out.println("curr loader:" + classLoader);
		
		ClassLoader parentLoader = classLoader.getParent();
		System.out.println("parent loader:" + parentLoader);
		
		ClassLoader gparentLoader = parentLoader.getParent();
		System.out.println("gparent loader:" + gparentLoader);
	}
}
