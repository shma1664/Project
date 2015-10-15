'''
Created on 2015年10月15日

@author: admin

in        如果在指定的序列中找到值返回True，否则返回False。    x 在 y序列中 , 如果x在y序列中返回True。
not in    如果在指定的序列中没有找到值返回True，否则返回False。    x 不在 y序列中 , 如果x不在y序列中返回True。

'''

a = 2;

myList = [1, 2, 3, 4, 5];

myTuples = (1, 2, 3, 4, 5);

myDict = {"name":"shma", "age":28};

if(a in myList) :
    print(a, " in ", myList);
else :
    print(a, " not in ", myList);
    
if(a not in myTuples) :
    print(a, " not in ", myTuples);
else :
    print(a, " in ", myTuples);

b = "name";

if(b in myDict.keys()) :
    print(b, " in ", myDict);
else :
    print(b, " not in ", myDict);

