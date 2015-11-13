'''
Created on 2015年11月11日

@author: admin

'''
from pip._vendor.distlib.compat import raw_input

'''
2.1 序列概况

'''
shma = ['马韶华', 26];
jjq = ['齐娇娇', 27];

db_user = [shma, jjq];
print(db_user);

'''
2.2 通用序列操作

'''
#2.2.1 索引
greeting = 'hello';
print(greeting[0]); # h
print(greeting[-1]); # o

print('hello'[2]);

fourth = raw_input("Year : ")[3];
print(fourth);

#2.2.2 分片：如果左边的索引比右边的索引晚出现在序列中，均返回空
nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
print(nums[1:4]); # [1,4) [2, 3, 4]
print(nums[-3:-1]); #[-3, -1) [8, 9]
print(nums[-3:0]); #如果左边的索引比右边的索引出现的晚，则返回空 []

#取出最后三个元素
print(nums[-3:]); #[8, 9, 10]

#取出前三个元素
print(nums[:3]); #[1, 2, 3]

#取出全部元素
print(nums[:]); #[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

#步长
print(nums[1:7:2]); #[2, 4, 6]
print(nums[::4]); #[1, 5, 9]

#步长不能为0，但可以为负数
#如果为负数，则逆方向遍历,左边比右边后出现
print(nums[8:3:-1]); #[9, 8, 7, 6, 5]
print(nums[-1:-7:-2]); #[10, 8, 6]
print(nums[::-2]); #[10, 8, 6, 4, 2]
print(nums[2::-2]); #[3, 1]
print(nums[:2:-2]); #[10, 8, 6, 4]
print(nums[3:7:-1]); #[]

#2.2.3 序列相加
#相同类型的序列用+号连接

print([1,2,3] + [4,5,6]); #[1, 2, 3, 4, 5, 6]
print('Hello, ' + 'World!'); #Hello, World!
#print([1,2,3] + 'Wo'); #TypeError: can only concatenate list (not "str") to list

#2.2.4 乘法
print(5 * [1,2]); #[1, 2, 1, 2, 1, 2, 1, 2, 1, 2]
print(2 * 'Hello World '); #Hello World Hello World 

#创建空列表
sequnce = 10 * [None]; #None类似于null，表示什么都么有
print(sequnce); #[None, None, None, None, None, None, None, None, None, None]


#2.2.5成员资格

#检查一个值是否在序列中，可以用in

name = 'Tom';
print('o' in name); #True
print('a' in name); #False

students = ['Tom', 'Lucy', 'Lily'];
print('Lucy' in students); #True
sName = raw_input("Plase input your name : ");
if sName in students :
    print("存在");
else :
    print("不存在");
    
sensitiveWords = '习近平毒品色情';
print('平毒' in sensitiveWords); #True

#2.2.6 长度、最小值、最大值
numbers = [2, 90, 15, 72, 18];
print(len(numbers));
print(max(numbers));
print(min(numbers));

'''
2.3 列表
列表：是可变的集合 [1,2,3,4,5]
元组：不可变的集合(1,2,3,4,5)
'''

#2.3.1 list函数
print(list('hello')); #['h', 'e', 'l', 'l', 'o'] 将一个字符串转换为列表
print(list((1,2,3,4,5))); #[1, 2, 3, 4, 5] 将一个元组转换为列表

taskIds = ['1001', '1002', '1003', '1004', '1005'];
taskIdStr = ','.join(taskIds); #列表转换为字符串,join中的序列必须为字符串类型
print(taskIdStr);

#2.3.2 基本的列表操作

#改变列表值
list01 = [1,2,3,4,5];
list01[2] = 6;
print(list01); #[1, 2, 6, 4, 5]
#list01[10] = 10; 
#print(list01); #IndexError: list assignment index out of range

list02 = [None] * 11;
list02[10] = 10;
print(list02); #[None, None, None, None, None, None, None, None, None, None, 10]

#删除列表值
list03 = ['Lucy', 'LiLei', 'HanMeimei', 'Junih'];
del list03[3]; #删除列表值
print(list03); #['Lucy', 'LiLei', 'HanMeimei']

#分片赋值
list04 = list('hello');
list04[2:] = list('kitty');
print(list04); #['h', 'e', 'k', 'i', 't', 't', 'y']

#不需要替换任务元素的情况下插入新元素
list05 = [1,5,9];
list05[1:1] = [2,3,4]; #插入在第一个后面
print(list05); #[1, 2, 3, 4, 5, 9]
list05[5:5] = [6,7,8]; #插入在第第五个后面
print(list05); #[1, 2, 3, 4, 5, 6, 7, 8, 9]

