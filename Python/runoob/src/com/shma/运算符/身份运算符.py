'''
Created on 2015年10月15日

@author: admin

is        is是判断两个标识符是不是引用自一个对象    x is y, 如果 id(x) 等于 id(y) , is 返回结果 1
is not    is not是判断两个标识符是不是引用自不同对象    x is not y, 如果 id(x) 不等于 id(y). is not 返回结果 1

'''

a = 10;
b = 20;

if(a is b) :
    print("id(", a, ") == id(", b, ")");
else :
    print("id(", a, ") != id(", b, ")");

a = 10;
b = 10;   
if(id(a) is not id(b)) :
    print("id(", a, ") != id(", b, ")");
else :
    print("id(", a, ") == id(", b, ")");
    
list1 = {1, 2, 3, 4};
list2 = list1;

if(list1 is list2) :
    print("id(", list1, ") == id(", list2, ")");
else :
    print("id(", list1, ") != id(", list2, ")");






