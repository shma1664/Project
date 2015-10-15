'''
Created on 2015年10月13日
@author: admin

字典(dictionary)是除列表以外python之中最灵活的内置数据结构类型。列表是有序的对象结合，字典是无序的对象集合。
两者之间的区别在于：字典当中的元素是通过键来存取的，而不是通过偏移存取。
字典用"{ }"标识。字典由索引(key)和它对应的值value组成

'''
myDict = {};
myDict['name'] = "张三";
myDict['age'] = 26;
myDict['school'] = '清华大学';

print(myDict);

otherDict = {'name' : '李四',
             'age' : 23,
             'school' : '浙江大学'};
             
print(otherDict);

print(myDict.get("name"));
print(myDict['age']);

print(myDict.keys());
print(myDict.values());


