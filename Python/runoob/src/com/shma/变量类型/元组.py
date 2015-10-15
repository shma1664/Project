'''
Created on 2015年10月13日
@author: admin

元组类似于List，用 “()”标识，内部用逗号隔开，元组是只读列表，不能二次赋值

'''

tuples = ('abc', 123, 21.12, 'edf', 22, 12.11, 'shma');
tintuple = ('john', 123);

print(tuples); #输出完整元组
print(tuples[0]); #输出第一个
print(tuples[1:4]); #输出[1,4)个
print(tuples[2:]); #输出[2,~
print(tintuple * 2);
print(tuples + tintuple);

'''
元组与List比较：元组不可修改，List可以修改
'''
newTuple = ('a', 'b', 'c', 1, 2, 3);
newList= ['a', 'b', 'c', 2, 3, 4];

#newTuple[1] = 'd'; #异常 TypeError: 'tuple' object does not support item assignment
newList[1] = 'shma';
print(newList);