#删除元素
list06 = [1,2,3,4,5,6,7,8,9];
del list06[2:5]; 
print(list06); #[1, 2, 6, 7, 8, 9]
#或者
list07 = [1,2,3,4,5,6,7,8,9];
list07[2:5] = [];
print(list07); #[1, 2, 6, 7, 8, 9]

#2.3.3 列表方法

#append:在列表末尾追加新对象
list08 = [1,2,3];
list08.append(4);
print(list08); #[1, 2, 3, 4]

#count:统计某个元素出现的次数
list09 = [1,2,4,3,2,5,7,3,2,1,9];
print(list09.count(2)); #3
list10 = [[1,2], 1, 3, 2, 1, [1,2], [1,2,[1,2]]];
print(list10.count([1,2])); #2

#extend:向列表末尾一次性添加多个新对象
list11 = ['a', 'b', 'c'];
list12 = ['d', 'e', 'f'];
list11.extend(list12);
print(list11); #['a', 'b', 'c', 'd', 'e', 'f']

list13 = ['a', 'b', 'c']; 
list14 = ['d', 'e', 'f'];
print(list13 + list14); #['a', 'b', 'c', 'd', 'e', 'f']
print(list13); #['a', 'b', 'c']
list13[len(list13):] = list14; #分片实现
print(list13); #['a', 'b', 'c', 'd', 'e', 'f']


#index:查找某一个值第一个匹配项的位置
kngints = ['zhangsan', 'lisi', 'wangwu', 'maliu'];
print(kngints.index('maliu')); #3
#print(kngints.index('sksa')); #ValueError: 'sksa' is not in list
 
#insert:将对象插入列表中
numbers = [1,2,3,4,5,6];
numbers.insert(2, 'five');
print(numbers); #[1, 2, 'five', 3, 4, 5, 6]

numbers[2:2] = ['sex']; #分片实现
print(numbers); #[1, 2, 'sex', 'five', 3, 4, 5, 6]

#pop:移除列表中的最后一个元素,先进后出原则
list15 = [1,2,3,4,5];
print(list15.pop()); #5
print(list15); #[1, 2, 3, 4]

print(list15.pop(3)); #4 移除第几位的值，返回该值
print(list15); #[1, 2, 3]

#实现先进先出
list16 = [1,2,3,4];
list16.insert(0, 5);
print(list16); #[5, 1, 2, 3, 4]
print(list16.pop(0)); #5
print(list16); #[1,2,3,4] #[1, 2, 3, 4]

#remove：用于移除列表中某一个值的第一个选项
list17 = ['a', 'b', 'c', 'c', 'd', 'a', 'c', 'e'];
list17.remove('a');
print(list17); #['b', 'c', 'c', 'd', 'a', 'c', 'e']

delValue = raw_input("Plase input del value : ");
if str(delValue) in list17 :
    list17.remove(str(delValue));
    print(list17);
else :
    print(str(delValue) + ' is not exist in ' + str(list17));
    
#reverse 反转
list18 = [1,2,3,4,5,6,7,8,9];
list18.reverse();
print(list18); #[9, 8, 7, 6, 5, 4, 3, 2, 1]

#sort排序:原位置进行改变
list19 = [2,7,4,3,9,1,5,8,6];
print(list19.sort()); #None
print(list19); #[1, 2, 3, 4, 5, 6, 7, 8, 9]
list19.reverse();
print(list19); #[9, 8, 7, 6, 5, 4, 3, 2, 1]

#复制排序
list20 = [2,7,4,3,9,1,5,8,6];
list21 = list20[:];
list21.sort();
print(list20); #[2, 7, 4, 3, 9, 1, 5, 8, 6]
print(list21); #[1, 2, 3, 4, 5, 6, 7, 8, 9]

list22 = sorted(list20);
print(list20); #[2, 7, 4, 3, 9, 1, 5, 8, 6]
print(list21); #[1, 2, 3, 4, 5, 6, 7, 8, 9]

#高级排序
list23 = ['zhangsan', 'lisi', 'wangwu', 'maliu'];
list23.sort(key=len, reverse=True);
print(list23); #['zhangsan', 'wangwu', 'maliu', 'lisi']


'''
2.4 元组:元列表一样，区别是元组不能被修改
'''

#元组必须要添加逗号，哪怕只有一个值
tuple01 = (1,2,3);
tuple02 = (1,);
print(3 * (10)); #30
print(3 * (10,)); #(10, 10, 10)

#2.4.1 tuple函数，将序列转换为元组
print(tuple('hello')); #('h', 'e', 'l', 'l', 'o')
print(tuple([1,2,3,4,5])); #(1, 2, 3, 4, 5)
print(tuple((1,2,3))); #(1,2,3)

#2.4.2基本操作
tuple03 = ('zhangsan', 1, 'lisi', 2, 'wangwu', 3, 'maliu', 4);
print(tuple03[2]); #lisi
print(tuple03[4:6]); #('wangwu', 3)



