'''
Created on 2015年10月16日

@author: admin

for iterating_var in sequence:
   statements(s)

'''
from com.shma.变量类型.元字典 import myDict

#循环遍历字符
name = 'python';
for letter in name :
    print(letter);

#集合遍历
fruits = ['banana', 'orange', 'apple', 'mango'];
for fruit in fruits :
    print(fruit);
    
#通过索引序号迭代 range：排序索引0-3列表
#内置函数 len() 和 range(),函数 len() 返回列表的长度，即元素的个数。 range返回一个序列的数
for index in range(len(fruits)) :
    print(fruits[index]);

#元组遍历
tuples = ('a', 'b', 'c', 'd', 'e', 1, 2, 3, 4, 5);
for tt in tuples :
    print(tt);

#元字典遍历
for key, value in myDict.items() :
    print("key : " + key + ", value : " + str(value));

for key in myDict :
    print("key : " + key + ", value : " + str(myDict.get(key)));
    
# for ... else ...
# 如果for正常退出，则执行else，如果for中break退出，则不执行
for num in range(10, 20) :
    for index in range(2, num) :
        if(num % 2 == 0) : 
            j = num / index;
            print('%d 等于  %d * %d' % (num, index, j));
            break;
    else : 
        print(num , '是一个质数');
else :
    print("end....");
            

