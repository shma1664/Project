package com.shma.guava.base;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Preconditions;

/**
 * 前置条件：让方法调用的前置条件判断更简单
 * @author admin
 *
	1.checkArgument(boolean) ：
		功能描述：检查boolean是否为真。 用作方法中检查参数
		失败时抛出的异常类型: IllegalArgumentException
	2.checkNotNull(T)：     
		功能描述：检查value不为null， 直接返回value；
		失败时抛出的异常类型：NullPointerException
	3.checkState(boolean)：
		功能描述：检查对象的一些状态，不依赖方法参数。 例如， Iterator可以用来next是否在remove之前被调用。
		失败时抛出的异常类型：IllegalStateException
	4.checkElementIndex(int index, int size)：
		功能描述：检查index是否为在一个长度为size的list， string或array合法的范围。 index的范围区间是[0, size)(包含0不包含size)。无需直接传入list， string或array， 只需传入大小。返回index。   
		失败时抛出的异常类型：IndexOutOfBoundsException
	5.checkPositionIndex(int index, int size)：
		功能描述：检查位置index是否为在一个长度为size的list， string或array合法的范围。 index的范围区间是[0， size)(包含0不包含size)。无需直接传入list， string或array， 只需传入大小。返回index。
		失败时抛出的异常类型：IndexOutOfBoundsExceptions
	6.checkPositionIndexes(int start, int end, int size)：
		功能描述：检查[start, end)是一个长度为size的list， string或array合法的范围子集。伴随着错误信息。
		失败时抛出的异常类型：IndexOutOfBoundsException
 */
public class TestPreconditions {

	public void paramCheck(String userName, int age) {
		try {
			checkInputParam(userName, age);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		
		System.out.println("验证成功");
	}
	
	
	public void checkInputParam(String userName, int age) throws Exception {
		Preconditions.checkNotNull(userName, "用户名不能为空");
		Preconditions.checkArgument(!userName.equals(""), "用户名不能为''");
		Preconditions.checkArgument(age > 0 && age <= 100, "年龄不能小于0或大于100");
		System.out.println("name:" + userName + ", age:" + age);
		
	}
	
	public void checkState(int size, int index) throws Exception {
		Preconditions.checkState(size > index, "index:" + index + ">=size:" + size);
	}
	
	public void checkPositionIndex(int size, int index) throws Exception {
		Preconditions.checkPositionIndex(index, size, "index:" + index + ">=size:" + size);
		
	}
	
	public void checkPositionIndexes(int size, int start, int end) throws Exception {
		Preconditions.checkPositionIndexes(start, end, size);
	}
	
	public void checkElementIndex(int size, int index) {
		Preconditions.checkElementIndex(index, size, "index:" + index + " is not in size:" + size);
	}
	
	@Test
	public void test01() {
		paramCheck(null, 23);
	}
	
	@Test
	public void test02() {
		paramCheck("", 23);
	}
	
	@Test
	public void test03() {
		paramCheck("shma", -1);
	}
	
	@Test
	public void test04() {
		paramCheck("shma", 120);
	}
	
	@Test
	public void test05() {
		paramCheck("shma", 26);
	}
	
	@Test
	public void test06() {
		List<Integer> intList=new ArrayList<Integer> ();
        for(int i=0;i<10;i++){            
            try {
                checkState(9, intList.size());
                intList.add(i);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        
        try {
            checkPositionIndex(intList.size(),3);    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            checkPositionIndex(intList.size(),13);    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            checkPositionIndexes(intList.size(),3,7);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            checkPositionIndexes(intList.size(),3,17);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            checkPositionIndexes(intList.size(),13,17);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            checkElementIndex(intList.size(),6);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            checkElementIndex(intList.size(),16);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
	}
	
}
