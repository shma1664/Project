package com.shma.reflection;

import java.io.File;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ThreadSafe
public class TestReflection01 extends ParentClass implements Serializable, TestInterface {
	
	private int id;
	
	private List<String> dataList;
	
	public TestReflection01() {
		id = 1;
		dataList = new ArrayList<String>();
	}
	
	public TestReflection01(int id) {
		this.id = id;
		dataList = new ArrayList<String>();
	}
	
	public TestReflection01(int id, List<String> dataList) {
		this.id = id;
		this.dataList = dataList;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<String> getDataList() {
		return dataList;
	}

	public void setDataList(List<String> dataList) {
		this.dataList = dataList;
	}

	@Override
	public String toString() {
		return "TestReflection01 [id=" + id + ", dataList=" + dataList + "]";
	}

	public static void main(String[] args) {
		
		System.out.println("������" + Collections.class.getName());
		System.out.println("��������" + Collections.class.getSimpleName());
		
		String className = "com.shma.reflection.TestReflection01";
		try {
			Class<?> clazz = Class.forName(className);
			System.out.println(clazz.getName());
			
			//���η�
			int modifier = clazz.getModifiers();
			System.out.println(Modifier.isPublic(modifier));
			System.out.println(Modifier.isAbstract(modifier));
			System.out.println(Modifier.isFinal(modifier));
			System.out.println(Modifier.isInterface(modifier));
			System.out.println(Modifier.isNative(modifier));
			System.out.println(Modifier.isPrivate(modifier));
			System.out.println(Modifier.isProtected(modifier));
			System.out.println(Modifier.isStatic(modifier));
			System.out.println(Modifier.isStrict(modifier));
			System.out.println(Modifier.isSynchronized(modifier));
			System.out.println(Modifier.isTransient(modifier));
			System.out.println(Modifier.isVolatile(modifier));
			
			Method[] methods = Collections.class.getMethods();
			//��ȡ����
			for(Method method : methods) {
				System.out.println(method.getName());
			}

			//��ȡ����Ϣ
			Package packageInfo = clazz.getPackage();
			System.out.println(packageInfo.getName());
			
			//��ȡ����
			Class<?> subClazz = clazz.getSuperclass();
			System.out.println("���ࣺ" + subClazz.getName());
			
			//��ȡ�ӿ��б�
			Class<?>[] interClazzs = clazz.getInterfaces();
			for(Class<?> inter : interClazzs) {
				System.out.println(inter.getName());
			}
			
			//���й��еĹ�����
			Constructor<?>[] constructors = clazz.getConstructors();
			for(Constructor<?> constructor : constructors) {
				System.out.println(constructor.getModifiers());
				Class<?>[] paramsClasses = constructor.getParameterTypes();
				for(Class<?> class1 : paramsClasses) {
					System.out.println(class1.getName());
				}
			} 
			
			Field[] fields = clazz.getFields();
			for(Field field : fields) {
				System.out.println(field.getName());
			}
			
			Annotation[] annotations = clazz.getAnnotations();
			for(Annotation annotation : annotations) {
				System.out.println(annotation.getClass().getName());
			}
			
			Constructor<?> constructor = clazz.getConstructor(new Class[]{int.class});
			System.out.println(constructor.getModifiers());
			
			TestReflection01 testReflection01 = (TestReflection01) constructor.newInstance(10);
			System.out.println(testReflection01);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
