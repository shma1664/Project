package com.shma.guava.base;

import java.util.Set;

import org.junit.Test;

import com.google.common.base.Optional;

/**
 * 非null判断
 * @author admin
 * 
 * 
Optional<T>.of(T)	为Optional赋值，当T为Null直接抛NullPointException,建议这个方法在调用的时候直接传常量，不要传变量
Optional<T>.fromNullable(T)	为Optional赋值，当T为Null则使用默认值。建议与or方法一起用，风骚无比
Optional<T>.absent()	为Optional赋值，采用默认值
T or(T)	当Optional的值为null时，使用or赋予的值返回。与fromNullable是一对好基友
T get()	当Optional的值为null时，抛出IllegalStateException，返回Optional的值
boolean isPresent()	如果Optional存在值，则返回True
T orNull()	当Optional的值为null时，则返回Null。否则返回Optional的值
Set<T> asSet()	将Optional中的值转为一个Set返回，当然只有一个值啦，或者为空，当值为null时。
 *
 */
public class TestOptional {

	public void sayHello(String userName) {
		userName = Optional.fromNullable(userName).or("游客");
		System.out.println("您好：" + userName);
	}
	
	@Test
	public void testSayHello() {
		sayHello(null); //您好：游客
		sayHello("Tom"); //您好：Tom
	}
	
	@Test
	public void test() {
		Optional<Integer> possible = Optional.of(20);
		Optional<Integer> absentOpt = Optional.absent();
		Optional<Integer> NullableOpt=Optional.fromNullable(null);
        Optional<Integer> NoNullableOpt=Optional.fromNullable(10);
        if(possible.isPresent()){
            System.out.println("possible isPresent:"+possible.isPresent());
            System.out.println("possible value:"+possible.get());
        }
        if(absentOpt.isPresent()){
            System.out.println("absentOpt isPresent:"+absentOpt.isPresent()); ;
        }
        if(NullableOpt.isPresent()){
            System.out.println("fromNullableOpt isPresent:"+NullableOpt.isPresent()); ;
        }
        if(NoNullableOpt.isPresent()){
            System.out.println("NoNullableOpt isPresent:"+NoNullableOpt.isPresent()); ;
        }
	}
	
	@Test
	public void testMethodReturn() {
		Optional<Long> value = method();
		if(value.isPresent()) {
			System.out.println("获得返回值: " + value.get());
		} else {
			System.out.println("获得返回值: " + value.or(-1L));
		}
		
		System.out.println("获得返回值 orNull: " + value.orNull());
        
        Optional<Long> valueNoNull = methodNoNull();
        if(valueNoNull.isPresent()==true){
            Set<Long> set=valueNoNull.asSet();
            System.out.println("获得返回值 set 的 size : " + set.size());    
            System.out.println("获得返回值: " + valueNoNull.get());     
        }else{
            System.out.println("获得返回值: " + valueNoNull.or(-12L));    
        }
        
        System.out.println("获得返回值 orNull: " + valueNoNull.orNull());
	}
	
	private Optional<Long> method() {
        return Optional.fromNullable(null);
    }
	
    private Optional<Long> methodNoNull() {
        return Optional.fromNullable(15L);
    }
}
